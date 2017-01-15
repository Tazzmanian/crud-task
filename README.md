## Simple CRUD
Used tutorial `https://www.youtube.com/watch?v=Vvnliarkw48`

This is maven project.
Using tomcat, javac 1.6 and jdbc setted by maven. And MySql DB.
To run use Run configuration... -> Goal as `tomcat7:run`.

## Condition
Create a simple CRUD (Create Read Update Delete) User Management 
Web Application using JSP, Servlet and MySQL/PostgreSQL that 
runs on a Tomcat server.
The fields that have to be filled are:
* First Name
* Last Name
* Date of Birth
* Phone Number
* E-mail Address

The user should be able to search within the
 results and also to be able to sort them by Last Name and Date of Birth. 


## Changes
Use following technologies:
* Spring Boot
* Spring Data JPA
with one of the following databases:
* H2
* HsQLDB

After the changes the server is started with `spring-boot:run` or Run the application.
To see installed dependencies run `dependency:tree`.
