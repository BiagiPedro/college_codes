package banco;

public class Conta {    
    static int ct = 0;
    String tipo;
    float saldo;
    int num;
    String usuario, senha;
    
    public void cadastraConta(String t, String usr1, String s1, float s) {
        tipo = t;
        usuario = usr1;
        senha = s1;
        if (s >= 500) saldo = s;
        else saldo = 500;
        num = ct;
        ct++;
    }
    
    String mostraSaldo() {
        return "O saldo da conta num "+num+", do tipo ("+tipo+") eh "+saldo+" reais.";
    }
    
    boolean sacar(float valor) {
        if (valor <= (saldo+100)) {
            saldo -= valor;
            return true;
        }else
            return false;
    }
    
    boolean depositar(float valor) {
        saldo += valor;
        return true;
    }
    
    boolean ehNegativo() {
        return (saldo < 0);
    }
    
    void transferir(float valor, Conta c) {
        if (sacar(valor)) {
            c.depositar(valor);
            System.out.println("Transferencia concluida.");
        } else
            System.out.println("Erro na operacao. Transferencia cancelada.");
    }

}