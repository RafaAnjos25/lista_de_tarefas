import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TarefaGUI {
    private JFrame frame;
    private JPanel tarefaPanel;
    private ArrayList<JPanel> tarefas;

    public TarefaGUI() {
        tarefas = new ArrayList<>();

        // Configuração da janela principal
        frame = new JFrame("Gerenciador de Tarefas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Botão "Criar Tarefa"
        JButton criarTarefaButton = new JButton("Criar Tarefa");

        criarTarefaButton.setPreferredSize(new Dimension(200, 40)); // Define o tamanho desejado

        criarTarefaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarTarefa("Nova Tarefa");
            }
        });

        // Painel para listar tarefas
        tarefaPanel = new JPanel();
        tarefaPanel.setLayout(new BoxLayout(tarefaPanel, BoxLayout.Y_AXIS)); // Alinhamento vertical das tarefas

        // Adiciona os componentes na janela
        frame.add(criarTarefaButton, BorderLayout.NORTH);
        frame.add(new JScrollPane(tarefaPanel), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // Método para adicionar uma nova tarefa
    private void adicionarTarefa(String descricao) {
        RoundedPanel panel = new RoundedPanel(15);  // 15 is the corner radius
        panel.setBackground(Color.WHITE);  // Set the desired background color
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(350, 50));

        // Cria o rótulo com a descrição da tarefa e centraliza o texto
        JLabel label = new JLabel(descricao, SwingConstants.CENTER); // Centraliza horizontalmente
        label.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o texto horizontalmente
        label.setVerticalAlignment(SwingConstants.CENTER);   // Centraliza o texto verticalmente
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Adiciona uma margem

        // Rótulo com a descrição da tarefa
        panel.add(label, BorderLayout.CENTER);

        // Botão de editar
        JButton editarButton = new JButton("✎");
        editarButton.setForeground(Color.BLUE);
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui, você pode adicionar a lógica para editar a tarefa
                String novaDescricao = JOptionPane.showInputDialog("Editar Tarefa:", descricao);
                if (novaDescricao != null && !novaDescricao.trim().isEmpty()) {
                    label.setText(novaDescricao);
                }
            }
        });

        // Botão de excluir
        JButton excluirButton = new JButton("X");
        excluirButton.setForeground(Color.RED);
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tarefaPanel.remove(panel);
                tarefaPanel.revalidate();
                tarefaPanel.repaint();
                tarefas.remove(panel);
            }
        });

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(editarButton);
        buttonPanel.add(excluirButton);

        panel.add(buttonPanel, BorderLayout.EAST);
        tarefaPanel.add(panel);
        tarefaPanel.revalidate();
        tarefaPanel.repaint();

        tarefas.add(panel);
    }

    public static void main(String[] args) {
        new TarefaGUI();
    }






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




