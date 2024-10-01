package com.example.parcial_1_am_acn4av_barreto_szucs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class LogoComponent extends ConstraintLayout {

    TextView logoText;

    public LogoComponent(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        inflate(context, R.layout.logo_component_layout,this);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LogoComponent,0,0);

        init();
        uploadAtributtes(typedArray);
    }
    private void init(){
        logoText = findViewById(R.id.logo);
    }

    private void uploadAtributtes(@NonNull TypedArray typedArray){
        setValue(typedArray.getString(R.styleable.LogoComponent_value));
    }

    public void setValue(String value){
        logoText.setText(value);
    }
}

