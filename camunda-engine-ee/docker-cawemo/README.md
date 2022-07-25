# CAWEMO 1.5

## Docker compose
```shell
docker-compose --env-file env.cawemo up -d --build
```

### TOKEN
```shell
docker run --rm -t \
  registry.camunda.cloud/iam-ee/iam-utility:v1.0.2 \
  yarn run generate-jwk
```