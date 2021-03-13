package kz.fis.questionnaire;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewResult = findViewById(R.id.textViewResult);

        textViewResult.append(String.format("Имя: %s\nПол: %s\nОбразование: %s\nСтрана: %s",
                getIntent().getStringExtra("fio"), getIntent().getStringExtra("gender"),
                getIntent().getStringExtra("education"), getIntent().getStringExtra("country")));
    }
}