package gimovel.visual;

import java.awt.Color;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Tabela extends JScrollPane {

    private DefaultTableModel dtm;
    private JTable _tabela = new JTable();
    JPopupMenu MenuTabela = new JPopupMenu();
    JMenuItem jMenuItem1 = new JMenuItem();

    public Tabela() {

        dtm = (DefaultTableModel) _tabela.getModel();

        dtm.addColumn("Jogador");
        dtm.addColumn("Dinheiro");

        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void addJogador(String nome, int dinheiro) {

        String[] linha = new String[2];
        linha[0] = nome;
        linha[1] = Integer.toString(dinheiro);

        dtm.addRow(linha);

    }


    public void Clear() {

        int cnt = dtm.getRowCount();

        for (int i = 0; i < cnt; i++) {
            dtm.removeRow(0);
        }

    }

    private void jbInit() throws Exception {
        _tabela.setEnabled(true);
        _tabela.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        _tabela.setBorder(null);
        _tabela.addMouseListener(new Tabela__tabela_mouseAdapter(this));
        _tabela.setSize(100, 200);
        _tabela.getColumnModel().getColumn(0).setPreferredWidth(75);
        _tabela.getColumnModel().getColumn(1).setPreferredWidth(25);
        jMenuItem1.setText("Editar");

        this.getViewport().add(_tabela);
        MenuTabela.add(jMenuItem1);
        this.setBorder(BorderFactory.createLoweredBevelBorder());
    }

    public void _tabela_mouseClicked(MouseEvent e) {

        if (e.getButton() == e.BUTTON3) {
            // JOptionPane.showMessageDialog(null, "Mensagem");
            MenuTabela.show(_tabela, e.getX(), e.getX());
        }
    }
}


class Tabela__tabela_mouseAdapter extends MouseAdapter {
    private Tabela adaptee;
    Tabela__tabela_mouseAdapter(Tabela adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseClicked(MouseEvent e) {
        adaptee._tabela_mouseClicked(e);
    }
}
