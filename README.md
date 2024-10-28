# Prueba Tecnica BHD # Creador de usuarios API

Esta API está construida con **Spring Boot** y utiliza **Maven** para la gestión de dependencias.

## Arquitectura basada en Domain-Driven Design (DDD)

La estructura del proyecto sigue un enfoque DDD para organizar la lógica de negocio en capas bien definidas:

### 1. Capa de Dominio
Define los modelos de negocio y sus reglas.

### 2. Capa de Aplicación
Esta capa coordina la ejecución de las reglas de negocio y las operaciones en la capa de dominio.

### 3. Capa de Infraestructura
La capa de infraestructura proporciona soporte técnico y de persistencia al proyecto.

### 4. Capa de Interfaz (API)
Expone la API a los usuarios permitiendo la interacción con la aplicación mediante solicitudes HTTP.

## Requisitos Previos
- **Java** (JDK 17)
- **Maven** (v3.6.0 o superior)
- **PostgreSQL** (v17)

## Instalación
1. Clona este repositorio:
   ```
   git clone https://github.com/tu-usuario/tu-proyecto.git
    ```
2. Instalar dependencias
   ```
   mvn clean install
    ```
3. Iniciar servidor de base de datos con Docker.
   ```
   docker-compose up -d
   ```
  **Nota:** Si no desea ejecutar el servidor de docker puede hacerlo manualmente ejecutando los querys de creación de tablas y data inicial
  de este archivo **src/main/resources/db.sql** al momento de ejecutar los querys asegurese de que en el archivo **application.properties** del proyecto
  esten configurados el puerto de la conexióna la db, el nombre de la db junto a su usuario y contraseña.

## Instalación y Prueba

1. Ejecutar la aplicación
   ```
   mvn spring-boot:run
La API esta disponible en http://localhost:8080

### Endpoints de la API

### Crear Usuario
- **URL**: `/api/user`
- **Método**: `POST`
- **Descripción**: Crea un nuevo usuario en el sistema.

### Modificar Catálogo
- **URL**: `/api/catalog/{id}`
- **Método**: `PUT`
- **Descripción**: Actualiza el valor de una variable de configuración o un catálogo específico, como expresiones regulares.

### Obtener Todos los Catálogos
- **URL**: `/api/catalog`
- **Método**: `GET`
- **Descripción**: Lista todos los catálogos junto con sus valores actuales, Favor de ejecutar este endpoint y asi conocer los catalogs y sus ID para poder modificar su valor.

### Swagger
  ```
  http://localhost:8080/swagger-ui/index.html#/
  ```
### Colleción de POSTMAN
 ... 
 
### Diseño de base de datos ER.
![BhdCreateUsers](https://github.com/user-attachments/assets/8d4c8e6e-e243-4e95-ba3b-b50418754304)

**Nota:** En los requerimientos iniciales del proyecto, se especificó que el nombre completo del usuario debía almacenarse en un único campo denominado
`fullName`, en lugar de separarlo en `firstName` (nombre) y `lastName` (apellido).

