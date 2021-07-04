# 🌬 Camunda

![img](./assets/niall-says-congrats.png)

## **📙** **Informações básicas** 

### ⚙ Tarefas De Serviço

Existem quatro maneiras de declarar como invocar a lógica Java:

- Especificar uma classe que implementa um JavaDelegate ou ActivityBehavior
- Avaliar uma expressão que resolve para um objeto de delegação
- Invocando uma expressão de método
- Avaliando uma expressão de valor

De <https://docs.camunda.org/manual/latest/reference/bpmn20/tasks/service-task/>

### 🗜 Tarefas Externas

O mecanismo de processo oferece suporte a duas maneiras de executar tarefas de serviço:

1. Tarefas de serviço interno: invocação síncrona de código implantado junto com um aplicativo de processo
2. Tarefas externas: fornecer uma unidade de trabalho em uma lista que pode ser consultada pelos  trabalhadores

De <https://docs.camunda.org/manual/latest/user-guide/process-engine/external-tasks/>

### 🖇 O Padrão de tarefas Externas

O mecanismo de processo oferece suporte a duas maneiras de executar tarefas de serviço:

**Process Engine** : Criação de uma instância de tarefa externa

- Quando o mecanismo de processo **encontra uma tarefa de serviço que está configurada para ser tratada externamente**, ele **cria uma instância de tarefa externa** e a inclui em uma lista de tarefas externas

**Trabalhador externo** : buscar e bloquear tarefas externas

- A instância da tarefa **recebe um tópico que identifica a natureza do trabalho a ser executado**. Em um momento no futuro, um trabalhador externo pode buscar e bloquear tarefas para um conjunto específico de tópicos

**Trabalhador externo e mecanismo de processo** : instância de tarefa externa completa

- Para evitar que uma tarefa seja buscada por **vários trabalhadores ao mesmo tempo**, uma tarefa tem um **bloqueio baseado em carimbo de data / hora que é definido quando a tarefa é adquirida**. Somente quando o bloqueio expira, outro trabalhador pode buscar a tarefa novamente. **Quando um trabalhador externo conclui o trabalho desejado, ele pode sinalizar ao mecanismo** de processo para continuar a execução do processo após a tarefa de serviço

De <https://docs.camunda.org/manual/latest/user-guide/process-engine/external-tasks/> 

#### 💡 Analogia de tarefas

As tarefas externas são **conceitualmente muito semelhantes** às tarefas do usuário. 

- Ao tentar entender o padrão de tarefa externa pela primeira vez, pode ser útil pensar sobre ele em **analogia às tarefas do usuário**: 

  - Tarefas do usuário: são criadas pelo mecanismo de processo e adicionadas a uma lista de tarefas. O mecanismo de processo então espera que um usuário humano consulte a lista, solicite uma tarefa e a conclua. 

  - Tarefas externas: são semelhantes: uma tarefa externa é criada e adicionada a um tópico. Um aplicativo externo então consulta o tópico e bloqueia a tarefa. Depois que a tarefa é bloqueada, o aplicativo pode trabalhar nela e concluir.

    

### 📌 Links

#### **🥁** **Trilha inicial**
| **Link**                                                                                               | **Descrição**                                |
| ------------------------------------------------------------------------------------------------------ | -------------------------------------------- |
| [Download and Installation (1/6)](https://docs.camunda.org/get-started/quick-start/install/)           | Instalação da  estrutura engine work camunda |
| [Executing automated steps (2/6)](https://docs.camunda.org/get-started/quick-start/service-task/)      | Execução da engine  work processo            |
| [Deploy the Process (3/6)](https://docs.camunda.org/get-started/quick-start/deploy/)                   | Deploy do processo  no cockpit do camunda    |
| [Add a User Task to the Process (4/6)](https://docs.camunda.org/get-started/quick-start/user-task/)    | Entendendo as  tarefas de usuário            |
| [Add Gateways to the Process (5/6)](https://docs.camunda.org/get-started/quick-start/gateway/)         | Aplicando  condicionais e rotas              |
| [Leverage business rules (6/6)](https://docs.camunda.org/get-started/quick-start/decision-automation/) | Adicionando regras  de negócio               |

#### **📚** **Documentação** 

| **Link**                                                     | **Descrição**                           |
| ------------------------------------------------------------ | --------------------------------------- |
| [Service   Task](https://docs.camunda.org/manual/latest/reference/bpmn20/tasks/service-task/) | Tarefas de serviço                      |
| [External   Tasks](https://docs.camunda.org/manual/latest/user-guide/process-engine/external-tasks/#long-polling-to-fetch-and-lock-external-tasks) | Tarefas externas                        |
| [Expression   Language](https://docs.camunda.org/manual/latest/user-guide/process-engine/expression-language/) | Condicionais                            |
| [Expressions   in the DMN Engine](https://docs.camunda.org/manual/latest/user-guide/dmn-engine/expressions-and-scripts/) | Condicionais de  negócio                |
| [Delegation   Code](https://docs.camunda.org/manual/latest/user-guide/process-engine/delegation-code/#java-delegate) | Integração com  Java                    |
| [BPMN 2.0 Símbolos](https://camunda.com/bpmn/reference/)     | Notação BPMN                            |
| [Spring   Framework Integration](https://docs.camunda.org/manual/latest/user-guide/spring-framework-integration/#expression-resolving) | Integração com  Spring Boot             |
| [Error   Handling](https://docs.camunda.org/manual/latest/user-guide/process-engine/expression-language/#external-task-error-handling) | Tratamento de erro  em tarefas externas |
| [Error   Events](https://docs.camunda.org/manual/latest/reference/bpmn20/events/error-events/) | Eventos de erro  BPMN                   |
| [Rest Api   Reference](https://docs.camunda.org/manual/latest/reference/rest/) | Referências API Rest. do Camunda        |

#### **📰** **Outros** 

| **Link**                          | **Conteúdo** |
| --------------------------------- | ------------ |
| [Blog](https://camunda.com/blog/) | New’         |

