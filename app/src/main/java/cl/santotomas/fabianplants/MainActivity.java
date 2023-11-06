package cl.santotomas.fabianplants;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

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
    }}
