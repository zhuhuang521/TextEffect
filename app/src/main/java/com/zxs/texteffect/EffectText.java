package com.zxs.texteffect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zxs on 14/11/2.
 */
public class EffectText extends TextView{

    private Bitmap mTemBitmap;

    private Paint paint;
    private Paint textpaint;
    public EffectText(Context context) {
        this(context, null);
    }

    public EffectText(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
        paint.setTextSize(120);
        textpaint=new Paint();
        textpaint.setTextSize(80);
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        textpaint.setColor(Color.GREEN);
    }

    public EffectText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        canvas.drawColor(Color.TRANSPARENT);
        //
        Bitmap tembitmap=Bitmap.createBitmap(1000,800, Bitmap.Config.ARGB_8888);
        Canvas temcanvas=new Canvas(tembitmap);
        temcanvas.drawRect(0,0,1000,500,textpaint);
        paint.setColor(Color.YELLOW);
        //temcanvas.drawRect(0,0,100,200,paint);
        temcanvas.drawText("Hello word",100,100,paint);
        canvas.drawBitmap(tembitmap,0f,100f,null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
    }
}
