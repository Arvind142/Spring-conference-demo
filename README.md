# Conference-app
![Website Status](https://img.shields.io/website?url=https%3A%2F%2Fconference-app-spring-rest-api.herokuapp.com%2F)

#### It's about what?
Rest endpoints to perform CURD operation in postgres database. I've used Spring framework to create this app.

Live app url : [conference-app](https://conference-app-spring-rest-api.herokuapp.com/) 

#### Details
- Endpoints Details
  - home
    - URI         : /
    - description : you get app version details and endpoints details
  - sessions
    - URI         : /api/v1/session 
    - description : users can perform CURD & list operation on above endpoint
  - speakers
    - URI           : /api/v1/speaker
    - description : users can perform CURD & list operation on above endpoint


---
### How to set it up in your local?

#### Prerequisite
1. Java 11
2. Maven
3. Docker installed(docker-compose installed).

#### Database Setup
1. navigate to Database folder
2. execute `start.sh` (linux users) or `start.bat` (windows user)

**Note**: Sometimes postgres db setup may take longer time to set up, suggest you to increase `timeout` or `sleep` from 20 to 30

#### Code execution
1. open src/main/resources/application.yml and change `spring.profiles.active` to `local`.
2. Execute `ConferenceDemoApplication.java` from src/main/java/com.personal.conferencedemo package

#### check
open postman/browser then navigate to `http://localhost:5000` to view app version and endpoint details.