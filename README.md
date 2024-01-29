# User Client Application

## Description
This Java application is a client for the REST endpoint provided by https://reqres.in. It queries the first page of the user data from the endpoint and prints the first and last names of the users to the console.

## Requirements
- Java 21
- Maven

## How to Compile and Run
1. Ensure Java 21 and Maven are installed on your system.
2. Navigate to the root directory of the project where the `pom.xml` file is located.
3. Run `mvn clean install` to compile the project and download the dependencies.
4. To run the application, execute `java -cp target/your-jar-name.jar userclientapp.UserClient` in the command line, replacing `your-jar-name.jar` with the actual name of the generated JAR file.

## Structure
- `src/main/java/userclientapp/UserDTO.java`: Defines the UserDTO class with properties id, email, firstName, and lastName.
- `src/main/java/userclientapp/UserClient.java`: Contains the main method and a method to query the REST endpoint.

## Author
Zishan Ali Khan

## Notes
- The application currently fetches data from the first page of users only but it is parameterized on the get call, can be exposed to accept page # as a param if needed.
- Additional features or enhancements can be added as per future requirements.
