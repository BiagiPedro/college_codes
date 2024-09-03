import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NumerosGUI extends JFrame {
    private List<Integer> numeros = new ArrayList<>();
    private JTextField inputNumero;
    private JTextField campoMenor;
    private JTextField campoMaior;
    private JTextField campoMedia;
    private JTextField valor1;
    private JTextField valor2;
    private JButton botaoSomar;
    private JButton botaoMultiplicar;

    public NumerosGUI() {
        super("Operações com Números");
        setLayout(new FlowLayout());

        add(new JLabel("Número:"));
        inputNumero = new JTextField(10);
        add(inputNumero);

        JButton botaoOk = new JButton("OK");
        botaoOk.addActionListener(e -> {
            try {
                int numero = Integer.parseInt(inputNumero.getText());
                numeros.add(numero);
                inputNumero.setText("");
                atualizarEstatisticas();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.");
            }
        });
        add(botaoOk);

        JButton botaoExibir = new JButton("EXIBIR");
        botaoExibir.addActionListener(e -> {
            if (!numeros.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Números digitados: " + numeros);
                atualizarEstatisticas();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma entrada de número foi detectada.");
            }
        });
        add(botaoExibir);

        add(new JLabel("Menor:"));
        campoMenor = new JTextField(10);
        campoMenor.setEditable(false);
        add(campoMenor);

        add(new JLabel("Maior:"));
        campoMaior = new JTextField(10);
        campoMaior.setEditable(false);
        add(campoMaior);

        add(new JLabel("Média:"));
        campoMedia = new JTextField(10);
        campoMedia.setEditable(false);
        add(campoMedia);

        // Campos para soma e multiplicação
        add(new JLabel("Valor 1:"));
        valor1 = new JTextField(5);
        add(valor1);

        add(new JLabel("Valor 2:"));
        valor2 = new JTextField(5);
        add(valor2);

        botaoSomar = new JButton("Somar");
        botaoSomar.addActionListener(e -> realizarOperacao("Somar"));
        add(botaoSomar);

        botaoMultiplicar = new JButton("Multiplicar");
        botaoMultiplicar.addActionListener(e -> realizarOperacao("Multiplicar"));
        add(botaoMultiplicar);

        setSize(250, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void atualizarEstatisticas() {
        if (!numeros.isEmpty()) {
            int min = numeros.stream().min(Integer::compare).get();
            int max = numeros.stream().max(Integer::compare).get();
            double media = numeros.stream().mapToInt(Integer::intValue).average().orElse(0);
            campoMenor.setText(String.valueOf(min));
            campoMaior.setText(String.valueOf(max));
            campoMedia.setText(String.format("%.2f", media));
        }
    }

    private void realizarOperacao(String operacao) {
        try {
            int num1 = Integer.parseInt(valor1.getText());
            int num2 = Integer.parseInt(valor2.getText());
            int resultado;
            if ("Somar".equals(operacao)) {
                resultado = num1 + num2;
            } else { // Multiplicar
                resultado = num1 * num2;
            }
            JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Insira números válidos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NumerosGUI::new);
    }
}
