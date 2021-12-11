# Microservicio de trayectos

Microservicio de manejo de servicios medicos y actividades, contiene toda la logica para el manejo de los servicios medicos y las actividades medicas.

## 💻 Requisitos

* Java 17
* PostgreSQL
* Docker

## 🛠️ Guia de configuracion

El proyecto se encuentra corriendo bajo un host de docker, es posible utilizar el proyecto de manera local utilizando Java o utilizando docker


### Configuracion del archivo application.properties

Se debe crear un archivo llamado **application.properties** en la ruta /src/main/resources/ dentro de la carpeta resources, este archivo es el encargado de configurar la base de datos de la aplicación.

```
# DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url=jdbc:h2:mem:rides
spring.datasource.username=admin
spring.datasource.password=admin

spring.h2.console.enabled=true
spring.datasource.driverClassName=org.h2.Driver

# Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

### Configuración tradicional

La guia de configuracion esta creada bajo comandos de Windows. Todos los comandos se deben realizar en la raiz del proyecto (carpeta del proyecto) a la altura del archivo mvnw.

#### 1️⃣ Iniciar el servidor del proyecto
```console
./mvnw spring-boot:run
```

### Configuracion via Docker

La guia de configuracion esta creada bajo comandos de Windows. Todos los comandos se deben realizar en la raiz del proyecto (carpeta del proyecto) a la altura del archivo mvnw.

#### 1️⃣ Inicio del servidor Docker
```console
docker-compose up -d
```

Para cerrar el servidor una vez inicializado se debe usar el comando:

#### ⏹️ Cerrar servidor Docker
```console
docker-compose down
```


## 💾 Base de Datos
El proyecto esta configurado con una base de datos H2 para el ambiente de desarrollo, esta tiene disponible una interfaz grafica en donde se puede manipular y ver la información de la misma. Se puede acceder a esta mediante la ruta:
```
http://localhost:8080/h2-console
```
Con los siguientes datos:

<ul>
    <li>JDBC URL = jdbc:h2:mem:rides</li>
    <li>User Name: admin</li>
    <li>Password: admin</li>
</ul>

## ⚙️ API

La aplicacion esta formada por dos subsistemas, el subsistema de especialitas y el subsistemma de actividades


