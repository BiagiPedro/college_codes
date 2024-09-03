import java.util.Scanner;

public class exercicio_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v[] = new int[10];

        for (int k = 0; k < 10; k++) {
            int i = 0;
            try {
                System.out.println();
                System.out.print("Digite o valor: ");
                int x = sc.nextInt();
                System.out.print("Digite o indice do array: ");
                i = sc.nextInt();
                v[i] = x;
                System.out.print("VETOR: ");
                for (int j = 0; j < 10; j++) {
                    System.out.print(v[j]);
                    System.out.print(" ");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.print("Erro, indice fora do array. Tente novamente.");
            }
        }
    }
}

