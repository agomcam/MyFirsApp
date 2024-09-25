package com.example.myfirsapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.i("Ciclo de vida", "Ha entrado en el metodo onCreate");

        // Components View
        EditText etName = findViewById(R.id.etName);
        EditText etSurname = findViewById(R.id.etSurname);

        Button btnSend = findViewById(R.id.btnOk);
        Button btnReset = findViewById(R.id.btnReset);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // necesitamos crear un objeto intent para pasar entre ventanas este objeto recibe
                // como parametros la ventana actual y la ventana a la que queremos nevegar
                if (etName.getText().toString().equalsIgnoreCase("") || etSurname.getText().toString().equalsIgnoreCase("")) {
                    // EL toas es un mensaje chiquitito que se ve en la pantalla
                    Toast toas = new Toast(MainActivity.this);
                    toas.setText("El nombre y apellido no puede estar vacio");
                    toas.show();
                    return;
                }else {
                    Intent intentDeMainActivity = new Intent(MainActivity.this, MainActivity2.class);

                    // Metodo para abrir otra activity
                    intentDeMainActivity.putExtra("nombre", etName.getText().toString());
                    intentDeMainActivity.putExtra("apellido", etSurname.getText().toString());

                    Log.i("name", etName.getText().toString());
                    Log.i("surname", etSurname.getText().toString());

                    startActivity(intentDeMainActivity);
                }

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etName.setText("");
                etSurname.setText("");

                Log.i("Cambios", "Textos reseteados");
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de vida", "He entrado en el metodo onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de vida", "He entrado en el metodo Resumen");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de vida", "He entrado en el metodo onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de vida", "He entrado en el metodo onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de vida", "Ha entrado en el metodo onDestroy");
    }
}