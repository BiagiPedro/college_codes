package Exercicio02;
public class FuncionarioNoturno extends Funcionario {
    private int horasNoturnas;

    public FuncionarioNoturno(int matricula, String nome, String CPF, int idade, double salarioBase) {
        super(matricula, nome, CPF, idade, salarioBase);
        this.horasNoturnas = 0;
    }

    public void atualizarHorasNoturnas(int horasNoturnas) {
        this.horasNoturnas = horasNoturnas;
    }

    public double calcularSalario() {
        return super.salarioBase + 2.5 * horasNoturnas;
    }

    public int getHorasNoturnas() {
        return horasNoturnas;
    }

    public void setHorasNoturnas(int horasNoturnas) {
        this.horasNoturnas = horasNoturnas;
    }
}



