import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Empregado> mapaEmpregados = new HashMap<>();

        // Entrada dos dados dos 5 empregados
        System.out.println("Digite os dados dos 5 empregados:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Empregado " + (i + 1) + ":");
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = scanner.nextInt();
            System.out.print("Salário: ");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer do scanner

            Empregado empregado = new Empregado(cpf, idade, salario);
            mapaEmpregados.put(cpf, empregado);
        }

        // Busca por CPF
        System.out.print("\nDigite o CPF para buscar o empregado: ");
        String cpfBusca = scanner.nextLine();
        Empregado empregadoEncontrado = mapaEmpregados.get(cpfBusca);
        if (empregadoEncontrado != null) {
            System.out.println("Empregado encontrado:");
            empregadoEncontrado.imprimirInformacoes();
        } else {
            System.out.println("Empregado não encontrado.");
        }

        // Encontrar CPFs dos empregados com menor e maior salários
        String cpfMenorSalario = null;
        String cpfMaiorSalario = null;
        double menorSalario = Double.MAX_VALUE;
        double maiorSalario = Double.MIN_VALUE;

        for (Map.Entry<String, Empregado> entry : mapaEmpregados.entrySet()) {
            Empregado empregado = entry.getValue();
            if (empregado.getSalario() < menorSalario) {
                menorSalario = empregado.getSalario();
                cpfMenorSalario = entry.getKey();
            }
            if (empregado.getSalario() > maiorSalario) {
                maiorSalario = empregado.getSalario();
                cpfMaiorSalario = entry.getKey();
            }
        }

        System.out.println("\nCPF do empregado com menor salário: " + cpfMenorSalario);
        System.out.println("CPF do empregado com maior salário: " + cpfMaiorSalario);

        scanner.close();
    }
}
