# CadastroConsultaCandidato

Sistema de cadastro e consulta de candidatos para eleições. Este projeto tem como objetivo permitir o registro e a consulta de informações de candidatos, facilitando o processo de gestão e acesso a dados por parte dos eleitores.

## Funcionalidades

- **Cadastro de Candidatos:** Insere novos candidatos no sistema com informações detalhadas.
- **Consulta de Candidatos:** Permite consultas com filtros como localidade e orientação ideológica.
- **Atualização de Informações:** Permite modificar informações dos candidatos já cadastrados.
- **Exclusão de Candidatos:** Remove candidatos do sistema.

## Estrutura do Projeto

### Classes Modelos (Model)
- **Pessoa:** Define atributos e métodos básicos.
- **Candidato:** Representa um candidato e estende a classe `Pessoa`, definindo um laço de herança entre elas, com reutilização do código de `Pessoa`. Inclui atributos próprios de um candidato.

### Classe de Serviço
- **ServicosCadastroCandidato:** Classe que fornece o serviço de cadastro do candidato, capturando as informações inseridas pelo usuário e validando os dados. Lida com a lógica de cadastro e retorna uma instância de `Candidato`.

### Classes e Interface de Repositório
- **Interface: ConstantesDB:** Arquivo criado pelo professor e adaptado pela equipe para abrigar constantes necessárias ao carregamento do Driver JDBC e dados para estabelecer a conexão com o banco de dados.
- **ConexaoBancoDados:** Gerencia a conexão com o banco de dados, incluindo o fechamento das conexões.
- **CandidatoDAO:** Centraliza o acesso ao banco de dados com métodos CRUD (Create, Read, Update, Delete). Captura a instância de `Candidato` para inserir, atualizar ou deletar o candidato no banco de dados.
- **CandidatoConsultaDAO:** Centraliza o acesso ao banco de dados para consultas (CRUD - Read). Esta classe inclui métodos para consultas ao banco, seja para todos os registros ou aplicando filtros específicos.

### Classes de Visualização (View)
- **Menu:** Classe abstrata contendo métodos abstratos para exibição de texto no prompt e processamento de entradas de usuário. Estes métodos são implementados polimorficamente em cada uma das subclasses.
   - **MenuPrincipal:** Menu inicial que interage com o usuário e, dependendo da opção escolhida, passa o fluxo de controle para outros menus ou inicia o processo de cadastro.
   - **MenuCandidato:** Menu para candidatos já cadastrados, com opções para alterar dados ou deletar cadastros, utilizando métodos da classe `CandidatoDAO`.
   - **MenuEleitor:** Menu voltado para o eleitorado, com operações de consulta fornecidas pela classe `CandidatoConsultaDAO`.

### Classe de Execução
- **CadastroConsultaCandidatoApp:** Classe principal que invoca e gerencia todas as funcionalidades providas pelas demais classes do software.

## Pré-requisitos

Para rodar este projeto, você precisa ter instalado:

- **Java 17** (versão que foi utilizada no projeto. Podendo ser utilizado em versões superiores, porém requer configuração das dependências).
- **Apache Maven** para gerenciar as dependências do projeto
- **MySQL** ou outro banco de dados compatível para armazenar os dados
- **NetBeans IDE** (opcional, mas recomendado)

Além disso, configure as dependências do Maven para incluir o driver JDBC do banco de dados que será utilizado. Certifique-se de configurar corretamente as informações de conexão para que o projeto funcione corretamente.

## Instalando o JDK 17 e Configurando o Ambiente

### Para Linux

1. **Atualizar o sistema:**
   Abra um terminal e execute:
   ```bash
   sudo apt update
   sudo apt upgrade

2. ** Instalar o OpenJDK 17:**
   ```bash
   sudo apt install openjdk-17-jdk

3. **Verificar a instalação:**
   ```bash
   java --version

4. **Configurando variáveis de ambiente:** Para definir a variável JAVA_HOME, adicione as seguintes linhas ao final do arquivo ~/.bashrc ou ~/.profile:
   ```bash
   export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
   export PATH=$PATH:$JAVA_HOME/bin
   
Depois execute:
   ```bash
   source ~/.bashrc
```

### Para Windows

1. **Baixar o JDK 17:** Acesse o site oficial do OpenJDK [neste link](https://jdk.java.net/17/) e baixe o instalador do JDK 17 para Windows.

2. **Instalar o JDK:** Execute o instalador e siga as instruções na tela. Por padrão, o JDK será instalado em `C:\Program Files\OpenJDK\jdk-17`.

3. **Configurar variáveis de ambiente:**
   - Clique com o botão direito em "Este PC" ou "Meu Computador" e selecione "Propriedades".
   - Clique em "Configurações avançadas do sistema".
   - Na aba "Avançado", clique em "Variáveis de Ambiente".
   - Adicione uma nova variável de sistema chamada `JAVA_HOME` com o valor `C:\Program Files\OpenJDK\jdk-17`.
   - Encontre a variável `Path` na lista de variáveis do sistema e clique em "Editar". Adicione uma nova entrada: `%JAVA_HOME%\bin`.



1. Clone o repositório para o seu ambiente local:
   ```bash
   git clone https://github.com/joaoVitorLeal/cadastro-consulta-candidato.git

