package com.example.admin.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DrawBitmap extends View {

    private Paint paint;
    private Drawable drawable;
    private Bitmap bitmap;

    public DrawBitmap(Context context) {
        this(context, null);
    }

    public DrawBitmap(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawBitmap(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        drawable = getResources().getDrawable(R.drawable.ic_launcher_foreground);
         bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    }

    private void initPaint() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float left = (getWidth() - bitmap.getWidth()) / 2f;
        float top = (getHeight() - bitmap.getHeight()) / 2f;
        Rect rect = new Rect(0 , 0, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        RectF rectF = new RectF(left, top, left + bitmap.getWidth(), top + bitmap.getHeight());

        canvas.drawBitmap(bitmap, rect, rectF, paint);
    }
}
