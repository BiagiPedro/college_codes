public class Dvds extends Midia {
    private String diretor;
    private String[] atores;
    private float tempo;

    public Dvds(String nome, String tipo, String genero, float precoLocacao, String diretor, String[] atores, float tempo) {
        super(nome, tipo, genero, precoLocacao);
        this.diretor = diretor;
        this.atores = atores;
        this.tempo = tempo;
    }

    public void printaDvds(){
        this.printaMidia();
        System.out.println("\nDiretor"+this.diretor+"\nAtores"+this.atores+"\nTempo de duracao"+this.tempo);
    }


}
