package gimovel.dados;

import java.util.ArrayList;
import java.util.Collection;

public class Jogadores {

    private ArrayList _jogadores;


    public Jogadores() {
        _jogadores = new ArrayList();
    }

    public void Add(Jogador jog) {
        _jogadores.add(jog);
    }

    public void Clear() {
        _jogadores = new ArrayList();
    }

    public int Count() {
        return _jogadores.size();
    }

    public Jogador Jogador(int posicao) {
        return (Jogador) _jogadores.get(posicao);
    }



}
