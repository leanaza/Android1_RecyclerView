package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class CustomTextView extends AppCompatTextView {

    private Paint paint;
    private LinearGradient linearGradient;

    public CustomTextView(Context context) {
        super(context);
        init();
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = getPaint();
        // Set shadow layer for the text
        setShadowLayer(1.5f, 5, 5, 0xFF000000);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        // Create a gradient for the text
        linearGradient = new LinearGradient(0, 0, 0, getHeight(),
                new int[]{0xFFFFEB3B, 0xFFFFC107},
                null, Shader.TileMode.CLAMP);

        paint.setShader(linearGradient);
        super.onDraw(canvas);
    }
}
