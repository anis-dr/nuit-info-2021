# NuitInfo-2021

This is an application build with microservices architecture using Docker compose It consists of 3 microservices -
nuit-info-api is a Spring Boot app - nuit-info-ui is a NextJS application - nuit-info-postgres is the database for the
app

## You can see the class diagram in ```nuit-info-2021.drawio.png```
## You can find a postman collection for testing in ```./Nuit Info 2021.postman_collection.json```

## How to build

- Clone the repository
- cd into the ```nuit-info-api``` directory
- run ```mvn install``` (```Maven install lifecycle```) with the following environment variables (it's preferable to use
  Intellij Idea)
    - POSTGRES_DB=nuit-info
    - POSTGRES_USER=nuit-info
    - POSTGRES_PASSWORD=nuit-info
    - DB_SERVER=localhost:5432

## How to run the whole project

    docker-compose -f docker-compose.yml up -d

## How to run the UI project

- cd into the ```nuit-info-ui``` directory
- run ```yarn run start```

## How to run the API project

- cd into the ```nuit-info-api``` directory
- spin-up ```nuit-info-postgres``` (see like this)
```
docker-compose -f docker-compose.yml restart nuit-info-postgres
```
- run ```mvn spring-boot:run``` (Run spring boot)

