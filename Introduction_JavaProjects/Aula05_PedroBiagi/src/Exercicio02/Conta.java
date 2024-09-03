package Exercicio02;
public class Conta implements Tributavel {
    protected double saldoBruto;
    protected double saldoLiquido;

    public Conta(double saldoLiquido) {
        setSaldoLiquido(saldoLiquido);
        setSaldoBruto(saldoLiquido);
    }

    public void sacar(double valor) {
        this.saldoBruto -= valor;
        this.saldoLiquido -= valor;
        calculaTributos();
    }

    public void depositar(double valor) {
        this.saldoBruto += valor;
        this.saldoLiquido += valor;
        calculaTributos();
    }

    public double getSaldoBruto() {
        return saldoBruto;
    }

    public void setSaldoBruto(double saldoBruto) {
        this.saldoBruto = saldoBruto;
    }

    public double getSaldoLiquido() {
        return saldoLiquido;
    }

    public void setSaldoLiquido(double saldoLiquido) {
        this.saldoLiquido = saldoLiquido;
    }

    @Override
    public double calculaTributos() {
        return 0;
    }
}

