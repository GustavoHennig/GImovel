package gimovel.dados;

public class CasaXml {
    private String nome;
    private String ramo;
    private String descricao;
    private double preco;
    private double rendimento;
    private char cor;

    public CasaXml() {

    }

    private void jbInit() throws Exception {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public void setCor(char cor) {
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public String getRamo() {
        return ramo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public double getRendimento() {
        return rendimento;
    }

    public char getCor() {
        return cor;
    }
}
