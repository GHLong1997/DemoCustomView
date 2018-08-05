package com.example.admin.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class CustomCalendarViewV2 extends View {

    private String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private Integer monthCircleSize;
    private Integer strokeCircleSize;
    private Integer monthNumberTextSize;
    private Integer monthStringTextSize;
    private Integer yearHeaderSize;
    private Integer yearTitleColor;
    private Integer defaultMonthColor;
    private Integer defaultMonthTextColor;
    private Integer viewBackGroundColor;
    private Integer yearNumberTextSize;

    private TextPaint monthNumberPaint;
    private TextPaint monthStringPaint;
    private TextPaint yearNumberPaint;

    private Paint circlePaint;
    private Paint circleStrokeOutPaint;

    private Integer viewHeight;
    private Integer viewWidth;

    private Integer numMonths = 6;
    private Integer numRows = 2;
    private Integer numCells = 6;
    private Integer year = 20180000;


    public CustomCalendarViewV2(Context context) {
        this(context, null);
    }

    public CustomCalendarViewV2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomCalendarViewV2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrs(context, attrs);
        initViews();
        setBackgroundColor(viewBackGroundColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), viewHeight * numRows + yearHeaderSize + yearHeaderSize / 2);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawYearTitle(canvas);
        drawMonth(canvas);
    }

    private void getAttrs(Context context, AttributeSet attrs) {
        yearTitleColor = ContextCompat.getColor(context, R.color.red);
        defaultMonthTextColor = ContextCompat.getColor(context, R.color.black);
        defaultMonthColor = ContextCompat.getColor(context, R.color.black);
        viewBackGroundColor = ContextCompat.getColor(context, R.color.gallery_approx);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomCalendarViewV2);
        try {
            monthCircleSize = typedArray.getDimensionPixelSize(R.styleable.CustomCalendarViewV2_monthCircleSize, getResources().getDimensionPixelSize(R.dimen.dp_20));
            monthNumberTextSize = typedArray.getDimensionPixelSize(R.styleable.CustomCalendarViewV2_monthNumberTextSize, getResources().getDimensionPixelSize(R.dimen.sp_14));
            monthStringTextSize = typedArray.getDimensionPixelSize(R.styleable.CustomCalendarViewV2_monthStringTextSize, getResources().getDimensionPixelSize(R.dimen.sp_10));
            yearNumberTextSize = typedArray.getDimensionPixelSize(R.styleable.CustomCalendarViewV2_yearStringTextSize, getResources().getDimensionPixelSize(R.dimen.sp_20));
            yearHeaderSize = typedArray.getDimensionPixelSize(R.styleable.CustomCalendarViewV2_yearHeaderSize, getResources().getDimensionPixelSize(R.dimen.dp_60));
            strokeCircleSize = typedArray.getDimensionPixelSize(R.styleable.CustomCalendarViewV2_strokeCircleSize, getResources().getDimensionPixelOffset(R.dimen.dp_02));
            viewHeight = typedArray.getDimensionPixelOffset(R.styleable.CustomCalendarViewV2_viewHeight, (getResources().getDimensionPixelOffset(R.dimen.dp_300) - yearHeaderSize) / 5);
        } finally {
            typedArray.recycle();
        }
    }

    private void initViews() {
        monthNumberPaint = new TextPaint();
        monthStringPaint = new TextPaint();
        yearNumberPaint = new TextPaint();
        circlePaint = new Paint();
        circleStrokeOutPaint = new Paint();

        yearNumberPaint.setFakeBoldText(true);
        yearNumberPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        yearNumberPaint.setStyle(Paint.Style.FILL);
        yearNumberPaint.setTextAlign(Paint.Align.CENTER);
        yearNumberPaint.setColor(yearTitleColor);
        yearNumberPaint.setTextSize(yearNumberTextSize.floatValue());
        yearNumberPaint.setTypeface(ResourcesCompat.getFont(getContext(), R.font.oswald_medium));

        circlePaint.setFakeBoldText(true);
        circlePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setTextAlign(Paint.Align.CENTER);
        circlePaint.setColor(Color.TRANSPARENT);

        circleStrokeOutPaint.setFakeBoldText(true);
        circleStrokeOutPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        circleStrokeOutPaint.setStyle(Paint.Style.FILL);
        circleStrokeOutPaint.setTextAlign(Paint.Align.CENTER);
        circleStrokeOutPaint.setColor(Color.RED);
        circleStrokeOutPaint.setStrokeWidth(strokeCircleSize.floatValue());
        circleStrokeOutPaint.setStrokeCap(Paint.Cap.ROUND);
        circleStrokeOutPaint.setStrokeJoin(Paint.Join.ROUND);

        monthNumberPaint.setFakeBoldText(true);
        monthNumberPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        monthNumberPaint.setStyle(Paint.Style.FILL);
        monthNumberPaint.setTypeface(ResourcesCompat.getFont(getContext(), R.font.oswald_medium));
        monthNumberPaint.setTextAlign(Paint.Align.CENTER);
        monthNumberPaint.setTextSize(monthNumberTextSize);

        monthStringPaint.setFakeBoldText(true);
        monthStringPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        monthStringPaint.setTypeface(ResourcesCompat.getFont(getContext(), R.font.oswald_regular));
        monthStringPaint.setStyle(Paint.Style.FILL);
        monthStringPaint.setTextAlign(Paint.Align.CENTER);
        monthStringPaint.setTextSize(monthStringTextSize);
    }

    private void drawYearTitle(Canvas canvas) {
        Integer x = viewWidth / 2;
        Integer y = yearHeaderSize;
        canvas.drawText(year.toString(), x.floatValue(), Float.valueOf(String.valueOf(y * 2 / 3)), yearNumberPaint);
    }

    private void drawMonth(Canvas canvas) {
        Integer y = (viewHeight + monthNumberTextSize) / 4 + yearHeaderSize;
        Integer paddingMonth = viewWidth / 7;
        Integer index = 1;
        Integer numLines = 1;
        Integer monthNumber = 1;
        while (index < numCells + 1 && numLines < 3) {
            Integer x = paddingMonth * index;
            monthNumberPaint.setColor(defaultMonthColor);
            monthStringPaint.setColor(defaultMonthColor);
            circlePaint.setColor(Color.WHITE);
            drawMonthNormal(monthNumber, canvas, x, y);
            index++;
            monthNumber++;
            if (index.equals(numMonths + 1)) {
                index = 1;
                numLines++;
                y += viewHeight + viewHeight / 3;
            }
        }
    }

    private void drawMonthNormal(Integer month, Canvas canvas, Integer x, Integer y) {
        circlePaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x.floatValue(), y.floatValue(), monthCircleSize.floatValue(), circlePaint);
        canvas.drawText(month.toString(), x.floatValue(), y.floatValue(), monthNumberPaint);
        canvas.drawText(months[month - 1], x.floatValue(), y.floatValue() + monthStringTextSize, monthStringPaint);
    }
}
