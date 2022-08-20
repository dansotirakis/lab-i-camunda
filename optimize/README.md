# Camunda Optimize
## [Optimize](http://localhost:8083/)
## Docker run Opensearch 2.2.0 at opensearchproject
```shell
  docker run -p 9200:9200 -p 9600:9600 -e "discovery.type=single-node" opensearchproject/opensearch:2.2.0
```
## Docker run Optimize 3.8.2 at camunda
```shell
  docker run -d \
   --name optimize \
   -p 8083:8090 \
   -e OPTIMIZE_ELASTICSEARCH_HOST=localhost \
   -e OPTIMIZE_ELASTICSEARCH_HTTP_PORT=9200 \
   -e OPTIMIZE_JAVA_OPTS=-Xmx1024m \
   -e ABSOLUTE_PATH_ON_HOST_TO_CONFIGURATION_FILE=optimize/config/optimize-config.yaml \
   camunda/optimize:3.8.2
```
## Login and Docker-Compose: Optimize Engine EE
```shell
docker login registry.camunda.cloud && docker-compose l --env-file env.optmize up -d --build
```
## Docker-Compose: Optimize HUB
```shell
docker-compose --env-file env.optmize up -d --build
```