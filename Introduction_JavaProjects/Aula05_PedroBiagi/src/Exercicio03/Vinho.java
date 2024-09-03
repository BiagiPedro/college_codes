package Exercicio03;

public class Vinho implements Produto {
    public String lote;
    public float valorBase;
    public float idade;
    public float valor;

    @Override
    public String id() {
        return lote;
    }

    @Override
    public int anoProducao() {
        return 0;
    }

    @Override
    public String unidadeVenda() {
        return "L";
    }

    @Override
    public String categoria() {
        return null;
    }

    public void setValor() {
        this.valor = this.valorBase + (this.idade * 20);
    }

    @Override
    public String preco() {
        setValor();
        return valor + unidadeVenda();
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public float getValorBase() {
        return valorBase;
    }

    public void setValorBase(float valorBase) {
        this.valorBase = valorBase;
    }

    public float getIdade() {
        return idade;
    }

    public void setIdade(float idade) {
        this.idade = idade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
