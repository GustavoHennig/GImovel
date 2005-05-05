package gimovel.dados;

import java.awt.*;

public class Casa {


    private int _X, _Y, _Larg, _Alt;
    private String _nm_Casa, _descricao, _ramo;
    private Color _corFundo;
    private int _Preco, _RendimentoInicial, _RendimentoAtual;
    private int _NroFiliais, _Atualizacao;
    private int _Indice;
    private Jogador[] _Jogadores = new Jogador[4];
    private Jogador _proprietario;
    private int _nroVisitasProprietario;
    private int _nroVisitasClientes;
    private boolean _Hipotecada;
    //    private JTextArea  lblNome= new JTextArea();

    public Casa(int X, int Y, int Larg, int Alt, Color cor, int indice) {
        _X = X;
        _Y = Y;
        _Larg = Larg;
        _Alt = Alt;
        _corFundo = cor;
        _Indice = indice;
        //      PreparaLabel();
    }

    public Casa(int X, int Y, int Larg, int Alt, int indice) {
        _X = X;
        _Y = Y;
        _Larg = Larg;
        _Alt = Alt;
        _Indice = indice;
//        PreparaLabel();
    }

    public String getNm_Casa() {
        return _nm_Casa;
    }

    public void setNm_Casa(String valor) {
        _nm_Casa = valor;
        //      lblNome.setText(_nm_Casa);
    }

    public void setCor(Color cor) {
        _corFundo = cor;
        //      lblNome.setBackground(_corFundo);
    }

    public void Desenha(Graphics g) {
        this.Desenha((Graphics2D) g);
    }

    public void Desenha(Graphics2D g2d) {

        g2d.setColor(_corFundo);
        g2d.fillRect(_X, _Y, _Larg, _Alt);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(_X, _Y, _Larg, _Alt);
        DesenhaJogadores(g2d);
        DesenhaProprietario(g2d);
        DesenhaNomeCasa(g2d);

    }

