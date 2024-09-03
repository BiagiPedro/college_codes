package Exercicio03;

import java.util.Scanner;

public class MainProdutos {
    public static void main(String[] args) {
        Eletrodomesticos[] eletrodomesticos = new Eletrodomesticos[5];
        Vinho[] vinhos = new Vinho[5];
        Cafe[] cafes = new Cafe[5];

        Scanner scanner = new Scanner(System.in);

        int contadorEletrodomesticos = 0;
        int contadorVinhos = 0;
        int contadorCafes = 0;

        while (true) {
            System.out.println("1- Adicionar produto");
            System.out.println("2- Calcular quantidade e preço total de uma categoria");
            System.out.println("3- Calcular total geral dos produtos");
            System.out.println("4- Ler produtos");
            System.out.println("5- Sair");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Escolha o tipo de produto: ");
                    String tipoProduto = scanner.nextLine();

                    switch (tipoProduto.toLowerCase()) {
                        case "eletrodomestico":
                            if (contadorEletrodomesticos < 5) {
                                eletrodomesticos[contadorEletrodomesticos] = new Eletrodomesticos();

                                System.out.println("Produto adicionado com sucesso.");
                                contadorEletrodomesticos++;
                            } else {
                                System.out.println("Limite de eletrodomésticos atingido.");
                            }
                            break;
                        case "vinho":
                            if (contadorVinhos < 5) {
                                vinhos[contadorVinhos] = new Vinho();

                                System.out.println("Produto adicionado com sucesso.");
                                contadorVinhos++;
                            } else {
                                System.out.println("Limite de vinhos atingido.");
                            }
                            break;
                        case "cafe":
                            if (contadorCafes < 5) {
                                cafes[contadorCafes] = new Cafe();

                                System.out.println("Produto adicionado com sucesso.");
                                contadorCafes++;
                            } else {
                                System.out.println("Limite de cafés atingido.");
                            }
                            break;
                        default:
                            System.out.println("Tipo de produto inválido.");
                    }
                    break;
                case 2:
                    System.out.println("Digite a categoria desejada: ");
                    String categoria = scanner.nextLine();

                    int quantidade = 0;
                    float precoTotal = 0;

                    switch (categoria.toLowerCase()) {
                        case "eletrodomestico":
                            for (int i = 0; i < contadorEletrodomesticos; i++) {
                                quantidade++;
                                precoTotal += Float.parseFloat(eletrodomesticos[i].preco().replace(eletrodomesticos[i].unidadeVenda(), ""));
                            }
                            break;
                        case "vinho":
                            for (int i = 0; i < contadorVinhos; i++) {
                                quantidade++;
                                precoTotal += Float.parseFloat(vinhos[i].preco().replace(vinhos[i].unidadeVenda(), ""));
                            }
                            break;
                        case "cafe":
                            for (int i = 0; i < contadorCafes; i++) {
                                quantidade++;
                                precoTotal += Float.parseFloat(cafes[i].preco().replace(cafes[i].unidadeVenda(), ""));
                            }
                            break;
                        default:
                            System.out.println("Categoria inválida.");
                            break;
                    }

                    System.out.println("Quantidade de produtos na categoria " + categoria + ": " + quantidade);
                    System.out.println("Preço total da categoria " + categoria + ": R$" + precoTotal);
                    break;
                case 3:
                    float precoTotalGeral = 0;

                    for (int i = 0; i < contadorEletrodomesticos; i++) {
                        precoTotalGeral += Float.parseFloat(eletrodomesticos[i].preco().replace(eletrodomesticos[i].unidadeVenda(), ""));
                    }

                    for (int i = 0; i < contadorVinhos; i++) {
                        precoTotalGeral += Float.parseFloat(vinhos[i].preco().replace(vinhos[i].unidadeVenda(), ""));
                    }

                    for (int i = 0; i < contadorCafes; i++) {
                        precoTotalGeral += Float.parseFloat(cafes[i].preco().replace(cafes[i].unidadeVenda(), ""));
                    }

                    System.out.println("Preço total geral dos produtos: R$" + precoTotalGeral);
                    break;
                case 4:
                    System.out.println("Digite o tipo de produto: ");
                    tipoProduto = scanner.nextLine();

                    switch (tipoProduto.toLowerCase()) {
                        case "eletrodomestico":
                            if (contadorEletrodomesticos < 5 && eletrodomesticos[contadorEletrodomesticos] == null) {
                                eletrodomesticos[contadorEletrodomesticos] = new Eletrodomesticos();
                                System.out.println("Digite o preço do eletrodoméstico: ");
                                eletrodomesticos[contadorEletrodomesticos].preco = scanner.nextFloat();
                                scanner.nextLine();
                                contadorEletrodomesticos++;
                            } else {
                                System.out.println("Limite de eletrodomésticos atingido.");
                            }
                            break;
                        case "vinho":
                            if (contadorVinhos < 5 && vinhos[contadorVinhos] == null) {
                                vinhos[contadorVinhos] = new Vinho();
                                System.out.println("Digite o preço do vinho: ");
                                vinhos[contadorVinhos].valorBase = scanner.nextFloat();
                                scanner.nextLine();
                                contadorVinhos++;
                            } else {
                                System.out.println("Limite de vinhos atingido.");
                            }
                            break;
                        case "cafe":
                            if (contadorCafes < 5 && cafes[contadorCafes] == null) {
                                cafes[contadorCafes] = new Cafe();
                                System.out.println("Digite o preço do café por Kg: ");
                                cafes[contadorCafes].preco = scanner.nextFloat();
                                scanner.nextLine();
                                contadorCafes++;
                            } else {
                                System.out.println("Limite de cafés atingido.");
                            }
                            break;
                        default:
                            System.out.println("Produto inválido.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

