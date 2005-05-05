package gimovel.visual;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import gimovel.geral.Geral;
import gimovel.dados.*;

public class Info extends JPanel {

    JLabel lblTitulo = new JLabel();

    JTextArea taDescricao = new JTextArea();
    Jogador _jogador;
    Casa _casa;
    Status _status;

    ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            // System.out.print("Ahhh, estou me destruindo....");
            //          Esconde();
            t.stop();
        }
    };

    Timer t = new Timer(10000, taskPerformer);
    JLabel lblPreco = new JLabel();

    Border bordaPadrao = BorderFactory.createEtchedBorder(Color.white,
            new Color(148, 145, 140));

    JLabel lblRendimento = new JLabel();
    JLabel lblRamo = new JLabel();
    JButton btnAtualizar = new JButton();
    JButton btnFechar = new JButton();
    JLabel lblProprietario = new JLabel();
    JLabel lblNroVisitas = new JLabel();
    JButton btnHipoteca = new JButton();

    public Info() {

        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        lblTitulo.setFont(new java.awt.Font("Dialog", Font.BOLD, 18));
        lblTitulo.setForeground(new Color(0, 0, 79));
        lblTitulo.setBorder(BorderFactory.createEtchedBorder());
        lblTitulo.setText("Casa das quenga");
        lblTitulo.setBounds(new Rectangle(3, 2, 273, 29));
        this.setLayout(null);
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        taDescricao.setFont(new java.awt.Font("Arial", Font.BOLD | Font.ITALIC,
                                              12));
        taDescricao.setBorder(BorderFactory.createLoweredBevelBorder());
        taDescricao.setEditable(false);
        taDescricao.setMargin(new Insets(1, 1, 1, 1));
        taDescricao.setText("Essa casa possui 5 níveis de atualizaçao.");
        taDescricao.setLineWrap(true);
        taDescricao.setRows(50);
        taDescricao.setWrapStyleWord(true);
        taDescricao.setBounds(new Rectangle(5, 63, 263, 97));
        lblPreco.setBorder(new TitledBorder(bordaPadrao, "Valor"));
        lblPreco.setText("R$ 0,00");
        lblPreco.setBounds(new Rectangle(11, 169, 88, 39));
        lblRendimento.setBorder(new TitledBorder(bordaPadrao, "Rendimento"));
        lblRendimento.setText("R$ 0,00");
        lblRendimento.setBounds(new Rectangle(102, 169, 88, 38));
        lblRamo.setFont(new java.awt.Font("Arial", Font.ITALIC, 12));
        lblRamo.setBorder(null);
        lblRamo.setText("jLabel1");
        lblRamo.setBounds(new Rectangle(5, 35, 267, 24));
        btnAtualizar.setBounds(new Rectangle(8, 264, 78, 35));
        btnAtualizar.setEnabled(false);
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new Info_btnAtualizar_actionAdapter(this));
        btnFechar.setBounds(new Rectangle(176, 263, 70, 36));
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new Info_btnFechar_actionAdapter(this));
        lblProprietario.setBorder(new TitledBorder(bordaPadrao, "Proprietário"));
        lblProprietario.setText("");
        lblProprietario.setBounds(new Rectangle(9, 213, 90, 41));
        lblNroVisitas.setBorder(new TitledBorder(bordaPadrao, "Visitas"));
        lblNroVisitas.setBounds(new Rectangle(106, 210, 97, 41));
        btnHipoteca.setBounds(new Rectangle(89, 263, 82, 36));
        btnHipoteca.setEnabled(false);
        btnHipoteca.setText("Hipotecar");
        btnHipoteca.addActionListener(new Info_btnHipoteca_actionAdapter(this));
        this.add(lblTitulo);
        this.add(lblRamo);
        this.add(taDescricao);
        this.add(btnAtualizar);
        this.add(lblPreco);
        this.add(lblRendimento);
        this.add(lblProprietario);
        this.add(btnHipoteca);
        this.add(btnFechar);
        this.add(lblNroVisitas);
        t.start();
    }

    public void setStatus(Status status){
        _status=status;
    }

    public void setCasa(Casa casa) {

        _casa = casa;

        lblRamo.setText(_casa.getRamo());
        lblRendimento.setText(Geral.SimboloMoedaLocalEspFim() +
                              Integer.toString(_casa.getRendimentoAtual()));
        lblPreco.setText(Geral.SimboloMoedaLocalEspFim() +
                         Integer.toString(_casa.getPreco()));
        lblTitulo.setText(_casa.getNm_Casa());
        taDescricao.removeAll();
        taDescricao.setText(_casa.getDescricao());
        if (casa.getProprietario() != null){
            lblProprietario.setText(casa.getProprietario().getNome());
        }

        lblNroVisitas.setText(String.valueOf(casa.getNroVisitasProprietario()));

        System.out.println(casa.getAtualizacao());
        System.out.println((casa.getNroVisitasProprietario() / 3) - 1);


        if (casa.getAtualizacao() <= (casa.getNroVisitasClientes() / 3) - 1) {
            btnAtualizar.setEnabled(true);

        }
    }

    public void Esconde() {
        this.setVisible(false);
    }

    public void btnFechar_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    public void btnAtualizar_actionPerformed(ActionEvent e) {
        _casa.AtualizacaoCasa(10) ;

        lblRendimento.setText(Geral.SimboloMoedaLocalEspFim() +
                              Integer.toString(_casa.getRendimentoAtual()));


    }

    public void btnHipoteca_actionPerformed(ActionEvent e) {


    }

}


class Info_btnHipoteca_actionAdapter implements ActionListener {
    private Info adaptee;
    Info_btnHipoteca_actionAdapter(Info adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnHipoteca_actionPerformed(e);
    }
}


class Info_btnAtualizar_actionAdapter implements ActionListener {
    private Info adaptee;
    Info_btnAtualizar_actionAdapter(Info adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnAtualizar_actionPerformed(e);
    }
}


class Info_btnFechar_actionAdapter implements ActionListener {
    private Info adaptee;
    Info_btnFechar_actionAdapter(Info adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnFechar_actionPerformed(e);
    }
}
