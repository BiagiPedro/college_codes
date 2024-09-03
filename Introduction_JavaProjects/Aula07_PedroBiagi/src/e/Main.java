package e;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Exemplo de utilização
        GestaoContatos gestaoContatos = new GestaoContatos();

        // Adicionando contatos
        Contato contato1 = new Contato("João", 30, "M", "Engenheiro", "123456789", "joao@gmail.com");
        Contato contato2 = new Contato("Maria", 25, "F", "Advogada", "987654321", "maria@gmail.com");
        Contato contato3 = new Contato("Carlos", 40, "M", "Professor", "456789123", "carlos@gmail.com");

        gestaoContatos.adicionaContato(contato1, "Familia");
        gestaoContatos.adicionaContato(contato2, "Amigos");
        gestaoContatos.adicionaContato(contato3, "Profissional");

        // Lista de contatos
        gestaoContatos.listaContatos();

        // Busca por contato mais velho
        System.out.println("Contato mais velho: " + gestaoContatos.maisVelho());

        // Busca por contato mais novo
        System.out.println("Contato mais novo: " + gestaoContatos.maisNovo());

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
