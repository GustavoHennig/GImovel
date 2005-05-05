package gimovel.geral;

import javax.swing.UIManager;

import gimovel.jogo.*;
import gimovel.visual.Janela;
import gimovel.visual.Splash;
import gimovel.dados.*;

public class Main {

    public static void main(String[] args) {
        try {

//         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (Exception e) {
            System.out.println(
                    "Look and Feel não encontrado, usando o default.");
        }

        try {

 //           SaxParser1 sps = new SaxParser1();
      //      sps.sx("DefinicaoTabuleiro.xml");

            Dado d = new Dado();
            System.out.println(d.getIntDados());

            Splash sp = new Splash();
            sp.show();
            Janela janela = new Janela();
            janela.show();
            sp.dispose();

        } catch (Exception ee) {
//        System.out.println(ee.getMessage());
            ee.printStackTrace();

        }
    }

}
