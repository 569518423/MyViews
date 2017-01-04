package com.jiawei.ibm.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ibm on 2017/1/3.
 */

public class MyViewGroup extends ViewGroup {
    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        int curHeight = t;
        for (int i =0;i<count;i++){
            View childView = getChildAt(i);
            int height  = childView.getMeasuredHeight();
            int width = childView.getMeasuredWidth();
            childView.layout(l,curHeight,l+width,curHeight+height);
            curHeight += height;
        }
    }

    public MyViewGroup(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
         int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int childCount = getChildCount();
        if (childCount ==0 ){
            setMeasuredDimension(0,0);
        }else {
            if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST){
                int height = getTotleHeight();
                int width = getMaxChildWidth();
                setMeasuredDimension(width,height);
            }else if (widthMode == MeasureSpec.AT_MOST){
                setMeasuredDimension(getMaxChildWidth(),heightSize);
            }else if (heightMode == MeasureSpec.AT_MOST){
                setMeasuredDimension(widthSize,getTotleHeight());
            }
        }
    }

    private int getMaxChildWidth() {
        int childCount = getChildCount();
        int maxWidth = 0;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getMeasuredWidth() > maxWidth) {
                maxWidth = childView.getMeasuredWidth();
            }
        }
        return maxWidth;
    }
    private int getTotleHeight() {
        int height =0;
        int childCount = getChildCount();
        for (int i =0; i<childCount; i++){
            View childView = getChildAt(i);
            height += childView.getMeasuredHeight();
        }
        return height;
    }

}
