package kz.fis.androiddev;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewY;
    private EditText A, B, X;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewY = findViewById(R.id.textViewY);
        A = findViewById(R.id.editTextA);
        B = findViewById(R.id.editTextB);
        X = findViewById(R.id.editTextX);


        if (savedInstanceState != null) {
            textViewY.setText(savedInstanceState.getString("y"));
        }
    }

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Сохранение нужных нам значений компонент при перевороте экрана
        outState.putString("y", textViewY.getText().toString());
    }


    @SuppressLint("DefaultLocale")
    public void onButtonSolveClick(View view) {
        double a, b, x, y;

        try {
            a = Double.parseDouble(A.getText().toString().trim());
            b = Double.parseDouble(B.getText().toString().trim());
            x = Double.parseDouble(X.getText().toString().trim());

            if (x >= 4) {
                y = (10 * (x + a * a)) / (b + a);
            } else {
                y = 5 * (x + a * a + b);
            }

            textViewY.setText(String.format("y = %.2f", y));
        } catch (Exception e) {
            Toast.makeText(this, "Ошибка", Toast.LENGTH_LONG).show();
        }

        clearFocuses();
    }

    public void onButtonClearClick(View view) {
        textViewY.setText("");
        textViewY.setHint("y = ");
        A.setText("");
        B.setText("");
        X.setText("");
        clearFocuses();
    }

    private void clearFocuses() {
        A.clearFocus();
        B.clearFocus();
        X.clearFocus();
    }
}