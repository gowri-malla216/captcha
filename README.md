# Mock Captcha Web Application
A secure web application featuring custom captcha implementation for user authentication and registration.
Features

- Custom Captcha Generation and Validation
- User Registration System
- Secure Login System
- JSP-based Web Interface
- Maven Build Support

## Prerequisites

- Java JDK 11 or higher
- Apache Maven 3.6+
- Your favorite IDE (VSCode, Eclipse, IntelliJ)
- Docker (for containerization)

## Installation

Clone the repository:
```
git clone https://github.com/gowri-malla216/mock-captcha.git
```

Build the project:
```
mvn clean install
```

Run locally:
```
mvn tomcat7:run
```

Access the application:
```
http://localhost:8080/web
```

##Docker Deployment

Build the Docker image:
```
docker build -t captcha-web-app .
```

Run the container:
```
docker run -p 8080:8080 captcha-web-app
```

## Configuration

- Update src/main/webapp/WEB-INF/web.xml for servlet mappings
- Configure database connections in servlet files

## Usage

- Access the application through the browser
- Register a new account with captcha verification
- Login using registered credentials
- Navigate through the secure pages
- maintain sessions

## Development

- Fork the repository
- Create your feature branch (git checkout -b feature/AmazingFeature)
- Commit your changes (git commit -m 'Add some AmazingFeature')
- Push to the branch (git push origin feature/AmazingFeature)
- Open a Pull Request

## Tech Stack

- Java Servlets
- JSP (JavaServer Pages)
- JavaScript
- jQuery
- HTML/CSS
- Maven
- Docker

## Contributing
Contributions are welcome! Please feel free to submit a Pull Request.
