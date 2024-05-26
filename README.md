# CRM

    - Application will run on port 8080

# Order

    Model: The data structure is the foundation of your application.
    Repository: Ensures data access methods are ready before implementing business logic.
    Service: Handles business logic, which relies on the repository.
    Properties: Configure the application environment and database.
    Controller: Finally, expose your functionality through the API endpoints.

# Database Setup

    - Postgres Database download via installer on the official website
    - Create a db named as crm_rm for the data
    - Database Port is 5432
    - In properties file change the username(spring.datasource.username) and password(spring.datasource.password) as per the database created
    - In properties file spring.datasource.url=jdbc:postgresql://localhost:5432/{{YOUR DATABASE NAME}}
    - Table creation and Entries will be taken up by JPA

    -For Data API's
        Create a db named as crm_data for the data and update the application.properties

# API's

    -GET http://localhost:8080/api/resources
    -POST http://localhost:8080/api/resources/add (Create RM)
    Format:
        {
        "name": "ghgz",
        "email": "abc@gmail.com",
        "password": "yolo"
        }
    -DELETE http://localhost:8080/api/resources/delete/id (Delete RM)
    -PUT http://localhost:8080/api/resources/update/id?password=newPassword (Update RM password)
