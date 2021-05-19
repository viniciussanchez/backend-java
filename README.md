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

### Observações
* Devido ao compartilhamento das classes do projeto shopping-client entre os demais projetos, é necessário fazer a sua instalação através do Maven, para que o jar do projeto fique disponível no repositório local do Maven na sua máquina.
* É necessário configurar o arquivo settings.xml do Maven, para permitir a utilização do plugin do spotify para rodar a aplicação em containeres docker. Normalmente o arquivo em um sistema operacional Windows, fica localizado em C:/Users/Usuario/.m2

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