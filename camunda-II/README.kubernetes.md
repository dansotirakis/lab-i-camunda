# Camunda 8 Kubernetes Run

## Requirements kubertes Run

- Kubernetes
- Kind
- Helm

## Cluster

### Create

```shell
kind create cluster --name camunda-platform-local
```

### Switch to the new cluster context

```shell
kubectl config use-context kind-camunda-platform-local
```

## Deploy Stack

### Repository

```shell
helm repo add camunda https://helm.camunda.io && helm repo update
```

### Install

```shell
helm install camunda-platform camunda/camunda-platform -f camunda-platform-core-kind-values.yaml
```

### Check Status

#### Helm

```shell
helm status camunda-platform
```

#### Kubectl

```shell
kubectl get services && kubectl get pods && kubectl describe pods
```

#### Kind

```shell
kind get clusters
```

## Access

### [Access engine](https://docs.camunda.io/docs/self-managed/setup/guides/accessing-components-without-ingress/#accessing-workflow-engine)

```shell
kubectl port-forward svc/camunda-zeebe-gateway 26500:26500
```

### [Access Apps](https://docs.camunda.io/docs/self-managed/setup/guides/accessing-components-without-ingress/#accessing-web-applications)

```shell
kubectl port-forward svc/camunda-operate  8081:8080

kubectl port-forward svc/camunda-tasklist 8082:8080

kubectl port-forward svc/camunda-optimize 8083:8080

kubectl port-forward svc/camunda-connectors 8088:8080
```

### LocalHosts

- Operate: <http://localhost:8081>
- TaskList: <http://localhost:8082>
- Optmize: <http://localhost:8083>

### TaskList + Operate Login

![login](https://docs.camunda.io/assets/images/operate-tasklist-login-2c770180f7663ba57f6726b6b4922078.png)

### TaskList + Operate Management

![tasklist](https://docs.camunda.io/assets/images/operate-tasklist-dashboard-bf31fba2cff2065ef604c906ecc8f57c.png)

## Remove Cluster local

```shell
kind delete cluster --name camunda-platform-local
```
