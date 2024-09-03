package Exercicio02;

public class SeguroDeVida extends Conta {
    private double premio;
    private double quantidadeMeses;

    private double taxa;

    public SeguroDeVida(double saldoLiquido, double premio, double quantidadeMeses) {
        super(saldoLiquido);
        this.premio = premio;
        this.quantidadeMeses = quantidadeMeses;
        calculaTributos();
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }
    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
        calculaTributos();
    }

    public double getQuantidadeMeses() {
        return quantidadeMeses;
    }

    public void setQuantidadeMeses(double quantidadeMeses) {
        this.quantidadeMeses = quantidadeMeses;
    }

    public double calculaTributos() {
        double novaTaxa = -42 * quantidadeMeses + premio;
        setSaldoBruto(novaTaxa);
        return novaTaxa;
    }

}
