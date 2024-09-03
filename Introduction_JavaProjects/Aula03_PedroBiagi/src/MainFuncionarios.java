import java.util.Scanner;

public class MainFuncionarios {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        Vendedores[] vendedores = new Vendedores[100]; // Assumindo que você tem, no máximo, 100 vendedores
        Administradores[] administradores = new Administradores[100]; // Assumindo que você tem, no máximo, 100 administradores
        int numVendedores = 0;
        int numAdministradores = 0;
        float mediaSalario = 0;

        while (opcao != 6) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Vendedor");
            System.out.println("2. Adicionar Administrador");
            System.out.println("4. Exibir Todos os Funcionários");
            System.out.println("5. Exibir Maior salario dos Funcionarios");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite um salario base para os vendedores");
                    float leituraBase = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Digite o nome do vendedor");
                    String leituraNome = sc.nextLine();
                    System.out.println("Digite o total de vendas");
                    float leituraTotalVendas = sc.nextFloat();
                    System.out.println("Digite o CPF do vendedor");
                    int leituraCpf = sc.nextInt();

                    Vendedores novoVendedor = new Vendedores(leituraNome, leituraCpf, leituraBase, leituraTotalVendas);
                    vendedores[numVendedores++] = novoVendedor;
                    break;

                case 2:
                    System.out.println("Digite um salario base para o administrador");
                    leituraBase = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Digite o nome do administrador");
                    leituraNome = sc.nextLine();
                    System.out.println("Digite o total de horas");
                    float totalHoras = sc.nextFloat();
                    System.out.println("Digite o CPF do administrador");
                    leituraCpf = sc.nextInt();

                    Administradores novoAdministrador = new Administradores(leituraNome, leituraCpf, leituraBase, totalHoras);
                    administradores[numAdministradores++] = novoAdministrador;
                    break;

                case 3:
                    System.out.println("Vendedores:");
                    for (int i = 0; i < numVendedores; i++) {
                        mediaSalario = vendedores[i].getSalarioTotal();
                    }

                    System.out.println("Administradores:");
                    for (int i = 0; i < numAdministradores; i++) {
                        mediaSalario = administradores[i].getSalarioTotal();
                    }
                    break;

                case 4:
                    for (int i = 0; i < numVendedores; i++) {
                        vendedores[i].motraV();
                    }

                    for (int i = 0; i < numAdministradores; i++) {
                        administradores[i].mostraA();
                    }

                    break;

                case 5:
                    float maiorSalarioVendedor = 0;
                    Vendedores vendedorMaiorSalario = null;
                    float maiorSalarioAdministrador = 0;
                    Administradores administradorMaiorSalario = null;
                    for (int i = 0; i < numVendedores; i++) {
                        if (vendedores[i].getSalarioTotal() > maiorSalarioVendedor) {
                            maiorSalarioVendedor = vendedores[i].getSalarioTotal();
                            vendedorMaiorSalario = vendedores[i];
                        }
                    }

                    // Encontrar administrador com maior salário
                    for (int i = 0; i < numAdministradores; i++) {
                        if (administradores[i].getSalarioTotal() > maiorSalarioAdministrador) {
                            maiorSalarioAdministrador = administradores[i].getSalarioTotal();
                            administradorMaiorSalario = administradores[i];
                        }
                    }

                    // Exibir vendedor com maior salário
                    if (vendedorMaiorSalario != null) {
                        System.out.println("Vendedor com maior salário:");
                        vendedorMaiorSalario.motraV();
                    } else {
                        System.out.println("Nenhum vendedor encontrado.");
                    }

                    // Exibir administrador com maior salário
                    if (administradorMaiorSalario != null) {
                        System.out.println("Administrador com maior salário:");
                        administradorMaiorSalario.mostraA();
                    } else {
                        System.out.println("Nenhum administrador encontrado.");
                    }
                    break;


            }
        }
    }
}
