public class Administradores extends Funcionario {

    private float horasExtra;
    private float salarioTotal;

    public Administradores(String nome, int cpf, float salarioBase, float horasExtra) {
        super(nome, cpf, salarioBase);
        this.horasExtra = horasExtra;
        this.setSalarioTotal();
    }

    public float setSalarioTotal() {
        this.salarioTotal = this.getSalarioBase() + ((this.getSalarioBase() * 0.01F) * this.horasExtra);
        return this.salarioTotal;
    }

    public float getSalarioTotal() {
        return salarioTotal;
    }

    public float getHorasExtra(){
        return this.horasExtra;
    }

    public void mostraA(){
        mostraF();
        System.out.println("Salario Total ----"+this.salarioTotal+"\nHoras Extras ----"+this.horasExtra);
    }


}
