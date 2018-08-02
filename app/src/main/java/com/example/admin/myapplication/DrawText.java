package com.example.admin.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class DrawText extends View {

    private TextPaint textPaint;

    public DrawText(Context context) {
        this(context, null);
    }

    public DrawText(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTextPaint();
    }

    private void initTextPaint() {
        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLUE);
        textPaint.setTextSize(100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(100, 100);// thay đổi tọa độ mặc định
//        canvas.scale(1,2);//mặc định kich thước view 1,1
//        canvas.rotate(270);
        canvas.drawText("Long", 200, 400, textPaint);
        canvas.drawText("Long", 1,  3, 200, 600, textPaint); // toa đọ x y, start: index to start draw
        // (result "on"
    }
}
