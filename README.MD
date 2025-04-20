# Real Estate Project

This is a Spring Boot-based real estate management system built with modern Java technologies and best practices.

## Technology Stack

- **Java Version**: 1.8
- **Framework**: Spring Boot 2.0.9.RELEASE
- **Build Tool**: Maven
- **Database**: MySQL 8.0.13
- **Template Engine**: JSP with Sitemesh 2.4.2
- **Security**: Spring Security
- **ORM**: Spring Data JPA
- **Other Libraries**:
  - ModelMapper 0.7.4
  - Lombok
  - DisplayTag 1.2
  - Commons Lang 2.6
  - Log4j 1.2.17

## Prerequisites

Before you begin, ensure you have the following installed:
- JDK 1.8
- Maven
- MySQL 8.0.13
- Your preferred IDE (IntelliJ IDEA, Eclipse, etc.)

## Getting Started

1. Clone the repository
```bash
git clone [repository-url]
```

2. Configure MySQL database
- Create a new MySQL database
- Update the database configuration in `src/main/resources/application.properties`

3. Build the project
```bash
mvn clean install
```

4. Run the application
```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`

## Project Structure

The project follows a standard Spring Boot application structure:
- `src/main/java` - Java source files
- `src/main/resources` - Configuration files and static resources
- `src/main/webapp` - JSP views and web resources

## Features

- Spring Security integration for authentication and authorization
- JPA-based database operations
- MVC architecture
- Sitemesh decorators for consistent layout
- Form validation
- Responsive web interface

## Building for Production

To build the project for production:
```bash
mvn clean package
```
This will generate a WAR file in the `target` directory.

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details. 