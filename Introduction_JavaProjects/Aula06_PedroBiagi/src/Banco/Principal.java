package Banco;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    static Conta[] clientes = new Conta[5];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op = -1, contClientes = 0;

        while (op != 0) {
            try {
                System.out.println("=== MENU ===");
                System.out.println("1 - Cadastrar");
                System.out.println("2 - Sacar");
                System.out.println("3 - Depositar");
                System.out.println("4 - Visualizar saldo");
                System.out.println("0 - Sair");
                System.out.print("Opção: ");
                op = sc.nextInt();
                sc.nextLine();

                switch (op) {
                    case 1:
                        try {
                            if (contClientes < clientes.length) {
                                System.out.print("Nome do cliente: ");
                                String nome = sc.nextLine();
                                System.out.print("Saldo inicial: ");
                                double saldo = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("Numero da conta: ");
                                int num = sc.nextInt();
                                sc.nextLine();
                                Conta novaConta = new Conta(nome, saldo, num);
                                clientes[contClientes] = novaConta;
                                System.out.println("Conta cadastrada com sucesso!");
                            } else {
                                System.out.println("Limite de contas atingido!");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Certifique-se de inserir o tipo de dado correto.");
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("Ocorreu um erro inesperado ao cadastrar a conta.");
                        }
                        contClientes++;
                        break;
                    case 2:
                        try {
                            System.out.print("Digite o numero da conta: ");
                            int contaSaque = sc.nextInt();
                            Conta contaParaSaque = findConta(contaSaque);
                            if (contaParaSaque != null) {
                                System.out.print("Valor: ");
                                double valorSaque = sc.nextDouble();
                                sc.nextLine();
                                if (contaParaSaque.sacar(valorSaque)) {
                                    System.out.println("Saque realizado com sucesso.");
                                } else {
                                    System.out.println("Saldo insuficiente.");
                                }
                            } else {
                                System.out.println("Conta não encontrada.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Certifique-se de inserir o tipo de dado correto.");
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("Ocorreu um erro inesperado ao realizar o saque.");
                        }
                        break;
                    case 3:
                        try {
                            System.out.print("Digite o numero da conta: ");
                            int contaDeposito = sc.nextInt();
                            Conta contaParaDeposito = findConta(contaDeposito);
                            if (contaParaDeposito != null) {
                                System.out.print("Valor: ");
                                double valorDeposito = sc.nextDouble();
                                sc.nextLine();
                                contaParaDeposito.depositar(valorDeposito);
                                System.out.println("Depósito realizado com sucesso.");
                            } else {
                                System.out.println("Conta não encontrada.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Certifique-se de inserir o tipo de dado correto.");
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("Ocorreu um erro inesperado ao realizar o depósito.");
                        }
                        break;
                    case 4:
                        try {
                            System.out.print("Digite o numero da conta: ");
                            int contaSaldo = sc.nextInt();
                            Conta contaParaSaldo = findConta(contaSaldo);
                            if (contaParaSaldo != null) {
                                System.out.println(contaParaSaldo.mostraSaldo());
                            } else {
                                System.out.println("Conta não encontrada.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Certifique-se de inserir o tipo de dado correto.");
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("Ocorreu um erro inesperado ao visualizar o saldo.");
                        }
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Certifique-se de inserir o tipo de dado correto.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado. Por favor, tente novamente.");
            }
        }
    }




    public static Conta findConta(int numeroConta) {
        for (Conta c : clientes) {
            if (c != null && c.num == numeroConta) {
                return c;
            }
        }
        return null;
    }
}

