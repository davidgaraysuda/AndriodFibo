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
    private double operando1 = 0;
    private String operador = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textOp = findViewById(R.id.text_operaciones);
        textRes = findViewById(R.id.text_resultado);

        int[] botonesNumeros = {R.id.bt0, R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4,
                R.id.bt5, R.id.bt6, R.id.bt7, R.id.bt8, R.id.bt9};
        int[] botonesOperadores = {R.id.btMas, R.id.btMenos, R.id.btMult, R.id.btDiv};
        Button btnIgual = findViewById(R.id.btCalc);
        Button btnBorrar = findViewById(R.id.btn_clear);

        // Listener para los botones de números
        for (int id : botonesNumeros) {
            Button b = findViewById(id);
            b.setOnClickListener(v -> {
                numeroConcatenado += b.getText().toString();
                textOp.setText(numeroConcatenado);
            });
        }

        // Listener para los botones de operadores
        for (int id : botonesOperadores) {
            Button b = findViewById(id);
            b.setOnClickListener(v -> {
                if (!numeroConcatenado.isEmpty()) {
                    operando1 = Double.parseDouble(numeroConcatenado);
                    operador = b.getText().toString();
                    textOp.setText(numeroConcatenado + " " + operador + " ");
                    numeroConcatenado = "";
                }
            });
        }

        // Listener para el botón de igual (=)
        btnIgual.setOnClickListener(v -> {
            if (!numeroConcatenado.isEmpty() && !operador.isEmpty()) {
                double operando2 = Double.parseDouble(numeroConcatenado);
                double resultado = 0;
                switch (operador) {
                    case "+":
                        resultado = operando1 + operando2;
                        break;
                    case "-":
                        resultado = operando1 - operando2;
                        break;
                    case "*":
                        resultado = operando1 * operando2;
                        break;
                    case "/":
                        if (operando2 != 0) {
                            resultado = operando1 / operando2;
                        } else {
                            Toast.makeText(MainActivity.this, "¡División por cero!", Toast.LENGTH_SHORT).show();
                            resultado = 0;
                        }
                        break;
                }
                textRes.setText(String.valueOf(resultado));
                operando1 = resultado; // Para permitir operaciones encadenadas
                operador = "";
                numeroConcatenado = "";
            }
        });

        // Listener para el botón de borrar (C)
        btnBorrar.setOnClickListener(v -> {
            numeroConcatenado = "";
            operando1 = 0;
            operador = "";
            textOp.setText("");
            textRes.setText("");
        });
    }
}