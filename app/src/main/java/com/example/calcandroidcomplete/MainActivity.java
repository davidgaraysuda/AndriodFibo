package com.example.calcandroidcomplete;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String numeroConcatenado = "";
    private TextView textOp;
    private TextView textRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textOp = findViewById(R.id.text_operaciones);
        textRes = findViewById(R.id.text_resultado);

        int[] botones = { R.id.bt0, R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4,
                R.id.bt5, R.id.bt6, R.id.bt7, R.id.bt8, R.id.bt9, R.id.btMas,
                R.id.btMenos, R.id.btMult, R.id.btDiv};

        for (int id : botones) {
            Button b = findViewById(id);
            b.setOnClickListener(v -> {
                numeroConcatenado += b.getText().toString();
                textOp.setText(numeroConcatenado);
            });
        }

        Button btnBorrar = findViewById(R.id.btn_clear);
        btnBorrar.setOnClickListener(v -> {
            numeroConcatenado = "";
            textOp.setText("Operaciones");
        });

        Button btnCalcular = findViewById(R.id.btCalc);
        btnCalcular.setOnClickListener(v -> {
            numeroConcatenado = "";
            textRes.setText("Operaciones");
        });
    }
}

