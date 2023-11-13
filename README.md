# Back-end Course
-------
### [Link to hosted web-server](https://back-end-course-spring-3a0c4dce4f54.herokuapp.com/api/healthcheck) 
-------

## How to Run the Server localy:

### Using IntelliJ IDEA or Another IDE with Gradle and Kotlin Support:

1. Clone the project.
2. Open the project in your IDE.
3. Build the project using the following command in the terminal:
    ```bash
    gradle build
    ```
4. Run the project with the following command:
    ```bash
    gradle run
    ```
5. The server is now running at [https://localhost:8080/](https://localhost:8080/).

### Using Other IDEs with Docker:

1. Clone the project ```git clone https://github.com/michigang1/back-end-course.git```
2. Install the [Docker CLI](https://docs.docker.com/engine/install/) and [Docker Compose CLI](https://docs.docker.com/compose/install/) from the official site.

3. Open a terminal and navigate to the project directory.

4. Build the Docker image:
    ```bash
    docker build -t your-image-name .
    ```
    **OR**
   ```bash
   docker-compose build
   ```

6. Run the Docker container:
    ```bash
    docker run -p 8080:8080 your-image-name
    ```
    **OR**
   ```bash
   docker-compose up
   ```

8. The server is now running at [https://localhost:8080/](https://localhost:8080/).
