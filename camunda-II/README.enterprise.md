# Camunda 8 Enterprise Run

## Kubertes

### Enterprise Secret [link](https://docs.camunda.io/docs/self-managed/setup/install/#enterprise-components-secret)

```shell
kubectl create secret docker-registry registry-camunda-cloud \
  --namespace=<NAMESPACE>
  --docker-server=registry.camunda.cloud \
  --docker-username=<DOCKER_USER> \
  --docker-password=<DOCKER_PASSWORD> \
  --docker-email=<DOCKER_EMAIL>
```

### Kind

> This values need add into root `.kind` infrastructure file

#### Modeler

##### External postgres service

```yaml
...
webModeler:
  restapi:
    externalDatabase:
      url: jdbc:postgresql://postgres.example.com:5432/modeler-db
      user: modeler-user
      password: secret
postgresql:
  # disables the PostgreSQL chart dependency
  enabled: false
...

```

##### With postgres into stack

```yaml
...
webModeler:
  enabled: true
  image:
    pullSecrets:
      # Create the secret as mentioned according to the instructions.
      - name: registry-camunda-cloud
  restapi:
    mail:
      smtpHost: smtp.example.com
      smtpPort: 587
      smtpUser: user
      smtpPassword: secret
      # Email address to be displayed as sender of emails from Web Modeler
      fromAddress: no-reply@example.com
postgresql:
  enabled: true
...
```

##### Console

```yaml
...
console:
  enabled: true
  image:
    pullSecrets:
      - name: registry-camunda-cloud
...

```

### Access

#### Modeler ports

```shell
kubectl port-forward svc/camunda-web-modeler-webapp 8084:80

kubectl port-forward svc/camunda-web-modeler-websockets 8085:80

kubectl port-forward svc/camunda-keycloak 18080:80
```

#### Console ports

```shell
- Console 
- Web Modelerell
kubectl port-forward svc/camunda-console 8087:80

kubectl port-forward svc/camunda-keycloak 18080:80
```

#### LocalHosts

- Modeler: <http://localhost:8084>
- Console: <http://localhost:8087>

## Docker

### Web Modeler

- [Documentation](https://docs.camunda.io/docs/self-managed/setup/deploy/other/docker/#web-modeler)

```shell
docker login registry.camunda.cloud
Username: your_username
Password: ******
Login Succeeded
```

#### Images

- [Configurations](https://docs.camunda.io/docs/self-managed/modeler/web-modeler/configuration/)

##### Backend

```shell
docker pull registry.camunda.cloud/web-modeler-ee/modeler-restapi:latest
```

##### FrontEnd

```shell
docker pull registry.camunda.cloud/web-modeler-ee/modeler-webapp:latest
```

##### WebSocket

```shell
docker pull registry.camunda.cloud/web-modeler-ee/modeler-websockets:latest
```
