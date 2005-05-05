package gimovel.visual;

import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class ImagemDados extends JPanel {

    Image[] _img = new Image[6];

    public ImagemDados() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private int _img_Atual = 1;

    private void jbInit() throws Exception {
        for (int i = 1; i <= 6; i++) {
            InputStream in = getClass().getResourceAsStream("/imagens/dado" + Integer.toString(i) + ".GIF");
            _img[i - 1] = ImageIO.read(in);
        }
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(_img[_img_Atual - 1], 1, 1, 32, 32, null);
    }

    public void SetDado(int dado) {
        _img_Atual = dado;
        this.paintImmediately(1, 1, 32, 32);
        this.repaint();
    }

}
