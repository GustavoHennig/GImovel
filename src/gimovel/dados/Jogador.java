package gimovel.dados;

import java.awt.Color;

public class Jogador {

    private int posicao;
    private String nome;
    private char simbolo;
    private int dinheiro = 0;
    private Color cor;
    private int ID_Jogador;
    private boolean falido;


    public Jogador(int posicao, String nome, Color cor, int ID_Jogador) {
        this.posicao = posicao;
        this.nome = nome;
        this.cor = cor;
        this.ID_Jogador = ID_Jogador;
        this.dinheiro = 100000;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public void setFalido(boolean falido) {
        this.falido = falido;
    }

    public void setID_Jogador(int ID_Jogador) {
        this.ID_Jogador = ID_Jogador;
    }

    public int getPosicao() {
        return posicao;
    }

    public String getNome() {
        if(falido){
         return nome + "(Falido)";
        }else{
          return nome;
        }

    }

    public char getSimbolo() {
        return simbolo;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public Color getCor() {
        return cor;
    }

    public boolean isFalido() {
        return falido;
    }

    public int getID_Jogador() {
        return ID_Jogador;
    }

    public void AdicionaDinheiro(int valor){
           dinheiro += valor;
    }

    public void RetiraDinheiro(int valor){
           dinheiro -= valor;
    }


}
