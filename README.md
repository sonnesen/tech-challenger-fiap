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
