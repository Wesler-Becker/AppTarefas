# App de Tarefas com Firebase In-App Messaging

Este é um app Android com Java que demonstra o uso de Firebase In-App Messaging para engajar o usuário conforme ele conclui tarefas.

## Funcionalidades

- Lista com tarefas
- Marcação de tarefas concluídas
- Mensagens inteligentes com base no progresso:
    - 1 tarefa: mensagem padrão
    - 50% tarefas: mensagem motivacional
    - 100% tarefas: mensagem de conclusão total

## Tecnologias

- Android Studio
- Firebase Analytics
- Firebase In-App Messaging

## Telas

![image](https://github.com/user-attachments/assets/18cc0409-9357-428b-ad14-a85842e7623c)

## Como testar

1. Conecte-se ao Firebase
2. Crie os eventos `tarefa_concluida`, `tarefas_metade`, `todas_tarefas_concluidas` no Console Firebase
3. Configure campanhas de In-App Messaging associadas a cada evento
