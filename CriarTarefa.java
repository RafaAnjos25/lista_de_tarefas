import javax.swing.*;
import java.util.ArrayList;

public class CriarTarefa {
    private ArrayList<String> tarefas; // Lista para armazenar as tarefas

    // Construtor
    public CriarTarefa() {
        tarefas = new ArrayList<>();
    }

    // Método para adicionar tarefa
    public void adicionarTarefa(JTextField campoTarefa, JTextArea listaTarefas) {
        String tarefa = campoTarefa.getText(); // Obtém o texto do campo de entrada
        if (!tarefa.isEmpty()) {
            tarefas.add(tarefa); // Adiciona a tarefa à lista
            campoTarefa.setText(""); // Limpa o campo de entrada
            atualizarListaTarefas(listaTarefas); // Atualiza a área de exibição de tarefas
        }
    }

    // Método para atualizar a exibição das tarefas na área de texto
    private void atualizarListaTarefas(JTextArea listaTarefas) {
        listaTarefas.setText(""); // Limpa a área de texto
        for (String tarefa : tarefas) {
            listaTarefas.append(tarefa + "\n"); // Adiciona cada tarefa à exibição
        }
    }
}
