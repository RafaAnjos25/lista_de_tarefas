import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import package "CriarTarefa";

public class SwingExample {
    public static void main(String[] args) {
<<<<<<< Updated upstream
                // Instância da classe CriarTarefa
                CriarTarefa criarTarefa = new CriarTarefa();

                // Configuração da janela principal
                JFrame frame = new JFrame("Exemplo de Interface Gráfica");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);
        
                // Painel principal
                JPanel panel = new JPanel();
                panel.setLayout(null);
                frame.add(panel);
        
                // Campo de entrada para a tarefa
                JTextField tarefaText = new JTextField(20);
                tarefaText.setBounds(150, 20, 200, 25);
                panel.add(tarefaText);
        
                // Área de exibição das tarefas
                JTextArea tarefaList = new JTextArea();
                tarefaList.setBounds(10, 100, 350, 120);
                tarefaList.setEditable(false);
                panel.add(tarefaList);
        
                // Botão para adicionar tarefa
                JButton addButton = new JButton("Adicionar Tarefa");
                addButton.setBounds(150, 60, 150, 25);
                panel.add(addButton);
        
                // Chama o método adicionarTarefa da classe CriarTarefa quando o botão é clicado
                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        criarTarefa.adicionarTarefa(tarefaText, tarefaList); // Chama o método adicionarTarefa
                    }
                });
        
                // Torna a janela visível
                frame.setVisible(true);
            }
    
=======
        // Instância da classe CriarTarefa
        criarTarefa criarTarefa = new criarTarefa();

        // Configuração da janela principal
        JFrame frame = new JFrame("Exemplo de Interface Gráfica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        // Campo de entrada para a tarefa
        JTextField tarefaText = new JTextField(20);
        tarefaText.setBounds(150, 20, 200, 25);
        panel.add(tarefaText);

        // Área de exibição das tarefas
        JTextArea tarefaList = new JTextArea();
        tarefaList.setBounds(10, 100, 350, 120);
        tarefaList.setEditable(false);
        panel.add(tarefaList);

        // Botão para adicionar tarefa
        JButton addButton = new JButton("Adicionar Tarefa");
        addButton.setBounds(150, 60, 150, 25);
        panel.add(addButton);

        // Chama o método adicionarTarefa da classe CriarTarefa quando o botão é clicado
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarTarefa.adicionarTarefa(tarefaText, tarefaList); // Chama o método adicionarTarefa
            }
        });

        // Torna a janela visível
        frame.setVisible(true);
    }
>>>>>>> Stashed changes


    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Titulo
        JLabel userLabel = new JLabel("Tarefa 1°");
        userLabel.setBounds(150, 25, 150, 25);
        panel.add(userLabel);

        // Criação do campo de texto
        JTextField userText = new JTextField(20);
        userText.setBounds(200, 20, 100, 25);
        panel.add(userText);

        // Criação do botão
        JButton make_task = new JButton("Criar Tarefa");
        make_task.setBounds(10, 20, 150, 25);
        panel.add(make_task);

        // Criação do botão
        JButton view_task = new JButton("Criar Tarefa");
        view_task.setBounds(20, 50, 350, 50);
        panel.add(view_task);

        // Adicionando ação ao botão
        make_task.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText.getText();
            }
        });

        view_task.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText.getText();
            }
        });

    }
}
