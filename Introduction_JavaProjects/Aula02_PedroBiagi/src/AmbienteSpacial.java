import java.util.Scanner;

public class AmbienteSpacial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        int quantidade = 0;
        String nome;
        int posicaoMaisRapida = -1;
        int velocidade;
        NaveEspacial vetor[] = new NaveEspacial[5];

        while (opcao != 6) {
            System.out.println("1 - Criar nave ");
            System.out.println("2 - Nave mais rápida ");
            System.out.println("3 - Mostrar Naves em movimento");
            System.out.println("4 - Parar uma nave");
            System.out.println("5 - Ligar uma nave");
            System.out.println("6 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    if (quantidade < 5) {
                        System.out.println("Escreva o nome da nave");
                        nome = sc.nextLine();
                        vetor[quantidade] = new NaveEspacial(nome);
                        quantidade++;
                        System.out.println("Nave criada com sucesso!");
                    } else {
                        System.out.println("Número máximo de naves atingido.");
                    }
                    break;

                case 2:
                    if (quantidade > 0) {
                        posicaoMaisRapida = 0;
                        for (int i = 1; i < quantidade; i++) {
                            if (vetor[i].getVelocidade() > vetor[posicaoMaisRapida].getVelocidade()) {
                                posicaoMaisRapida = i;
                            }
                        }
                        vetor[posicaoMaisRapida].mostraNave();
                    } else {
                        System.out.println("Nenhuma nave registrada.");
                    }
                    break;

                case 3:
                    for (int i = 0; i < quantidade; i++) {
                        if (vetor[i].getVelocidade() != 0) {
                            vetor[i].mostraNave();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Escolha a nave para parar (0 - " + (quantidade - 1) + ")");
                    int posicaoParar = sc.nextInt();
                    if (posicaoParar >= 0 && posicaoParar < quantidade) {
                        if (vetor[posicaoParar].getVelocidade() != 0) {
                            vetor[posicaoParar].setVelocidade(0);
                            System.out.println("Nave parada com sucesso!");
                            quantidade--;
                        } else {
                            System.out.println("A nave já está parada.");
                        }
                    } else {
                        System.out.println("Posição inválida.");
                    }
                    break;

                case 5:
                    if (quantidade > 3) {
                        System.out.println("Superpopulacao de naves");
                    } else {
                        System.out.println("Escolha a nave para ligar (0 - " + (quantidade - 1) + ")");
                        int posicaoLigar = sc.nextInt();
                        if (posicaoLigar >= 0 && posicaoLigar < quantidade) {
                            System.out.println("Qual a velocidade?");
                            velocidade = sc.nextInt();
                            vetor[posicaoLigar].setVelocidade(velocidade);
                            System.out.println("Nave ligada com sucesso!");
                        } else {
                            System.out.println("Posição inválida.");
                        }
                    }
                    break;
            }
        }
    }
}

