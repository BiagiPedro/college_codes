package Circulo;

import Ponto.Ponto;
import static java.lang.Math.PI;
public class Circulo {

    private String nome;
    private float raio;
    private Ponto centro;

    public Circulo(String nome, float raio, Ponto centro) {
        if( nome != "") {
            this.nome = nome;
            this.centro = centro;
            this.raio = raio;
        }else {
            System.out.println("Nome nao preenchido ERROR");
            this.nome = "semNome";
        }
    }

    public float calcularDiametro() {
        return this.raio + this.raio;
    }


    public float calcularArea() {
        float raio2 = this.raio * this.raio;
        float area = (float) (PI * raio2);
        return area;
    }


    public float calcularperimetro() {
       float pi2 = (float) (PI * this.raio);
       return 2 * pi2;
    }

    public void modificraNome(String nome){
        this.nome = nome;
    }

    public void relatorio(){
        System.out.println("==========================");
        System.out.println("Dados do circulo ---"+this.nome);
        System.out.println("raio :"+this.raio);
        System.out.println("Diametro :"+this.calcularDiametro());
        System.out.println("Area  :"+this.calcularArea());
        System.out.println("Perimetro :"+this.calcularperimetro());
    }
}
