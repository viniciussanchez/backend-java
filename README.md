# Back-end Java
Microsserviços, Spring Boot e Kubernetes

### Ambiente
* [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/download)
* [Maven](https://maven.apache.org)
* [Docker](https://www.docker.com/products/docker-desktop)
* [pgAdmin](https://www.pgadmin.org/download)
* [PostgreSQL](https://www.postgresql.org/download)

Se preferir, pode usar a [imagem](https://hub.docker.com/_/postgres) docker do PostgreSQL:

`
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=mypassword postgres
`

### Bibliotecas
* Spring Boot
* Spring Web
* Spring Data
* [Flyway](https://github.com/flyway/flyway)
* [PostgreSQL](https://mvnrepository.com/artifact/org.postgresql/postgresql)

### Running
1 - Devido ao compartilhamento das classes do projeto shopping-client entre os demais projetos, é necessário fazer a sua instalação através do Maven, para que o jar do projeto fique disponível no repositório local do Maven na sua máquina.
2 - É necessário configurar o arquivo settings.xml do Maven, para permitir a utilização do plugin do spotify para rodar a aplicação em containeres docker. Normalmente o arquivo em um sistema operacional Windows, fica localizado em C:/Users/Usuario/.m2

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings 
    xmlns="http://maven.apache.org/SETTINGS/1.0.0" 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">

    <pluginGroups>
        <pluginGroup>com.spotify</pluginGroup>
    </pluginGroups>
</settings>
```

#### Running with docker
Em cada API, será necessário executar os seguintes comandos:
```cmd
mvn clean install
mvn dockerfile:build
```
Obs: será necessário habilitar a opção "**Expose daemon on tcp://localhost:2375 without TLS**" nas configurações do docker, conforme mostra a imagem abaixo:

![image](https://user-images.githubusercontent.com/16382981/118900145-a2e77a00-b8e6-11eb-9b83-ce5c729e88d7.png)

Ao finalizar a execução dos comandos, deve haver as seguintes imagens em sua máquina:

```cmd
C:\Users\Vinicius\Documentos\Projetos\Java\backend-java\shopping-api>docker images
REPOSITORY          TAG            IMAGE ID       CREATED          SIZE
loja/shopping-api   latest         98c61ad141eb   15 seconds ago   144MB
loja/product-api    latest         77e78088219a   2 minutes ago    144MB
loja/user-api       latest         7904c9f83d84   6 minutes ago    144MB
postgres            latest         26c8bcd8b719   5 weeks ago      314MB
```

Feito isso, basta executar o comando a seguir para subir as aplicações:

```
docker-compose up
```

e o comando abaixo para parar as aplicações:

```
docker-compose down
```

#### Kubernetes

Se você ainda não possui o Kubernetes instalado na sua máquina e utiliza o sistema operacional Windows junto com o Docker for Desktop, basta acessar a tela de configuração do Docker for Desktop e ativar a opção "Enable Kubernetes", como mostra a imagem abaixo:

![image](https://user-images.githubusercontent.com/16382981/119264235-ac0f6a00-bbb8-11eb-8db2-e1ab4d95de71.png)


#### Kubectl

Uma das formas de se interagir com o Kubernetes é através de linha de comando. Para isso vamos instalar o Kubectl. No sistema operacional Windows, basta acessar a página oficial do Kubernetes e seguir a [documentação](https://kubernetes.io/docs/tasks/tools/install-kubectl-windows/). Para verificar se deu tudo certo na instalação, ou caso deseja verificar se você já possui o Kubectl instalado, basta digitar o seguinte comando:

```
kubectl version --client
```

#### Kubernetes dashboard

Outra forma de interagir com o Kubernetes é usando o Dashboard, que por padrão não é instalado de forma automática. Para instalar, basta executar o seguinte comando, como é indicado no [projeto oficial](https://github.com/kubernetes/dashboard) disponibilizado no GitHub:

```
kubectl create -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.2.0/aio/deploy/recommended.yaml
```
