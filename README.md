# Sistema de Recrutamento

API backend para gerenciamento de candidatos, empresas, vagas e candidaturas.

Este projeto simula um sistema de recrutamento onde candidatos podem se cadastrar, empresas podem publicar vagas e candidatos podem aplicar para essas vagas.

## Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Data JPA / Hibernate
* PostgreSQL
* Docker
* Docker Compose
* Maven

Ferramentas de desenvolvimento:

* DBeaver (visualização do banco)
* Postman / Swagger (testes da API)

---

# Arquitetura

O projeto segue uma arquitetura em camadas:

Controller → Service → Repository → Database

Responsabilidades:

* **Controller**: expõe os endpoints da API
* **Service**: contém a lógica de negócio
* **Repository**: comunicação com o banco via JPA
* **Model**: entidades do sistema

Estrutura de pastas:

```
src/main/java/com/dev/lacerda/SistemadeRecrutamento

controllers
services
repositories
models
```

---

# Entidades do sistema

## Candidato

Representa um usuário que deseja aplicar para vagas.

Campos principais:

* id
* nome
* email

---

## Empresa

Empresa responsável por publicar vagas.

Campos principais:

* id
* nome
* descricao

---

## Vaga

Representa uma oportunidade de trabalho publicada por uma empresa.

Campos principais:

* id
* titulo
* descricao
* empresa

Relacionamento:

Empresa → 1:N → Vagas

---

## Candidatura

Representa a aplicação de um candidato para uma vaga.

Campos principais:

* id
* candidato
* vaga
* status
* dataAplicacao

Relacionamentos:

Candidato → N:N → Vagas
(intermediado por Candidatura)

---

# Status da candidatura

Enum utilizado no sistema:

```
EM_ANALISE
APROVADO
REJEITADO
```

---

# Endpoints principais

## Candidatos

Criar candidato

POST /candidatos

Listar candidatos

GET /candidatos

Buscar candidato por id

GET /candidatos/{id}

Atualizar candidato

PUT /candidatos/{id}

Deletar candidato

DELETE /candidatos/{id}

---

## Empresas

POST /empresas
GET /empresas
GET /empresas/{id}
PUT /empresas/{id}
DELETE /empresas/{id}

---

## Vagas

POST /vagas
GET /vagas
GET /vagas/{id}
PUT /vagas/{id}
DELETE /vagas/{id}

---

## Candidaturas

Aplicar para vaga

POST /candidaturas

Exemplo de body:

```
{
  "candidatoId": 1,
  "vagaId": 2
}
```

Listar candidaturas

GET /candidaturas

Atualizar status da candidatura

PATCH /candidaturas/{id}/status

---

# Rodando o projeto

## Pré-requisitos

* Java 21
* Maven
* Docker

---

## Rodar localmente

Gerar o JAR:

```
mvn clean package
```

Subir containers:

```
docker compose up --build
```

A API ficará disponível em:

```
http://localhost:8080
```

---

# Banco de dados

Banco utilizado:

PostgreSQL

Configuração padrão:

```
database: hiring_db
user: postgres
password: postgres
```

O banco pode ser acessado via DBeaver ou outro cliente SQL.

---

# Melhorias futuras

Algumas melhorias planejadas:

* autenticação com JWT
* paginação de resultados
* filtros de busca de vagas
* evitar candidatura duplicada
* frontend em React

---

# Autor

Projeto desenvolvido para estudo de backend com Spring Boot.
