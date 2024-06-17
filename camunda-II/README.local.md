# Camunda 8 Local Run

## Requirements local run

- [Dowloads components](https://github.com/camunda/camunda-platform/releases)
- ElasticSearch
- Jdk 17

## Operate

```shell
./components/camunda-operate-[version]/bin/operate
```

## TaskList

```shell
./components/camunda-tasklist-[version]/bin/tasklist
```

## Identity

- Run with [spring configurations](https://docs.camunda.io/docs/self-managed/identity/deployment/configuration-variables/)

```shell
cd components/camunda-identity-[version]/

java -jar *.jar

```

## Connectors

- [configuration](https://github.com/camunda/connectors/tree/main/connector-runtime#configuration-options)

### Bundle

#### Structure

```md
/home/user/bundle-with-connector $
├── connector-runtime-bundle-VERSION-with-dependencies.jar
└── my-custom-connector-0.1.0-SNAPSHOT-with-dependencies.jar
```

#### Run

```shell
java -cp "/home/user/bundle-with-connector/*" "io.camunda.connector.runtime.app.ConnectorRuntimeApplication"
```

### Runtime

#### Structures

```md
/home/user/runtime-only-with-connector $
├── connector-runtime-application-VERSION-with-dependencies.jar
└── my-custom-connector-0.1.0-SNAPSHOT-with-dependencies.jar
```

#### Runs

```shell
java -cp "/home/user/runtime-only-with-connector/*" "io.camunda.connector.runtime.app.ConnectorRuntimeApplication"
```

## Zeebe

### Broker

```shell
./components/camunda-zeebe-[version]/bin/broker
```

### Gateway

```shell
./components/camunda-zeebe-[version]/bin/gateway
```

### Client

```shell
./components/camunda-zeebe-[version]/bin/zbctl
```

## [Documentation](https://docs.camunda.io/docs/self-managed/setup/deploy/local/manual/)