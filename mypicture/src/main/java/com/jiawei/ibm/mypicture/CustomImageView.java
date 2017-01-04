
package com.jiawei.ibm.mypicture;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by ibm on 2016/12/13.
 */

public class
CustomImageView extends View {
    private int mWidth;
    private Bitmap mImage;
    private int mHeight;
    private int mImageScale;
    private static final int IMAGE_SCALE_FITXY = 0;
    private static final int IMAGE_SCALE_CENTER = 0;
    private String mTitle;
    private int mTextColor;
    private int mTextSize;
    private Paint mPaint;
    /**
     * 对文本的约束
     */
    private Rect mTextBound;
    /**
     * 控制整天布局
     */
    private  Rect rect;
    public CustomImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    public CustomImageView(Context context) {
        this(context, null);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.CustomImagView,defStyleAttr,0);
        int n = a.getIndexCount();
        for (int i=0 ;i < n; i++){
            int attr = a.getIndex(i);
            switch (attr){
                case  R.styleable.CustomImagView_image:
                    mImage = BitmapFactory.decodeResource(getResources(),a.getResourceId(attr,0));
                    break;
                case R.styleable.CustomImagView_imageScaleType:
                    mImageScale = a.getInt(attr,0);
                    break;
                case R.styleable.CustomImagView_titleText:
                    mTitle = a.getString(attr);
                    break;
                case R.styleable.CustomImagView_titleTextColors:
                    mTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomImagView_titleTextSize:
                    mTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics()));
                    break;
            }

        }
        a.recycle();
        rect = new Rect();
        mPaint = new Paint();
        mTextBound = new Rect();
        mPaint.setTextSize(mTextSize);
        mPaint.getTextBounds(mTitle,0,mTitle.length(),mTextBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY){//match_parent ,accurate
            mWidth =specSize;

        }else{
            int desireByImg = getPaddingLeft()+getPaddingRight() + mImage.getWidth();
            int desireByTitle = getPaddingLeft() + getPaddingRight() + mTextBound.width();
            if (specMode == MeasureSpec.AT_MOST){
                int  desire = Math.max(desireByImg,desireByTitle);
                mWidth = Math.min(desire,specSize);
            }
        }
        specMode = MeasureSpec.getMode(heightMeasureSpec);
        specSize = MeasureSpec.getSize(heightMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY){
            mHeight = specSize;

        }else{
            int  desire = getPaddingTop() +  getPaddingBottom() + mImage.getHeight() + mTextBound.height();
            if (specMode == MeasureSpec.AT_MOST){
                mHeight = Math.min(desire,specSize);
            }
        }
        setMeasuredDimension(mWidth,mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.CYAN);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);

        rect.left = getPaddingLeft();
        rect.right = mWidth - getPaddingRight();
        rect.top =getPaddingTop();
        rect.bottom = mHeight - getPaddingBottom();

        mPaint.setColor(mTextColor);
        mPaint.setStyle(Paint.Style.FILL);

        if(mTextBound.width() > mWidth){
            TextPaint paint = new TextPaint(mPaint);
            String msg = TextUtils.ellipsize(mTitle,paint,mWidth - getPaddingLeft() - getPaddingRight(),TextUtils.TruncateAt.END).toString();
            canvas.drawText(msg,getPaddingLeft(),mHeight - getPaddingBottom(),mPaint);

        }else{
            canvas.drawText(mTitle,mWidth/2 - mTextBound.width() *1.0f/2,mHeight -getPaddingBottom(),mPaint);
        }
        rect.bottom -=mTextBound.height();
        if (mImageScale == IMAGE_SCALE_FITXY){
            canvas.drawBitmap(mImage,null,rect,mPaint);
        }else{
            rect.left = mWidth/2 -mImage.getWidth()/2;
            rect.right = mWidth/2-+ mImage.getWidth()/2;
            rect.top = (mHeight - mTextBound.height())/2 + mImage.getHeight()/2;
            rect.bottom  = (mHeight -mTextBound.height())/2 + mImage.getHeight()/2;

            canvas.drawBitmap(mImage,null,rect, mPaint);
        }
    }
}
