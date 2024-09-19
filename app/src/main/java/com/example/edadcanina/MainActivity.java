package com.example.edadcanina;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
        EditText edadEdit = findViewById(R.id.edad_id);
        TextView resultText = findViewById(R.id.result_id);
        Button button = findViewById(R.id.id_botonCalcular);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edad = edadEdit.getText().toString();
                if(!edad.isEmpty()){
                    int edadInt = Integer.parseInt(edad);

                    int resultado = edadInt * 7;
                    String resultString = "La edad de tu perrito es "+ resultado +" en años";
                    resultText.setText(resultString);
                }else{
                    Toast.makeText(MainActivity.this, "Llenar campos faltantes", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}