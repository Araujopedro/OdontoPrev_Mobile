## **Sistema de Gerenciamento de Consultas Odontológicas**

Este é um projeto mobile desenvolvido em Kotlin no Android Studio, parte de um sistema de gerenciamento de consultas odontológicas. O aplicativo é voltado para pacientes, oferecendo suporte para acompanhamento de consultas, check-ups regulares e incentivo a bons hábitos de higiene bucal. Ele também facilita a marcação de consultas e oferece um sistema de pontos como forma de fidelização.

**Funcionalidades**

Tela de Login
Interface para autenticação de usuários com validação de CEP, para que o usuário só consiga buscar clínicas quando insere um CEP válido de 8 dígitos.

Perfil do Paciente
Exibe informações sobre o paciente, incluindo nome, dados cadastrais e quantidade de pontos acumulados.

Agendamento de Consultas
Permite ao usuário marcar, visualizar e gerenciar suas consultas odontológicas. Essa tela possui um layout otimizado para exibir o calendário dos meses, facilitando a escolha da data.

Higiene Bucal
Acompanhamento de hábitos diários de higiene, como escovar os dentes após refeições, marcar consultas e realizar limpezas dentárias, incentivando o paciente a manter uma rotina saudável.

Notificações
Sistema de alertas e lembretes sobre consultas futuras e atividades de higiene, que ajuda o usuário a não perder consultas e a se manter em dia com a saúde bucal.

Sistema de Pontos
Sistema de gamificação que recompensa bons hábitos de saúde bucal, proporcionando um sistema de pontos como incentivo.

Buscar Clínicas
Interface de busca de clínicas odontológicas próximas, utilizando a API pública do ViaCEP para buscar clínicas com base no CEP fornecido. Futuramente, o projeto deverá ser conectado a um banco de dados que armazenará as informações das clínicas.

## **API Utilizada**

ViaCEP
A aplicação utiliza a API ViaCEP para validar e buscar informações sobre o CEP informado. A requisição é feita por meio de Retrofit, uma biblioteca para requisições HTTP em Android. A resposta da API é exibida na tela para o usuário, e no futuro será integrada com o banco de dados para armazenar e retornar a lista de clínicas mais próximas.

# **Estrutura de Telas**
1. Login
Tela inicial para autenticação de usuários, com campos para e-mail e senha.

2. Funcionalidades
Tela principal do aplicativo, oferecendo acesso a agendamentos, perfil do paciente e notificações. Nessa tela, foram implementadas imagens que funcionam como botões para navegação entre as seções.

3. Agendamentos
Permite que o paciente marque e visualize suas consultas odontológicas, com um fundo azul escuro e um layout de calendário que facilita a escolha das datas.

4. Perfil
Exibe detalhes do paciente, como dados cadastrais, sistema de pontos acumulados e histórico de consultas.

5. Notificações
Tela para alertas e lembretes de consultas e atividades de higiene bucal, para garantir que o paciente esteja atualizado com suas atividades.

## **Tratamento de Erros**

Para garantir a qualidade e a experiência do usuário, o projeto inclui:

Validação de CEP: A entrada do CEP é validada para aceitar apenas números e garantir exatamente 8 dígitos.
Tratamento de Respostas da API: Em caso de falha na conexão ou erro na resposta da API, uma mensagem amigável é exibida ao usuário.
Verificação de Entrada: O aplicativo utiliza toasts para notificar o usuário sobre erros de entrada, como falta de dados obrigatórios, CEP inválido, entre outros.

## **Tecnologias Utilizadas**
Linguagem: Kotlin
IDE: Android Studio
Layout: ConstraintLayout
Banco de Dados: (a ser adicionado em futuras implementações)
Controle de Versão: Git, GitHub


## **Diagrama demonstrando a integração/comunicação do aplicativo**
![Diagrama](https://github.com/bia98silva/OdontoPrev_Mobile/blob/master/IMG/Diagrama.png)
