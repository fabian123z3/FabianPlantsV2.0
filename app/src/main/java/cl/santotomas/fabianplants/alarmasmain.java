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

                // Programa la notificación en la hora seleccionada
                scheduleNotification(hour, minute);
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }

    private void scheduleNotification(int hour, int minute) {
        // Obtén una instancia de AlarmManager
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        // Crea un Intent para el BroadcastReceiver que manejará la notificación
        Intent notificationIntent = new Intent(this, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this,
                0,
                notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        // Configura el tiempo de la notificación
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        // Programa la notificación
        alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(),
                pendingIntent
        );
    }
}
