package com.example.admin.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class SmileyView extends View {

    private Paint mCirclePaint;
    private Paint mEyeAndMouthPaint;

    private float mCenterX;
    private float mCenterY;
    private float mRadius;

    private Paint paint;
    private RectF mArcBounds = new RectF();

    public SmileyView(Context context) {
        this(context, null);
    }

    public SmileyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SmileyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
        initPaint1();
    }

    private void initPaints() {
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setStyle(Paint.Style.FILL); //to mau`
        mCirclePaint.setColor(Color.YELLOW);
        mEyeAndMouthPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mEyeAndMouthPaint.setStyle(Paint.Style.STROKE); // chi ve ko to
        mEyeAndMouthPaint.setStrokeWidth(16 * getResources().getDisplayMetrics().density);
        mEyeAndMouthPaint.setStrokeCap(Paint.Cap.ROUND); // Bo tròn nét vẽ ở hai đầu mút của đoạn thẳng.
        mEyeAndMouthPaint.setColor(Color.BLACK);

    }


    private void  initPaint1() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(50);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       int w = MeasureSpec.getSize(widthMeasureSpec); //10191931, w 900
       int h = MeasureSpec.getSize(heightMeasureSpec);//1310319, h 1200

       int size = Math.min(w, h); //900
       setMeasuredDimension(size, size);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh); //900 900
        mCenterX = w / 2f; //450
        mCenterY = h / 2f;//450
        mRadius = Math.min(w, h) / 2f; //225
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //draw face
        canvas.drawCircle(mCenterX , mCenterY, mRadius, mCirclePaint);
        // draw eyes
        float eyeRadius = mRadius / 5f;
        float eyeOffsetX = mRadius / 3f;
        float eyeOffsetY = mRadius / 3f;
        canvas.drawCircle(mCenterX - eyeOffsetX, mCenterY - eyeOffsetY, eyeRadius, mEyeAndMouthPaint);
        canvas.drawCircle(mCenterX + eyeOffsetX, mCenterY - eyeOffsetY, eyeRadius, mEyeAndMouthPaint);
        // draw mouth
        float mouthInset = mRadius /3f;
        mArcBounds.set(mouthInset, mouthInset, mRadius * 2 - mouthInset, mRadius * 2 - mouthInset);
        canvas.drawArc(mArcBounds, 45f, 90f, false, mEyeAndMouthPaint);


    }
}
