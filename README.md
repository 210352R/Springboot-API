# Spring Boot REST API with MySQL Database

This repository contains a Spring Boot application that serves as a REST API with data persistence in a MySQL database.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Configuration](#configuration)
  - [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before you begin, ensure you have the following installed:

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) (version X or newer)
- [MySQL](https://www.mysql.com/downloads/) (version X or newer)
- [Maven](https://maven.apache.org/download.cgi) (for building the project)

## Getting Started

### Configuration

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/spring-boot-mysql-api.git
Navigate to the project directory:

bash
Copy code
cd spring-boot-mysql-api
Open src/main/resources/application.properties and configure the MySQL database connection properties:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
Running the Application
Run the following command to build and start the Spring Boot application:

mvn spring-boot:run
The application will be accessible at http://localhost:8080.

API Endpoints
Endpoint	Method	Description
/api/users	GET	Retrieve all users
/api/users/{id}	GET	Retrieve a user by ID
/api/users	POST	Create a new user
/api/users/{id}	PUT	Update an existing user by ID
/api/users/{id}	DELETE	Delete a user by ID
Detailed API documentation can be found here.

Testing
To run the tests, execute the following command:


mvn test
Contributing
Feel free to contribute by opening issues or submitting pull requests. Please follow our contribution guidelines.

License
This project is licensed under the MIT License.


Replace placeholders such as `your-username`, `your_database`, `your_use
