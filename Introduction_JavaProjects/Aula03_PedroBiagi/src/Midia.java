public class Midia {
    private String nome;
    private String tipo;
    private String genero;
    private float precoLocacao;

    public Midia(String nome, String tipo, String genero, float precoLocacao) {
        this.nome = nome;
        this.tipo = tipo;
        this.genero = genero;
        this.precoLocacao = precoLocacao;
    }

    public void printaMidia(){
        System.out.println("Nome"+this.nome+"\nTipo"+this.tipo);
        System.out.println("Genero"+this.genero+"Preco locação"+this.precoLocacao);
    }

}
