package c;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Double> salariosBrutos = lerArquivo("salbruto.datedesc.dat");
        Map<String, Double> descontos = lerArquivo("descontos.datedesc.dat");
        Map<String, Double> salariosLiquidos = calcularSalariosLiquidos(salariosBrutos, descontos);
        gravarSalariosLiquidos(salariosLiquidos, "salliq.txt");
        System.out.println("Salários líquidos calculados e gravados com sucesso.");
    }

    public static Map<String, Double> lerArquivo(String nomeArquivo) {
        Map<String, Double> dados = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(" ");
                String cpf = partes[0];
                double valor = Double.parseDouble(partes[1]);
                dados.put(cpf, valor);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + nomeArquivo);
            e.printStackTrace();
        }
        return dados;
    }

    public static Map<String, Double> calcularSalariosLiquidos(Map<String, Double> salariosBrutos, Map<String, Double> descontos) {
        Map<String, Double> salariosLiquidos = new HashMap<>();
        for (Map.Entry<String, Double> entry : salariosBrutos.entrySet()) {
            String cpf = entry.getKey();
            double salarioBruto = entry.getValue();
            double desconto = descontos.getOrDefault(cpf, 0.0);
            double salarioLiquido = salarioBruto - desconto;
            salariosLiquidos.put(cpf, salarioLiquido);
        }
        return salariosLiquidos;
    }

    public static void gravarSalariosLiquidos(Map<String, Double> salariosLiquidos, String nomeArquivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Map.Entry<String, Double> entry : salariosLiquidos.entrySet()) {
                bw.write(entry.getKey() + " " + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo: " + nomeArquivo);
            e.printStackTrace();
        }
    }
}
