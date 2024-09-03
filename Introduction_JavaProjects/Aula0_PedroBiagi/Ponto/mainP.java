package Ponto;
import java.util.Scanner;

public class mainP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float leitura1 = 0;
        float leitura2 = 0;

        System.out.println("entre com dois pontos");
        leitura1 = sc.nextFloat();
        leitura2 = sc.nextFloat();
        ponto p1 = new ponto(leitura1,leitura2);
        System.out.println("entre com mais dois pontos");
        leitura1 = sc.nextFloat();
        leitura2 = sc.nextFloat();
        ponto p2 = new ponto(leitura1,leitura2);

        System.out.println("a distancia euclidiana eh");
        System.out.println(p1.DistanciaEuclidiana(leitura1,leitura2));

        System.out.println();

    }
}
