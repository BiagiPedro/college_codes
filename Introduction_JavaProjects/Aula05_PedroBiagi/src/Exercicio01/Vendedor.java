package Exercicio01;

public class Vendedor extends Funcionario {

    private double comissao;

    public Vendedor(String nome, String matricula, double salarioBase, double comissao) {
        super(nome, matricula, salarioBase);
        setComissao(comissao);
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public double calculaSalario() {
        return getSalarioBase() + getComissao();
    }
}
