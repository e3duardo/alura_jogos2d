package br.com.caelum.jogos2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;

/**
 * Created by eduardo on 01/01/17.
 */

public class ForcaView extends PlanoCartesianoView {

    private Path pathForca;

    public ForcaView(Context context) {
        super(context);
        pathForca = new Path();
    }

    public ForcaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        pathForca = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        pathForca.moveTo(toPixel(2), toPixel(2));
//        pathForca.lineTo(toPixel(8), toPixel(2));

        plotaArmacaoForca();
        plotaCabeca();
        plotaCorpo();

        plotaMembro(Membro.braco, Lado.direito);
        plotaMembro(Membro.braco, Lado.esquerdo);
        plotaMembro(Membro.perna, Lado.direito);
        plotaMembro(Membro.perna, Lado.esquerdo);

        canvas.drawPath(pathForca, getPaintForca());
    }

    private void plotaArmacaoForca(){
        pathForca.moveTo(toPixel(1), toPixel(10));
        pathForca.lineTo(toPixel(3), toPixel(10));

        pathForca.moveTo(toPixel(2), toPixel(10));
        pathForca.lineTo(toPixel(2), toPixel(1));

        pathForca.rLineTo(toPixel(5), 0);

        pathForca.rLineTo(0, toPixel(1));
    }

    private void plotaCabeca(){
        pathForca.addCircle(toPixel(7), toPixel(3), toPixel(1), Path.Direction.CW);
    }

    private void plotaCorpo(){
        pathForca.moveTo(toPixel(7), toPixel(4));
        pathForca.lineTo(toPixel(7), toPixel(7));
    }

    private void plotaMembro(Membro membro, Lado lado){
        final int posicaoCorpo = 7;
        final int alturaBraco = 5;
        final int alturaPerna = 7;
        int alturaFinal = 0;

        if(membro == Membro.braco){
            pathForca.moveTo(toPixel(posicaoCorpo), toPixel(alturaBraco));
            alturaFinal = alturaBraco+1;
        }
        if(membro == Membro.perna){
            pathForca.moveTo(toPixel(posicaoCorpo), toPixel(alturaPerna));
            alturaFinal = alturaPerna+1;
        }

        if(lado == Lado.direito) {
            pathForca.lineTo(toPixel(posicaoCorpo+1), toPixel(alturaFinal));
        }
        if(lado == Lado.esquerdo) {
            pathForca.lineTo(toPixel(posicaoCorpo-1), toPixel(alturaFinal));
        }
    }

    private Paint getPaintForca() {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
        return paint;
    }


    private enum Membro{braco, perna}
    private enum Lado{direito,esquerdo}
}
