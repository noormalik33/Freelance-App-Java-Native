package com.example.freelance_assist_app;

// --- STANDARD IMPORTS ---
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

// --- MISSING IMPORTS ADDED BELOW ---
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

// --- SWEET ALERT IMPORT ---
import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ActivityLifeCycle";

    private RadioGroup radioGroupExperience;
    private CheckBox cbAvailable;
    private Button btnDatePicker, btnTimePicker, btnSaveProfile, btnShowSweet;
    private TextView tvSelectedDateTime;

    private int mYear, mMonth, mDay, mHour, mMinute;
    private String dateString = "", timeString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate invoked");
        Toast.makeText(this, "onCreate: App Started", Toast.LENGTH_SHORT).show();

        initializeViews();
        setupPickers();
        setupButtons();
        setupBackPress();
    }

    private void initializeViews() {
        radioGroupExperience = findViewById(R.id.radioGroupExperience);
        cbAvailable = findViewById(R.id.cbAvailable);
        btnDatePicker = findViewById(R.id.btnDatePicker);
        btnTimePicker = findViewById(R.id.btnTimePicker);
        btnSaveProfile = findViewById(R.id.btnSaveProfile);
        btnShowSweet = findViewById(R.id.btnShowSweet);
        tvSelectedDateTime = findViewById(R.id.tvSelectedDateTime);
    }

    private void setupPickers() {
        btnDatePicker.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                    (view, year, monthOfYear, dayOfMonth) -> {
                        dateString = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        updateDateTimeText();
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        });

        btnTimePicker.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                    (view, hourOfDay, minute) -> {
                        timeString = String.format("%02d:%02d", hourOfDay, minute);
                        updateDateTimeText();
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        });
    }

    private void updateDateTimeText() {
        String fullText = "Deadline: " + (dateString.isEmpty() ? "--" : dateString) +
                " at " + (timeString.isEmpty() ? "--" : timeString);
        tvSelectedDateTime.setText(fullText);
    }

    private void setupButtons() {
        btnSaveProfile.setOnClickListener(v -> {
            int selectedId = radioGroupExperience.getCheckedRadioButtonId();
            RadioButton selectedRb = findViewById(selectedId);
            String experience = (selectedRb != null) ? selectedRb.getText().toString() : "Not Selected";
            String available = cbAvailable.isChecked() ? "Yes" : "No";

            String message = "Experience: " + experience + "\n" +
                    "Immediate Start: " + available + "\n" +
                    "Deadline: " + tvSelectedDateTime.getText().toString();

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Confirm Profile")
                    .setMessage(message)
                    .setPositiveButton("Save", (dialog, which) -> {
                        Toast.makeText(MainActivity.this, "Profile Saved", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Cancel", null)
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        });

        // This is now CORRECT. It uses SweetAlertDialog.
        btnShowSweet.setOnClickListener(v -> {
            new SweetAlertDialog(MainActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good job!")
                    .setContentText("You clicked the bonus button!")
                    .show();
        });
    }

    private void setupBackPress() {
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Exit App")
                        .setMessage("Are you sure you want to exit?")
                        .setPositiveButton("Yes", (dialog, which) -> finish())
                        .setNegativeButton("No", null)
                        .show();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }
}