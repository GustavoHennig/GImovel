package gimovel.visual;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;

public class Splash extends JFrame {
    public Splash() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(borderLayout1);
        this.setResizable(false);
        this.setSize(320, 240);
        this.setLocation(300, 300);
        lblAguarde.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        lblAguarde.setHorizontalAlignment(SwingConstants.CENTER);
        lblAguarde.setHorizontalTextPosition(SwingConstants.CENTER);
        lblAguarde.setText("Aguarde...");
        this.getContentPane().add(lblAguarde, java.awt.BorderLayout.CENTER);
    }

    JLabel lblAguarde = new JLabel();
    BorderLayout borderLayout1 = new BorderLayout();
}
