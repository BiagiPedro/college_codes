package Exercicio01;

public class Principal {
    public static void main(String[] args) {
        Funcionario[] funcionarios = new Funcionario[5];

        funcionarios[0] = new Gerente("André", "12221BSI201", 5000);
        funcionarios[1] = new Assistente("Maria", "12221BSI456", 2500);
        funcionarios[2] = new Assistente("Pedro", "12221BSI789", 2200);
        funcionarios[3] = new Vendedor("Lucas", "12221BSI987", 4000, 500);
        funcionarios[4] = new Vendedor("Kaká", "12221BSI654", 3500, 250);

        System.out.println("FOLHA SALARIAL");
        double folhaSalarial = 0;
        for (int i = 0; i < funcionarios.length; i++) {
            System.out.println("Funcionario " + (i + 1) + " (" + funcionarios[i].getNome() + "): " + funcionarios[i].calculaSalario());
            folhaSalarial += funcionarios[i].calculaSalario();
        }
        System.out.println("Valor total: " + folhaSalarial);
        System.out.println();

        double salarioGerente = 0, salarioAssistente = 0, salarioVendedor = 0;
        int contG = 0, contA = 0, contV = 0;
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] instanceof Gerente) {
                salarioGerente += funcionarios[i].calculaSalario();
                contG++;
            }
            if (funcionarios[i] instanceof Assistente) {
                salarioAssistente += funcionarios[i].calculaSalario();
                contA++;
            }
            if (funcionarios[i] instanceof Vendedor) {
                salarioVendedor += funcionarios[i].calculaSalario();
                contV++;
            }
        }

        double mediaGerente = salarioGerente / contG;
        double mediaAssistente = salarioAssistente / contA;
        double mediaVendedor = salarioVendedor / contV;

        System.out.println("GERENTE");
        System.out.println("Total: " + salarioGerente);
        System.out.println("Média salarial: " + mediaGerente);
        System.out.println();
        System.out.println("ASSITENTE");
        System.out.println("Total: " + salarioAssistente);
        System.out.println("Média salarial: " + mediaAssistente);
        System.out.println();
        System.out.println("VENDEDOR");
        System.out.println("Total: " + salarioVendedor);
        System.out.println("Média salarial: " + mediaVendedor);
    }
}


