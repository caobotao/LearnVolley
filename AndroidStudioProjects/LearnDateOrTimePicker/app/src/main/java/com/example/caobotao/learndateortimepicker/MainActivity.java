package com.example.caobotao.learndateortimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private TimePicker timePicker;
    private Calendar calendar;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        setTitle(year +"-"+ month +"-"+ day +"  "+ hour +":"+ minute);
        datePicker.init(year, month - 1, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.year = year;
                MainActivity.this.month = monthOfYear + 1;
                MainActivity.this.day = dayOfMonth;
                setTitle(MainActivity.this.year + "-" + month + "-" + day + "  " + hour + ":" + minute);
            }
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                MainActivity.this.hour = hourOfDay;
                MainActivity.this.minute = minute;
                setTitle(year + "-" + month + "-" + day + "  " + hour + ":" + MainActivity.this.minute);
            }
        });
//        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                MainActivity.this.year = year;
//                MainActivity.this.month = monthOfYear + 1;
//                MainActivity.this.day = dayOfMonth;
//                setTitle(MainActivity.this.year + "-" + month + "-" + day + "  " + hour + ":" + minute);
//            }
//        },year,month - 1,day).show();
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                MainActivity.this.hour = hourOfDay;
                MainActivity.this.minute = minute;
                setTitle(year + "-" + month + "-" + day + "  " + hour + ":" + MainActivity.this.minute);
            }
        },hour,minute,true).show();
    }
}
