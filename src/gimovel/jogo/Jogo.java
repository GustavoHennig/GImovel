package gimovel.jogo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import gimovel.dados.*;
import gimovel.visual.*;
import java.net.URL;


public class Jogo extends JPanel {

    private Status status;
    Info info = new Info();
    private Tabuleiro _tabuleiro;
    ImageIcon img;
    ImagemDados _imgdados1 = new ImagemDados();
    ImagemDados _imgdados2 = new ImagemDados();


    public Jogo() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        //this.addMouseListener( new Jogo_this_mouseAdapter( this));
        this.addMouseListener(ma);
        status = new Status();
        this.setLayout(null);
        status.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        status.setBorder(null);
        status.setBounds(new Rectangle(106, 111, 222, 159));
        this.status.setVisible(true);
        this.setSize(800, 600);
        btnJogar.setBounds(new Rectangle(209, 349, 103, 39));
        btnJogar.setBorder(BorderFactory.createLineBorder(Color.black));
        btnJogar.setFocusPainted(false);
        btnJogar.setText("Jogar");
        btnJogar.addActionListener(new Jogo_btnJogar_actionAdapter(this));
        lblMensagem.setBackground(SystemColor.info);
        lblMensagem.setFont(new java.awt.Font("Arial", Font.BOLD | Font.ITALIC,
                                              14));
        lblMensagem.setBorder(BorderFactory.createLineBorder(Color.black));
        lblMensagem.setOpaque(true);
        lblMensagem.setText("Status");
        lblMensagem.setBounds(new Rectangle(107, 445, 490, 27));
        btnComprar.setBounds(new Rectangle(112, 350, 93, 40));
        btnComprar.setEnabled(false);
        btnComprar.setBorder(BorderFactory.createLineBorder(Color.black));
        btnComprar.setFocusPainted(false);
        btnComprar.setText("Comprar");
        _imgdados1.setBackground(Color.white);
        _imgdados1.setBorder(BorderFactory.createLineBorder(Color.black));
        _imgdados1.setDoubleBuffered(false);
        _imgdados1.setOpaque(true);
        _imgdados2.setBackground(Color.white);
        _imgdados2.setBorder(BorderFactory.createLineBorder(Color.black));
        _imgdados2.setDoubleBuffered(false);
        _imgdados2.setOpaque(true);
        this.add(status);
        this.add(lblMensagem);
        this.add(_imgdados2);
        this.add(_imgdados1);
        this.add(btnComprar);
        this.add(btnJogar);
        _imgdados1.setBounds(new Rectangle(129, 298, 34, 34));
        _imgdados2.setBounds(new Rectangle(108, 274, 34, 34));

        _tabuleiro = new Tabuleiro();
        _tabuleiro.CarregaTabuleiro();
        status.CarregaJogadores();

        //       img = new ImageIcon("E:\\_Desenv\\java\\BancoImobiario\\imagens\\dado1.bmp");
        //Image img;
        // img.
        //   Graphics g = imagem.getGraphics();
        // g.drawRect(1,1,32,32);

//        this.repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        DesenhaTabuleiro desenha = new DesenhaTabuleiro(g, this);
        desenha.RepintaCasas(_tabuleiro.getCasas());

        //    URL url = this.getClass().getResource();
//     if (url == null)     System.out.println("ERRO");

        //      String imageName = java.util.ResourceBundle.getBundle(Globals.selected_lang).getString("/img/cards/police.gif");

    }

    public void this_mouseClicked(MouseEvent e) {

        Casa casa = _tabuleiro.getCasaClicada(e.getX(), e.getY());

        if (casa != null) {

            System.out.println("Clicou em: " + casa.getIndice());
            info.setCasa(casa);
            this.add(info);
            info.setBounds(new Rectangle(400, 100, 280, 370));
            info.setVisible(true);
            info.repaint();

        }
    }


    MouseAdapter ma = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            this_mouseClicked(e);
        }
    };
    JButton btnJogar = new JButton();
    TitledBorder titledBorder1 = new TitledBorder("");
    JLabel lblMensagem = new JLabel();
    JButton btnComprar = new JButton();
    public void btnJogar_actionPerformed(ActionEvent e) {

        try {
            Dado d = new Dado();
            Jogar j = new Jogar(_tabuleiro, lblMensagem);

            int id_casa;
            int dado1 = d.getIntDados();
            int dado2 = d.getIntDados();

            _imgdados1.SetDado(dado1);
            _imgdados2.SetDado(dado2);

            _imgdados1.paintImmediately(1, 1, 32, 32);
            _imgdados2.paintImmediately(1, 1, 32, 32);
            //        _imgdados.;

            id_casa = j.AvancarCasas(this, status.getJogadorAtual(),
                                     dado1 + dado2);

            j.ParouNaCasa(status.getJogadorAtual());

            status.AtualizaTabela();

            _tabuleiro.getCasa(id_casa).Desenha(this.getGraphics());

            j.ProximoJogador(status);
            //this.repaint();
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    public void repaint(Casa casa) {
        this.repaint(casa.getX(), casa.getY(), casa.getW(), casa.getH());
    }


    class Jogo_btnJogar_actionAdapter implements ActionListener {
        private Jogo adaptee;
        Jogo_btnJogar_actionAdapter(Jogo adaptee) {
            this.adaptee = adaptee;
        }

        public void actionPerformed(ActionEvent e) {
            adaptee.btnJogar_actionPerformed(e);
        }
    }


    class Jogo_this_mouseAdapter extends MouseAdapter {
        private Jogo adaptee;
        Jogo_this_mouseAdapter(Jogo adaptee) {
            this.adaptee = adaptee;
        }

        public void mouseClicked(MouseEvent e) {
            adaptee.this_mouseClicked(e);
        }
    }
}
