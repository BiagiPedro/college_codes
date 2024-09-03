package Exercicio02;

import java.util.Arrays;

public class Cliente {
    private String nome;
    private double cpf;
    private Conta[] contas = new Conta[5];
    private int indiceConta = 0;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCpf() {
        return cpf;
    }

    public void setCpf(double cpf) {
        this.cpf = cpf;
    }

    public Cliente(String nome, double cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public void adicionarConta(Conta conta) {
            contas[indiceConta++] = conta;
            System.out.println("Conta adicionada com sucesso!");
    }

    public Conta[] getVetorC() {
        Conta[] vetorC = new Conta[indiceConta];
        for (int i = 0; i < indiceConta; i++) {
            vetorC[i] = contas[i];
        }
        return vetorC;
    }

    public double getTaxas() {
        double totalTaxas = 0;
        for (int i = 0; i < indiceConta; i++) {
            totalTaxas += contas[i].calculaTributos();
        }
        return totalTaxas;
    }
}
