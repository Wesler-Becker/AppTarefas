# Como funciona o In-App Messaging
O funcionamento é baseado em gatilhos de eventos. O desenvolvedor configura o app para enviar eventos ao Firebase Analytics quando o usuário realiza determinadas ações. Em seguida, o desenvolvedor cria campanhas no Console do Firebase, configurando para que as mensagens sejam exibidas quando o app estiver em primeiro plano e algum desses eventos for detectado.

O ciclo funciona assim:
- Usuário realiza uma ação dentro do app (por exemplo, marca uma tarefa como concluída).
- O app envia um evento personalizado ao Firebase Analytics.
- No Firebase Console, uma campanha de mensagem é configurada para ser acionada quando o app estiver em primeiro plano e após o envio desse evento.
- Quando as condições são atendidas, a mensagem é exibida ao usuário.


# Introdução ao Firebase In-App Messaging
O Firebase In-App Messaging é uma ferramenta que permite enviar mensagens direcionadas para os usuários dentro do aplicativo, com o objetivo de estimular ações específicas, como concluir tarefas, usar uma funcionalidade, ou até promover conteúdos.

Essas mensagens aparecem em tempo real, enquanto o app está aberto, e podem ser personalizadas com textos, imagens, botões e muito mais. Elas são ideais para melhorar o engajamento dos usuários, orientar o uso do app ou fornecer feedback com base em ações do usuário.


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
