package br.com.caelum.jogos2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class PlanoCartesianoView extends View {

    private int menorLadoDisplay;
    private int unidade;

    public PlanoCartesianoView(Context context) {
        super(context);
    }

    public PlanoCartesianoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (getHeight() > getWidth()) {
            menorLadoDisplay = getWidth();
        } else {
            menorLadoDisplay = getHeight();
        }

        unidade = menorLadoDisplay / 10;

        drawPlanoCartesiano(canvas);
    }

    private void drawPlanoCartesiano(Canvas canvas) {
        Path path = new Path();
        int max = toPixel(10);
        for (int i = 0; i <= 10; i++) {
            //verticais
            path.moveTo(toPixel(i), 1);
            path.lineTo(toPixel(i), max);
            //horizontais
            path.moveTo(1, toPixel(i));
            path.lineTo(max, toPixel(i));
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);

        canvas.drawPath(path, paint);
    }

    protected int toPixel(int i) {
        return i * unidade;
    }
}
