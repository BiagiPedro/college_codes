package Exercicio01;

public class FormaTridimensional extends Forma {

    private int x;
    private int y;
    private int z;

    public FormaTridimensional(String cor, int id, int x, int y, int z) {
        super(cor, id);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public double obterVolume() {
        return 0;
    }

    public String mostra() {
        return super.mostra() + "-" + this.x + "-" + this.y + "-" + this.y;
    }

}
