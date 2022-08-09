# 🐋 Camunda using Docker
## Docker run Postgres using image at docker hub
```shell
docker run -d \
  --name postgres \
  -p 5432:5432 \
  -e POSTGRES_PASSWORD=postgres-password \
  postgres
```
## Docker run Camunda latest engine at camunda
```shell
  docker run -d \
   --name camunda-engine \
   -p 8080:8080 \
   --link postgres:db \
   -e DB_DRIVER=org.postgresql.Driver \
   -e DB_URL=jdbc:postgresql://db:5432/camunda-engine-db \
   -e DB_USERNAME=postgres \
   -e DB_PASSWORD=postgres-password \
   -e WAIT_FOR=db:5432 \
   camunda/camunda-bpm-platform:latest
```
## Docker Compose Engine EE
```shell
docker login registry.camunda.cloud && docker-compose -f docker-compose.yaml --env-file env.enterprise up -d --build
```
## Credentials Cockpit
- Login: demo
- User: demo
## Resources
- [Cockpit](http://localhost:8080/camunda/)