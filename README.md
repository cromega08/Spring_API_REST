# Spring API REST

An API REST build using SpringBoot.

## Tech

- **Languages**: Java.

- **DataBase**: MySQL.

- **Framework**: SpringBoot.

- **Libraries**: SpringWeb, JPA, MySQL Driver, Lombok.

## Installation

1. Download this repo in your local machine.

2. Create a _MySQL Database_ with the following command:

    ```sql
    CREATE DATABASE your_db_name;
    ```

3. Move inside this dir:

    ```shell
    cd /path_to_this_repo/src/main/resources
    ```

4. Change this configuration and paste it inside _application.properties_:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost/your_db_name?useSSL=false&serveTimeZone=UTC
    spring.datasource.username=your_user_name
    spring.datasource.password=your_user_password
    spring.datasource.driver-class=com.mysql.cj.jdbc.Driver
    spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
    spring.jpa.hibernate.ddl-auto=update
    logging.level.org.hibernate.SQL=debug
    ```

## Usage

1. Move inside the root folder of this repo.

2. Execute the follow command:

    - MacOS/Linux:

    ```shell
    ./mvnw spring-boot:run
    ```

    - Windows:
    ```shell
   mvnw spring-boot:run
    ```

3. Use any of the follow _CRUD_ methods with the follow structure in your api tester or code:

    1. GET:

        - To get all from the DB: _http://localhost:8080/api/user_.
        - To get a specific user from the DB: _http://localhost:8080/api/user/{id_of_requested_user}_.

    2. POST:

        ```json
        {
          "firstName": "first_name_as_string",
          "lastName": "last_name_as_string"
        }
        ```

        - To create a new user in the DB, send the JSON above to this address: _http://localhos:8080/user_.

    3. UPDATE:

        ```json
        {
          "firstName": "new_first_name_as_string",
          "lastName": "new_last_name_as_string"
        }
        ```

        - To update a user data, send the JSON above to this address: _http://localhos:8080/user/{id_of_requested_user}_.

    4. DELETE:

        - To delete a specific user from de DB, send the follow request: _http://localhost:8080/user/{id_of_requested_user}_.

## Author

- [@Cromega08](https://github.com/cromega08)

## License

- [GNU AGPL v3.0](https://choosealicense.com/licenses/agpl-3.0/)