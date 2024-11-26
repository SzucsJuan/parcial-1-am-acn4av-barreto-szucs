package com.example.parcial_1_am_acn4av_barreto_szucs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class RejectArcTextView extends View {
    private Paint paint;
    private Path path;
    private String text = "HOOKN'T";

    public RejectArcTextView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setColor(0xFF000000);
        paint.setTextSize(80);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        
        path = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w, h, oldw, oldh);

        float radius = Math.min(w, h) / 2.5f;
        float centerX = w / 2f;
        float centerY = h / 2f;

        path.reset();
        path.addArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius, -180, 180);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawTextOnPath(text, path, 0, 0, paint);
    }

    //Metodos para modificar parametros en clase originante(RejectActivity)
    public void setText(String newText) {
        this.text = newText;
        invalidate();
    }

    public void setTextSize(float size) {
        paint.setTextSize(size);
        invalidate();
    }

    public void setTextColor(int color) {
        paint.setColor(color);
        invalidate();
    }

}
