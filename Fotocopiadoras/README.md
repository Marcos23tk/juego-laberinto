# Sistema de Gestión de Fotocopiadoras

## Descripción

Plataforma web completa para la gestión integral de equipos fotocopiadores. Incluye seguimiento de inventario, mantenimiento, control de usuarios y auditoría de operaciones.

## Características

### Backend
- ✅ **API REST completa** con 11 endpoints principales
- ✅ **Autenticación JWT** segura
- ✅ **Validación de datos** en todas las operaciones
- ✅ **Manejo de excepciones personalizado**
- ✅ **Swagger/OpenAPI** para documentación automática
- ✅ **CORS configurado** para múltiples orígenes
- ✅ **Base de datos MySQL** con relaciones complejas

### Frontend
- ✅ **Dashboard reactivo** con estadísticas en tiempo real
- ✅ **Sistema de login** con autenticación segura
- ✅ **Módulos CRUD** para todas las entidades
- ✅ **Interfaz responsiva** adaptable a dispositivos móviles
- ✅ **Gestión de permisos** por rol
- ✅ **Notificaciones** en tiempo real

### Entidades Principales
1. **Usuarios** - Control de acceso y autenticación
2. **Roles** - Gestión de permisos
3. **Equipos** - Inventario principal de fotocopiadoras
4. **Marcas** - Fabricantes de equipos
5. **Modelos** - Modelos específicos de equipos
6. **Sedes** - Ubicaciones de equipos
7. **Clasificaciones** - Tipos de equipos
8. **Estado de Equipo** - Estados operacionales
9. **Personal** - Técnicos y personal administrativo
10. **Mantenimiento** - Historial de servicio
11. **Despacho** - Gestión de despachos judiciales

## Requisitos Previos

- Java 17 o superior
- Maven 3.6+
- MySQL 8.0+
- Node.js 14+ (opcional, para desarrollo frontend)
- Windows 10+ o Linux

## Instalación

### 1. Configurar Base de Datos

```bash
# Acceder a MySQL
mysql -u root -p

# Ejecutar el script de inicialización
source src/main/resources/init-db.sql;
```

**O manualmente:**
```sql
CREATE DATABASE IF NOT EXISTS dbinventario;
USE dbinventario;
-- (Ejecutar el contenido de init-db.sql)
```

### 2. Configurar Aplicación

Editar `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/dbinventario?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_contraseña
```

### 3. Compilar y Ejecutar

```bash
# Compilar proyecto
mvnw clean compile

# Ejecutar aplicación
mvnw spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

## Uso

### Credenciales de Prueba

| Usuario | Contraseña | Rol |
|---------|-----------|-----|
| admin | admin | ADMIN |
| usuario | usuario | USUARIO |

**Nota:** Las contraseñas están encriptadas en la base de datos. Para cambiarlas, use el endpoint de actualización.

### Acceso

1. **Frontend**: http://localhost:8080
2. **API REST**: http://localhost:8080/api/v1
3. **Swagger/OpenAPI**: http://localhost:8080/swagger-ui.html

### Módulos Disponibles

#### Dashboard
- Resumen de estadísticas
- Últimos equipos registrados
- Control de acceso rápido

#### Equipos
- Crear, leer, actualizar, eliminar equipos
- Filtrar por marca, modelo, estado
- Historial de mantenimiento

#### Usuarios
- Gestión de cuentas
- Asignación de roles
- Control de permisos

#### Sedes
- Registrar ubicaciones
- Asignar equipos a sedes
- Gestión geográfica

#### Personal
- Registrar técnicos y personal administrativo
- Asignar a tareas de mantenimiento
- Contactos y referencias

#### Marcas y Modelos
- Catálogo de fabricantes
- Especificaciones de modelos
- Relación marca-modelo

#### Mantenimiento
- Registro de servicios
- Historial por equipo
- Costos y observaciones

## Endpoints API

### Autenticación
```
POST   /api/v1/auth/login          - Iniciar sesión
POST   /api/v1/auth/register       - Registrar usuario
GET    /api/v1/auth/validate       - Validar token
```

### Equipos
```
GET    /api/v1/equipo              - Listar todos
POST   /api/v1/equipo              - Crear nuevo
GET    /api/v1/equipo/{id}         - Obtener por ID
PUT    /api/v1/equipo/{id}         - Actualizar
DELETE /api/v1/equipo/{id}         - Eliminar
```

### Usuarios
```
GET    /api/v1/usuario             - Listar todos
POST   /api/v1/usuario             - Crear nuevo
GET    /api/v1/usuario/{id}        - Obtener por ID
PUT    /api/v1/usuario/{id}        - Actualizar
DELETE /api/v1/usuario/{id}        - Eliminar
```

### Sedes
```
GET    /api/v1/sede                - Listar todos
POST   /api/v1/sede                - Crear nuevo
GET    /api/v1/sede/{id}           - Obtener por ID
PUT    /api/v1/sede/{id}           - Actualizar
DELETE /api/v1/sede/{id}           - Eliminar
```

*(Patrones similares para: marcas, modelos, roles, personal, clasificación, estado-equipo, distrito-fiscal, despacho)*

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/Fotocopiadoras/Fotocopiadoras/
│   │       ├── Controller/          - Controladores REST
│   │       ├── Entity/              - Modelos de datos
│   │       ├── Repository/          - Acceso a datos
│   │       ├── Service/             - Lógica de negocio
│   │       ├── Exception/           - Manejo de excepciones
│   │       ├── Dto/                 - Objetos de transferencia
│   │       ├── Config/              - Configuraciones
│   │       ├── Security/            - Seguridad y JWT
│   │       └── FotocopiadorasApplication.java
│   ├── resources/
│   │   ├── application.properties   - Configuración
│   │   ├── init-db.sql              - Script de BD
│   │   └── static/                  - Frontend web
│   │       ├── index.html
│   │       ├── dashboard.html
│   │       └── assets/
│   │           ├── css/
│   │           └── js/
│   └── test/
└── pom.xml
```

