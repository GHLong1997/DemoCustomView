package com.example.admin.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class arc extends View {

    Paint paint;
    Path path;

    public arc(Context context) {
        super(context);
        init();
    }

    public arc(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public arc(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.STROKE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);

        final RectF oval = new RectF();
        paint.setStyle(Paint.Style.STROKE);
        /*
         * drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
         *
         * oval - The bounds of oval used to define the shape and size of the arc
         * startAngle - Starting angle (in degrees) where the arc begins //góc bắt đầu cắt
         * sweepAngle - Sweep angle (in degrees) measured clockwise  //cắt bao nhiêu độ
         * useCenter - If true, include the center of the oval in the arc, and close it if it is being stroked. This will draw a wedge
         * paint - The paint used to draw the arc
         */
        canvas.drawOval(50,200,150,300, paint);

        oval.set(50, 50, 150, 150);
        canvas.drawArc(oval, 90, 45, true, paint);

        oval.set(50, 300, 150, 400);
        canvas.drawArc(oval, 180, 45, true, paint);

        oval.set(200, 150, 450, 350);
        canvas.drawArc(oval, 0, 270, true, paint);

        oval.set(200, 400, 450, 600);
        canvas.drawArc(oval, 0, 270, false, paint);


    }
}