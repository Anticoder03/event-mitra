# Event Ticket Booking Platform

Spring Boot REST API for managing users, events, tickets, bookings, and employees. The application uses Spring Data JPA with MySQL for persistence and runs on port `8090` by default.

## Tech Stack

- Java 17
- Spring Boot 4.0.7
- Spring Web
- Spring Data JPA
- Thymeleaf
- MySQL Connector/J
- Lombok

## Features

- Create, read, update, and delete users
- Create, read, update, and delete events
- Create and view tickets
- Create, view, and delete bookings
- Manage employees with basic CRUD endpoints
- Filter events by location, type, price, and date

## Project Structure

- `src/main/java/com/excelr/project/controller` - REST controllers
- `src/main/java/com/excelr/project/entity` - JPA entities
- `src/main/java/com/excelr/project/repository` - Spring Data repositories
- `src/main/java/com/excelr/project/service` - Business logic
- `src/main/java/com/excelr/project/exception` - Custom exception handling
- `src/main/resources/application.properties` - Application configuration

## Configuration

The default configuration is defined in `src/main/resources/application.properties`:

- Server port: `8090`
- Database: `jdbc:mysql://localhost:3306/excelr-project`
- Username: `root`
- Password: empty by default
- Hibernate DDL mode: `update`

Update these settings before running the app if your local MySQL setup is different.

## Running the Application

### Using Maven Wrapper

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
mvnw.cmd spring-boot:run
```

### Build the Project

```bash
./mvnw clean package
```

On Windows:

```powershell
mvnw.cmd clean package
```

## API Overview

### User API

Base path: `/user`

| Method | Endpoint | Description |
| --- | --- | --- |
| POST | `/user` | Create user |
| GET | `/user` | Get all users |
| GET | `/user/{id}` | Get user by ID |
| GET | `/user/email/{email}` | Get user by email |
| PUT | `/user/{id}` | Update user |
| DELETE | `/user/{id}` | Delete user |

### Event API

Base path: `/event`

| Method | Endpoint | Description |
| --- | --- | --- |
| POST | `/event` | Create event |
| GET | `/event` | Get all events |
| GET | `/event/{id}` | Get event by ID |
| GET | `/event/location/{location}` | Filter by location |
| GET | `/event/type/{type}` | Filter by type |
| GET | `/event/price/lessthan/{price}` | Events below a price |
| GET | `/event/price/greaterthan/{price}` | Events above a price |
| GET | `/event/after/{date}` | Events after a date |
| GET | `/event/before/{date}` | Events before a date |
| PUT | `/event/{id}` | Update event |
| DELETE | `/event/{id}` | Delete event |

Date format: `yyyy-MM-dd`

Example: `/event/after/2026-08-01`

### Ticket API

Base path: `/ticket`

| Method | Endpoint | Description |
| --- | --- | --- |
| POST | `/ticket` | Create ticket |
| GET | `/ticket` | Get all tickets |
| GET | `/ticket/{id}` | Get ticket by ID |

### Booking API

Base path: `/booking`

| Method | Endpoint | Description |
| --- | --- | --- |
| POST | `/booking` | Create booking |
| GET | `/booking` | Get all bookings |
| GET | `/booking/{id}` | Get booking by ID |
| DELETE | `/booking/{id}` | Delete booking |

### Employee API

Base path: `/employees`

| Method | Endpoint | Description |
| --- | --- | --- |
| POST | `/employees` | Create employee |
| GET | `/employees` | Get all employees |
| GET | `/employees/{id}` | Get employee by ID |
| PUT | `/employees/{id}` | Update employee |
| DELETE | `/employees/{id}` | Delete employee |

## Domain Model

- `User` - user profile with email, password, gender, age, and role
- `Event` - event details such as name, type, location, capacity, price, and date
- `Ticket` - links a user to an event and stores ticket quantity
- `Booking` - links a ticket, user, and event with total price
- `Employee` - simple employee record with name, department, and salary

## Notes

- The application starts from `com.excelr.project.ProjectApplication`.
- `User` email is unique.
- `role` defaults to `USER` when not provided.
- Error handling is done with `ResourceNotFoundException` in several controllers.

## License

No license has been defined for this project.