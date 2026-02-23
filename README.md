# 🏦 Sistema Bancário API

API REST desenvolvida com **Spring Boot** para gerenciamento de clientes e contas bancárias.

O projeto simula operações básicas de um sistema bancário, como:

- Cadastro de clientes  
- Criação de contas  
- Depósito  
- Saque  
- Transferência entre contas  

---

## 🚀 Tecnologias Utilizadas

- Java 17 
- Spring Boot  
- Spring Data JPA  
- Hibernate  
- MySQL 8  
- Swagger (OpenAPI)  
- Maven  
- Lombok  

---

## 📂 Estrutura do Projeto

```
src/main/java/com/banco/sistema_bancario
│
├── controller
├── service
├── repository
├── entity
├── exception
├── dto
│   ├── cliente
│   └── conta
└── config
```

Arquitetura em camadas seguindo boas práticas:

- **Controller** → recebe requisições  
- **Service** → regras de negócio  
- **Repository** → acesso ao banco  
- **DTO** → comunicação da API  

---

## 🗄 Banco de Dados

Banco utilizado: **MySQL**

Exemplo de configuração (`application.yml`):

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/sistema_bancario
    username: root
    password: root

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

---

## ▶ Como Rodar o Projeto

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/SEU_USUARIO/sistema-bancario.git
```

### 2️⃣ Criar o banco no MySQL

```sql
CREATE DATABASE sistema_bancario;
```

### 3️⃣ Rodar a aplicação

Via IDE (IntelliJ / Eclipse):

Executar a classe:

```
SistemaBancarioApplication
```

Ou via terminal:

```bash
mvn spring-boot:run
```

---

## 📖 Documentação da API (Swagger)

Após iniciar a aplicação, acessar:

```
http://localhost:8080/swagger-ui.html
```

ou

```
http://localhost:8080/swagger-ui/index.html
```

No Swagger é possível:

- Testar endpoints  
- Criar clientes  
- Criar contas  
- Realizar operações bancárias  

---

## 📌 Funcionalidades Implementadas

### 👤 Cliente
- Criar cliente  
- Listar clientes  
- Buscar cliente por ID  

### 💳 Conta
- Criar conta  
- Consultar saldo  
- Depositar  
- Sacar  
- Transferir  

---

## 🔐 Regras de Negócio

- CPF é único  
- Número da conta é único  
- Não permite saque maior que o saldo  
- Transferência valida saldo antes da operação  

---

## 📈 Melhorias Futuras

- Autenticação com Spring Security  
- Versionamento de API  
- Testes unitários (JUnit + Mockito)  
- Docker  
- Deploy em nuvem  

---

## 👨‍💻 Autor

Projeto desenvolvido para prática de:

- API REST  
- JPA / Hibernate  
- Arquitetura em camadas  
- Integração com banco relacional  
