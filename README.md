# StudentsService
Students Service is a Spring Boot application for managing student data. The application allows you to add students, delete students by their unique ID, and view a list of all students.

## Table of Contents
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)

## Installation

### Prerequisites
- Java 11 or higher
- PostgreSQL
- Maven

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/students-service.git
   cd students-service
   ```
2. Build the project using Maven:
   ```bash
   mvn clean install
   ```
## Usage
### Running the Application
To run the application, use the following command:
```bash
   mvn spring-boot:run
  ```
## Accessing the Application
Open your browser and navigate to http://localhost:8080 to access the application.

# API Endpoints
## Add Student
* URL: /students
* Method: POST
* Request Body:
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "middleName": "A",
  "dateOfBirth": "2000-01-01",
  "group": "CS101"
}
```
* Response: 200 OK

## Delete Student
* URL: /students/{id}
* Method: DELETE
* Response: 200 OK

## Get All Students
* URL: /students
* Method: GET
* Response:
```json
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "middleName": "A",
    "dateOfBirth": "2000-01-01",
    "group": "CS101"
  }
]
```

