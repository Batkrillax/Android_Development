package kz.fis.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPersonName;
    private RadioGroup radioGroupGender;
    private RadioGroup radioGroupEducation;
    private Spinner spinnerCountry;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPersonName = findViewById(R.id.editTextPersonName);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioGroupEducation = findViewById(R.id.radioGroupEducation);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        btn = findViewById(R.id.button);

        btn.setEnabled(false);

        editTextPersonName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                boolean isReady = editable.length() > 0;
                btn.setEnabled(isReady);
            }
        });
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, ResultActivity.class);

        RadioButton selectedGenderRadioButton = findViewById(radioGroupGender.getCheckedRadioButtonId());
        RadioButton selectedEducationRadioButton = findViewById(radioGroupEducation.getCheckedRadioButtonId());

        intent.putExtra("fio", editTextPersonName.getText().toString());
        intent.putExtra("gender", selectedGenderRadioButton.getText());
        intent.putExtra("education", selectedEducationRadioButton.getText());
        intent.putExtra("country", spinnerCountry.getSelectedItem().toString());

        startActivity(intent);
    }
}