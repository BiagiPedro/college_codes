package d;

import java.io.*;
import java.util.ArrayList;

class GestaoContatos implements Serializable {
    private ArrayList<Contato> familia = new ArrayList<>();
    private ArrayList<Contato> amigos = new ArrayList<>();
    private ArrayList<Contato> profissional = new ArrayList<>();

    public void adicionaContato(Contato contato, ArrayList<Contato> lista) {
        lista.add(contato);
    }

    public void eliminaContato(String nome) throws ContatoNaoEncontrado {
        boolean encontrado = false;
        for (ArrayList<Contato> lista : new ArrayList[]{familia, amigos, profissional}) {
            for (Contato contato : lista) {
                if (contato.toString().contains(nome)) {
                    lista.remove(contato);
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) break;
        }
        if (!encontrado) throw new ContatoNaoEncontrado();
    }

    public void listaContatos(ArrayList<Contato> lista) {
        for (Contato contato : lista) {
            System.out.println(contato);
        }
    }

    public Contato maisVelho(ArrayList<Contato> lista) {
        Contato maisVelho = null;
        int idadeMax = Integer.MIN_VALUE;
        for (Contato contato : lista) {
            if (contato != null && contato.idade > idadeMax) {
                idadeMax = contato.idade;
                maisVelho = contato;
            }
        }
        return maisVelho;
    }

    public Contato maisNovo(ArrayList<Contato> lista) {
        Contato maisNovo = null;
        int idadeMin = Integer.MAX_VALUE;
        for (Contato contato : lista) {
            if (contato != null && contato.idade < idadeMin) {
                idadeMin = contato.idade;
                maisNovo = contato;
            }
        }
        return maisNovo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Familia: ").append(familia).append("\n");
        sb.append("Amigos: ").append(amigos).append("\n");
        sb.append("Profissional: ").append(profissional);
        return sb.toString();
    }
}
