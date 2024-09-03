package e;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class Contato implements Serializable {
    public int idade;
    private String nome;

    private String sexo;
    private String profissao;
    private String telefone;
    private String email;

    public Contato(String nome, int idade, String sexo, String profissao, String telefone, String email) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.profissao = profissao;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public String toString() {
        return nome + ", " + idade + " anos, sexo " + sexo + ", " + profissao + ", telefone: " + telefone + ", e-mail: " + email;
    }

    public int getIdade() {
        return idade;
    }


    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

