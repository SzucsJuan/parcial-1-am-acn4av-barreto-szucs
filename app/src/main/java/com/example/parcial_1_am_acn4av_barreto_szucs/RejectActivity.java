package com.example.parcial_1_am_acn4av_barreto_szucs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RejectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reject);

        RejectArcTextView rejectText = findViewById(R.id.hooknt_text);
        rejectText.setText("HOOKN'T");
        rejectText.setTextSize(100);
        rejectText.setTextColor(0xFF000000);
        TextView emojis = findViewById(R.id.emojis_reject);

        rejectText.setVisibility(RejectArcTextView.VISIBLE);
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(2000);
        rejectText.startAnimation(fadeIn);

        new Handler().postDelayed(() -> {
            emojis.setVisibility(View.VISIBLE);
            emojis.startAnimation(fadeIn);
        }, 2000);


        new Handler().postDelayed(() -> {
            Intent intent = new Intent(RejectActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 5000);
    }
}