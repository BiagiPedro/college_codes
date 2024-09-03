package Circulo;

import Circulo.Circulo;
import Ponto.Ponto;

import java.util.Scanner;
public class MainC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float x , y, raio;
        String nome;
        System.out.println("Inicialize com dois pontos e o raio");
        System.out.println("Ponto x");
        x = sc.nextFloat();
        System.out.println("Ponto y");
        y = sc.nextFloat();
        System.out.println("Tamanho raio");
        raio = sc.nextFloat();
        sc.nextLine();
        System.out.println("Nomeie o seu círculo");
        nome = sc.nextLine();
        Ponto p1 = new Ponto(x , y);
        Circulo pp = new Circulo(nome , raio , p1);

        pp.relatorio();



    }
}
