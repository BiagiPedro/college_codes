package cliente;
import java.util.Scanner;

public class MainC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String leituraNome;
        int leituracpf, leituraIdade, leituraTelefone;

        System.out.println("Escreva o nome do cliente");
        leituraNome = sc.nextLine();
        System.out.println("Escreva o cpf do cliente");
        leituracpf = sc.nextInt();
        System.out.println("Escreva a idade do cliente");
        leituraIdade = sc.nextInt();
        System.out.println("Escreva o telefone");
        leituraTelefone = sc.nextInt();

        Cliente C1 =new Cliente(leituraNome, leituracpf, leituraIdade,leituraTelefone);

        C1.MostrarDadosClientes();


    }
}
