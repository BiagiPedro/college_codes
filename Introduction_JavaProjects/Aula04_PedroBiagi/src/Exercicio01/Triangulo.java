package Exercicio01;

public class Triangulo extends FormaBidimensional{
    private double base;
    private double altura;

    public Triangulo(String cor, int id, int x, int y,float altura , float base) {
        super(cor, id, x, y);
        this.altura = altura;
        this.base = base;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double obterArea() {
        return (base * altura);
    }
}
