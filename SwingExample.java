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

        // Criação do rótulo (label)
        JLabel userLabel = new JLabel("Clique no botão:");
        userLabel.setBounds(10, 20, 150, 25);
        panel.add(userLabel);

        // Criação do campo de texto
        JTextField userText = new JTextField(20);
        userText.setBounds(150, 20, 200, 25);
        panel.add(userText);

        // Criação do botão
        JButton loginButton = new JButton("Clique Aqui");
        loginButton.setBounds(150, 60, 150, 25);
        panel.add(loginButton);

        // Adicionando ação ao botão
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText.setText("Eduardo Tecelão");
            }
        });
    }
}
