public class Cds extends Midia {
    private String cantor;
    private int numeroFaixas;

    public Cds(String nome, String tipo, String genero, float precoLocacao, String cantor, int numeroFaixas) {
        super(nome, tipo, genero, precoLocacao);
        this.cantor = cantor;
        this.numeroFaixas = numeroFaixas;
    }

    public void printarCds(){
        this.printaMidia();
        System.out.println("\n Cantor"+this.cantor+"\nNumero de fixas"+this.numeroFaixas);
    }
}
