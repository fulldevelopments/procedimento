 Spring-restfull-docker

## 🛠️ IDEA utilizada

* [IntelliJ IDEA Community](https://www.jetbrains.com/pt-br/idea/download/#section=windows)

### 📋 Pré-requisitos

* [Docker](https://docs.docker.com/docker-for-windows/install/)
* [git](https://git-scm.com/downloads)
* [Java](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)

## ⚙️ Executando

Clonar o repositório:

```
$ git clone https://github.com/fulldevelopments/springboot-rest-docker.git
```

Colocar usuario do https://hub.docker.com/ no arquivo dockerfile.

Criar imagem docker:

```
$ docker build -t="procedimento-java" .
```

####Iniciar o container:

```
$ docker run -p 8080:8080 -it --rm procedimento-java
```
```
$ curl localhost:8080
```

Parar o container:

```
$ docker stop `docker container ls | grep "procedimento-java:*" | awk '{ print $1 }'`
```

Iniciar com docker-compose:
criar e iniciar o container 

```
$ docker-compose up -d 
```

```
$ curl localhost:8080
```

Parar o container:
```
$ docker-compose down
```
