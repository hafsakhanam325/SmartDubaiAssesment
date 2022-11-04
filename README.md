# SmartDubaiAssesment

Docker image URL: docker pull hafsakhanam325/bookstore:latest
Docker command to run : docker run -p 8080:8080 bookstore
Swagger URL: http://localhost:8080/api/swagger-ui/

Assumptions and understandings made while developing API's:

-Assuming that discount through promotion code is applicable on the total price value rather than a specific book type.

Design developed as follows :

Using H2 in memory database to store the data of books
Using java 8 Streams API to filter and collect the data
Using Swagger configurations for API documentation and test purpose



Deliverables achieved are as follows :

    1) Unit tests for all operations : Achieved Successfully

          - All the unit test cases have been written as expected with code covergae of 100%

    2) Ability to run the application locally :Achieved Successfully

          - Command to run locally java -jar "bookservice-0.0.1-SNAPSHOT.jar"

    3) Ability to run the application on a docker container : Achieved Successfully

         - The docker image namely "bookstore" created has been pushed to docker hub repository.
         - Command to download docker image is docker pull hafsakhanam325/bookstore:latest (hafsakhanam325 being the docker hub Id)
         - Command to run docker image is docker run -p 8080:8080 bookstore
         - Swagger configurations has been made as well for the ease of evaluator to understand the API's developed. 
             Swagger URL:http://localhost:8080/api/swagger-ui/

    4) All the CRUD API's have been developed.

    5) Checkout API has been developed which returns the total price to be payable.

         - Using bookId based on which the book objects are retrieved from the database.
