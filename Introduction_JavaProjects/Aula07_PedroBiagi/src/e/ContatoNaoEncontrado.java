package e;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class ContatoNaoEncontrado extends Exception {
    public ContatoNaoEncontrado() {
        super("Contato não encontrado.");
    }


}