    private void DesenhaNomeCasa(Graphics2D g2d) {
        if (_nm_Casa != null) {

            //    DesenhaLabel();

            g2d.setFont(new java.awt.Font("Arial", Font.PLAIN, 10));

            int ultPos = 0;
            int charPorLinha = 0;
            int tamanho = _nm_Casa.length();
            int posIni = 0;
            int posFim = 0;
            int linha = 0;

            if (isVertical()) {
                charPorLinha = 9;
            } else {
                charPorLinha = 18;
            }

            posFim += charPorLinha;

            while (posFim < tamanho + charPorLinha) {

                try {
                    g2d.drawString(_nm_Casa.substring(posIni,
                            (posFim > tamanho - 1 ? tamanho : posFim)),
                                   _X + 1, _Y + 12 + linha);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                posIni += charPorLinha;
                posFim += charPorLinha;

                linha += 12;
            }

        }

    }

    public int getX() {
        return _X;
    }

    public int getY() {
        return _Y;
    }

    public int getH() {
        return _Alt;
    }

    public int getW() {
        return _Larg;
    }

    public String getDescricao() {
        return _descricao;
    }

    public void setDescricao(String ds) {
        _descricao = ds;
    }

    public void setPreco(int valor) {
        _Preco = valor;
    }

    public int getPreco() {
        return _Preco;
    }

    public void setRendimentoAtual(int valor) {
        _RendimentoAtual = valor;
    }

    public int getRendimentoAtual() {
        return _RendimentoAtual;
    }

    public void setRendimentoInicial(int valor) {
        _RendimentoInicial = valor;
    }

    public int getRendimentoInicial() {
        return _RendimentoInicial;
    }

    public void setNroFiliais(int valor) {
        _NroFiliais = valor;
    }

    public int getNroFiliais() {
        return _NroFiliais;
    }

    public void setAtualizacao(int valor) {
        _Atualizacao = valor;
    }

    public int getAtualizacao() {
        return _Atualizacao;
    }

    public int getIndice() {
        return _Indice;
    }

    public Color getCor() {
        return _corFundo;
    }

    public boolean isVertical() {
        return _Alt > _Larg;
    }

    public void setRamo(String ramo) {
        _ramo = ramo;
    }

    public String getRamo() {
        return _ramo;
    }

    private int CasaX(int X, int Y) {
        int ret = 0;
        if (isVertical()) {
            ret = _X + X;
        } else {
            ret = _X + Y;
        }
        return ret;
    }

    private int CasaY(int X, int Y) {
        int ret = 0;
        if (isVertical()) {
            ret = _Y + Y;
        } else {
            ret = _Y + _Alt - X - 3;
        }
        return ret;
    }

    private void DesenhaProprietario(Graphics2D g2d) {
        if (_proprietario != null) {
            g2d.setColor(_proprietario.getCor());
            DesenhaCirculo(g2d, 1, 1, 3);
//         g2d.setColor(Color.BLACK);
        }

    }

    private void DesenhaJogadores(Graphics2D g2d) {

        for (int i = 0; i < 4; i++) {
            if (_Jogadores[i] != null) {
                g2d.setColor(_Jogadores[i].getCor());
                DesenhaJogador(g2d, i);
            } else {
                g2d.setColor(_corFundo);
            }

            g2d.setColor(Color.BLACK);
        }

    }

    private void DesenhaJogador(Graphics2D g2d, int ID_Jogador) {
        int x1 = 15, y1 = 50, x2 = 30, y2 = 65;

        switch (ID_Jogador) {
        case 0:
            DesenhaCirculo(g2d, x1, y1);
            break;
        case 1:
            DesenhaCirculo(g2d, x1, y2);
            break;
        case 2:
            DesenhaCirculo(g2d, x2, y1);
            break;
        case 3:
            DesenhaCirculo(g2d, x2, y2);
            break;
        }

    }

    private void DesenhaCirculo(Graphics2D g2d, int x, int y) {
        final int tamanho = 12;

        g2d.fillOval(CasaX(x, y), CasaY(x, y), tamanho, tamanho);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(CasaX(x, y), CasaY(x, y), tamanho, tamanho);
    }

    private void DesenhaCirculo(Graphics2D g2d, int x, int y, int tamanho) {

        g2d.fillOval(CasaX(x, y), CasaY(x, y),(int) (tamanho * 2), tamanho);
        g2d.setColor(Color.BLACK);
//        g2d.drawOval(CasaX(x, y), CasaY(x, y), tamanho, tamanho);
    }

    public void AtualizacaoCasa(int percentual){

         //  this._Atualizacao += (this._Atualizacao * percentual / 100);

           _RendimentoAtual += _RendimentoAtual * percentual / 100;
    }

    public void setJogador(int jogador_casa, Jogador id_jogador) {
        this._Jogadores[jogador_casa] = id_jogador;
    }

    public Jogador getJogador(int jogador_casa) {
        return _Jogadores[jogador_casa];
    }

    public void setProprietario(Jogador proprietario) {
        this._proprietario = proprietario;
    }

    public Jogador getProprietario() {
        return _proprietario;
    }

    public void setNroVisitasProprietario(int nroVisitasProprietario) {
        this._nroVisitasProprietario = nroVisitasProprietario;
    }

    public void setNroVisitasClientes(int nroVisitasClientes) {
        this._nroVisitasClientes = nroVisitasClientes;
    }

    public int getNroVisitasProprietario() {
        return _nroVisitasProprietario;
    }

    public int getNroVisitasClientes() {
        return _nroVisitasClientes;
    }

    public void setHipotecada(boolean vl) {
        this._Hipotecada = vl;
    }



    /*
        private void PreparaLabel() {
            lblNome.setBounds(_X, _Y, _Larg, _Alt);

            lblNome.setBorder(BorderFactory.createLineBorder(Color.black));
            lblNome.setFont(new java.awt.Font("Arial", Font.PLAIN ,  10));
           // lblNome.setHorizontalAlignment(SwingConstants.LEFT);
      //      lblNome.setHorizontalTextPosition(SwingConstants.CENTER);
            //lblNome.setVerticalAlignment(SwingConstants.TOP);
//        lblNome.setVerticalTextPosition(SwingConstants.TOP);
            lblNome.setBackground(_corFundo);
            lblNome.setLineWrap(true);
            lblNome.setOpaque(true);
            lblNome.setEditable(false);
            lblNome.setWrapStyleWord(true);
        }

        private void DesenhaLabel() {

            lblNome.repaint();
//  this.getContentPane().add(lblAguarde, java.awt.BorderLayout.CENTER);
        }

        public JTextArea getLabel() {
            return lblNome;
        }
     */

}
