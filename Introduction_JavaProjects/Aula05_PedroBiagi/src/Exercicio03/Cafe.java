package Exercicio03;

public class Cafe implements Produto {
    public String idProdutora;
    public int numeroLote;
    public float preco;

    @Override
    public String id() {
        return idProdutora + anoProducao() + numeroLote;
    }

    @Override
    public int anoProducao() {
        return 0;
    }

    @Override
    public String unidadeVenda() {
        return "Kg";
    }

    @Override
    public String categoria() {
        return null;
    }

    @Override
    public String preco() {
        return this.preco + this.unidadeVenda();
    }

    public String getIdProdutora() {
        return idProdutora;
    }

    public void setIdProdutora(String idProdutora) {
        this.idProdutora = idProdutora;
    }

    public int getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(int numeroLote) {
        this.numeroLote = numeroLote;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
