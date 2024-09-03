package Exercicio01;

public class Tetraedro extends FormaTridimensional{
    private double base;
    private double altura;
    private double alturaBase;

    public Tetraedro(String cor, int id, int x, int y, int z, float altura, float base, int i, int i1) {
        super(cor, id, x, y, z);
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

    public double getAlturaBase() {
        return alturaBase;
    }

    public void setAlturaBase(double alturaBase) {
        this.alturaBase = alturaBase;
    }

    public double obterVolume(){
        return ((1/3)*alturaBase*altura);
    }
}
