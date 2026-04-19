-- Script de inicialización de bd Fotocopiadoras
-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS dbinventario;
USE dbinventario;

-- Tabla: rol
CREATE TABLE IF NOT EXISTS rol (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(255),
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla: usuario
CREATE TABLE IF NOT EXISTS usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    rol_id INT NOT NULL,
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (rol_id) REFERENCES rol(id) ON DELETE RESTRICT
);

-- Tabla: clasificacion
CREATE TABLE IF NOT EXISTS clasificacion (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla: marca
CREATE TABLE IF NOT EXISTS marca (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla: modelo
CREATE TABLE IF NOT EXISTS modelo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    marca_id INT NOT NULL,
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (marca_id) REFERENCES marca(id) ON DELETE RESTRICT
);

-- Tabla: estado_equipo
CREATE TABLE IF NOT EXISTS estado_equipo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255),
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla: sede
CREATE TABLE IF NOT EXISTS sede (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    ubicacion VARCHAR(255),
    ciudad VARCHAR(50),
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla: distrito_fiscal
CREATE TABLE IF NOT EXISTS distrito_fiscal (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla: despacho
CREATE TABLE IF NOT EXISTS despacho (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    distrito_fiscal_id INT NOT NULL,
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (distrito_fiscal_id) REFERENCES distrito_fiscal(id) ON DELETE RESTRICT
);

-- Tabla: equipo (tabla principal del sistema)
CREATE TABLE IF NOT EXISTS equipo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codigo_patrimonial VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(255),
    clasificacion_id INT NOT NULL,
    modelo_id INT NOT NULL,
    estado_equipo_id INT NOT NULL,
    sede_id INT NOT NULL,
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (clasificacion_id) REFERENCES clasificacion(id) ON DELETE RESTRICT,
    FOREIGN KEY (modelo_id) REFERENCES modelo(id) ON DELETE RESTRICT,
    FOREIGN KEY (estado_equipo_id) REFERENCES estado_equipo(id) ON DELETE RESTRICT,
    FOREIGN KEY (sede_id) REFERENCES sede(id) ON DELETE RESTRICT
);

-- Tabla: personal
CREATE TABLE IF NOT EXISTS personal (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefono VARCHAR(20),
    cargo VARCHAR(100),
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla: mantenimiento
CREATE TABLE IF NOT EXISTS mantenimiento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    equipo_id INT NOT NULL,
    descripcion VARCHAR(255),
    fecha_mantenimiento DATE NOT NULL,
    personal_id INT,
    costo DECIMAL(10, 2),
    observaciones VARCHAR(500),
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (equipo_id) REFERENCES equipo(id) ON DELETE CASCADE,
    FOREIGN KEY (personal_id) REFERENCES personal(id) ON DELETE SET NULL
);

-- Insertar datos iniciales
-- Roles
INSERT INTO rol (nombre, descripcion) VALUES 
('ADMIN', 'Administrador del sistema'),
('USUARIO', 'Usuario regular'),
('TECNICO', 'Personal técnico');

-- Usuarios (sin cifrado, solo para pruebas)
INSERT INTO usuario (nombre, username, password, rol_id) VALUES 
('Administrador', 'root', 'soyelputoamo23', 1),
('Usuario Test', 'usuario', 'usuario123', 2);

-- Clasificaciones
INSERT INTO clasificacion (nombre, descripcion) VALUES 
('Fotocopiadora Láser', 'Máquinas fotocopiadoras láser'),
('Fotocopiadora inkjet', 'Máquinas fotocopiadoras inkjet'),
('Escáner', 'Dispositivos de escaneo'),
('Impresora', 'Impresoras');

-- Marcas
INSERT INTO marca (nombre, descripcion) VALUES 
('Xerox', 'Xerox Corporation'),
('Canon', 'Canon Inc'),
('Ricoh', 'Ricoh Company'),
('HP', 'Hewlett-Packard');

-- Modelos
INSERT INTO modelo (nombre, descripcion, marca_id) VALUES 
('WorkCentre 7875', 'Fotocopiadora multifuncional', 1),
('imageRUNNER', 'Serie imageRUNNER', 2),
('MP C3004', 'Multifunción', 3),
('Color LaserJet', 'Impresora láser', 4);

-- Estados de Equipo
INSERT INTO estado_equipo (nombre, descripcion) VALUES 
('Operativo', 'Equipo en funcionamiento'),
('Mantenimiento', 'En mantenimiento'),
('Dañado', 'Requiere reparación'),
('Fuera de Servicio', 'No en uso');

-- Sedes
INSERT INTO sede (nombre, ubicacion, ciudad) VALUES 
('Sede Central', 'Calle Principal 123', 'Lima'),
('Sede Norte', 'Avenida Norte 456', 'Lima'),
('Sede Sur', 'Avenida Sur 789', 'Lima');

-- Distritos Fiscales
INSERT INTO distrito_fiscal (nombre, descripcion) VALUES 
('Distrito I', 'Primer distrito'),
('Distrito II', 'Segundo distrito');

-- Despachos
INSERT INTO despacho (nombre, descripcion, distrito_fiscal_id) VALUES 
('Despacho 1', 'Despacho fiscal 1', 1),
('Despacho 2', 'Despacho fiscal 2', 2);

-- Personal
INSERT INTO personal (nombre, apellido, email, telefono, cargo) VALUES 
('Juan', 'García', 'juan@example.com', '987654321', 'Técnico'),
('María', 'López', 'maria@example.com', '987654322', 'Supervisor');

-- Equipos (Ejemplos)
INSERT INTO equipo (codigo_patrimonial, descripcion, clasificacion_id, modelo_id, estado_equipo_id, sede_id) VALUES 
('EQ-001', 'Fotocopiadora Xerox 1', 1, 1, 1, 1),
('EQ-002', 'Fotocopiadora Canon 1', 1, 2, 1, 2),
('EQ-003', 'Escáner Ricoh 1', 3, 3, 2, 1);

-- Mantenimientos (Ejemplos)
INSERT INTO mantenimiento (equipo_id, descripcion, fecha_mantenimiento, personal_id, costo, observaciones) VALUES 
(1, 'Cambio de tóner', '2024-01-15', 1, 150.00, 'Mantenimiento preventivo'),
(2, 'Limpieza y revisión', '2024-02-20', 2, 100.00, 'Mantenimiento regular');

-- Crear índices
CREATE INDEX idx_usuario_rol ON usuario(rol_id);
CREATE INDEX idx_modelo_marca ON modelo(marca_id);
CREATE INDEX idx_despacho_distrito ON despacho(distrito_fiscal_id);
CREATE INDEX idx_equipo_clasificacion ON equipo(clasificacion_id);
CREATE INDEX idx_equipo_modelo ON equipo(modelo_id);
CREATE INDEX idx_equipo_estado ON equipo(estado_equipo_id);
CREATE INDEX idx_equipo_sede ON equipo(sede_id);
CREATE INDEX idx_mantenimiento_equipo ON mantenimiento(equipo_id);
CREATE INDEX idx_mantenimiento_personal ON mantenimiento(personal_id);
