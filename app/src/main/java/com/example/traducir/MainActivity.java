package com.example.traducir;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;
    private EditText editTextPalabra;
    private Button buttonTraducir;
    private Button buttonVolver;
    private TextView textViewResultado;
    private ImageView imageViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        editTextPalabra = findViewById(R.id.editTextPalabra);
        buttonTraducir = findViewById(R.id.buttonTraducir);
        buttonVolver = findViewById(R.id.buttonVolver);
        textViewResultado = findViewById(R.id.textViewResultado);
        imageViewResultado = findViewById(R.id.imageViewResultado);

        viewModel.getPalabraTraducida().observe(this, new Observer<Palabra>() {
            @Override
            public void onChanged(Palabra palabra) {
                if (palabra != null) {
                    textViewResultado.setText(palabra.getEnglish());
                    imageViewResultado.setImageResource(palabra.getImg());

                    buttonVolver.setVisibility(View.VISIBLE);
                    buttonTraducir.setVisibility(View.GONE);
                    editTextPalabra.setVisibility(View.GONE);

                }
            }
        });

        buttonTraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String palabra = editTextPalabra.getText().toString();
                viewModel.translateWord(palabra);
                editTextPalabra.setText("");
            }
        });

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonVolver.setVisibility(View.GONE);
                buttonTraducir.setVisibility(View.VISIBLE);
                editTextPalabra.setVisibility(View.VISIBLE);
                textViewResultado.setText("");
                imageViewResultado.setImageResource(0);
                editTextPalabra.setText("");
            }
        });
    }
}
