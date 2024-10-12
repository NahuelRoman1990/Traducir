package com.example.traducir;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.traducir.databinding.ActivityResultadoBinding;

public class ResultadoActivity extends AppCompatActivity {

    private ActivityResultadoBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityResultadoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String english = getIntent().getStringExtra("english");
        int imageResId = getIntent().getIntExtra("imageResId", R.drawable.defaulf);

        binding.resultTextView.setText(english);
        binding.imageView.setImageResource(imageResId);
    }
}
