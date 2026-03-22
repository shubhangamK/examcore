# examcore

Backend service for an online competitive exam platform, similar to GATE/JEE. Built with Java, Spring Boot, and MongoDB.

## Tech Stack

- Java 17
- Spring Boot 3.5.12
- MongoDB
- Spring Security + JWT
- Maven

## Project Status

| Phase | Description | Status |
|-------|-------------|--------|
| Phase 1 | Setup and project initialization | Complete |
| Phase 2 | User authentication (Register, Login, JWT) | In progress |
| Phase 3 | Question bank module | Pending |
| Phase 4 | Exam engine | Pending |
| Phase 5 | Results and analytics | Pending |
| Phase 6 | Admin panel APIs | Pending |
| Phase 7 | Security hardening and validation | Pending |
| Phase 8 | Deployment | Pending |

## Architecture

```
examweb (React - localhost:3000)
         |
         | REST APIs
         |
examcore (Spring Boot - localhost:8080)
         |
         | Spring Data MongoDB
         |
MongoDB  (localhost:27017)
```

The application follows a strict layered architecture:

```
Controller -> Service -> ServiceImpl -> Repository -> MongoDB
```

## API Endpoints

### Authentication (Phase 2 - In Progress)

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | /api/auth/register | Register new user | No |
| POST | /api/auth/login | Login, returns JWT token | No |

More endpoints will be added as each phase is completed.

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
├── dto/
│   ├── request/
│   └── response/
├── entity/
├── repository/
├── service/
├── serviceImpl/
├── config/
├── security/
└── ExamcoreApplication.java
```

## Author

Shubhangam - [GitHub](https://github.com/shubhangamK)