## Tecnologías Utilizadas

### Backend
- **Spring Boot 4.0.3** - Framework web
- **Spring Data JPA** - ORM
- **Spring Security** - Autenticación
- **JWT (jjwt)** - Tokens seguros
- **MySQL** - Base de datos
- **Swagger/OpenAPI** - Documentación

### Frontend
- **HTML5** - Estructura
- **CSS3** - Estilos responsivos
- **JavaScript (Vanilla)** - Interactividad
- **Fetch API** - Comunicación con backend

## Documentación API

Acceso automático: `http://localhost:8080/swagger-ui.html`

La documentación incluye:
- Todos los endpoints disponibles
- Parámetros y respuestas
- Ejemplos de uso
- Autenticación JWT

## Configuración Avanzada

### Variables de Entorno

Usar `application.yml` or `application-prod.properties`:

```properties
# Base de datos
spring.datasource.url=jdbc:mysql://host:port/database
spring.datasource.username=user
spring.datasource.password=pass

# JWT
app.jwtSecret=tu_secreto_seguro_muy_largo
app.jwtExpirationMs=86400000

# Logging
logging.level.root=INFO
logging.level.com.Fotocopiadoras=DEBUG
```

### CORS Configuration

Editar `WebConfig.java` para cambiar orígenes permitidos:

```java
registry.addMapping("/api/**")
    .allowedOrigins("http://localhost:3000", "https://tudominio.com")
    .allowedMethods("GET", "POST", "PUT", "DELETE");
```

## Troubleshooting

### Error: "Connection refused"
- Verificar que MySQL está ejecutándose
- Revisar credenciales en `application.properties`

### Error: "401 Unauthorized"
- Token JWT expirado: Volver a login
- Token no incluido: Verificar encabezado `Authorization: Bearer <token>`

### Error: "Compilación Java 21 no soportada"
- Cambiar version en `pom.xml` a `<java.version>17</java.version>`
- Ejecutar `mvnw clean compile` nuevamente

## Contribuciones

Para contribuir al proyecto:

1. Fork el repositorio
2. Crear rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit los cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Licencia

Este proyecto está bajo la licencia MIT. Ver archivo `LICENSE` para más detalles.

## Soporte

Para reportar bugs o solicitar features: [crear issue en GitHub](https://github.com/tu-usuario/fotocopiadoras/issues)

## Roadmap - Próximas Mejoras

- [ ] Módulo de reportes avanzados
- [ ] Export a PDF/Excel
- [ ] Gráficos de rendimiento
- [ ] App móvil (React Native)
- [ ] Notificaciones por email
- [ ] Integración con sistemas contables
- [ ] API GraphQL
- [ ] Caché distribuido (Redis)
- [ ] Actualizaciones en tiempo real (WebSockets)

## Autores

- **Sistema de Gestión de Fotocopiadoras** - Versión 1.0.0
- Desarrollado con Spring Boot + JavaScript Vanilla

## Changelog

### v1.0.0 (2024-04-03)
- ✅ Sistema completo de autenticación
- ✅ CRUD para todas las entidades
- ✅ API REST documentada
- ✅ Frontend web responsivo
- ✅ Base de datos con relaciones

---

**Última actualización:** 2024-04-03  
**Versión:** 1.0.0  
**Estado:** Producción
