public class Empregado implements Comparable<Empregado> {
    private String cpf;
    private int idade;
    private double salario;

    public Empregado(String cpf, int idade, double salario) {
        this.cpf = cpf;
        this.idade = idade;
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void imprimirInformacoes() {
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
        System.out.println("Salário: " + salario);
    }

    @Override
    public int compareTo(Empregado outroEmpregado) {
        // Comparar as idades
        return Integer.compare(this.idade, outroEmpregado.getIdade());
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        // Exemplo de uso da classe Empregado
        Empregado empregado1 = new Empregado("123456789", 30, 3000.0);
        Empregado empregado2 = new Empregado("987654321", 35, 3500.0);

        // Comparar as idades
        if (empregado1.compareTo(empregado2) > 0) {
            System.out.println("O empregado 1 é mais velho.");
        } else if (empregado1.compareTo(empregado2) < 0) {
            System.out.println("O empregado 2 é mais velho.");
        } else {
            System.out.println("Os empregados têm a mesma idade.");
        }
    }

}