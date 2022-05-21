# 🐋 Camunda using Docker

## Docker  run postgres using image at docker hub
```shell
docker run -d \
  --name postgres \
  -p 5432:5432 \
  -e POSTGRES_PASSWORD=postgres-password \
  postgres
```

## Docker run camunda latest engine at docker hub
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
## OR
```shell
docker-compose up -d
```

## Credentials
- Login: demo
- User: demo