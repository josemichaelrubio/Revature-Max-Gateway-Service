# Revature Max: Gateway Service

## Project Description

A gateway service for the Microservice implementation of the Revature Max Application. This serves as the single point of access to the application and provides a full Spring Security implementation to authorize access to application endpoints.

## Technologies Used

- Java 1.8
- Gradle
- Spring Framework
- Spring Boot
- Spring Data
- Spring Web MVC
- Spring Cloud
- Spring Security

## Features

**Implemented Features:**  
- Integrates with Discovery Service to access all registered microservices.
- Uses Ribbon built in load balancing to direct traffic if multiple services are found.
- Implements Spring Security Bcrypt to hash and authenticate passwords.
- Generates JWTs to track user session on user's device.

## Getting Started

To get started, you can close the service from GitLab using the following command.
> `git clone https://gitlab.com/210301-java-azure/project3/revature-max-gateway-service.git`

- All the `code` required to get started
- Images of what it should look like

## Usage

> Here, you instruct other people on how to use your project after they’ve installed it. This would also be a good place to include screenshots of your project in action.

## Contributors

- Sebastian Perez
- Steve Hedstrom
- Jude Nimesh
- Derek Martinez
- Karl Kanitsch


