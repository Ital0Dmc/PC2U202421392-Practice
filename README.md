# {{APP_NAME}} Platform API

RESTful API for {{APP_NAME}}, built with Java and Spring Boot as part of the Open Source Application Development course (PC2).

## Description

{{APP_NAME}} {{ONE_SENTENCE_ABOUT_THE_COMPANY}}. This backend manages the {{AGGREGATE_PLURAL}} of the platform, applying Domain-Driven Design and validating every business rule before storing the information.

## Features

- Endpoint `POST /api/v1/{{endpoint}}` to register a new {{AGGREGATE}}.
- Business rules validated in the domain layer, with the correct HTTP status for each error (400 Bad Request, 409 Conflict).
- Error messages in English and Spanish, selected with the `Accept-Language` header.
- Auditable aggregate root with creation and last update dates.
- API documentation with OpenAPI and Swagger UI.

## Technologies

- Java 26
- Spring Boot 4.0.9
- Spring Data JPA
- PostgreSQL
- Lombok
- springdoc-openapi (Swagger UI)

## Architecture

- Domain-Driven Design with the bounded contexts `{{BC}}` and `shared`.
- Layered architecture: domain, application, infrastructure and interfaces.
- CQRS, Resource and Assembler patterns.
- Separation of domain concepts (aggregates and domain repositories) from persistence concepts (persistence entities, persistence repositories and repository adapters).

## Getting Started

1. Create a PostgreSQL database named `{{DB_NAME}}`.
2. Check the credentials in `src/main/resources/application.properties`.
3. Run the application from IntelliJ IDEA or with `./mvnw spring-boot:run`.
4. Open Swagger UI at `http://localhost:{{PORT}}/swagger-ui/index.html`.

## Author

- **Name:** Italo Gianfranco Damacen Galindo
- **Student code:** u202421392
- **Section:** 7760
