# Backend

## System requirement

- JDK 14
- Docker 19
- Docker Compose 1.25

## Available Scripts

```
./mvnw clean package -DskipTests
docker build -f appjre.Dockerfile --build-arg JAR="webapp-mdb-s1/target/chat-webapp-mdb-s1-0.0.1-SNAPSHOT.jar" -t chat-webapp-mdb-s1:SNAPSHOT .
docker build -f appjre.Dockerfile --build-arg JAR="webapp-pdb-s1/target/chat-webapp-pdb-s1-0.0.1-SNAPSHOT.jar" -t chat-webapp-pdb-s1:SNAPSHOT .
```

Builds backend app images

```
docker-compose -f docker-compose-dev-storage-mongodb.yml up
docker-compose -f docker-compose-dev-storage-postgres.yml up
```

Ups storages

## Available Scripts of webapp

```
./mvnw spring-boot:run
```

Runs backend app

> Next - open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

# Frontend

## System requirement

- Node 12
- Yarn
- Docker 19
- Docker Compose 1.25

## Available Scripts

```
yarn
```

Installs required packages

```
docker-compose -f docker-compose-dev-chat-webapp-mdb-s1.yml up
docker-compose -f docker-compose-dev-chat-webapp-pdb-s1.yml up
```

Ups storages and backend apps

## Available Scripts of packages/web

```
yarn start
```

Runs frontend app

> Next - open [http://localhost:3000](http://localhost:3000)
