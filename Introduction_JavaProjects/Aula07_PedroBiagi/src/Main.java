import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Empregado> listaEmpregados = new ArrayList<>();

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
            listaEmpregados.add(new Empregado(cpf, idade, salario));
        }

        // Busca por CPF
        System.out.print("\nDigite o CPF para buscar o empregado: ");
        String cpfBusca = scanner.nextLine();
        Empregado empregadoEncontrado = null;
        for (Empregado empregado : listaEmpregados) {
            if (empregado.getCpf().equals(cpfBusca)) {
                empregadoEncontrado = empregado;
                break;
            }
        }
        if (empregadoEncontrado != null) {
            System.out.println("Empregado encontrado:");
            empregadoEncontrado.imprimirInformacoes();
        } else {
            System.out.println("Empregado não encontrado.");
        }

        // Filtrar por salário
        System.out.print("\nDigite um valor de salário para filtrar os empregados: ");
        double salarioFiltro = scanner.nextDouble();
        System.out.println("Empregados com salário maior do que " + salarioFiltro + ":");
        for (Empregado empregado : listaEmpregados) {
            if (empregado.getSalario() > salarioFiltro) {
                empregado.imprimirInformacoes();
            }
        }

        // Ordenar a lista de empregados em ordem crescente de salário
        Collections.sort(listaEmpregados, Comparator.comparingDouble(Empregado::getSalario));

        // Imprimir lista ordenada
        System.out.println("\nLista de empregados ordenada por salário:");
        for (Empregado empregado : listaEmpregados) {
            empregado.imprimirInformacoes();
        }

        scanner.close();
    }


}
