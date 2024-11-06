# Lista de Tarefas com Notificações

Este é um projeto de uma aplicação em Java desenvolvida para gerenciar tarefas do dia a dia, com funcionalidades que permitem a criação, edição e remoção de tarefas, além de notificações para lembrar o usuário sobre as tarefas pendentes

**Funcionalidades**

- Interface Gráfica (GUI):

- Criar Tarefas:

- Exibe uma lista das tarefas agendadas, permitindo o usuário visualizar as informações detalhadas de cada uma.

- Editar Tarefas:

- Permite a exclusão de tarefas da lista quando elas forem concluídas ou canceladas.

- Notificações:

## Tecnologias Utilizadas

+ Java SE (Standard Edition):
 A linguagem principal para o desenvolvimento do programa.

+ Swing
 Biblioteca para a criação de interfaces gráficas, utilizada para a tela de gerenciamento de tarefas.

+ Timer/Threading:
 Para o controle das notificações no momento correto.

+ Date and Time API (java.time)
 Para manipulação de datas e horas de forma eficiente e segura.

**Estrutura do Projeto**
```
TarefaApp/
├── src/
│   ├── Main.java          # Classe principal com a execução do programa
│   ├── Tarefa.java        # Classe que representa a tarefa (com data, descrição, etc.)
│   ├── TarefaDAO.java     # Classe para gerenciar a persistência de tarefas (opcional)
│   └── Notificacao.java   # Classe para lidar com o envio das notificações
│
├── resources/             # Arquivos de configuração e imagens (se necessário)
│
└── lib/                   # Bibliotecas externas
```

Como Executar o Programa
Pré-requisitos:

Instalar o Java JDK (Recomendado: JDK 8 ou superior).
Compilação e Execução:

Baixar ou clonar o repositório.

```
git clone https://github.com/RafaAnjos25/lista_de_tarefas.git
```