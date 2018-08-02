package com.example.admin.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class AddAttribute extends View {

    private Boolean showText;
    private Boolean bbbb;

    public AddAttribute(Context context) {
        super(context);
    }

    public AddAttribute(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AddAttribute(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AddAttribute, 0, 0);
        showText = typedArray.getBoolean(R.styleable.AddAttribute_showText, false);
        typedArray.recycle(); //đối tượng TypedArray là một tài nguyên được chỉa sẻ nên phải được giải phóng (recycle ) sau khi sử dụng.

    }

    public boolean isShowText() {
        return showText;
    }

    public void setShowText(boolean showText) {
        this.showText = showText;
        invalidate();
        requestLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) { //hàm này đc gọi rất nhiều lần, vd thay đổi text, color, ngf dùng chạm vào view: sử dụng invalidate()
        super.onDraw(canvas);
    }
    //requestLayout () : cập nhật view chỉ từ onMearsure(),
    // nó cập nhật lại và tính toán cả kích cỡ, vị trí của view, sau đó sẽ vẽ lại theo tham số mới.
}
