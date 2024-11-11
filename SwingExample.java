import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingExample {
    public static void main(String[] args) {
        // Criação da janela principal
        JFrame frame = new JFrame("Exemplo de Interface Gráfica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        
        // Criação de um painel
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Tornar a janela visível
        frame.setVisible(true);
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
