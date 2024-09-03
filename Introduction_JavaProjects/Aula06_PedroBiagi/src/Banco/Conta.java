package Banco;

public class Conta {
    String nome;
    double saldo;
    int num;

    public Conta(String nome, double saldo, int num) {
        this.nome = nome;
        this.saldo = saldo;
        this.num = num;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    String mostraSaldo() {
        return "O saldo da conta num "+num+", eh "+saldo+" reais.";
    }

    boolean sacar(double valor) {
        if (valor <= (saldo)) {
            saldo -= valor;
            return true;
        }else
            return false;
    }

    boolean depositar(double valor) {
        saldo += valor;
        return true;
    }


}