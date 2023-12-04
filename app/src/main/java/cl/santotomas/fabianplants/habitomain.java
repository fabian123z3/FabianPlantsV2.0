package cl.santotomas.fabianplants;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class habitomain extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button button;
    private int buttonPressCount = 0;
    private static final int TARGET_BUTTON_PRESS_COUNT = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habitomain);

        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressCount++;

                if (buttonPressCount >= TARGET_BUTTON_PRESS_COUNT) {
                    // Llenar la barra de progreso al máximo
                    progressBar.setProgress(progressBar.getMax());

                    // Obtener y almacenar el logro en Firebase
                    almacenarLogroEnFirebase("Regador Novato");

                    // Iniciar la actividad trofeomain y pasar información adicional
                    mostrarTrofeosActivity();
                } else {
                    // Incrementar la barra de progreso al tamaño total
                    progressBar.incrementProgressBy(progressBar.getMax() / TARGET_BUTTON_PRESS_COUNT);
                }
            }
        });
    }

    private void almacenarLogroEnFirebase(String logro) {
        // Obtener una referencia a la base de datos para logros
        DatabaseReference logrosReference = FirebaseDatabase.getInstance().getReference("logros");

        // Almacenar el logro en Firebase
        logrosReference.push().setValue(logro);
    }

    private void mostrarTrofeosActivity() {
        // Crea un Intent para iniciar la actividad trofeomain
        Intent intent = new Intent(this, trofeomain.class);

        // Inicia la actividad con un código de solicitud
        startActivityForResult(intent, 1);
    }

    // Agregar el método onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Verificar que el resultado provenga de trofeomain y se haya completado
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Reiniciar la barra de progreso después de un breve retraso
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    reiniciarBarraDeProgreso();
                }
            }, 500);
        }
    }

    private void reiniciarBarraDeProgreso() {
        // Reiniciar la barra de progreso estableciendo el progreso a cero
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
    }
}
