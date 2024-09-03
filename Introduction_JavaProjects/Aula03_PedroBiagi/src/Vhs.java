public class Vhs extends Midia{
   private boolean rebobinada;
    public Vhs(String nome, String tipo, String genero, float precoLocacao,boolean rebobinada) {
        super(nome, tipo, genero, precoLocacao);
        this.rebobinada = rebobinada;
    }

    public void printarVhs(){
        this.printaMidia();
        System.out.println("\n Estado da bubina "+this.rebobinada);
    }
}
