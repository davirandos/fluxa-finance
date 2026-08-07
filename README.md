<div align="Center">
  <img src="./docs/images/fluxa-logo.png" width="200" height="200">
</div>

<p align="center">
  Sistema de gestão financeira empresarial desenvolvido com Java e Spring Boot.
</p>

<p align="center">
  Projeto voltado ao controle de contas, receitas, despesas e movimentações financeiras, desenvolvido com foco em boas práticas de backend, modelagem de dados e arquitetura de software.
</p>

## Sumário

* [Sobre o projeto](#sobre-o-projeto)
* [Objetivos](#objetivos)
* [Funcionalidades](#funcionalidades)
* [Tecnologias](#tecnologias)
* [Modelagem do banco de dados](#modelagem-do-banco-de-dados)
* [Decisões de modelagem](#decisões-de-modelagem)
* [Como executar](#como-executar)
* [Testes](#testes)
* [Roadmap](#roadmap)
* [Status do projeto](#status-do-projeto)
* [Autores](#autores)

---

# Sobre o projeto

O **Fluxa Finance** é uma aplicação de gestão financeira voltada para empresas.

O sistema tem como objetivo centralizar e organizar informações relacionadas a:

* contas financeiras;
* receitas;
* despesas;
* categorias;
* movimentações;
* fluxo de caixa;
* indicadores financeiros.

Além das funcionalidades de negócio, o projeto também é utilizado para aplicar conceitos de desenvolvimento de software, como:

* Programação Orientada a Objetos;
* modelagem de domínio;
* banco de dados relacional;
* APIs REST;
* arquitetura em camadas;
* separação de responsabilidades;
* persistência com JPA/Hibernate;
* validação de dados;
* tratamento de exceções;
* testes automatizados;
* Docker;
* documentação técnica;
* Git e GitHub.

> O Fluxa Finance está em desenvolvimento. A arquitetura, modelagem e funcionalidades podem evoluir conforme novas necessidades forem identificadas.

---

# Objetivos

Os principais objetivos do projeto são:

1. Desenvolver uma aplicação financeira baseada em um cenário próximo ao mercado real.
2. Aplicar boas práticas de desenvolvimento backend.
3. Praticar modelagem de banco de dados e modelagem de domínio.
4. Construir uma API REST utilizando Java e Spring Boot.
5. Aplicar persistência utilizando JPA, Hibernate e MySQL.
6. Utilizar Docker para padronizar o ambiente de desenvolvimento.
7. Implementar testes automatizados.
8. Documentar decisões técnicas e arquiteturais.
9. Construir um projeto sólido para portfólio profissional.

---

# Funcionalidades

## Empresas

* [ ] Cadastro de empresas
* [ ] Consulta de empresas
* [ ] Atualização dos dados cadastrais
* [ ] Ativação e desativação de empresas

## Contas financeiras

* [ ] Cadastro de contas
* [ ] Consulta de contas
* [ ] Tipos diferentes de conta
* [ ] Controle de saldo
* [ ] Associação da conta com uma empresa
* [ ] Ativação e desativação de contas

## Categorias

* [ ] Cadastro de categorias
* [ ] Categorias de receita
* [ ] Categorias de despesa
* [ ] Categorias personalizadas por empresa
* [ ] Subcategorias

## Transações

* [ ] Registro de receitas
* [ ] Registro de despesas
* [ ] Transferências entre contas
* [ ] Associação com categorias
* [ ] Controle de data de competência
* [ ] Controle de pagamento ou recebimento
* [ ] Status da transação

## Relatórios

* [ ] Fluxo de caixa
* [ ] Saldo por conta
* [ ] Total de receitas
* [ ] Total de despesas
* [ ] Receitas por categoria
* [ ] Despesas por categoria
* [ ] Indicadores financeiros

---

# Tecnologias

### Backend

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Maven

### Banco de dados

* MySQL

### Infraestrutura

* Docker
* Docker Compose

### Documentação

* Draw.io

### Testes

* Spring Boot Test

### Versionamento
* Git
* GitHub

---

# Modelagem do banco de dados

A modelagem do banco de dados é desenvolvida antes e durante a implementação das entidades para facilitar a compreensão dos relacionamentos e das responsabilidades de cada conceito do domínio.

<p align="center">
  <img
    src="./docs/database/database-model.png"
    alt="Modelagem do banco de dados do Fluxa Finance"
    width="900"
  />
</p>

O arquivo editável do diagrama pode ser encontrado em:

```text
docs/database/database-model.drawio
```
---

# Decisões de modelagem

Documentamos algumas decisões importantes tomadas durante o desenvolvimento.

## Conta e categoria possuem responsabilidades diferentes

Uma conta representa **onde o recurso financeiro está registrado**.
Uma categoria representa **a natureza da movimentação financeira**.

Exemplo:

```text
Descrição: Assinatura de servidor

Valor:
R$ 350,00

Conta:
Nubank PJ

Categoria:
Infraestrutura
```

Portanto:

```text
Conta
→ Onde ocorreu a movimentação?

Categoria
→ Por que ocorreu a movimentação?
```

Essa separação permite gerar relatórios por categoria independentemente da conta utilizada.

---

# Como executar

## Pré-requisitos

Certifique-se de possuir instalado:

* Git;
* Java;
* Docker;
* Docker Compose.

O Maven Wrapper poderá ser utilizado para executar o Maven sem a necessidade de instalação global.

---

## 1. Clone o repositório

```bash
git clone https://github.com/davirandos/fluxa-finance.git
```

Entre no diretório:

```bash
cd fluxa-finance
```

---

## 2. Configure as variáveis de ambiente

Crie um arquivo:

```text
.env
```

Utilizando como base:

```text
.env.example
```

Exemplo:

```env
MYSQL_DATABASE=fluxa_finance
MYSQL_USER=fluxa
MYSQL_PASSWORD=your_password
MYSQL_ROOT_PASSWORD=your_root_password

DB_HOST=localhost
DB_PORT=3306
DB_NAME=fluxa_finance
DB_USER=fluxa
DB_PASSWORD=your_password
```

> Não envie credenciais reais para o GitHub.
O `.env` deve estar presente no `.gitignore`.

---

## 3. Inicialize o banco de dados

```bash
docker compose up -d
```

Verifique os containers:

```bash
docker compose ps
```

Para visualizar os logs:

```bash
docker compose logs -f
```

Para parar os containers:

```bash
docker compose down
```

---

## 4. Execute a aplicação

### Linux / macOS

```bash
./mvnw spring-boot:run
```

### Windows

```powershell
mvnw.cmd spring-boot:run
```

A aplicação deverá ficar disponível em:

```text
http://localhost:8080
```

---

# Roadmap

## 1. Modelagem

* [x] Definição das principais entidades
* [x] Modelagem inicial do banco de dados
* [ ] Revisão dos relacionamentos
* [ ] Definição completa das regras de negócio

## 2. Estrutura do backend

* [x] Configurar Spring Boot
* [ ] Configurar MySQL
* [ ] Configurar Docker
* [ ] Criar entidades
* [ ] Criar repositories
* [ ] Criar services
* [ ] Criar controllers
* [ ] Criar DTOs
* [ ] Criar mappers
* [ ] Implementar tratamento global de erros

## 3. Gestão financeira

* [ ] Empresas
* [ ] Contas
* [ ] Categorias
* [ ] Receitas
* [ ] Despesas
* [ ] Transferências
* [ ] Fluxo de caixa

## 4. Qualidade

* [ ] Testes unitários
* [ ] Testes de integração
* [ ] Validações
* [ ] Revisão da arquitetura

## 5. Segurança

* [ ] Autenticação
* [ ] Autorização
* [ ] Spring Security
* [ ] Controle de acesso por empresa

## 6. Evoluções

* [ ] Dashboards
* [ ] Relatórios
* [ ] Contas a pagar
* [ ] Contas a receber
* [ ] Transações recorrentes
* [ ] Auditoria
* [ ] Frontend

---

# Status do projeto

> **Em desenvolvimento**

Atualmente o projeto está na fase de modelagem do domínio, modelagem do banco de dados e definição da estrutura inicial da aplicação.
A documentação será atualizada conforme novas funcionalidades forem desenvolvidas.

---

# Aprendizados aplicados

Durante o desenvolvimento do Fluxa Finance são aplicados conhecimentos relacionados a:

* Java;
* orientação a objetos;
* Spring Boot;
* Spring Data JPA;
* Hibernate;
* MySQL;
* modelagem relacional;
* APIs REST;
* arquitetura de software;
* Docker;
* Git;
* GitHub;
* testes automatizados;
* validação;
* tratamento de exceções;
* documentação técnica.

---

# Autores

Desenvolvido por:

**Luccas Davi**
Análise e Desenvolvimento de Sistemas — FATEC

**Juan Andrés**
Análise e Desenvolvimento de Sistemas - FATEC
