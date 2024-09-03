import java.util.Scanner;

public class Maint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hora, minuto, segundo, opcao;

        // Declarando o objeto fora do loop
        Tempo relogio = null;

        do {
            System.out.println("1 - Crie seu relógio");
            System.out.println("2 - Decrementar um MINUTO");
            System.out.println("3 - Acrescentar um MINUTO");
            System.out.println("4 - Printar relógio");
            System.out.println("5 - Horario internacional");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Crie seu relógio");
                    System.out.println("Insira os valores no modo HHMMSS, valores não aceitos tornarão-se 0");
                    hora = sc.nextInt();
                    minuto = sc.nextInt();
                    segundo = sc.nextInt();
                    relogio = new Tempo(hora, minuto, segundo);
                    break;
                case 2:
                    System.out.println("Decremente um minuto");
                    if (relogio != null) {
                        relogio.decrementaMinuto();
                    } else {
                        System.out.println("Relógio não criado ainda.");
                    }
                    break;
                case 3:
                    System.out.println("Acrescentar um MINUTO");
                    if (relogio != null) {
                        relogio.incrementaMinuto();
                    } else {
                        System.out.println("Relógio não criado ainda.");
                    }
                    break;
                case 4:
                    System.out.println("Printar seu relógio");
                    if (relogio != null) {
                        relogio.mostraRelogio();
                    } else {
                        System.out.println("Relógio não criado ainda.");
                    }
                    break;

                case 5:
                    if (relogio != null) {
                        System.out.println(relogio.horarioInternacional());
                    } else {
                        System.out.println("Relógio não criado ainda.");
                    }
                    break;

            }

        } while (opcao != 6);
    }
}
