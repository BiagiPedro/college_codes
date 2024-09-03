package Exercicio01;

public class Forma {
    private String cor;
    private int identificador;

    public Forma(String cor, int id) {
        this.cor = cor;
        this.identificador = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String mostra() {
        return +this.identificador + "-" + this.cor;
    }

}
