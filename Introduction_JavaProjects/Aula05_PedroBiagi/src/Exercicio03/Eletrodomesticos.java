package Exercicio03;

public class Eletrodomesticos implements Produto{
    public String marca;
    public float preco;
    @Override
    public String id() {
        return marca+anoProducao();
    }

    @Override
    public int anoProducao() {
        return 0;
    }

    @Override
    public String unidadeVenda() {
        return"U";
    }

    @Override
    public String categoria() {
        return null;
    }

    @Override
    public String preco() {
        return preco + this.unidadeVenda();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
