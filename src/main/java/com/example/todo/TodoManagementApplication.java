package com.example.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * Clase principal de la aplicación Spring Boot para la gestión de tareas (ToDo).
 * Configura la aplicación y habilita la documentación automática con Swagger/OpenAPI.
 */
@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Todo Management API",
        version = "1.0.0",
        description = "API REST para gestión de tareas (ToDo) - Realizada por Rodrigo Viveros H."
    )
)
public class TodoManagementApplication {

    /**
     * Método principal que inicia la aplicación Spring Boot.
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(TodoManagementApplication.class, args);
    }
}