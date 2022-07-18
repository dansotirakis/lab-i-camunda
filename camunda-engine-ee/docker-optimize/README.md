# [📗](https://docs.camunda.org/optimize/3.1/) Optimize
## [🧾](https://docs.camunda.org/optimize/3.1/technical-guide/setup/installation/#getting-started-with-the-optimize-docker-image) Docker instruções
## [🧾](https://docs.camunda.org/optimize/3.1/technical-guide/setup/installation/#configuration-using-a-environment-config-yaml-file) Váriaveis de ambiente
## [🧾](https://docs.camunda.org/optimize/3.1/technical-guide/optimize-explained/import/import-overview/) Importação de dados da engine
## [🧾](https://docs.camunda.org/optimize/3.1/technical-guide/setup/multiple-engines/) Vários mecanismos de processo
### [🔖](https://docs.camunda.org/optimize/3.1/technical-guide/setup/multiple-engines/#multiple-engines-with-distributed-databases) Com banco de dados distribuido
### [🔖](https://docs.camunda.org/optimize/3.1/technical-guide/setup/multiple-engines/#multiple-engines-with-a-shared-database) Com banco de dados compartilhado
## [🗺️](https://forum.camunda.io/c/optimize/21) Forum Optimize
### [📢](https://forum.camunda.io/t/optimize-can-not-verify-engines-version/37544/7) Optimize-can-not-verify-engines-version

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
   -e ABSOLUTE_PATH_ON_HOST_TO_CONFIGURATION_FILE=optimize/config/environment-config.yaml \
   camunda/optimize:3.8.2
```
## Login and Docker-Compose: Optimize Engine
```shell
docker login registry.camunda.cloud && docker-compose -f docker-compose.yaml --env-file env.optmize up -d --build
```
---
- [Optimize](http://localhost:8083/)