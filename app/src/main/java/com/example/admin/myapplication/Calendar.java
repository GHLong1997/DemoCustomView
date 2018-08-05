package com.example.admin.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class Calendar extends View implements View.OnClickListener {

    private String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private Integer yearNumberSize;
    private Integer yearTitleColor;
    private Integer defaultMonthColor;
    private Integer monthCircleRadiusSize;
    private Integer monthNumberSize;
    private Integer monthStringSize;
    private Integer viewBackGroundColor;

    private TextPaint monthNumberPaint = new TextPaint();
    private TextPaint monthStringPaint = new TextPaint();
    private TextPaint yearNumberPaint = new TextPaint();

    private Paint monthCirclePaint = new Paint();
    private Paint monthCircleStrokePaint = new Paint();

    private Integer circleHeight;
    private Integer viewWidth;
    private Integer numCells = 6;
    private Integer year = 2018;
    private Integer yearHeaderSize;
    private Integer numLines = 2;

    private java.util.Calendar calendar = java.util.Calendar.getInstance();

    public Calendar(Context context) {
        this(context, null);
    }

    public Calendar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Calendar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrs(context, attrs);
        initPaints();
        setBackgroundColor(viewBackGroundColor);
    }

    private void getAttrs(Context context, AttributeSet attrs) {
        yearTitleColor = ContextCompat.getColor(context, R.color.vermillion);
        defaultMonthColor = ContextCompat.getColor(context, R.color.black);
        viewBackGroundColor = ContextCompat.getColor(context, R.color.whiteSix);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Calendar);
        try {
            monthCircleRadiusSize = typedArray.getDimensionPixelSize(R.styleable.Calendar_monthCircleSize1, getResources().getDimensionPixelSize(R.dimen.dp_17));
            monthNumberSize = typedArray.getDimensionPixelSize(R.styleable.Calendar_monthNumberSize1, getResources().getDimensionPixelSize(R.dimen.sp_14));
            monthStringSize = typedArray.getDimensionPixelSize(R.styleable.Calendar_monthStringSize1, getResources().getDimensionPixelSize(R.dimen.sp_10));
            yearNumberSize = typedArray.getDimensionPixelSize(R.styleable.Calendar_yearNumberSize1, getResources().getDimensionPixelSize(R.dimen.sp_20));
            yearHeaderSize = typedArray.getDimensionPixelSize(R.styleable.Calendar_yeaHeaderSize1, getResources().getDimensionPixelSize(R.dimen.dp_64));
            circleHeight = typedArray.getDimensionPixelOffset(R.styleable.Calendar_viewHeight1, getResources().getDimensionPixelOffset(R.dimen.dp_40));
        } finally {
            typedArray.recycle();
        }
    }

    private void initPaints() {
        monthCirclePaint.setFakeBoldText(true);
        monthCirclePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        monthCirclePaint.setStyle(Paint.Style.FILL);
        monthCirclePaint.setTextAlign(Paint.Align.CENTER);
        monthCirclePaint.setColor(Color.WHITE);

        monthCircleStrokePaint.setFakeBoldText(true);
        monthCircleStrokePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        monthCircleStrokePaint.setStyle(Paint.Style.STROKE);
        monthCircleStrokePaint.setTextAlign(Paint.Align.CENTER);
        monthCircleStrokePaint.setColor(getResources().getColor(R.color.vermillion));
        monthCircleStrokePaint.setStrokeWidth(getResources().getDimensionPixelOffset(R.dimen.dp_02));

        yearNumberPaint.setFakeBoldText(true);
        yearNumberPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        yearNumberPaint.setStyle(Paint.Style.FILL);
        yearNumberPaint.setTextAlign(Paint.Align.CENTER);
        yearNumberPaint.setTextSize(yearNumberSize.floatValue());
        yearNumberPaint.setColor(yearTitleColor);
        yearNumberPaint.setTypeface(ResourcesCompat.getFont(getContext(), R.font.oswald_medium));

        monthNumberPaint.setFakeBoldText(true);
        monthNumberPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        monthNumberPaint.setStyle(Paint.Style.FILL);
        monthNumberPaint.setTypeface(Typeface.create(ResourcesCompat.getFont(getContext(), R.font.oswald_medium), Typeface.BOLD));
        monthNumberPaint.setTextAlign(Paint.Align.CENTER);
        monthNumberPaint.setTextSize(monthNumberSize);

        monthStringPaint.setFakeBoldText(true);
        monthStringPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        monthStringPaint.setTypeface(ResourcesCompat.getFont(getContext(), R.font.oswald_regular));
        monthStringPaint.setStyle(Paint.Style.FILL);
        monthStringPaint.setTextAlign(Paint.Align.CENTER);
        monthStringPaint.setTextSize(monthStringSize);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int viewHeight = yearHeaderSize + 2 * (3 * monthCircleRadiusSize - monthCircleRadiusSize / 4);
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), viewHeight);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawYear(canvas);
        drawMonth(canvas);
    }

    @Override
    public void onClick(View v) {

    }

    private void drawYear(Canvas canvas) {
        Integer x = getWidth() / 2;
        Integer y = (yearHeaderSize / 2) + (yearHeaderSize / 4);
        canvas.drawText("2018", x.floatValue(), y, yearNumberPaint);
    }

    private void drawMonth(Canvas canvas) {
        int mItemWidth = getWidth() / 6;
        int month = 1;
        for (int i = 0; i < numLines; i++) {
            for (int j = 0; j < numCells; j++) {
                Integer x = j * mItemWidth + mItemWidth / 2;
                Integer y = yearHeaderSize + monthCircleRadiusSize + i * (3 * monthCircleRadiusSize + monthCircleRadiusSize / 4);
                if (calendar.getTime().getMonth() == month && calendar.get(java.util.Calendar.YEAR) == 2018) {
                    drawCurrentMonth(canvas, x, y);
                }
                drawMonthNormal(canvas, x, y);
                drawTextMonth(canvas, x, y, month);
                month++;
            }
        }
    }

    private void drawTextMonth(Canvas canvas, int x, int y, int month) {
        canvas.drawText(String.valueOf(month), x, y, monthNumberPaint);
        canvas.drawText(months[month - 1], x, y + monthStringSize, monthStringPaint);
    }

    private void drawCurrentMonth(Canvas canvas, int x, int y) {
        canvas.drawCircle(x, y, monthCircleRadiusSize, monthCircleStrokePaint);
    }

    private void drawMonthNormal(Canvas canvas, int x, int y) {
        canvas.drawCircle(x, y, monthCircleRadiusSize.floatValue(), monthCirclePaint);
    }

    public void addDate() {

    }
}
