package gimovel.visual;

import java.awt.*;

import gimovel.dados.Casa;

public class DesenhaTabuleiro {


    Graphics2D _g2d;
    //  Container _c;

    public DesenhaTabuleiro(Graphics g, Container c) {
        _g2d = (Graphics2D) g;
        //    _c = c;
    }

    public void RepintaCasas(Casa[] casas) {
        for (int i = 0; i < 44; i++) {
            casas[i].Desenha(_g2d);
            // _c.add(casas[i].getLabel());
        }
    }


}
