import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CadastroAluno extends JFrame {
    private List<Aluno> listaAlunos;
    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField enderecoField;

    public CadastroAluno() {
        listaAlunos = new ArrayList<>();

        setTitle("Cadastro de Alunos");
        setSize(400, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); 
        setResizable(false); // Impede o redimensionamento
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Container componentes de texto do formulário
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new GridLayout(3, 2, 10, 10));
        bodyPanel.setBorder(new EmptyBorder(5, 5, 0, 5));

        // Componentes de texto do formulário
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField();
        JLabel idadeLabel = new JLabel("Idade:");
        idadeField = new JTextField();
        JLabel enderecoLabel = new JLabel("Endereco:");
        enderecoField = new JTextField();
        
        // Container dos botões do formulário
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4, 5,0));
        buttonPanel.setBorder(new EmptyBorder(0, 5, 5, 5));

        // Botões do formulário
        JButton okButton = new JButton("Ok");
        JButton limparButton = new JButton("Limpar");
        JButton mostrarButton = new JButton("Mostrar");
        JButton sairButton = new JButton("Sair");

        // Adicionando componentes de texto ao JFrame
        bodyPanel.add(nomeLabel);
        bodyPanel.add(nomeField);
        bodyPanel.add(idadeLabel);
        bodyPanel.add(idadeField);
        bodyPanel.add(enderecoLabel);
        bodyPanel.add(enderecoField);

        //Inserindo botões ao painel de botões (container)
        buttonPanel.add(okButton);
        buttonPanel.add(limparButton);
        buttonPanel.add(mostrarButton);
        buttonPanel.add(sairButton);

        // Adicionando componentes ao formulário (JFrame) em suas disposições
        add(bodyPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // Ação do botão Ok
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                int idade = Integer.parseInt(idadeField.getText());
                String endereco = enderecoField.getText();

                // Criar um novo aluno e adicionar à lista
                Aluno aluno = new Aluno(nome, idade, endereco);
                listaAlunos.add(aluno);

                // Limpar os campos após o cadastro
                nomeField.setText("");
                idadeField.setText("");
                enderecoField.setText("");
            }
        });

        // Ação do botão Limpar
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeField.setText("");
                idadeField.setText("");
                enderecoField.setText("");
            }
        });

        // Ação do botão Mostrar
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder mensagem = new StringBuilder("Alunos Cadastrados:\n");
                for (Aluno aluno : listaAlunos) {
                    mensagem.append("Id: ").append(aluno.getUuid())
                    .append(", Nome: ").append(aluno.getNome())
                    .append(", Idade: ").append(aluno.getIdade())
                    .append(", Endereco: ").append(aluno.getEndereco()).append("\n");
                }
                JOptionPane.showMessageDialog(null, mensagem.toString());
            }
        });

        // Ação do botão Sair
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroAluno cadastro = new CadastroAluno();
            cadastro.setVisible(true);
        });
    }
}

