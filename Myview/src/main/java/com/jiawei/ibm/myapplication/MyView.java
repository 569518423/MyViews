package com.jiawei.ibm.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by ibm on 2017/1/3.
 */

public class MyView extends View {
    private  int defaultSize;
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.MyView);
        defaultSize = a.getDimensionPixelSize(R.styleable.MyView_size,200);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMySize(defaultSize,widthMeasureSpec);
        int height = getMySize(defaultSize,heightMeasureSpec);
        if (width>height){
            width = height;
        }else{
            width =height;
        }
        setMeasuredDimension(width,height);

    }

    private int getMySize(int defaultSize, int measureSpec) {
        int mySize = defaultSize;
        int size = MeasureSpec.getSize(measureSpec);
        int  mode = MeasureSpec.getMode(measureSpec);
        switch (mode){
            case MeasureSpec.UNSPECIFIED:
                mySize = defaultSize;
                break;
            case MeasureSpec.AT_MOST:
                mySize =size;
                break;
            case MeasureSpec.EXACTLY:
                mySize = size;
                break;
        }
        return mySize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r = getMeasuredHeight()/2;
        int centerX = getLeft()+r;
        int centerY = getTop() + r;
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#998908"));
        canvas.drawCircle(centerX,centerY,r,paint);
    }
}
