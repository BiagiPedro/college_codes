package banco;

import java.util.Scanner;

public class Principal {
    static Cliente[] clientes = new Cliente[10];

    static Cliente logar(Scanner sc) {
        System.out.print("Usuario: ");
        String usr = sc.nextLine();
        System.out.print("Senha: ");
        String sen = sc.nextLine();
        for (int i = 0; i < Cliente.ct; i++)
            if ((clientes[i].conta.usuario.equals(usr)) && (clientes[i].conta.senha.equals(sen)))
                return clientes[i];
        return null;
    }

    static banco.Conta buscaConta(int num) {
        for (int i = 0; i < Cliente.ct; i++)
            if (clientes[i].conta.num == num)
                return clientes[i].conta;
        return null;
    }

    public static void main(String a[]) {

        Scanner sc = new Scanner(System.in);
        int op = -1;
        int contClientes = 0;

        while (op != 9) {
            System.out.println("=== MENU ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Saldo");
            System.out.println("3 - Sacar");
            System.out.println("4 - Depositar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Relatorio");
            System.out.println("7 - Relatorio de contas negativadas");
            System.out.println("7 - Relatorio de contas menores de 18 anos");
            System.out.println("9 - Sair");
            op = sc.nextInt();
            sc.nextLine();
            String tipo;
            float saldo;
            String nome, CPF, telefone;
            int idade;
            String usr, sen;
            Cliente c;

            switch (op) {
                case 1:
                    System.out.print("Tipo da Conta: ");
                    tipo = sc.nextLine();
                    System.out.print("Saldo inicial: ");
                    saldo = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    nome = sc.nextLine();
                    System.out.print("CPF: ");
                    CPF = sc.nextLine();
                    System.out.print("Telefone: ");
                    telefone = sc.nextLine();
                    System.out.print("Idade: ");
                    idade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Usuario: ");
                    usr = sc.nextLine();
                    System.out.print("Senha: ");
                    sen = sc.nextLine();
                    banco.Conta c1 = new banco.Conta();
                    c1.cadastraConta(tipo, usr, sen, saldo);
                    Cliente cli1 = new Cliente();
                    cli1.nome = nome;
                    cli1.CPF = CPF;
                    cli1.telefone = telefone;
                    cli1.idade = idade;
                    cli1.conta = c1;
                    //cli1.cadastraCliente(nome, CPF, telefone, idade, c1);
                    clientes[contClientes] = cli1;
                    Cliente.ct++;
                    contClientes++;
                    break;
                case 2:
                    c = logar(sc);
                    if (c != null) {
                        System.out.println(c.conta.mostraSaldo());
                    } else
                        System.out.println("Acesso negado.");
                    break;
                case 3:
                    c = logar(sc);
                    if (c != null) {
                        System.out.print("Valor: ");
                        Float valor = sc.nextFloat();
                        if (c.conta.sacar(valor))
                            System.out.println("Saque realizado com sucesso.");
                        else
                            System.out.println("Erro ao realizar o saque.");
                    }
                    break;
                case 4:
                    c = logar(sc);
                    if (c != null) {
                        System.out.print("Valor: ");
                        Float valor = sc.nextFloat();
                        if (c.conta.depositar(valor))
                            System.out.println("Deposito realizado com sucesso.");
                        else
                            System.out.println("Erro ao realizar o saque.");
                    }
                    break;
                case 5:
                    c = logar(sc);
                    if (c != null) {
                        System.out.print("Num conta destino: ");
                        int n = sc.nextInt();
                        System.out.print("Valor: ");
                        Float valor = sc.nextFloat();
                        banco.Conta temp = buscaConta(n);
                        if (temp != null)
                            c.conta.transferir(valor, temp);
                        else
                            System.out.println("Conta destino inexistente!");
                    }
                    break;
                case 6:
                    for (int i = 0; i < Cliente.ct; i++) {
                        System.out.println(clientes[i].mostraDadosConta());
                    }
                    break;

                case 7:
                    System.out.println("==========Contas negativadas==========");
                    for (int i = 0; i < Cliente.ct; i++) {
                        if (clientes[i].conta.saldo < 0)
                            System.out.println(clientes[i].nome + "------" + clientes[i].conta.saldo);
                    }
                    break;

                case 8:
                    System.out.println("==========Contas de pessoas menores de 18==========");
                    for (int i = 0; i < Cliente.ct; i++) {
                    if (clientes[i].idade < 18)
                        System.out.println(clientes[i].nome + "------" + clientes[i].idade);
                }
                    break;


            }
        }
    }
}