public class Funcionario {

    String nome;
    int cpf;
    float salarioBase;


    public Funcionario(String nome, int cpf, float salarioBase) {
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void mostraF() {
        System.out.println("Nome----" + nome + "\nCpf ----" + cpf);
    }
}
