package gimovel.visual;

import java.awt.*;

import javax.swing.*;

//import com.borland.jbcl.layout.XYConstraints;
//import com.borland.jbcl.layout.XYLayout;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import gimovel.dados.Jogadores;
import gimovel.dados.Jogador;


public class Status extends JPanel {


    private JLabel lblJogadores = new JLabel();
    private Tabela tblJogadores = new Tabela();
    private JLabel lblJogadorAtual = new JLabel();
    private JPanel jPanel1 = new JPanel();

    private Jogadores _jogadores = new Jogadores();
    private Jogador _jogadorAtual;


    public Status() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        lblJogadorAtual.setFont(new java.awt.Font("Arial", Font.BOLD, 18));
        lblJogadorAtual.setAutoscrolls(true);
        lblJogadorAtual.setBorder(BorderFactory.createLineBorder(Color.black));
        lblJogadorAtual.setHorizontalTextPosition(SwingConstants.RIGHT);
        lblJogadorAtual.setAlignmentX((float) 0.5);
        lblJogadorAtual.setOpaque(true);
        lblJogadorAtual.setBackground(new Color(212, 255, 200));
        lblJogadorAtual.setDisplayedMnemonic('0');
        lblJogadorAtual.setVerticalAlignment(SwingConstants.CENTER);
        lblJogadorAtual.setBounds(new Rectangle(117, 6, 96, 26));
        lblJogadores.setBackground(Color.lightGray);
        lblJogadores.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        lblJogadores.setAlignmentX((float) 0.0);
        lblJogadores.setAlignmentY((float) 0.5);
        lblJogadores.setBorder(null);
        lblJogadores.setOpaque(true);
        lblJogadores.setText(" Jogadores");
        lblJogadores.setBounds(new Rectangle(6, 6, 70, 27));
        lblJogadorAtual.setText("Gustavo");

        tblJogadores.setAlignmentY((float) 0.3);
        tblJogadores.setBorder(null);
        tblJogadores.setMaximumSize(new Dimension(640, 480));
        this.setToolTipText("");
        
        AbsoluteLayout xYLayout1 = new AbsoluteLayout();
        
        this.setLayout(xYLayout1);
        jPanel1.setBackground(Color.lightGray);
        jPanel1.setBorder(BorderFactory.createRaisedBevelBorder());
        jPanel1.setLayout(null);
        jPanel1.add(lblJogadores);
        jPanel1.add(lblJogadorAtual);
        this.add(jPanel1, new AbsoluteConstraints(1, 1, 221, 39));
        this.add(tblJogadores, new AbsoluteConstraints(1, 40, 220, 117));
    }

    public void setJogadorAtual(int ID_Jogador) {
        _jogadorAtual = _jogadores.Jogador(ID_Jogador);
        lblJogadorAtual.setText(_jogadorAtual.getNome());
        lblJogadorAtual.setBackground(_jogadorAtual.getCor());
    }

    public Jogador getJogadorAtual() {
        return _jogadorAtual;
    }

    public Jogadores getJogadores() {
        return _jogadores;
    }

    public void CarregaJogadores() {
        _jogadores.Add(new Jogador(0, "Gustavo", new Color(100, 220, 220), 0));
        _jogadores.Add(new Jogador(0, "Patatof", new Color(100, 220, 20), 1));
        _jogadores.Add(new Jogador(0, "Asdrubal", new Color(200, 20, 220), 2));

        for (int i = 0; i < _jogadores.Count(); i++) {
            tblJogadores.addJogador(
                    _jogadores.Jogador(i).getNome(),
                    _jogadores.Jogador(i).getDinheiro());
        }

        setJogadorAtual(0);
    }

    public void AtualizaTabela(){
        tblJogadores.Clear();
        for (int i = 0; i < _jogadores.Count(); i++) {
            tblJogadores.addJogador(
                    _jogadores.Jogador(i).getNome(),
                    _jogadores.Jogador(i).getDinheiro());
        }
    }
}
