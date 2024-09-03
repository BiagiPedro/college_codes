package d;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Exemplo de utilização
        GestaoContatos gestaoContatos = new GestaoContatos();
        ArrayList<Contato> familia = new ArrayList<>();
        ArrayList<Contato> amigos = new ArrayList<>();
        ArrayList<Contato> profissional = new ArrayList<>();

        // Adicionando contatos
        Contato contato1 = new Contato("João", 30, "M", "Engenheiro", "123456789", "joao@gmail.com");
        Contato contato2 = new Contato("Maria", 25, "F", "Advogada", "987654321", "maria@gmail.com");
        Contato contato3 = new Contato("Carlos", 40, "M", "Professor", "456789123", "carlos@gmail.com");

        gestaoContatos.adicionaContato(contato1, familia);
        gestaoContatos.adicionaContato(contato2, amigos);
        gestaoContatos.adicionaContato(contato3, profissional);

        // Lista de contatos
        gestaoContatos.listaContatos(familia);
        gestaoContatos.listaContatos(amigos);
        gestaoContatos.listaContatos(profissional);

        // Busca por contato mais velho
        System.out.println("Contato mais velho na lista de familia: " + gestaoContatos.maisVelho(familia));
        System.out.println("Contato mais velho na lista de amigos: " + gestaoContatos.maisVelho(amigos));
        System.out.println("Contato mais velho na lista profissional: " + gestaoContatos.maisVelho(profissional));

        // Busca por contato mais novo
        System.out.println("Contato mais novo na lista de familia: " + gestaoContatos.maisNovo(familia));
        System.out.println("Contato mais novo na lista de amigos: " + gestaoContatos.maisNovo(amigos));
        System.out.println("Contato mais novo na lista profissional: " + gestaoContatos.maisNovo(profissional));

        // Removendo um contato
        try {
            gestaoContatos.eliminaContato("João");
        } catch (ContatoNaoEncontrado e) {
            e.printStackTrace();
        }

        // Persistência em arquivo
        try {
            FileOutputStream fos = new FileOutputStream("contatos.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(gestaoContatos);
            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("contatos.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            GestaoContatos gestaoContatosLidos = (GestaoContatos) ois.readObject();
            ois.close();
            fis.close();

            System.out.println("Contatos lidos do arquivo: ");
            System.out.println(gestaoContatosLidos);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
