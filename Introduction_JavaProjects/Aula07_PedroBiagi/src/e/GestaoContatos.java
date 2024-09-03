package e;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class GestaoContatos implements Serializable {
    private Map<String, Contato> contatos = new HashMap<>();

    public void adicionaContato(Contato contato, String tipo) {
        contatos.put(tipo, contato);
    }

    public void eliminaContato(String nome) throws ContatoNaoEncontrado {
        if (!contatos.containsKey(nome)) {
            throw new ContatoNaoEncontrado();
        }
        contatos.remove(nome);
    }

    public void listaContatos() {
        for (Map.Entry<String, Contato> entry : contatos.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public Contato maisVelho() {
        Contato maisVelho = null;
        int idadeMax = Integer.MIN_VALUE;
        for (Contato contato : contatos.values()) {
            if (contato != null && contato instanceof Contato) {
                Contato contatoAtual = (Contato) contato;
                if (contatoAtual.getIdade() > idadeMax) {
                    idadeMax = contatoAtual.getIdade();
                    maisVelho = contatoAtual;
                }
            }
        }
        return maisVelho;
    }

    public Contato maisNovo() {
        Contato maisNovo = null;
        int idadeMin = Integer.MAX_VALUE;
        for (Contato contato : contatos.values()) {
            if (contato != null && contato instanceof Contato) {
                Contato contatoAtual = (Contato) contato;
                if (contatoAtual.getIdade() < idadeMin) {
                    idadeMin = contatoAtual.getIdade();
                    maisNovo = contatoAtual;
                }
            }
        }
        return maisNovo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Contato> entry : contatos.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
