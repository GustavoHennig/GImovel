package gimovel.jogo;

import gimovel.dados.Jogador;
import gimovel.dados.Tabuleiro;
import gimovel.visual.Status;
import gimovel.dados.Casa;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.*;

public class Jogar {
    public Jogar() {
    }

    Tabuleiro _tabuleiro;
    JLabel _lblMensagem;

    public Jogar(Tabuleiro tabuleiro, JLabel msg) {
        _tabuleiro = tabuleiro;
        _lblMensagem = msg;
    }

    public void JogarDado() {

    }

    public int AvancarCasas(Jogo jogo, Jogador jog, int n_casas) {

        int pos_ant, pos_nova, pos_atual;

        pos_ant = jog.getPosicao();
        pos_atual = pos_ant;
        pos_nova = jog.getPosicao() + n_casas;

        if (pos_nova > 43) {
            pos_nova -= 44;
        }

        while (jog.getPosicao() != pos_nova) {

            pos_atual++;
            if (pos_atual > 43) {
                pos_atual -= 44;
            }

            Casa casa;
            casa = _tabuleiro.getCasas()[jog.getPosicao()];
            casa.setJogador(jog.getID_Jogador(), null);

            casa.Desenha(jogo.getGraphics());
            jog.setPosicao(pos_atual);
            casa = _tabuleiro.getCasas()[jog.getPosicao()];

            if (pos_atual == 0) {
                jog.AdicionaDinheiro(casa.getRendimentoAtual());
            }

            casa.setJogador(jog.getID_Jogador(), jog);

            casa.Desenha(jogo.getGraphics());

            try {
                Thread.sleep(120);
            } catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }


         //   this.notify();
           // System.Win
            // this.repaint(casa);
        }
        return pos_nova;
    }


    public void ProximoJogador(Status status) throws Exception {

        int tot = status.getJogadores().Count();
        int jog = status.getJogadorAtual().getID_Jogador();

        int todosfalidos = 0;
        boolean repete = true;

        while (repete) {
            jog++;
            repete = false;

            if (jog >= tot) {
                jog -= tot;
            }

            if (status.getJogadores().Jogador(jog).isFalido()) {
                todosfalidos++;
                repete = true;
            }
            if (todosfalidos >= tot - 1) {
                throw new Exception("Todos jogadores estão falidos.");
            } else if (todosfalidos == tot - 1) {
                throw new Exception("Todos outros jogadores faliram.");
            }

        }

        status.setJogadorAtual(jog);

    }

    public void ParouNaCasa(Jogador jog) {

        Casa casa = _tabuleiro.getCasas()[jog.getPosicao()];

        if (casa.getProprietario() == null) {
            if (!(casa.getPreco() > jog.getDinheiro())) {

                _lblMensagem.setText(
                        "Casa disponível para a compra.");

                if (JOptionPane.showConfirmDialog(null,
                                                  "Você deseja comprar essa casa por " +
                                                  casa.getPreco(), "Comprar",
                                                  JOptionPane.YES_NO_OPTION) ==
                    JOptionPane.OK_OPTION) {

                    CompraCasa(casa, jog);

                }
            } else {
                _lblMensagem.setText(
                        "Casa disponível mas você está sem dinheiro para compra-la");
            }

        } else if (!casa.getProprietario().equals(jog)) {

            casa.setNroVisitasClientes(casa.getNroVisitasClientes() + 1);

            _lblMensagem.setText(jog.getNome() + " pagou R$ " +
                                 Integer.toString(casa.getRendimentoAtual()) +
                                 " para " + casa.getProprietario().getNome() +
                                 ".");
            jog.RetiraDinheiro(casa.getRendimentoAtual());

            casa.getProprietario().AdicionaDinheiro(casa.getRendimentoAtual());

        } else if (casa.getProprietario().equals(jog)) {
            casa.setNroVisitasProprietario(casa.getNroVisitasProprietario() + 1);
            _lblMensagem.setText("Você é o proprietário.");
        }

        ValidaDinheiroJogador(jog);

    }


    public void CompraCasa(Casa casa, Jogador jog) {
        if (jog.getDinheiro() >= casa.getPreco()) {

            jog.RetiraDinheiro(casa.getPreco());

            casa.setProprietario(jog);
            _lblMensagem.setText(casa.getNm_Casa() + " comprada por " +
                                 jog.getNome());
        } else {
//          JOptionPane.showMessageDialog(null, "Dinheiro insuficiente.");
            _lblMensagem.setText("Dinheiro insuficiente.");

        }
    }

    public void AtualizarCasa(Casa casa, Jogador jog) {
        if (JOptionPane.showConfirmDialog(null,
                                          "Você deseja atualizar essa casa agora " +
                                          casa.getPreco(), "Comprar",
                                          JOptionPane.YES_NO_OPTION) ==
            JOptionPane.OK_OPTION) {

        }

    }

    private void ValidaDinheiroJogador(Jogador jog) {
        boolean ret = jog.getDinheiro() < 0;

        if (ret) {
            FalenciaJogador(jog);
        }

//        return ret;
    }

    private void FalenciaJogador(Jogador jog) {
        JOptionPane.showMessageDialog(null, "Esse jogador faliu!");
        jog.setFalido(true);
        //Remove casas vinculadas ao jogador
        Casa[] casa = _tabuleiro.getCasas();

        for (int i = 0; i < casa.length; i++) {
            if (casa[i].getProprietario() == jog) {
                casa[i].setProprietario(null);
            }
        }

        _lblMensagem.setText(
                "Todas casas do jogador falido estão disponíveis para a venda.");
    }

    private int HipotecarCasa(Casa casa) {
        int ret = 0;
        ret = casa.getPreco() / 2;
        casa.setHipotecada(true);
        return ret;
    }
    private int DeshipotecarCasa(Casa casa) {
    int ret = 0;
    double result;

    result = casa.getPreco() * 2.1;
    ret = (int) result;

    casa.setHipotecada(true);
    return ret;

    }



}
