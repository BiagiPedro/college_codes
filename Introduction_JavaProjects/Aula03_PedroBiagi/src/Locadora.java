import java.util.Scanner;

public class Locadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantVhs = 0;
        int quantCds = 0;
        int quantDvds = 0;
        int opcao = 0;
        float leituraPreco;
        String leituraNome;
        String leituraTipo;
        String leituraGenero;
        boolean leituraRebobina;

        Vhs[] vhs = new Vhs[5];
        Cds[] cds = new Cds[5];
        Dvds[] dvds = new Dvds[5];

        while (opcao != 5) {
            System.out.println("1 - Adicionar Vhs");
            System.out.println("2 - Adicionar Cds");
            System.out.println("3 - Adicionar Dvds");
            System.out.println("4 - Printar todas as mídias");
            System.out.println("5 - Sair");
            opcao = sc.nextInt();
            sc.nextLine(); // Consumir a quebra de linha pendente

            switch (opcao) {
                case 1:
                    if (quantVhs < 5) {
                        quantVhs++;
                        System.out.println("Digite o nome do VHS:");
                        leituraNome = sc.nextLine();
                        System.out.println("Digite o tipo do VHS:");
                        leituraTipo = sc.nextLine();
                        System.out.println("Digite o gênero do VHS:");
                        leituraGenero = sc.nextLine();
                        System.out.println("Digite o preço do VHS:");
                        leituraPreco = sc.nextFloat();
                        System.out.println("O VHS está rebobinado? (true/false):");
                        leituraRebobina = sc.nextBoolean();

                        vhs[quantVhs - 1] = new Vhs(leituraNome, leituraTipo, leituraGenero, leituraPreco, leituraRebobina);
                    } else {
                        System.out.println("Quantidade de VHS ultrapassada");
                    }
                    break;

                case 2:
                    if (quantCds < 5) {
                        quantCds++;
                        System.out.println("Digite o nome do CD:");
                        leituraNome = sc.nextLine();
                        System.out.println("Digite o tipo do CD:");
                        leituraTipo = sc.nextLine();
                        System.out.println("Digite o gênero do CD:");
                        leituraGenero = sc.nextLine();
                        System.out.println("Digite o preço do CD:");
                        leituraPreco = sc.nextFloat();
                        System.out.println("Digite o nome do cantor do CD:");
                        String cantor = sc.nextLine();
                        System.out.println("Digite o número de faixas do CD:");
                        int numeroFaixas = sc.nextInt();

                        cds[quantCds - 1] = new Cds(leituraNome, leituraTipo, leituraGenero, leituraPreco, cantor, numeroFaixas);
                    } else {
                        System.out.println("Quantidade de CDs ultrapassada");
                    }
                    break;

                case 3:
                    if (quantDvds < 5) {
                        quantDvds++;
                        System.out.println("Digite o nome do DVD:");
                        leituraNome = sc.nextLine();
                        System.out.println("Digite o tipo do DVD:");
                        leituraTipo = sc.nextLine();
                        System.out.println("Digite o gênero do DVD:");
                        leituraGenero = sc.nextLine();
                        System.out.println("Digite o preço do DVD:");
                        leituraPreco = sc.nextFloat();
                        System.out.println("Digite o nome do diretor do DVD:");
                        String diretor = sc.nextLine();
                        System.out.println("Digite os atores do DVD (separados por vírgula):");
                        String atoresInput = sc.nextLine();
                        String[] atores = atoresInput.split(", ");
                        System.out.println("Digite o tempo de duração do DVD:");
                        float tempo = sc.nextFloat();

                        dvds[quantDvds - 1] = new Dvds(leituraNome, leituraTipo, leituraGenero, leituraPreco, diretor, atores, tempo);
                    } else {
                        System.out.println("Quantidade de DVDs ultrapassada");
                    }
                    break;

                case 4:
                    // Imprimir todas as mídias
                    for (int i = 0; i < quantVhs; i++) {
                        vhs[i].printarVhs();
                    }
                    for (int i = 0; i < quantCds; i++) {
                        cds[i].printarCds();
                    }
                    for (int i = 0; i < quantDvds; i++) {
                        dvds[i].printaDvds();
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}