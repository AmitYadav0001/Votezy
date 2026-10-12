# 🗳️ Votezy — Voting Management System

### A RESTful backend application built with Java, Spring Boot & MySQL

Votezy is a backend development project designed to manage voters, candidates, voting operations, and election results through REST APIs. It focuses on clean architecture, database relationships, validation, and reliable exception handling.

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?logo=openjdk" alt="Java 21" />
  <img src="https://img.shields.io/badge/Spring%20Boot-4.1.1-6DB33F?logo=springboot&logoColor=white" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/MySQL-Database-4479A1?logo=mysql&logoColor=white" alt="MySQL" />
  <img src="https://img.shields.io/badge/Maven-Build%20Tool-C71A36?logo=apachemaven&logoColor=white" alt="Maven" />
  <img src="https://img.shields.io/badge/Status-In%20Development-yellow" alt="In Development" />
</p>

---

## ✨ Features

- 👥 **Voter Management** — Manage voter records with CRUD operations.
- 🧑‍💼 **Candidate Management** — Create, retrieve, update, and delete candidate records.
- 🗳️ **Voting Operations** — Handle vote-casting functionality.
- 🛡️ **Vote Restrictions** — Implement rules to prevent duplicate or unauthorized voting as defined by the business logic.
- 📊 **Election Results** — Manage and retrieve election result records.
- ⚠️ **Global Exception Handling** — Handle missing resources, duplicate resources, and voting-related errors.
- ✅ **Input Validation** — Validate incoming API request data.
- 🧱 **Layered Architecture** — Keep controllers, services, repositories, entities, and DTOs separated for maintainability.

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| ☕ Java 21 | Programming language |
| 🌱 Spring Boot 4.1.1 | Backend framework |
| 🗄️ Spring Data JPA | Database access |
| 🔗 Hibernate | ORM and entity mapping |
| 🐬 MySQL | Relational database |
| 📦 Maven | Dependency and build management |
| ✅ Jakarta Bean Validation | Request validation |
| ♻️ Lombok | Reduce boilerplate code |
| 🔌 REST APIs | Client-server communication |

## 🏗️ Project Architecture

```text
Votezy/
├── src/main/java/in/amit/votezy/
│   ├── controller/     # REST API endpoints
│   ├── dto/            # Request and response objects
│   ├── entity/         # JPA entities
│   ├── exception/      # Custom exceptions and error handling
│   ├── repository/     # Database operations
│   ├── service/        # Business logic
│   └── VotezyApplication.java
├── src/main/resources/
│   └── application.properties
├── src/test/
├── pom.xml
├── mvnw
└── README.md
```

## 🚀 Getting Started

### Prerequisites

Make sure you have the following installed:

- Java JDK 21
- MySQL Server
- IntelliJ IDEA (recommended)
- Git

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/AmitYadav0001/Votezy.git
cd Votezy
```

### 2️⃣ Create the Database

Execute this SQL command in MySQL:

```sql
CREATE DATABASE votezy_db;
```

### 3️⃣ Configure Database Connection

Update `src/main/resources/application.properties` with your local MySQL configuration.

Keep credentials outside version control. If you use environment variables, configure `DB_USERNAME` and `DB_PASSWORD` before starting the application.

### 4️⃣ Run the Application

Open the project in IntelliJ IDEA and run `VotezyApplication.java`.

Alternatively, run:

```bash
mvn spring-boot:run
```

The default application port is `8080`, unless configured differently.

## 🔐 Security Status

🚧 **In Progress**

Spring Security and authentication/authorization are planned for a future update. The current version focuses on voting functionality, business logic, database relationships, validation, and exception handling.

> Note: This project is under development and is not intended for production use in its current state.

## 🧠 Key Learnings

Through Votezy, I am strengthening my understanding of:

- Designing RESTful APIs using Spring Boot.
- Implementing CRUD operations using Spring Data JPA.
- Mapping relationships between entities.
- Applying controller-service-repository architecture.
- Handling exceptions globally using `@ControllerAdvice`.
- Validating request data.
- Integrating MySQL with a Spring Boot application.
- Organizing backend code for maintainability.

## 🔮 Future Enhancements

- 🔐 Spring Security integration.
- 👤 User authentication and role-based authorization.
- 🔒 Secure voting and administrative endpoints.
- 🧪 Expanded unit and integration testing.
- 📘 API documentation and testing improvements.

## 👨‍💻 About Me

**Amit Yadav**  
*B.Tech Graduate | Aspiring Java Backend Developer*

I'm building backend projects to strengthen my skills in Java, Spring Boot, REST APIs, and database management.

- 💻 **GitHub:** [AmitYadav0001](https://github.com/AmitYadav0001)
- 🤝 **LinkedIn:** [Amit Yadav](https://www.linkedin.com/in/amityadav21/)

---

<p align="center">
  ⭐ If you find this project interesting, feel free to explore the repository!
</p>

<p align="center">
  <i>Built with Java, Spring Boot, and a continuous learning mindset.</i>
</p>
