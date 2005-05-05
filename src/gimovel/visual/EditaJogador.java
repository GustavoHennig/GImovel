package gimovel.visual;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.*;

public class EditaJogador extends JFrame {
    public EditaJogador() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        txtNome.setText("");
        txtNome.setBounds(new Rectangle(9, 69, 211, 29));
        this.getContentPane().setLayout(null);
        btnCancelar.setBounds(new Rectangle(121, 109, 99, 44));
        btnCancelar.setText("Cancelar");
        btnOK.setBounds(new Rectangle(9, 109, 99, 44));
        btnOK.setText("OK");
        lblNome.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        this.getContentPane().add(btnCancelar);
        lblNome.setText("Nome");
        lblNome.setBounds(new Rectangle(11, 9, 52, 15));
        this.setResizable(false);
        this.setTitle("Editando Jogador");
        this.getContentPane().add(btnOK);
        this.getContentPane().add(txtNome, null);
        this.getContentPane().add(txtOutro);
        this.getContentPane().add(lblNome);
        txtOutro.setBounds(new Rectangle(9, 27, 211, 29));
    }

    public void setNome(String nome) {
        txtNome.setText(nome);
    }

    public void setCancelou(boolean cancelou) {
        this.cancelou = cancelou;
    }

    public String getNome() {
        return txtNome.getText();
    }

    public boolean isCancelou() {
        return cancelou;
    }

    JTextField txtNome = new JTextField();
    JTextField txtOutro = new JTextField();
    JButton btnOK = new JButton();
    JButton btnCancelar = new JButton();
    JLabel lblNome = new JLabel();
    private boolean cancelou;

}
