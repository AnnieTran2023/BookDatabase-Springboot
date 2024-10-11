# Book Database 📚

This project is a **Spring Boot** application designed to manage a book database. It provides users with a web interface to perform **CRUD** (Create, Read, Update, Delete) operations on books in the database. The application leverages **Spring Security** to restrict certain operations (such as editing and deleting books) to users with **ADMIN** authority.

Additionally, the API has been thoroughly tested using **Postman** to ensure that all endpoints work as expected.

## Features ✨

- **View Books (Read)**: Users can view a list of all books in the database.
- **Add Books (Create)**: Users can add new books to the database.
- **Edit Books (Update)**: Admin users can edit existing book details.
- **Delete Books (Delete)**: Admin users can delete books from the database.
- **Search Books**: Users can search for books by title.

## Endpoints 🔗

- `/booklist`: Displays a list of all books.
- `/save`: Saves a new book to the database (`POST` request).
- `/delete/{id}`: Deletes a book by its ID (`GET` request, Admin only).
- `/edit/{id}`: Edits a book by its ID (`GET` request, Admin only).

## CRUD Operations ⚙️

This project follows the **CRUD** (Create, Read, Update, Delete) pattern:
- **Create**: Users can add new books via the `/save` endpoint.
- **Read**: Users can view all books by accessing the `/booklist` endpoint.
- **Update**: Admin users can update book details by accessing the `/edit/{id}` endpoint.
- **Delete**: Admin users can delete books by accessing the `/delete/{id}` endpoint.

## API Testing with Postman 🧪

The API has been tested using **Postman**, a popular tool for testing RESTful APIs. All CRUD endpoints were verified to ensure:
- **Correct behavior** for adding, updating, and deleting books.
- **Proper authentication and authorization** for endpoints that require `ADMIN` access.
- **Validation** of data such as correct handling of invalid inputs, missing fields, etc.

Feel free to import the **Postman** collection to test the API on your local environment after setting up the application.

## Security 🔒

- **Admin Authority**: Editing and deleting books are restricted to users with `ADMIN` authority.
- **Spring Security**: Manages authentication and authorization.

## Technologies Used 🛠

- **Spring Boot**: For building the web application.
- **Spring Data JPA**: For CRUD operations on the database.
- **Spring Security**: To secure the application.
- **Thymeleaf**: For rendering web pages.
- **MySQL**: For storing book data.
- **JUnit**: For unit testing.
- **Postman**: For API testing.
- **Maven**: For project management and build automation.

## Getting Started 🚀

### 1. Clone the repository:

git clone https://github.com/AnnieTran2023/BookDatabase-Springboot.git

cd BookDatabase-Springboot


### 2. Configure the database:

spring.datasource.url=jdbc:mysql://localhost:8080/bookdb

spring.datasource.username=your_username

spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

### 3. Run application:

mvn spring-boot:run


