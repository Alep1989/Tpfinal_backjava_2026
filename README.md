# Articulos API

API REST para la gestión de artículos desarrollada con Spring Boot.

## Descripción

Esta es una aplicación Spring Boot que proporciona endpoints REST para realizar operaciones CRUD (Create, Read, Update, Delete) sobre artículos.

## Requisitos

- Java 17 o superior
- Maven 3.8 o superior

## Instalación y Ejecución

1. Clonar el repositorio:
```bash
git clone https://github.com/Alep1989/Tpfinal_backjava_2026.git
cd Tpfinal_backjava_2026
```

2. Compilar y ejecutar la aplicación:
```bash
mvn clean install
mvn spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`

## Endpoints

### Listar todos los artículos
- **GET** `/api/articulos`
- Devuelve una lista de todos los artículos

### Obtener un artículo por ID
- **GET** `/api/articulos/{id}`
- Devuelve un artículo específico

### Crear un nuevo artículo
- **POST** `/api/articulos`
- Body (JSON):
```json
{
  "nombre": "Producto",
  "descripcion": "Descripción del producto",
  "precio": 99.99,
  "stock": 10
}
```

### Actualizar un artículo
- **PUT** `/api/articulos/{id}`
- Body (JSON): Mismo formato que POST

### Eliminar un artículo
- **DELETE** `/api/articulos/{id}`

## Base de Datos

La aplicación utiliza H2 como base de datos en memoria.

Consola H2: `http://localhost:8080/h2-console`

## Autor

Alejandro Arancibia
