package com.example.admin.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Canvas extends View {

    private Paint paint;
    private Float startY = 400f;

    public Canvas(Context context) {
        this(context, null);
    }

    public Canvas(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Canvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint1();
    }

    private void  initPaint1() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL); //tô màu đố tượng
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(150); // có tác dụng nếu là đoạn thẳng, set giá trị độ rộng của net vẽ
        paint.setStrokeCap(Paint.Cap.ROUND); // bo tròn 2 đầu mút của đoạn thẳng
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        startY = 1100f;
        invalidate();
        return super.onTouchEvent(event);

    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int x = 100;
        int y = 200;
        float x1[] = {100 ,300 , 500 , 700, 900, 110};
        float y1[] = {200, 400, 600};
//        canvas.drawPoint(x, y, paint);
//        canvas.drawPoints(x1, paint);
//
//        canvas.drawLine(100, 100, 100, 300, paint);
        float x2[] = {200, 100, 200, 300};

//        canvas.drawLines(x2, paint); //Vẽ đoạn thẳng trong mảng pts với 4 phần tử liên
        // tiếp sẽ là startX, startY, stopX, stopY sử dụng paint để vẽ.

        //vẽ đoạn thẳng
//        canvas.drawLine(0, 500, getWidth(), 500, paint);
        canvas.drawLine(100, startY, 600, 500, paint);

        //vẽ hình chữ nhật
//        canvas.drawRect(100, 100, 400, 350, paint);

        float width = 600;
        float height = 500;
        float left = (getWidth() - width) / 2f;
        float top = (getHeight() - height) /2f;
//        canvas.drawRect(left, top, left + width, top + height, paint);

        /**
         * vẽ hình tròn
         */
//        canvas.drawCircle(500, 600, 100, paint);
//        canvas.drawCircle(getWidth() / 2f, getHeight() / 2f, 100, paint);
//
//        //oval
//        canvas.drawOval(300, 500,  600, 800, paint);

    }

}
