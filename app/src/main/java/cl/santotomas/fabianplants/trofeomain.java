package cl.santotomas.fabianplants;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class trofeomain extends AppCompatActivity {

    private TextView logrosTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trofeomain);

        logrosTextView = findViewById(R.id.logrosTextView);

        // Obtener la referencia a la base de datos para logros
        DatabaseReference logrosReference = FirebaseDatabase.getInstance().getReference("logros");

        // Agregar un listener para obtener la lista de logros desde Firebase
        logrosReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Limpiar el texto existente
                logrosTextView.setText("");

                // Crear una lista para almacenar logros
                List<String> logrosList = new ArrayList<>();

                // Iterar sobre los logros y agregarlos a la lista
                for (DataSnapshot logroSnapshot : dataSnapshot.getChildren()) {
                    String logro = logroSnapshot.getValue(String.class);
                    logrosList.add(logro);
                }

                // Mostrar la lista de logros en el TextView
                mostrarLogros(logrosList);

                // Obtener el logro obtenido, si hay alguno
                String logroObtenido = obtenerLogroObtenido();

                // Mostrar el logro obtenido si es diferente de null
                if (logroObtenido != null) {
                    mostrarLogroObtenido(logroObtenido);
                }

                // Reiniciar la barra de progreso después de un breve retraso
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        reiniciarBarraDeProgreso();
                    }
                }, 500);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Manejar errores
            }
        });
    }

    private void mostrarLogros(List<String> logrosList) {
        // Mostrar los logros en el TextView
        for (String logro : logrosList) {
            logrosTextView.append("- " + logro + "\n");
        }
    }

    private String obtenerLogroObtenido() {
        // Obtener el intent que inició esta actividad
        Intent intent = getIntent();

        // Obtener el logro obtenido como un extra del intent
        return intent.getStringExtra("logroObtenido");
    }

    private void mostrarLogroObtenido(String logro) {
        // Mostrar el logro obtenido en el TextView
        logrosTextView.append("- " + logro + "\n");
    }

    private void reiniciarBarraDeProgreso() {
        // Configurar un resultado para indicar que se ha completado
        setResult(RESULT_OK);
    }
}
