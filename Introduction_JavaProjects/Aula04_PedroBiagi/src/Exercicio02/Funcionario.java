package Exercicio02;
public class Funcionario {

    protected int matricula;
    protected String nome;
    protected String CPF;
    protected int idade;
    protected double salarioBase;

    public Funcionario(int matricula, String nome, String CPF, int idade, double salarioBase) {
        this.matricula = matricula;
        this.nome = nome;
        this.CPF = CPF;
        this.idade = idade;
        this.salarioBase = salarioBase;
    }

    public double calcularSalario() {
        return salarioBase;
    }

    public void atualizarSalarioBase(double novoSalarioBase) {
        this.salarioBase = novoSalarioBase;
    }

}
