package Exercicio01;

public class Quadrado extends FormaBidimensional{
    private double lado;

    public Quadrado(String cor, int id, int x, int y,float lado) {
        super(cor, id, x, y);
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double obterArea() {
        return (lado*lado);
    }

}
