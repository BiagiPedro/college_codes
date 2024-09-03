package d;

public class ContatoNaoEncontrado extends Exception {
    public ContatoNaoEncontrado() {
        super("Contato não encontrado.");
    }
}