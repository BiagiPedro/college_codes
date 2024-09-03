package Exercicio01;

public class Esfera extends FormaTridimensional{
    private double raio;

    public Esfera(String cor, int id, int x, int y, int z,float raio) {
        super(cor, id, x, y, z);
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double obterVolume(){
        return ((4/3)*3.14*(raio*raio*raio));
    }

    public boolean interceptaE(Esfera e){
        double dx = Math.pow((getX()- e.getX()), 2);
        double dy = Math.pow((getY()- e.getY()), 2);
        double dz = Math.pow((getZ()- e.getZ()), 2);
        double d = Math.sqrt(dx+dy+dz);
        return d <= (getRaio() + e.getRaio());
    }
}
