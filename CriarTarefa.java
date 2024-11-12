
    
import javax.swing.*;
import java.util.ArrayList;


public class CriarTarefa  {
    // Lista para armazenar as tarefas
    private static ArrayList<String> tarefas = new ArrayList<>();

    public static void main(String[] args) {
        // Configuração da janela e componentes omitida para focar na função de adicionar tarefa
    }

    // Função para adicionar tarefa
    public static void adicionarTarefa(JTextField campoTarefa, JTextArea listaTarefas) {
        String tarefa = campoTarefa.getText(); // Obtém o texto do campo de entrada
        if (!tarefa.isEmpty()) {
            tarefas.add(tarefa); // Adiciona a tarefa à lista
            campoTarefa.setText(""); // Limpa o campo de entrada
            atualizarListaTarefas(listaTarefas); // Atualiza a área de exibição de tarefas
        }
    }

    // Função para atualizar a exibição das tarefas na área de texto
    private static void atualizarListaTarefas(JTextArea listaTarefas) {
        listaTarefas.setText(""); // Limpa a área de texto
        for (String tarefa : tarefas) {
            listaTarefas.append(tarefa + "\n"); // Adiciona cada tarefa à exibição
        }
    }
}


