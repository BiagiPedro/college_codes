public class Vendedores extends Funcionario {

    private float salarioTotal;
    private float totalVendas;

    public Vendedores(String nome, int cpf, float salarioBase, float totalVendas) {
        super(nome, cpf, salarioBase);
        this.totalVendas = totalVendas;
        this.setSalarioTotal();
    }

    public float getVendas() {
        return this.totalVendas;
    }

    public float getSalarioTotal() {
        return this.salarioTotal;
    }

    public void setSalarioTotal() {
        this.salarioTotal = this.getSalarioBase() + (getVendas() * 0.05F);
    }

    public void motraV() {
        this.mostraF();
        System.out.print("\nTotal de vendas ----" + this.totalVendas+"\nSalario Total"+this.salarioTotal);
    }


}
