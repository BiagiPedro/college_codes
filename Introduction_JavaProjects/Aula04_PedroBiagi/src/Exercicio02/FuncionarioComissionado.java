package Exercicio02;
public class FuncionarioComissionado extends Funcionario {

    private double vendas;

    public FuncionarioComissionado(int matricula, String nome, String CPF, int idade, double salarioBase) {
        super(matricula, nome, CPF, idade, salarioBase);
        this.vendas = 0.0;
    }

    public void atualizarVendas(double valorVendas) {
        this.vendas = valorVendas;
    }

    public double calcularSalario() {
        return super.salarioBase + 0.1 * vendas;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }
}
