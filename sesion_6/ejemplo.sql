DROP DATABASE IF EXISTS parcial;
CREATE DATABASE parcial;

USE parcial;

CREATE TABLE rol(
	id INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(50) NOT NULL UNIQUE,
	nombre VARCHAR(50) NOT NULL
);


CREATE TABLE usuario(
	id INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(50) NOT NULL UNIQUE,
	contrasenia VARCHAR(50) NOT NULL,
	nombre_completo VARCHAR(50) NOT NULL,
    rol_id INT,
    FOREIGN KEY (rol_id) REFERENCES rol(id)
);

CREATE TABLE sala(
	id INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(50) NOT NULL UNIQUE,
	nombre VARCHAR(50) NOT NULL
);

CREATE TABLE categoria(
	id INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(50) NOT NULL UNIQUE,
	nombre VARCHAR(50) NOT NULL
);


CREATE TABLE libro(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE,
	autor VARCHAR(50) NOT NULL,
    sala_id INT,
    categoria_id INT,
    FOREIGN KEY (sala_id) REFERENCES sala(id),
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

CREATE TABLE prestamo(
	id INT PRIMARY KEY AUTO_INCREMENT,
    estado BIT NOT NULL,
    fecha_prestamo TIMESTAMP,
    fecha_entrega TIMESTAMP,
    usuario_visitante_id INT,
    usuario_admin_id INT,
    libro_id INT,
    FOREIGN KEY (usuario_visitante_id) REFERENCES usuario(id),
    FOREIGN KEY (usuario_admin_id) REFERENCES usuario(id),
    FOREIGN KEY (libro_id) REFERENCES libro(id)
);


INSERT INTO rol (codigo, nombre) VALUES
('1010', 'Admin'),
('1012', 'Visitante');

INSERT INTO usuario (usuario, contrasenia, nombre_completo, rol_id) VALUES 
('pepito21','dsfhdsajf','Pepito Perez', 1),
('sofia32','abcd','Sofia Mendez', 2),
('karol10','abcd123','Karol G', 2);

INSERT INTO categoria (codigo, nombre) VALUES
('1010', 'Categoría 1'),
('1012', 'Categoría 2'),
('1013', 'Categoría 3');

INSERT INTO sala (codigo, nombre) VALUES
('1010', 'Sala 1'),
('1012', 'sala 2'),
('1013', 'sala 3');

INSERT INTO libro (nombre, autor, sala_id, categoria_id) VALUES
('100 años de soledad', 'Grabriel Garcia', 1, 1),
('Ingeniería de Software', 'Pantaleo', 2, 3),
('Pantrones de Software', 'Pepito Perez', 2, 3);

INSERT INTO prestamo (estado, fecha_prestamo, fecha_entrega, usuario_visitante_id, usuario_admin_id, libro_id) VALUES
(1, now(), now(), 2, 1, 1),
(1, now(), now(), 3, 1, 3);

SELECT * FROM usuario;
SELECT * FROM categoria;
SELECT * FROM rol;
SELECT * FROM sala;
SELECT * FROM libro;
SELECT * FROM prestamo;

SELECT 
    ua.nombre_completo as administrador,
    ra.nombre as rolAdmin,
    uv.nombre_completo as visitante,
    rv.nombre as rolVisitante,
    l.nombre,
	c.nombre,
    s.nombre
FROM 
	prestamo p   
    INNER JOIN usuario ua ON ua.id = p.usuario_admin_id
    INNER JOIN rol ra ON ra.id = ua.rol_id
    INNER JOIN usuario uv ON uv.id = p.usuario_visitante_id
    INNER JOIN rol rv ON rv.id = uv.rol_id
    INNER JOIN libro l ON p.libro_id = l.id
    INNER JOIn categoria c ON l.categoria_id = c.id
    INNER JOIn sala s ON l.sala_id = s.id
  
