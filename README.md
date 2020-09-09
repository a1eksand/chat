# Backend

## System requirement

- JDK 14
- Docker 19
- Docker Compose 1.25

## Available Scripts of .

#### `./mvnw clean package -DskipTests && docker build -f dev-chat-webapp.Dockerfile -t chat-webapp:SNAPSHOT . && ./mvnw clean`

Builds backend app image

#### `docker-compose -f docker-compose-dev-storage-mongodb.yml up`

Ups MongoDB

## Available Scripts of webapp

#### `./mvnw spring-boot:run`

Runs backend app in development mode

> Next - open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

# Frontend

## System requirement

- Node 12
- Yarn
- Docker 19
- Docker Compose 1.25

## Available Scripts of .

#### `yarn`

Installs required packages

#### `docker-compose -f docker-compose-dev-chat-webapp.yml up`

Ups MongoDB and backend app

## Available Scripts of packages/web/

#### `yarn start`

Runs frontend app in development mode

> Next - open [http://localhost:3000](http://localhost:3000)
