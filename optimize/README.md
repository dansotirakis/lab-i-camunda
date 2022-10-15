# Camunda Optimize
## Docker run Optimize 3.8.2 at camunda
```shell
  docker run -d \
   --name optimize \
   -p 8083:8090 \
   -e OPTIMIZE_ELASTICSEARCH_HOST=172.17.0.1 \
   -e OPTIMIZE_ELASTICSEARCH_HTTP_PORT=4566 \
   -e OPTIMIZE_JAVA_OPTS=-Xmx1024m \
   -e ABSOLUTE_PATH_ON_HOST_TO_CONFIGURATION_FILE=optimize/config/optimize-config.yaml \
   camunda/optimize:3.8.2
```
## Docker compose 
```shell
docker-compose --env-file optimize.env up -d --build
```
---
- [Optimize](http://localhost:8083/)