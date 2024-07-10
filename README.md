# Clustered Data Warehouse

## Project Description
This project is part of a scrum team developing a data warehouse for Bloomberg to analyze FX deals. The system accepts deal details and persists them into a PostgreSQL database.

## Features
- Accepts FX deal details and persists them into the database.
- Validates the structure of the deal details (e.g., missing fields, type format).
- Prevents importing the same request twice.
- Ensures no rollback is allowed; all rows imported are saved in the database.
- Proper error/exception handling.
- Logging of various actions and events.
- Unit tests with proper coverage.

## Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- Maven

## Setup and Installation

### Prerequisites
- Docker
- Docker Compose
- Java 17
- Maven

### Running the Application

1. Clone the repository:
    ```bash
    git clone https://github.com/YousefMahfouzz/clustered_data_warehouse.git
    cd clustered_data_warehouse
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

3. Run the application using Docker Compose:
    ```bash
    docker-compose up
    ```

### Running Unit Tests
To run the unit tests, use the following command:
```bash
mvn test
