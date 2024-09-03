package Exercicio02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorImposto gerenciador = new GerenciadorImposto();

        int opcao;
        do {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1- Criar Cliente");
            System.out.println("2- Criar Conta");
            System.out.println("3- Realizar Operações");
            System.out.println("4- Exibir Saldo Devedor");
            System.out.println("0- Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o nome do cliente: ");
                    String nome = scanner.next();

                    System.out.print("Informe o CPF do cliente: ");
                    double cpf = scanner.nextDouble();

                    Cliente cliente = new Cliente(nome, cpf);
                    gerenciador.adicionarCliente(cliente);

                    System.out.println("Cliente criado com sucesso!");
                    break;
                case 2:
                    System.out.print("Informe o índice do cliente: ");
                    int indiceCliente = scanner.nextInt();

                    Cliente cliente1 = gerenciador.getCliente(indiceCliente);

                    if (cliente1 != null) {
                        System.out.print("Informe o saldo inicial da conta: ");
                        double saldoInicial = scanner.nextDouble();

                        System.out.println("Escolha o tipo de conta:");
                        System.out.println("1- Conta Corrente");
                        System.out.println("2- Seguro de Vida");
                        System.out.println("3- Conta Poupança");

                        int opcaoConta = scanner.nextInt();

                        Conta conta = new Conta(saldoInicial);
                        switch (opcaoConta) {
                            case 1:
                                conta = new ContaCorrente(saldoInicial);
                                break;
                            case 2:
                                System.out.print("Valor do prêmio: ");
                                double premioSeguro = scanner.nextDouble();

                                System.out.print("Quantidade de meses: ");
                                double quantidadeMeses = scanner.nextDouble();

                                conta = new SeguroDeVida(saldoInicial, premioSeguro, quantidadeMeses);
                                break;

                            case 3:
                                conta = new ContaPoupanca(saldoInicial);
                                break;
                        }

                        cliente1.adicionarConta(conta);
                        System.out.println("Conta criada com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Informe o índice do cliente: ");
                    indiceCliente = scanner.nextInt();

                    Cliente cliente2 = gerenciador.getCliente(indiceCliente);

                    if (cliente2 != null) {
                        System.out.println("Escolha a conta:");
                        Conta[] contas = cliente2.getVetorC();
                        for (int i = 0; i < contas.length && contas[i] != null; i++) {
                            System.out.println(i + " - " + contas[i].getClass().getSimpleName());
                        }

                        int indiceConta = scanner.nextInt();

                        Conta conta = contas[indiceConta];

                        System.out.println("MENU DE OPERAÇÕES");
                        System.out.println("1- Sacar");
                        System.out.println("2- Depositar");
                        System.out.println("3- Exibir Saldo Bruto");
                        System.out.println("4- Exibir Saldo Líquido");

                        int opcaoOperacao = scanner.nextInt();

                        switch (opcaoOperacao) {
                            case 1:
                                System.out.print("Informe o valor para sacar: ");
                                double valorSaque = scanner.nextDouble();
                                conta.sacar(valorSaque);
                                System.out.println("Saque realizado com sucesso!");
                                break;
                            case 2:
                                System.out.print("Informe o valor para depositar: ");
                                double valorDeposito = scanner.nextDouble();
                                conta.depositar(valorDeposito);
                                System.out.println("Depósito realizado com sucesso!");
                                break;
                            case 3:
                                System.out.println("Saldo Bruto: " + conta.getSaldoBruto());
                                break;
                            case 4:
                                System.out.println("Saldo Líquido: " + (conta.getSaldoBruto() - conta.calculaTributos()));
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Informe o índice do cliente: ");
                    int indiceCliente4 = scanner.nextInt();
                    scanner.nextLine();

                    Cliente cliente4 = gerenciador.getCliente(indiceCliente4);

                    if (cliente4 != null) {
                        double saldoDevedorCliente = cliente4.getTaxas();
                        System.out.println("Saldo devedor total do cliente: " + saldoDevedorCliente);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
            }
        } while (opcao != 0);
    }
}
