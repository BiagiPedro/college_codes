import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfaceContas extends JFrame {
    private ArrayList<Conta> contas;
    private JButton preencherDadosButton;
    private JButton visualizarDadosButton;
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField dataNascimentoField;
    private JComboBox<String> sexoComboBox;
    private JTextField numeroContaField;
    private JTextField senhaField;
    private JTextField emailField;
    private JCheckBox desejaReceberNoticiasCheckBox;

    public InterfaceContas() {
        super("Gestão de Contas");

        contas = new ArrayList<>();

        preencherDadosButton = new JButton("Preencher Dados");
        visualizarDadosButton = new JButton("Visualizar Dados");

        preencherDadosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel(new GridLayout(9, 2));
                panel.add(new JLabel("Nome:"));
                nomeField = new JTextField();
                panel.add(nomeField);
                panel.add(new JLabel("CPF:"));
                cpfField = new JTextField();
                panel.add(cpfField);
                panel.add(new JLabel("Data de Nascimento:"));
                dataNascimentoField = new JTextField();
                panel.add(dataNascimentoField);
                panel.add(new JLabel("Sexo:"));
                sexoComboBox = new JComboBox<>(new String[]{"Masculino", "Feminino", "Outro"});
                panel.add(sexoComboBox);
                panel.add(new JLabel("Número da Conta:"));
                numeroContaField = new JTextField();
                panel.add(numeroContaField);
                panel.add(new JLabel("Senha:"));
                senhaField = new JTextField();
                panel.add(senhaField);
                panel.add(new JLabel("E-mail:"));
                emailField = new JTextField();
                panel.add(emailField);
                panel.add(new JLabel("Deseja Receber Notícias?"));
                desejaReceberNoticiasCheckBox = new JCheckBox();
                panel.add(desejaReceberNoticiasCheckBox);

                int result = JOptionPane.showConfirmDialog(null, panel, "Preencher Dados",
                        JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    String nome = nomeField.getText();
                    String cpf = cpfField.getText();
                    String dataNascimento = dataNascimentoField.getText();
                    String sexo = (String) sexoComboBox.getSelectedItem();
                    String numeroConta = numeroContaField.getText();
                    String senha = senhaField.getText();
                    String email = emailField.getText();
                    boolean desejaReceberNoticias = desejaReceberNoticiasCheckBox.isSelected();

                    if (nome.isEmpty() || cpf.isEmpty() || dataNascimento.isEmpty() || numeroConta.isEmpty() || senha.isEmpty() || email.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
                    } else if (!cpf.matches("\\d+") || !numeroConta.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "CPF e Número da Conta devem ser numéricos.");
                    } else {
                        Conta novaConta = new Conta(nome, cpf, dataNascimento, sexo, numeroConta, senha, email, desejaReceberNoticias);
                        contas.add(novaConta);
                        JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
                    }
                }
            }
        });

        visualizarDadosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                panel.add(new JLabel("Selecione um CPF:"));

                JComboBox<String> cpfComboBox = new JComboBox<>();
                for (Conta conta : contas) {
                    cpfComboBox.addItem(conta.getCPF());
                }
                panel.add(cpfComboBox);

                int result = JOptionPane.showConfirmDialog(null, panel, "Visualizar Dados",
                        JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    String cpfSelecionado = (String) cpfComboBox.getSelectedItem();
                    for (Conta conta : contas) {
                        if (conta.getCPF().equals(cpfSelecionado)) {
                            JPanel innerPanel = new JPanel(new GridLayout(9, 2));
                            innerPanel.add(new JLabel("Nome:"));
                            innerPanel.add(new JTextField(conta.getNome()));
                            innerPanel.add(new JLabel("CPF:"));
                            innerPanel.add(new JTextField(conta.getCPF()));
                            innerPanel.add(new JLabel("Data de Nascimento:"));
                            innerPanel.add(new JTextField(conta.getDataNascimento()));
                            innerPanel.add(new JLabel("Sexo:"));
                            innerPanel.add(new JTextField(conta.getSexo()));
                            innerPanel.add(new JLabel("Número da Conta:"));
                            innerPanel.add(new JTextField(conta.getNumeroConta()));
                            innerPanel.add(new JLabel("Senha:"));
                            innerPanel.add(new JTextField(conta.getSenha()));
                            innerPanel.add(new JLabel("E-mail:"));
                            innerPanel.add(new JTextField(conta.getEmail()));
                            innerPanel.add(new JLabel("Deseja Receber Notícias?"));
                            innerPanel.add(new JTextField(String.valueOf(conta.isDesejaReceberNoticias())));

                            int saveOption = JOptionPane.showConfirmDialog(null, innerPanel, "Dados do Usuário",
                                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                            if (saveOption == JOptionPane.OK_OPTION) {
                                // Aqui você poderia adicionar a lógica para salvar as alterações
                                JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
                            }
                            break;
                        }
                    }
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(preencherDadosButton);
        panel.add(visualizarDadosButton);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfaceContas();
            }
        });
    }
}