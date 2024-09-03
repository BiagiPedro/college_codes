package Exercicio02;

import java.util.Scanner;

public class FolhaPagamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidadeComissionado = 0;
        int quantidadeNoturno = 0;
        double maiorSalarioComissionado = 0;
        double maiorSalarioNoturno = 0;
        double totalFolhaPagamento = 0;

        Funcionario[] funcionarios = new Funcionario[10];

        for (int i = 0; i < 2; i++) {
            System.out.println("Escolha o tipo de funcionário para a posição " + i + ":");
            System.out.println("1. Funcionário Comissionado");
            System.out.println("2. Funcionário Noturno");
            int escolha = scanner.nextInt();

            System.out.println("Digite a matrícula, nome, CPF, idade e salário base:");
            int matricula = scanner.nextInt();
            String nome = scanner.next();
            String CPF = scanner.next();
            int idade = scanner.nextInt();
            double salarioBase = scanner.nextDouble();

            if (escolha == 1) {
                funcionarios[i] = new FuncionarioComissionado(matricula, nome, CPF, idade, salarioBase);
            } else if (escolha == 2) {
                funcionarios[i] = new FuncionarioNoturno(matricula, nome, CPF, idade, salarioBase);
            }
        }
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Pesquisar funcionário por CPF ou Matrícula");
            System.out.println("2. Mostrar quantidade de funcionários de cada categoria");
            System.out.println("3. Mostrar o maior salário de cada categoria");
            System.out.println("4. Montar folha de pagamento");
            System.out.println("0. Sair");
            System.out.print("Escolha a opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    for (int i = 0; i < 10; i++) {
                        String cpfOuMatricula;
                        cpfOuMatricula = scanner.nextLine();
                        if (funcionarios[i].CPF.equals(cpfOuMatricula) || Integer.toString(funcionarios[i].matricula).equals(cpfOuMatricula)) {
                            System.out.println(funcionarios[i].toString());
                            return;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 10; i++) {
                        if (funcionarios[i] instanceof FuncionarioComissionado) {
                            quantidadeComissionado++;
                        }
                    }
                    for (int i = 0; i < 10; i++) {
                        if (funcionarios[i] instanceof FuncionarioNoturno) {
                            quantidadeNoturno++;
                        }
                    }
                    System.out.println(quantidadeComissionado + "-----" + quantidadeNoturno);

                    break;
                case 3:
                    for (Funcionario funcionario : funcionarios) {
                        if (funcionario instanceof FuncionarioComissionado) {
                            double salario = funcionario.calcularSalario();
                            if (salario > maiorSalarioComissionado) {
                                maiorSalarioComissionado = salario;
                            }
                        } else if (funcionario instanceof FuncionarioNoturno) {
                            double salario = funcionario.calcularSalario();
                            if (salario > maiorSalarioNoturno) {
                                maiorSalarioNoturno = salario;
                            }
                        }
                    }
                    System.out.println(maiorSalarioNoturno + "------" + maiorSalarioComissionado);
                    break;
                case 4:
                    for (Funcionario funcionario : funcionarios) {
                        if (funcionario != null) {
                            double salario = funcionario.calcularSalario();
                            totalFolhaPagamento += salario;
                            System.out.println(funcionario.toString() + ", Salário: " + salario);
                        }
                    }
                    System.out.println("\nTotal da Folha de Pagamento: " + totalFolhaPagamento);

                    break;
                case 0:

                    break;
                default:

                    break;
            }
        } while (opcao != 0);
    }
}

