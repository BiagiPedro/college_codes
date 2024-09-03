package Ponto;

import java.util.Scanner;

public class MainP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float x, y;
        int opcao;

        System.out.println("Inicie com dois pontos maio que 0");
        x = sc.nextFloat();
        y = sc.nextFloat();
        Ponto p1 = new Ponto(x, y);
        p1.setX(x);
        p1.setY(y);


        System.out.println("Inicie com dois pontos maio que 0");
        x = sc.nextFloat();
        y = sc.nextFloat();
        Ponto p2 = new Ponto(x, y);
        p2.setX(x);
        p2.setY(y);

        System.out.println(p1.distanciaEuclidiana(p2));

        do {
            System.out.println("1--Alterar Pontos");
            System.out.println("2--Retornar valores");
            System.out.println("3--Retornar Distancia euclidiana");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Alterar pontos");
                    System.out.println("Alterar P1");
                    x = sc.nextFloat();
                    y = sc.nextFloat();
                    p1.setX(x);
                    p1.setX(y);
                    System.out.println("Alterar P1");
                    x = sc.nextFloat();
                    y = sc.nextFloat();
                    p2.setX(x);
                    p2.setY(y);
                    break;

                case 2:
                    System.out.println("Retornar Valores ");
                    System.out.println("P1");
                    p1.printarPontos();
                    System.out.println("P2");
                    p2.printarPontos();
                    break;

                case 3:
                    System.out.println(p1.distanciaEuclidiana(p2));
                    break;

            }


        } while (opcao != 4);


    }
}
