
---

## Docker run ElasticSearch 7.17.0 at elastic
```shell
  docker run -d \
   --name elasticsearch \
   -p 9200:9200 \
   -p 9300:9300 \
   -e cluster.routing.allocation.disk.threshold_enabled=true \
   -e cluster.routing.allocation.disk.watermark.low=1024mb \
   -e cluster.routing.allocation.disk.watermark.high=512mb \
   -e cluster.routing.allocation.disk.watermark.flood_stage=256mb \
   -e cluster.name=elasticsearch \
   -e bootstrap.memory_lock=true \
   -e discovery.type=single-node \
   -e action.auto_create_index=false \
   -e transport.host=0.0.0.0 \
   -e http.host=0.0.0.0 \
   -e ES_JAVA_OPTS=-Xms512m -Xmx512m \
   -e client.transport.sniff=false \
   -v elasticsearch:/usr/share/elasticsearch/data
   docker.elastic.co/elasticsearch/elasticsearch:7.17.0
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
## Login and Docker-Compose: Optimize Docker HUB
```shell
docker-compose --env-file env.optmize up -d --build
```
---
- [Optimize](http://localhost:8083/)