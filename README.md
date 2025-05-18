# 📝 ToDo Management API
_By Rodrigo Viveros H._

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.11-green)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Swagger](https://img.shields.io/badge/Swagger-2.5.0-%2385EA2D)

Una API REST robusta para administrar tareas (ToDo), desarrollada como parte de un reto técnico.

## 📌 Características Clave
✔ CRUD Completo  
✔ Validaciones Automáticas  
✔ Documentación Interactiva con Swagger  
✔ Pruebas de Integración con Testcontainers  
✔ Arquitectura limpia (Controller-Service-Repository)

### Requisitos Previos
- Java 17+
- MySQL 8+
- Maven 3.8+



## Instalación

1. Clonar repositorio:
   ```bash
   git clone [(https://github.com/Rodrigo-Viveros-H/ToDo-Management-API.git)]
   cd todo-api
   ```
2. Configurar la Base de Datos:
   ```bash
   CREATE DATABASE todo_db;
   ```
3. Configurar Credenciales:
   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   ```

4. Ejecutar la app:
   ```bash
   mvn spring-boot:run
   ```  

5. Acceder a la documentación:
   ```bash
   http://localhost:8080/swagger-ui.html
   ```

## 🔌 Endpoints Principales
### Endpoints de la API
La API está documentada con Swagger UI. Accede a ella en:
http://localhost:8080/swagger-ui.html

| Método  | Ruta                         | Descripción                |
|---------|------------------------------|----------------------------|
| `POST`  | `/api/todos`                 | Crear una nueva tarea      |
| `GET`   | `/api/todos`                 | Obtener todas las tareas   |
| `GET`   | `/api/todos/{id}`            | Obtener una tarea por ID   |
| `PUT`   | `/api/todos/{id}`            | Actualizar una tarea completa |
| `PATCH` | `/api/todos/{id}/status`     | Cambiar solo el estado     |
| `DELETE`| `/api/todos/{id}`            | Eliminar una tarea         |


## Interfaz gráfica

![App Screenshot](https://velog.velcdn.com/images/97gkswn/post/ab88c560-8a10-4a8d-8fcf-78720cc8c605/image.png)
_La interfaz se vera como el ejemplo que se muestra (Imagen ilustrativa de swagger)_

## 📋 Ejemplos de Uso
En cada opción se debe dar click en "Try it out", después de reemplazar el JSON con sus propios datos, haga click en "Execute" y verifique la respuesta.

### 1. Crear una nueva tarea (POST)
```bash
{
  "description": "Mi primera tarea",
  "date": "2025-05-17T15:00:00"
}
```

### 1.1 Respuesta exitosa (201 Created)
```bash
{
  "id": 1,
  "description": "Mi primera tarea",
  "date": "2025-05-20T14:30:00",
  "status": "PENDIENTE",
  "createdAt": "2025-05-17T10:15:22",
  "updatedAt": "2025-05-17T10:15:22"
}
```

### 2. Obtener todas las tareas (GET)
```bash
curl -X GET "http://localhost:8080/api/todos"
```

### 2.1 Respuesta (GET)
```bash
[
  {
    "id": 1,
    "description": "Mi primera tarea",
    "date": "2025-05-20T14:30:00",
    "status": "PENDIENTE",
    "createdAt": "2025-05-17T10:15:22",
    "updatedAt": "2025-05-17T10:15:22"
  }
]
```

### 3. Actualizar una tarea (PUT)
```bash
{
  "description": "Tarea actualizada",
  "date": "2025-05-18T10:00:00",
  "status": "EN_PROGRESO"
}
```

### 4. Actualizar solo el estado (PATCH)
Use el ID de una tarea existente
```bash
curl -X PATCH "http://localhost:8080/api/todos/1/status" \
-H "Content-Type: application/json" \
-d '"COMPLETADO"'
```

### 5. Eliminar una tarea (DELETE)
Ingrese el ID de la tarea existente
```bash
curl -X DELETE "http://localhost:8080/api/todos/1"
```

### 5.1 Respuesta exitosa (DELETE)
No content (204)

### Manejo de errores (Ejemplo [Solicitud inválida])
```bash
curl -X POST "http://localhost:8080/api/todos" \
-H "Content-Type: application/json" \
-d '{"date": "2025-05-20T14:30:00"}'
```

### 5.2 Respuesta de error (400 Bad Request)
```bash
{
  "timestamp": "2025-05-17T10:20:35",
  "status": 400,
  "error": "Bad Request",
  "message": "La descripción no puede estar vacía",
  "path": "/api/todos"
}
```

## Pruebas

El proyecto incluye pruebas de integración con Testcontainers para garantizar calidad:

```bash
  mvn test 
```

## Estructura del Proyecto

```bash
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── todo/
│   │               ├── config/         # Configuraciones
│   │               ├── controller/     # Endpoints API
│   │               ├── model/          # Entidades
│   │               ├── repository/     # Acceso a datos
│   │               ├── service/        # Lógica de negocio
│   │               └── TodoManagementApplication.java
│   └── resources/                      # Properties y templates
└── test/                               # Pruebas unitarias e integración
```

## Autor

- [@Rodrigo-Viveros-H](https://github.com/Rodrigo-Viveros-H) GitHub
- [@Rodrigo Viveros H.](https://www.linkedin.com/in/rodrigo-viveros-h/) Linkedin.


## Licencia
Este proyecto está bajo la licencia MIT.
© 2025 - Rodrigo Viveros H.
[MIT](https://choosealicense.com/licenses/mit/)
