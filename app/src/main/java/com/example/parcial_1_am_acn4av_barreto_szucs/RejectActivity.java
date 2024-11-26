package com.example.parcial_1_am_acn4av_barreto_szucs;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RejectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reject);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(RejectActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 5000);
    }
}