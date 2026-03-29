# examcore

Backend service for an online competitive exam platform, similar to GATE/JEE. Built with Java, Spring Boot, and MongoDB.

## Tech Stack

- Java 17
- Spring Boot 3.5.12
- MongoDB
- Spring Security + JWT (JJWT 0.12.3)
- BCrypt password hashing
- Maven

## Project Status

| Phase | Description | Status |
|-------|-------------|--------|
| Phase 1 | Setup and project initialization | Complete |
| Phase 2 | User authentication (Register, Login, JWT) | Complete |
| Phase 3 | Question bank module | Pending |
| Phase 4 | Exam engine | Pending |
| Phase 5 | Results and analytics | Pending |
| Phase 6 | Admin panel APIs | Pending |
| Phase 7 | Security hardening and validation | Pending |
| Phase 8 | Deployment | Pending |

## Architecture

```
examweb (React/Vite - localhost:5173)
         |
         | REST APIs + JWT Token
         |
examcore (Spring Boot - localhost:8080)
         |
         | Spring Data MongoDB
         |
MongoDB  (localhost:27017)
```

Layered architecture:
```
Controller -> Service -> ServiceImpl -> Repository -> MongoDB
```

## API Endpoints

### Authentication

| Method | Endpoint | Description | Auth | Status |
|--------|----------|-------------|------|--------|
| POST | /api/auth/register | Register new user | No | 201 Created |
| POST | /api/auth/login | Login, returns JWT | No | 200 OK |

#### Register Request
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123",
  "role": "STUDENT"
}
```

#### Login Request
```json
{
  "email": "john@example.com",
  "password": "password123"
}
```

#### Login Response
```json
{
  "token": "eyJhbGciOiJIUzM4NCJ9...",
  "email": "john@example.com",
  "role": "STUDENT"
}
```

#### Validation Error Response (400)
```json
{
  "email": "Invalid Email Format",
  "password": "Password Must be at Least 6 characters"
}
```

## Getting Started

### Prerequisites

- JDK 17
- MongoDB running on localhost:27017
- Maven 3.9+

### Setup

1. Clone the repository
```
git clone git@github.com:shubhangamK/examcore.git
```

2. Copy the example properties file
```
cp src/main/resources/application-example.properties src/main/resources/application.properties
```

3. Update application.properties with your values

4. Run the application
```
./mvnw spring-boot:run
```

Application starts on port 8080.

## Project Structure

```
src/main/java/com/shubhangam/examcore/
├── controller/
│   └── AuthController.java
├── dto/
│   ├── request/
│   │   ├── RegisterRequest.java
│   │   └── LoginRequest.java
│   └── response/
│       └── AuthResponse.java
├── entity/
│   ├── User.java
│   └── Role.java
├── repository/
│   └── UserRepository.java
├── service/
│   └── AuthService.java
├── serviceImpl/
│   └── AuthServiceImpl.java
├── config/
│   ├── SecurityConfig.java
│   ├── CorsConfig.java
│   └── GlobalExceptionHandler.java
├── security/
│   └── JwtUtil.java
└── ExamcoreApplication.java
```

## Author

Shubhangam - [GitHub](https://github.com/shubhangamK)