package com.example.admin.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Canvas extends View {

    private Paint paint;
    private Path path = new Path();

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
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE); //tô màu đố tượng
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3); // có tác dụng nếu là đoạn thẳng, set giá trị độ rộng của net vẽ
//        paint.setStrokeCap(Paint.Cap.ROUND); // bo tròn 2 đầu mút của đoạn thẳng
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
    protected void onDraw(final android.graphics.Canvas canvas) {
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
//        canvas.drawLine(100, 400, 600, 500, paint);

        //vẽ hình chữ nhật
//        canvas.drawRect(100, 100, 400, 350, paint);

//        float width = 600;
//        float height = 500;
//        float left = (getWidth() - width) / 2f;
//        float top = (getHeight() - height) /2f;
//        canvas.drawRect(left, top, left + width, top + height, paint);

        /**
         * vẽ hình tròn
         */
//        canvas.drawCircle(500, 600, 128, paint);
//        canvas.drawCircle(getWidth() / 2f, getHeight() / 2f, 100, paint);
//
//        //oval
//        canvas.drawOval(300, 500,  600, 800, paint);
//
//        canvas.drawCircle(0, 550, 100, paint);


//        path.moveTo(300,300);
//        path.lineTo(100, 300);
//        path.lineTo(300,500);
//
//        path.lineTo(500,300);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(13);
        path.moveTo(86, 229);
//        path.cubicTo(300, 50, 100, 400, 400, 400);
        path.cubicTo(167, 427, 318, 138, 423, 299);
        canvas.drawPath(path, paint);

//        path.reset();
//        paint.setColor(Color.GRAY);
//        paint.setStrokeWidth(1);
//        path.moveTo(50, 50);
//        path.lineTo(300, 50);
//        path.lineTo(100, 400);
//        path.lineTo(400, 400);

//        canvas.drawPath(path, paint);
//        for (double s = 0; s < 1; s = s + 0.1) {
////            final int d = (int)(Math.pow(1 - s, 3) * 50 + 3 * Math.pow(1 - s, 2) * s * 300 + 3 * Math.pow(1 - s,
////                    2) * 100 + Math.pow(s, 3) * 400);
////            final int  e = (int)(Math.pow(1 - s, 3) * 50 + 3 * Math.pow(1 - s, 2) * s * 50 + 3 * Math.pow(1 - s,
////                    2) * 400 + Math.pow(s, 3) * 400);
//            Point point = new Point(d, e);
//            path.lineTo(point.x,point.y);
//            canvas.drawPath(path, paint);

//        }


        canvas.drawPath(path, paint);

    }

}
