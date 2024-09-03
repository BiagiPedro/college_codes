package Exercicio01;

public class Gerente extends Funcionario {

    public Gerente(String nome, String matricula, double salarioBase) {
        super(nome, matricula, salarioBase);
    }

    @Override
    public double calculaSalario() {
        return 2 * getSalarioBase();
    }
}