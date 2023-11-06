package cl.santotomas.fabianplants;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TimePicker;

public class alarmasmain extends AppCompatActivity {
    ImageButton habitos;
    ImageButton trofeos;
    private int hour, minute;
    private Button selectTimeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmasmain);

        habitos = findViewById(R.id.Habitos);
        trofeos = findViewById(R.id.Trofeo);
        selectTimeButton = findViewById(R.id.selectTimeButton);

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

        selectTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });
    }

    public void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                // La hora y el minuto seleccionados por el usuario
                hour = selectedHour;
                minute = selectedMinute;

                // Aquí puedes configurar la lógica para programar las notificaciones en la hora seleccionada.
                // Puedes usar AlarmManager y BroadcastReceiver para manejar las notificaciones.
                // Consulta la documentación de Android para obtener más detalles.
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }
}