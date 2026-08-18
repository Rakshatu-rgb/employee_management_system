# Employee Management System

A backend Employee Management System developed using Java and Spring Boot.

## Features

- Employee CRUD operations
- User registration and login
- OTP-based email verification
- Input validation
- Global exception handling
- MySQL database integration
- Spring Data JPA and Hibernate
- Email service integration
- RESTful APIs

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Jakarta Validation
- JavaMailSender

## Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.tcs.ems
│   │       ├── controller
│   │       ├── entity
│   │       ├── exception
│   │       ├── repository
│   │       ├── service
│   │       └── util
│   └── resources
└── test
```
## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA or Eclipse.
3. Create a MySQL database named `ems`.
4. Configure your database credentials in `application.properties`.
5. Configure your email credentials for OTP verification.
6. Run the Spring Boot application.

The application runs on:

`http://localhost:8085`

## Database Configuration

The application uses MySQL.

Create the database using:

```sql
CREATE DATABASE ems;
```


### 3. API Overview

Since your project is a **REST API backend**, this is useful.

You don't need to document every endpoint. A simple overview is enough:

```markdown
## API Overview

The application provides REST APIs for:

- User registration
- User login
- OTP generation and verification
- Employee creation
- Employee retrieval
- Employee update
- Employee deletion

```

## Author

**Raksha T U**

Computer Science and Engineering
