package gimovel.visual;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;

import gimovel.jogo.Jogo;
import java.awt.*;

//import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
//import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;


public class Janela extends JFrame {

    Jogo jogo = new Jogo();
    // LookAndFeel lf = new LookAndFeel();

    public Janela() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private void jbInit() throws Exception {
        this.getContentPane().setBackground(new Color(134, 166, 166));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("GImovel - Banco Imobiliário Fajuto");
        this.getContentPane().setLayout(null);
        this.setSize(800, 600);
        jogo.setBackground(new Color(134, 166, 166));
        jogo.setVisible(true);
        jogo.setBounds(new Rectangle(0, 0, 771, 572));
        jogo.setLayout(null);
        this.getContentPane().add(jogo, null);
    }

}
