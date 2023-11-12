package cl.santotomas.fabianplants;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class alarmasmain extends AppCompatActivity {
    ImageButton habitos;
    ImageButton trofeos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmasmain);

        habitos = findViewById(R.id.Habitos);
        trofeos = findViewById(R.id.Trofeo);


        habitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(alarmasmain.this, habitomain.class);
                startActivity(intent);
            }
        });

        trofeos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(alarmasmain.this, trofeomain.class);
                startActivity(intent);
            }
        });


    }
}
