package Exercicio01;

public class FormaBidimensional extends Forma {

    private int x;
    private int y;

    public FormaBidimensional(String cor, int id, int x, int y) {
        super(cor, id);
        this.x = x;
        this.y = y;
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

    public double obterArea() {
        return 0;
    }

    public String mostra() {
        return super.mostra() + "-" + this.x + "-" + this.y;
    }

}
