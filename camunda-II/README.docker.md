# Camunda 8 Docker Run

## Requirements

- [ElasticSearch](https://www.elastic.co/guide/en/elasticsearch/reference/current/run-elasticsearch-locally.html#local-dev-run-es)

## Operate

- [Configuration](https://docs.camunda.io/docs/self-managed/operate-deployment/operate-configuration)

```shell
docker run --name operate -p 8080-8080:8082-8082 camunda/operate:latest
```

## Identity

- [Configuration Variables](https://docs.camunda.io/docs/self-managed/identity/deployment/configuration-variables)

```shell
docker run --name identity -p 8080-8080:8080-8080 camunda/identity:latest
```

## TaskList

- [Configuration](https://docs.camunda.io/docs/self-managed/tasklist-deployment/tasklist-configuration)

```shell
docker run --name tasklist -p 8080-8080:8081-8081 camunda/tasklist:latest
```

## Zeebe

-[Environment Variables](https://docs.camunda.io/docs/self-managed/zeebe-deployment/configuration/environment-variables/)

```shell
docker run --name zeebe -p 26500-26502:26500-26502 camunda/zeebe:latest
```

## Optimize

-[Environment Variables](https://docs.camunda.io/optimize/self-managed/optimize-deployment/install-and-start/#available-environment-variables)

```shell
docker run --name optimize -p 8080-8080:8083-8083 camunda/optimize:latest
```

## Documentation

### [images](https://docs.camunda.io/docs/self-managed/setup/deploy/other/docker/)

### [compose](https://github.com/camunda/camunda-platform#using-docker-compose)