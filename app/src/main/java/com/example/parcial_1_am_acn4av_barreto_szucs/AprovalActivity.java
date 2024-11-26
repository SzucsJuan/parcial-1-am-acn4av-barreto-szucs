package com.example.parcial_1_am_acn4av_barreto_szucs;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AprovalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aproval);

        AprovalArcTextView aprovalText = findViewById(R.id.hooked_text);
        aprovalText.setText("HOOKED");
        aprovalText.setTextSize(100);
        aprovalText.setTextColor(0xFF000000);
        TextView emojis = findViewById(R.id.emojis_aproval);

        aprovalText.setVisibility(RejectArcTextView.VISIBLE);
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(2000);
        aprovalText.startAnimation(fadeIn);

        new Handler().postDelayed(() -> {
            emojis.setVisibility(View.VISIBLE);
            emojis.startAnimation(fadeIn);
        }, 2000);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(AprovalActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 5000);
    }
}