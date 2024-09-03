package Exercicio01;

public class Circulo extends FormaBidimensional {
    private double raio;

    public Circulo(String cor, int id, int x, int y,float raio) {
        super(cor, id, x, y);
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double obterArea() {
        return (3.14*(raio*raio));
    }

    public boolean interceptaC(Circulo r){
        double dx = Math.pow((getX()- r.getX()), 2);
        double dy = Math.pow((getY()- r.getY()), 2);
        double d = Math.sqrt(dx+dy);
        return d <= (getRaio() + r.getRaio());
    }
}
