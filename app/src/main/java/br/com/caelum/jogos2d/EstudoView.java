package br.com.caelum.jogos2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class EstudoView extends View {

    public EstudoView(Context context) {
        super(context);
    }

    public EstudoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        desenhaLinha(canvas);
        desenhaRetangulo(canvas);
        desenhaCirculo(canvas);
    }

    private void desenhaLinha(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(2);

        paint.setColor(Color.BLUE);


        for(int i = 1; i<=40; i++){
            paint.setStrokeWidth(i);
            canvas.drawLine(50, i*50,720,i*50, paint);
        }
    }

    private void desenhaRetangulo(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(2);

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);


        for(int i = 1; i<=20; i++){
            canvas.drawRect(300+(i*20*-1),300+(i*20*-1),400+(i*20),400+(i*20), paint);
        }
    }

    private void desenhaCirculo(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(2);

        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);

        //canvas.drawLine(0,0,100,100, paint);

        //canvas.drawLine(50,50,500,50, paint);


        //for(int i = 1; i<=20; i++){
            canvas.drawCircle(100,100,100, paint);
        //}
    }

}
