package Exercicio01;

public class Cubo extends FormaTridimensional{
    private double lado;

    public Cubo(String cor, int id, int x, int y, int z,float raio) {
        super(cor, id, x, y, z);
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double obterVolume(){
        return (lado*lado*lado);
    }
}
