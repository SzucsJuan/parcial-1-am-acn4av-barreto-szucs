package com.example.parcial_1_am_acn4av_barreto_szucs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {

    Button logout_button, home_button, save_button;
    EditText nameEditText, ageEditText, locationEditText;
    FirebaseAuth mAuth;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profile), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        logout_button = findViewById(R.id.logoutBtn);
        save_button = findViewById(R.id.saveBtn);
        nameEditText = findViewById((R.id.edit_name));
        ageEditText = findViewById((R.id.edit_age));
        locationEditText = findViewById((R.id.edit_location));


        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
            }
            public void HomeBtn(View view){
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }

        });
        save_button.setOnClickListener(view -> saveUserData());
    }
    private void saveUserData(){
        String name = nameEditText.getText().toString().trim();
        String age = ageEditText.getText().toString().trim();
        String location = locationEditText.getText().toString().trim();

        if (name.isEmpty() || age.isEmpty() || location.isEmpty()){
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        String userId = mAuth.getCurrentUser().getUid();

        db.collection("users").document(userId).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                DocumentSnapshot document = task.getResult();
                if(document.exists()){
                    updateUser(userId, name, age, location);
                } else {
                    saveNewUser(userId, name, age, location);
                }
            } else {
                Toast.makeText(this, "Error al acceder a los datos: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void saveNewUser(String userId, String name, String age, String location) {
        Map<String, Object> user = new HashMap<>();
        user.put("name", name);
        user.put("age", Integer.parseInt(age));
        user.put("location", location);

        db.collection("users").document(userId)
                .set(user)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "Datos guardados exitosamente.", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Error al guardar los datos: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
    private void updateUser(String userId, String name, String age, String location) {

        db.collection("users").document(userId)
                .update("name", name, "age", Integer.parseInt(age), "location", location)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "Datos actualizados exitosamente.", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Error al actualizar los datos: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}