package com.example.parcial_1_am_acn4av_barreto_szucs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button aproval_button, reject_button;

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

    }
    public void AprovalBtn(View view){
        Toast.makeText(getApplicationContext(),"Bien maquina, ahora calma la fiera, yo te aviso si esta para hablarle", Toast.LENGTH_SHORT).show();
    }

    public void RejectBtn(View view){
        Toast.makeText(getApplicationContext(),"Que mal, yo pense que era tu tipo", Toast.LENGTH_SHORT).show();
    }
}