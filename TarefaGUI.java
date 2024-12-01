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

        // Adiciona ação ao botão "Criar Tarefa" para abrir a janela de criação
        criarTarefaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaEdicao("Nova Tarefa", "", "Nao iniciado", true, null, null, null);
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
    private void adicionarTarefa(String titulo, String descricao, String status) {
        // Cria o painel arredondado para a tarefa
        RoundedPanel panel = new RoundedPanel(15); // Define o raio dos cantos
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(700, 80)); // Tamanho exato da caixa de tarefa
        panel.setMaximumSize(new Dimension(700, 80));   // Limita o tamanho máximo da caixa
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Margem interna da caixa

        // Painel interno para organizar título, descrição e status centralizados
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);
        contentPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza horizontalmente

        // Rótulo com o título da tarefa
        JLabel tituloLabel = new JLabel(titulo);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 15)); // Título com fonte maior
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza horizontalmente
        contentPanel.add(tituloLabel);

        // Rótulo com a descrição da tarefa
        JLabel descricaoLabel = new JLabel(descricao);
        descricaoLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Descrição com fonte menor
        descricaoLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza horizontalmente
        contentPanel.add(descricaoLabel);

        // Rótulo com o status da tarefa
        JLabel statusLabel = new JLabel(status);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 12)); // Status em negrito
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza horizontalmente
        contentPanel.add(statusLabel);

        // Adiciona o painel de conteúdo ao painel principal
        panel.add(contentPanel, BorderLayout.CENTER);

        // Botão de editar
        JButton editarButton = new JButton("✎");
        editarButton.setForeground(Color.BLUE);
        editarButton.setPreferredSize(new Dimension(50, 30)); // Ajusta o tamanho do botão editar
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaEdicao(titulo, descricao, status, false, tituloLabel, descricaoLabel, statusLabel);
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
        tarefaPanel.add(Box.createVerticalStrut(10)); // Adiciona um espaço vertical entre as tarefas
        tarefaPanel.revalidate();
        tarefaPanel.repaint();

        tarefas.add(panel);
    }

    // Método para abrir uma janela de edição/criação com layout semelhante à imagem fornecida
    private void abrirJanelaEdicao(String titulo, String descricao, String status, boolean isNovaTarefa,
                                   JLabel tituloLabel, JLabel descricaoLabel, JLabel statusLabel) {
        JDialog dialog = new JDialog(frame, isNovaTarefa ? "Criar Tarefa" : "Editar Tarefa", true);
        dialog.setSize(400, 300);
        dialog.setLayout(null);

        // Título
        JLabel tituloTextoLabel = new JLabel("Titulo:");
        tituloTextoLabel.setBounds(10, 10, 100, 25);
        dialog.add(tituloTextoLabel);

        JTextField tituloField = new JTextField(titulo);
        tituloField.setBounds(120, 10, 250, 25);
        dialog.add(tituloField);

        // Descrição
        JLabel descricaoTextoLabel = new JLabel("Descricao:");
        descricaoTextoLabel.setBounds(10, 50, 100, 25);
        dialog.add(descricaoTextoLabel);

        JTextField descricaoField = new JTextField(descricao);
        descricaoField.setBounds(120, 50, 250, 25);
        dialog.add(descricaoField);

        // Status
        JLabel statusTextoLabel = new JLabel("Status:");
        statusTextoLabel.setBounds(10, 90, 100, 25);
        dialog.add(statusTextoLabel);

        String[] statusOptions = {"Nao iniciado", "Em andamento", "Concluido"};
        JComboBox<String> statusComboBox = new JComboBox<>(statusOptions);
        statusComboBox.setBounds(120, 90, 250, 25);
        statusComboBox.setSelectedItem(status);
        dialog.add(statusComboBox);

        // Botão de salvar
        JButton salvarButton = new JButton("Salvar");
        salvarButton.setBounds(100, 150, 80, 25);
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String novoTitulo = tituloField.getText();
                String novaDescricao = descricaoField.getText();
                String novoStatus = (String) statusComboBox.getSelectedItem();

                if (isNovaTarefa) {
                    // Adiciona nova tarefa à interface principal
                    adicionarTarefa(novoTitulo, novaDescricao, novoStatus);
                } else if (tituloLabel != null && descricaoLabel != null && statusLabel != null) {
                    // Atualiza a tarefa existente
                    tituloLabel.setText(novoTitulo);
                    descricaoLabel.setText(novaDescricao);
                    statusLabel.setText(novoStatus);
                }
                dialog.dispose();
            }
        });
        dialog.add(salvarButton);

        // Botão de cancelar
        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(200, 150, 100, 25);
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.add(cancelarButton);

        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        new TarefaGUI();
    }
}
