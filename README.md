# Clustered Data Warehouse

A data warehouse for Bloomberg to analyze FX deals. This project is part of a scrum team effort to develop a data warehouse that accepts and persists deal details into a database.

## Features

- Accepts deal details including:
  - Deal Unique ID
  - From Currency ISO Code (Ordering Currency)
  - To Currency ISO Code
  - Deal Timestamp
  - Deal Amount in Ordering Currency
- Validates the structure of each deal (ex : missing fields, type format, etc.)
- Prevents the import of duplicate deals
- Ensures all valid deals are saved in the database (no rollback)

## Technology Stack

- Java 17
- Spring Boot 3.3.1
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- Maven

## Setup and Installation

## Prerequisites

- Java 17
- Docker and Docker Compose
- PostgreSQL

