
## Project Summary: Product Management System with Spring Boot

This project is a Spring Boot application designed for product management, providing a RESTful API for basic CRUD operations (Create, Read, Update, Delete).

Key Components:

ProductModel: A class representing the product entity, storing information such as ID, name, and value. Utilizes JPA for database persistence.

ProductController: Controller responsible for handling HTTP requests related to products. Provides endpoints for creating, listing, updating, and deleting products.

Main Endpoints:

POST /products: Creates a new product based on the provided data in the request body.
GET /products: Retrieves the list of all registered products.
GET /products/{id}: Retrieves a specific product based on the provided ID.
PUT /products/{id}: Updates the information of an existing product based on the provided ID.
DELETE /products/{id}: Deletes a product based on the provided ID.
DTO (ProductRecordDto): Used for transferring data between the application and the client, separating the external representation of data from the internal representation.

ProductRepository: Interface extending JpaRepository for handling database operations related to products.

Usage Instructions:

Clone the repository.
Run the Spring Boot application.
Access the API through the mentioned endpoints to interact with the products.
