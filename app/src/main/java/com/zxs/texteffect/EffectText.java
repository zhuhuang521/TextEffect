package com.zxs.texteffect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zxs on 14/11/2.
 */
public class EffectText extends TextView{

    private Bitmap mTemBitmap;
    private Canvas mTemcanvas;

    private Paint mPaint;

    public EffectText(Context context) {
        this(context, null);
    }

    public EffectText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);


    }
    public EffectText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint=new Paint();
        mPaint.setColor(Color.GREEN);
        getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        mTemBitmap=Bitmap.createBitmap(1080,1920, Bitmap.Config.ARGB_8888);
        mTemcanvas=new Canvas(mTemBitmap);
        setBackgroundColor(0x00000000);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        mTemcanvas.drawRect(0,0,this.getWidth(),this.getHeight(),mPaint);
        super.onDraw(mTemcanvas);
        canvas.drawBitmap(mTemBitmap,0f,0f,null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    public void setBackgroundColor(int color) {
        //super.setBackgroundColor(0x00000000);
        if(color!=0) {
            mPaint.setColor(color);
        }
    }

    @Override
    public void setBackground(Drawable background) {
        super.setBackground(null);
    }

    @Override
    public void setBackgroundResource(int resid) {
        super.setBackgroundResource(resid);

    }

    @Override
    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
    }
}
