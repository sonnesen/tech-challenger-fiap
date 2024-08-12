# tech-challenger-fiap

Bem-vindo ao repositório do projeto "Fotoexpress", desenvolvido como parte do desafio tecnológico da FIAP. Este projeto visa implementar uma API para uma empresa de fotografia, utilizando princípios de Domain-Driven Design (DDD), EventStorming e Clean Code.

Projeto de pós-graduação em arquitetura e desenvolvimento JAVA pela FIAP
ALUNOS 5ADJT

<p>Edson</p>
<p>Gabriel Ricardo </p>
<p>Luiz Romão</p>
<p>Marcelo Souza</p>
<p>Rodrigo Almeida</p>

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.10-brightgreen?style=flat&logo=spring&logoColor=white)
![Java 17](https://img.shields.io/badge/Java-17-blue?style=flat&logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.8.5-orange?style=flat&logo=apachemaven&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat&logo=mysql&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-3.0-brightgreen?style=flat&logo=swagger&logoColor=white)

## Sumário

- [Visão Geral](#visão-geral)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Como Executar o Projeto](#como-executar-o-projeto)
- [Endpoints da API](#endpoints-da-api)
- [Contribuindo](#contribuindo)
- [Licença](#licença)

## Visão Geral

O projeto consiste na criação de uma API para gerenciar processos e operações de uma empresa de fotografia. O desenvolvimento foi guiado pelos princípios de DDD para uma melhor organização do código e arquitetura, EventStorming para uma compreensão clara dos eventos e fluxos do sistema, e Clean Code para garantir um código limpo e sustentável.

[Event Storming](https://miro.com/app/board/uXjVK6a5xfM=/?share_link_id=868388996904)
[Wiki](https://www.notion.so/Tech-Challenge-P-S-TECH-f6d1fa9d631248b4a980ec4f1eadd898?pvs=4)
[Documentação](https://docs.google.com/document/d/1BBqJWWr-0kGuwFF-z3BwpcLIFU5yAA3k1wurFEO11VU/edit#heading=h.u65y1ld2csi)


## Estrutura do Projeto

- **/src/main/java**: Código fonte da aplicação.
- **/src/main/resources**: Arquivos de configuração e recursos.
- **/src/test/java**: Testes unitários e de integração.
- **/docker**: Arquivos de configuração do Docker.

## Como Executar o Projeto

Para rodar o projeto localmente, siga os passos abaixo:

1. **Clone o repositório:**

    ```bash
    git clone https://github.com/LuizRomao02/tech-challenger-fiap.git
    ```

2. **Navegue até o diretório do projeto:**

    ```bash
    cd tech-challenger-fiap
    ```

3. **Construa o projeto com Maven:**

    ```bash
    mvn clean install
    ```

4. **Inicie a aplicação localmente:**

    ```bash
    mvn spring-boot:run
    ```

5. **Para executar usando Docker:**

    - **Construa a imagem Docker:**

        ```bash
        docker build -t fotoexpress .
        ```

    - **Execute o container Docker:**

        ```bash
        docker run -p 8080:8080 fotoexpress
        ```

    - **Para iniciar o banco de dados MySQL com Docker:**

        ```bash
        docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=fotoexpressdb -p 3306:3306 -d mysql:latest
        ```

## Endpoints da API

A API pode ser explorada e testada utilizando o Swagger. A documentação está disponível em:

http://localhost:8080/api-docs

## Contribuindo

Contribuições são bem-vindas! Para contribuir com o projeto, por favor siga estes passos:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature ou correção (`git checkout -b feature/nova-feature`).
3. Faça commit das suas mudanças (`git commit -am 'Adiciona nova feature'`).
4. Envie suas alterações para o repositório (`git push origin feature/nova-feature`).
5. Abra um pull request.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).



## Configurando as Variáveis de Ambiente do DocuSign

Para integrar o DocuSign ao seu projeto, siga os passos abaixo para obter as informações necessárias:

1. **Crie uma Conta no DocuSign:**
    - Acesse [DocuSign Developer](https://developers.docusign.com/) e crie uma conta.

2. **Acesse o Menu My Apps & Keys:**
    - Após fazer login, vá ao menu "My Apps & Keys".

3. **Obtenha o `accountId`:**
    - No canto superior direito, clique no seu perfil. Você verá o `accountId`.

4. **Obtenha o `userId`:**
    - No centro da página, você encontrará o `userId`.

5. **Crie um Novo App e Chave de Integração:**
    - Clique em "Add App and Integration Key".

6. **Nomeie o App:**
    - Dê um nome ao seu App.

7. **Obtenha a `Integration Key`:**
    - Após nomear o App, a `Integration Key` será gerada e exibida.

8. **Adicione uma Nova `Secret Key`:**
    - Clique no botão para adicionar uma nova `Secret Key`.

9. **Gere e Salve a Chave Privada (`Private Key`):**
    - Clique no botão "Generate RSA", copie a `Private Key` e salve-a no arquivo `privateKey.txt` dentro do diretório `resources` do seu projeto.

10. **Configure a `Redirect URL`:**
    - Adicione uma `Redirect URL` clicando no botão "Add URI". Essa URL será chamada quando ocorrer um evento de assinatura do contrato. Ela deve ser uma rota da sua API. Exemplo: `https://localhost:8080/formalizacao/contrato-assinado`.

11. **Salve as Configurações:**
    - Após configurar, clique em "Save".

12. **Obtenha o Código de Autorização OAuth:**
    - Acesse a seguinte URL substituindo `integrationKey` pela sua `Integration Key` e autorize a aplicação:
      ```
      https://account-d.docusign.com/oauth/auth?response_type=code&scope=signature%20impersonation&client_id=integrationKey&redirect_uri=http://localhost/
      ```

Agora, você configurou as variáveis de ambiente do DocuSign necessárias para a integração com o seu projeto.
