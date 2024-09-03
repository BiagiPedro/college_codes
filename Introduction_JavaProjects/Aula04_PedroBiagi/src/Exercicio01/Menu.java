package Exercicio01;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Forma[] vetorFormas = new Forma[6];
        vetorFormas[0] = new Circulo("Azul", 11111, 5, 1, 2);
        vetorFormas[1] = new Quadrado("Vermelho", 22222, 4, 3, 4);
        vetorFormas[2] = new Triangulo("Verde", 33333, 3, 5, 6, 2);
        vetorFormas[3] = new Esfera("Amarelo", 44444, 2, 7, 8, 9);
        vetorFormas[4] = new Cubo("Roxo", 55555, 3, 10, 11, 12);
        vetorFormas[5] = new Tetraedro("Laranja", 66666, 4, 13, 14, 15, 16, 17, 18);


        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Mostrar descrição textual de todas as formas cadastradas");
            System.out.println("2. Mostrar área das formas bidimensionais cadastradas");
            System.out.println("3. Mostrar volume das formas tridimensionais cadastradas");
            System.out.println("4. Verificar se existem duas esferas ou dois círculos que se interceptam");
            System.out.println("0. Sair");
            System.out.print("Escolha a opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    for (int i = 0; i < 6; i++) {
                        if (vetorFormas[i] instanceof FormaBidimensional) {
                            System.out.println(((FormaBidimensional) vetorFormas[i]).mostra());
                        }
                    }

                    for (int i = 0; i < 6; i++) {
                        if (vetorFormas[i] instanceof FormaTridimensional) {
                            System.out.println(((FormaTridimensional) vetorFormas[i]).mostra());
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 6; i++) {
                        if (vetorFormas[i] instanceof FormaBidimensional) {
                            double area = ((FormaBidimensional) vetorFormas[i]).obterArea();
                            System.out.println("Área da forma " + vetorFormas[i].getIdentificador() + ": " + area);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 6; i++) {
                        if (vetorFormas[i] instanceof FormaTridimensional) {
                            double volume = ((FormaTridimensional) vetorFormas[i]).obterVolume();
                            System.out.println("Volume da forma " + vetorFormas[i].getIdentificador() + ": " + volume);
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < vetorFormas.length; i++) {
                        if (vetorFormas[i] instanceof Circulo || vetorFormas[i] instanceof Esfera) {
                            for (int j = i + 1; j < vetorFormas.length; j++) {
                                if (vetorFormas[j] instanceof Circulo) {
                                    if (((Circulo) vetorFormas[i]).interceptaC((Circulo) vetorFormas[j])) {
                                        System.out.println("As formas " + vetorFormas[i].getIdentificador() + " e " + vetorFormas[j].getIdentificador() + " se interceptam.");
                                    } else {
                                        System.out.println("As formas " + vetorFormas[i].getIdentificador() + " e " + vetorFormas[j].getIdentificador() + " não se interceptam.");
                                    }
                                }
                            }
                        }
                    }
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0);

    }
}