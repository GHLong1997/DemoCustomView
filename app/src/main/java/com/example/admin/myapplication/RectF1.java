package com.example.admin.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class RectF1 extends View{

    private Paint paint = new Paint();

    public RectF1(Context context) {
        super(context);
    }

    public RectF1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RectF1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectf = new RectF(100, 100, 400, 200);
//        canvas.drawOval(rectf, paint);
        canvas.drawRect(rectf, paint);
    }
}
