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

        // Painel com margem para o botão "Criar Tarefa"
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Botão "Criar Tarefa"
        JButton criarTarefaButton = new JButton("Criar Tarefa");
        criarTarefaButton.setPreferredSize(new Dimension(220, 50)); // Ajuste o tamanho do botão, se necessário
        criarTarefaButton.setFont(new Font("Arial", Font.BOLD, 18)); // Ajusta a fonte e o tamanho do texto no botão
        topPanel.add(criarTarefaButton);

        // Adiciona ação ao botão "Criar Tarefa"
        criarTarefaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarTarefa("Nova Tarefa");
                adicionarTarefa.setFont(new Font("Arial", Font.BOLD, 18)); // Ajusta a fonte e o tamanho do texto no botão
            }
        });

        // Painel para listar tarefas
        tarefaPanel = new JPanel();
        tarefaPanel.setLayout(new BoxLayout(tarefaPanel, BoxLayout.Y_AXIS));

        // Adiciona os componentes na janela
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(tarefaPanel), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // Método para adicionar uma nova tarefa
    private void adicionarTarefa(String descricao) {
        // Cria o painel arredondado para a tarefa
        RoundedPanel panel = new RoundedPanel(15); // Define o raio dos cantos
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(700, 50)); // Tamanho exato da caixa de tarefa
        panel.setMaximumSize(new Dimension(700, 50));   // Limita o tamanho máximo da caixa
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Margem interna da caixa

        // Rótulo com a descrição da tarefa, centralizado
        JLabel label = new JLabel(descricao, SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        
        panel.add(label, BorderLayout.CENTER);

        // Botão de editar
        JButton editarButton = new JButton("✎");
        editarButton.setForeground(Color.BLUE);
        editarButton.setPreferredSize(new Dimension(50, 30)); // Ajusta o tamanho do botão editar
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String novaDescricao = JOptionPane.showInputDialog("Editar Tarefa:", descricao);
                if (novaDescricao != null && !novaDescricao.trim().isEmpty()) {
                    label.setText(novaDescricao);
                }
            }
        });

        // Botão de excluir
        JButton excluirButton = new JButton("X");
        excluirButton.setForeground(Color.RED);
        excluirButton.setPreferredSize(new Dimension(50, 30)); // Ajusta o tamanho do botão excluir
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tarefaPanel.remove(panel);
                tarefaPanel.revalidate();
                tarefaPanel.repaint();
                tarefas.remove(panel);
            }
        });

        // Painel para os botões de editar e excluir
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(editarButton);
        buttonPanel.add(excluirButton);

        // Adiciona o painel de botões à direita
        panel.add(buttonPanel, BorderLayout.EAST);

        // Adiciona o painel da tarefa ao painel principal de tarefas
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




