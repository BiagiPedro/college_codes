import java.util.InputMismatchException;
import java.util.Scanner;

public class exercicio_A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float valorFloat = 0.0f;
        int tentativas = 1;

        while (tentativas <= 3) {
            try {
                System.out.print("Digite um valor real (float): ");
                valorFloat = scanner.nextFloat();
                break;
            } catch (InputMismatchException e) {
                if (tentativas == 3) {
                    System.out.println("Excedeu o limite de tentativas.");
                    break;
                } else {
                    System.out.print("Valor inválido! ");
                    scanner.next();
                    tentativas++;
                }
            }
        }
    }
}
