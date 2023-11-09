package cl.santotomas.fabianplants;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button pcomunes;
    Button pexoticas;
    Button pfruteras;
    ImageButton ptiendas;
    ImageButton palarmas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Verifica la versión de Android antes de crear el canal (solo necesario en versiones Oreo y superiores)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel();
        }

        pcomunes = findViewById(R.id.comunes);
        pexoticas = findViewById(R.id.exoticas);
        pfruteras = findViewById(R.id.fruteras);
        palarmas = findViewById(R.id.alarmas);
        ptiendas = findViewById(R.id.tiendas);

        pcomunes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, comunesmain.class);
                startActivity(intent);
            }
        });

        pexoticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, exoticasmain.class);
                startActivity(intent);
            }
        });

        pfruteras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, fruterasmain.class);
                startActivity(intent);
            }
        });

        palarmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, alarmasmain.class);
                startActivity(intent);
            }
        });

        ptiendas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel() {
        // Crea un canal de notificación con ID "channel_id"
        CharSequence name = "Channel Name";
        String description = "Channel Description";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel("channel_id", name, importance);
        channel.setDescription(description);

        // Registra el canal en el sistema
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }
}
