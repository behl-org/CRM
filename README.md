# CRM

    - Application will run on port 8080

# Database Setup

    - Postgres Database download via installer on the official website
    - Create a db named as crm_rm for the data
    - Database Port is 5432
    - In properties file change the username(spring.datasource.username) and password(spring.datasource.password) as per the database created
    - In properties file spring.datasource.url=jdbc:postgresql://localhost:5432/{{YOUR DATABASE NAME}}
    - Table creation and Entries will be taken up by JPA
