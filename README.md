## 🧩 Commons Library

The Commons repository is a shared library designed to centralize reusable components, configurations, and utilities used across all microservices in the banking account onboarding system. Its primary goal is to eliminate code duplication, enforce architectural consistency, and simplify maintenance across the distributed system.

This library is consumed by all domain microservices (Account, Customer, Intervention, Relation, and Document services) and provides common functionality related to persistence, messaging, security, and web-layer abstractions.

## 🔍 Key Features

- Shared Kafka producer and event serialization utilities
- Common security and authentication components (JWT handling)
- Reusable persistence models and repository helpers
- Standardized DTOs and validation logic
- Centralized configuration and bootstrapping support

## 👨‍💻 Technologies

<div style="display: inline_block"><br>
<img align="center" alt="Java" height="40" width="40" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg">
<img align="center" alt="Spring" height="40" width="40" src="https://github.com/devicons/devicon/blob/master/icons/spring/spring-original.svg">
<img align="center" alt="Docker" height="40" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/docker/docker-original.svg" />
<img align="center" alt="PostgreSQL" height="40" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postgresql/postgresql-original.svg" />
</div>

## 📂 Repository Structure

The repository is organized as follows:

- `persistence/src/main/java/com/bank/onboarding/commonslib/persistence/constants`: Shared persistence-related constant values.
- `persistence/src/main/java/com/bank/onboarding/commonslib/persistence/enums`: Common enums used for domain and database validation.
- `persistence/src/main/java/com/bank/onboarding/commonslib/persistence/exceptions`: Custom exceptions for persistence-layer error handling.
- `persistence/src/main/java/com/bank/onboarding/commonslib/persistence/models`: Reusable MongoDB domain models.
- `persistence/src/main/java/com/bank/onboarding/commonslib/persistence/repositories`: Base MongoDB repository interfaces.
- `persistence/src/main/java/com/bank/onboarding/commonslib/persistence/services`: Shared persistence service abstractions over repositories.
- `utils/src/main/java/com/bank/onboarding/commonslib/utils`: General-purpose helper and utility classes.
- `utils/src/main/java/com/bank/onboarding/commonslib/utils/mappers`: Object mappers for converting between models, DTOs, and events.
- `utils/src/main/java/com/bank/onboarding/commonslib/utils/kafka`: Shared Kafka producers and event serialization utilities.
- `web/src/main/java/com/bank/onboarding/commonslib/web`: Common web-layer and security-related components.
- `web/src/main/java/com/bank/onboarding/commonslib/web/dtos`: Shared Data Transfer Objects for API and inter-service communication.

## 📋 Prerequisites

- Java 17+
- Maven
- Docker
- PostgreSQL database instance (local or containerized)

## 🌟 Additional Resources

- [Master's dissertation](http://hdl.handle.net/10400.22/26586)
