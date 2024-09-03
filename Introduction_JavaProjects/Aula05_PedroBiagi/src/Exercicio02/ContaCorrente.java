package Exercicio02;
public class ContaCorrente extends Conta {
    private double taxa = 0.01;

    public ContaCorrente(double saldoLiquido) {
        super(saldoLiquido);
    }

    @Override
    public double calculaTributos() {
        return saldoBruto * taxa;
    }
}