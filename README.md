# 🩺 PCOSBuddy Backend

PCOSBuddy is a health and wellness tracking platform designed to support individuals managing Polycystic Ovary Syndrome (PCOS). This backend service is built using Spring Boot and offers secure RESTful APIs to track symptoms, manage profiles, and promote holistic health practices.

---

## 🚀 Tech Stack

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Spring Security (API Key Auth)**
- **PostgreSQL**
- **Lombok**
- **Validation (JSR 380)**

---

## 🔐 Authentication with API Key

All API requests (except registration/login) require an API key sent via header:


Each user has a unique key stored in the database. The API key is validated using a custom Spring Security filter that loads the user and sets an authenticated context.

---

## 🧠 Core Features

- ✅ User registration, profile update
- ✅ API key-based authentication
- ✅ Symptom tracking (acne, fatigue, cramps, mood, notes)
- ✅ Wellness log (coming soon: sleep, food, water, exercise)
- ✅ Role-based access (planned)
- ✅ DTO-driven request/response flow

---

## 📦 API Endpoints

### 🧑 User

| Method | Endpoint      | Description                  |
|--------|---------------|------------------------------|
| `GET`  | `/users/{id}` | Get current user profile     |
| `PUT`  | `/users/{id}` | Update profile info          |

### 💊 Symptom

| Method | Endpoint     | Description                     |
|--------|--------------|---------------------------------|
| `POST` | `/symptoms`  | Add new symptom entry           |
| `GET`  | `/symptoms`  | Get all symptoms for user       |
| `DELETE`| `/symptoms/{id}`| Delete a symptom entry          |

---

## 🛠️ Environment Setup

### Prerequisites

- Java 17
- Maven
- PostgreSQL

### ⚙️ `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/pcosbuddy
spring.datasource.username=your_user
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

