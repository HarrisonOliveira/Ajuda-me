# API Ajuda-me

API REST para gerenciamento de Organizações Não Governamentais (ONGs) desenvolvida com Spring Boot e Java.

## 🚀 Tecnologias Utilizadas

- **Java 25**
- **Spring Boot 4.0.0**
- **Spring Data JPA**
- **H2 Database** (Desenvolvimento)
- **PostgreSQL** (Produção)
- **SpringDoc OpenAPI 3** (Swagger)
- **Lombok**
- **Hibernate Validator**
- **Maven**

## 📋 Pré-requisitos

- Java 25 ou superior
- Maven 3.6 ou superior
- PostgreSQL (apenas para produção)

## 🏗️ Estrutura do Projeto

```
src/main/java/com/estudo/ajudame/
├── AjudameApplication.java          # Classe principal da aplicação
├── controller/                      # Controladores REST
│   ├── OngController.java          # Controller de ONGs
│   └── request/
│       └── OngRequest.java         # DTO de requisição
├── service/                         # Camada de serviço
│   └── OngService.java             # Lógica de negócio
├── repository/                      # Camada de dados
│   └── OngRepository.java          # Repositório JPA
├── domain/entity/                   # Entidades de domínio
│   └── Ong.java                    # Entidade ONG
└── exception/                       # Tratamento de exceções
    ├── GlobalExceptionHandler.java
    ├── OngNotFoundException.java
    └── OngAlreadyExistsException.java
```

## 🗄️ Configuração do Banco de Dados

### Desenvolvimento (Padrão)
A aplicação utiliza H2 em modo memória automaticamente:
- **Console H2**: http://localhost:8080/h2-console
- **URL**: `jdbc:h2:mem:ajudame_db`
- **Usuário**: `sa`
- **Senha**: (vazia)

### Produção
Para usar PostgreSQL em produção:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

Ou configure o banco de dados PostgreSQL:
1. Crie o banco de dados: `ajudame_db`
2. Configure as credenciais em `application-prod.properties`
3. Execute com o perfil `prod`

## 🚀 Executando a Aplicação

### 1. Clonar o repositório
```bash
git clone <repository-url>
cd ajudame
```

### 2. Compilar e executar
```bash
# Compilar o projeto
mvn clean compile

# Executar os testes
mvn test

# Iniciar a aplicação (modo desenvolvimento)
mvn spring-boot:run
```

### 3. Acessar a aplicação
- **API Base**: http://localhost:8080/api/v1
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **Console H2**: http://localhost:8080/h2-console

## 📚 Endpoints da API

### ONGs
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/api/v1/ongs` | Cadastrar nova ONG |
| GET | `/api/v1/ongs` | Listar todas as ONGs |
| GET | `/api/v1/ongs/{id}` | Buscar ONG por ID |
| GET | `/api/v1/ongs/cnpj/{cnpj}` | Buscar ONG por CNPJ |
| DELETE | `/api/v1/ongs/cnpj/{cnpj}` | Deletar ONG por CNPJ |

### Exemplos de Requisição

#### Cadastrar ONG
```json
POST /api/v1/ongs
Content-Type: application/json

{
  "nomeFantasia": "Instituto Aurora Social",
  "cnpj": "39458276000145"
}
```

#### Resposta de Sucesso
```json
{
  "id": 1,
  "nomeFantasia": "Instituto Aurora Social",
  "cnpj": "39458276000145",
  "dataCadastro": "2025-11-30T17:05:00"
}
```

## 🔧 Configuração de Ambiente

### Variáveis de Ambiente
```bash
# Para produção
export SPRING_PROFILES_ACTIVE=prod
export DB_HOST=localhost
export DB_PORT=5432
export DB_NAME=ajudame_db
export DB_USERNAME=postgres
export DB_PASSWORD=admin
```

### Docker (Opcional)
```dockerfile
# Para build com Docker
docker build -t ajudame-api .
docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=prod ajudame-api
```

## 🧪 Testes

### Executar testes unitários
```bash
mvn test
```

### Executar testes de integração
```bash
mvn verify
```

## 📝 Documentação

A documentação completa da API está disponível através do Swagger:
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs

## 🐛 Troubleshooting

### Problemas Comuns

1. **Porta 8080 em uso**
   ```bash
   # Mudar porta no application.properties
   server.port=8081
   ```

2. **PostgreSQL não conecta**
   - Verifique se o PostgreSQL está rodando: `pg_ctl status`
   - Verifique se o banco foi criado: `createdb ajudame_db`
   - Verifique credenciais no application-prod.properties

3. **Problemas com Java 25**
   - Verifique se o Java 25 está instalado: `java -version`
   - Configure JAVA_HOME corretamente

## 📈 Monitoramento

### Logs
- **Desenvolvimento**: Logs detalhados no console
- **Produção**: Logs em nível WARN

### Health Check
```bash
curl http://localhost:8080/actuator/health
```

## 🤝 Contribuição

1. Fork o projeto
2. Crie uma branch para sua feature: `git checkout -b feature/nova-feature`
3. Commit suas mudanças: `git commit -am 'Adiciona nova feature'`
4. Push para a branch: `git push origin feature/nova-feature`
5. Abra um Pull Request

## 📄 Licença

Este projeto está licenciado sob a MIT License.
