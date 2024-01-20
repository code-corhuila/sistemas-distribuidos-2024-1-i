-- DDL => lenguaje de definición de datos
DROP DATABASE IF EXISTS ejemplo1;
CREATE DATABASE ejemplo1;

-- DELETE FROM entidad where ***;

USE ejemplo1;

CREATE TABLE persona(
	id INT PRIMARY KEY AUTO_INCREMENT,
    tipo_documento VARCHAR(20) NOT NULL,
    documento VARCHAR(12) NOT NULL UNIQUE,
    nombre_completo VARCHAR(50) NOT NULL,
    correo VARCHAR(50) NOT NULL UNIQUE   
); 

CREATE TABLE estudiante(
	id INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    programa ENUM('Ing. Sistemas', 'Ing. Industrial', 'Ing. Ambiental'),
    persona_id INT UNIQUE,
    CONSTRAINT fk_estudiante_persona_id_persona_id FOREIGN KEY (persona_id) REFERENCES persona(id)
); 

CREATE TABLE profesor(
	id INT PRIMARY KEY AUTO_INCREMENT,
    tipo_vinculacion VARCHAR(50) NOT NULL,
    horario VARCHAR(200) NOT NULL,
    persona_id INT UNIQUE,
    CONSTRAINT fk_profesor_persona_id_persona_id FOREIGN KEY (persona_id) REFERENCES persona(id)
); 

CREATE TABLE materia(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(200) NOT NULL,
    credito TINYINT NOT NULL,
    nota DECIMAL(3, 1) CHECK (nota >= 0 AND nota <= 5),
	numero_semestre ENUM('1', '2', '3', '4', '5', '6', '7', '8', '9', '10')
); 

CREATE TABLE grupo(
	id INT PRIMARY KEY AUTO_INCREMENT,
    numero_grupo SMALLINT NOT NULL UNIQUE
); 

CREATE TABLE matricula(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nota DECIMAL(3, 1) CHECK (nota >= 0 AND nota <= 5) NULL,
    estudiante_id INT,
    materia_id INT,
    grupo_id INT,
    CONSTRAINT fk_matricula_estudiante_id_estudiante_id FOREIGN KEY (estudiante_id) REFERENCES estudiante(id),
    CONSTRAINT fk_matricula_materia_id_materia_id FOREIGN KEY (materia_id) REFERENCES materia(id),
    CONSTRAINT fk_matricula_grupo_id_grupo_id FOREIGN KEY (grupo_id) REFERENCES grupo(id)
); 

CREATE TABLE matricula_profesor(
	id INT PRIMARY KEY AUTO_INCREMENT,
    profesor_id INT,
    grupo_id INT,
    CONSTRAINT fk_matricula_profesor_profesor_id_profesor_id FOREIGN KEY (profesor_id) REFERENCES profesor(id),
    CONSTRAINT fk_matricula_profesor_grupo_id_grupo_id FOREIGN KEY (grupo_id) REFERENCES grupo(id)
); 


-- DML => Lenguaje de Manipulación de Datos. CRUD

SELECT * FROM persona;

INSERT INTO persona (tipo_documento, documento, nombre_completo, correo) VALUES
('CC','3473287432','Pepito Perez','pepito@gmail.com'),
('TI', '7890123', 'Ana Rodriguez', 'ana.rodriguez@email.com'),
('CC', '1234567', 'Juan Pérez', 'juan.perez@example.com'),
('CE', '9876543', 'María González', 'maria.gonzalez@mail.com'),
('TI', '5678901', 'Carlos Ramirez', 'carlos.ramirez@example.com'),
('CC', '2345678', 'Laura Martínez', 'laura.martinez@email.com'),
('CE', '8765432', 'Pedro Sánchez', 'pedro.sanchez@mail.com'),
('CC', '3456789', 'Isabel Gómez', 'isabel.gomez@example.com'),
('TI', '0123456', 'Sergio Torres', 'sergio.torres@email.com'),
('CE', '6543210', 'Daniela Herrera', 'daniela.herrera@mail.com');

-- ('Ing. Sistemas', 'Ing. Industrial', 'Ing. Ambiental')
INSERT INTO estudiante( codigo, programa, persona_id )VALUES
('346324','Ing. Sistemas',1),
('324322','Ing. Sistemas',2),
('464352','Ing. Sistemas',3),
('5435435','Ing. Industrial',4);


INSERT INTO profesor (tipo_vinculacion, horario, persona_id) VALUES 
('no trabaja', '08:00-16:00', 5), 
('Full Time', '08:00-16:00', 2), 
('Tiempo completo', '08:00-16:00', 1);

INSERT INTO grupo (numero_grupo) VALUES
(1),(2),(3);

-- Asignación de grupo por docente
INSERT INTO matricula_profesor (profesor_id, grupo_id) VALUES
(1,1),(2,2),(3,3);

SELECT * FROM estudiante;

-- Materia
INSERT INTO materia (nombre, descripcion, credito, nota, numero_semestre) VALUES 
('Cálculo diferencial', 'Dolores de cabeza ', 1, 2.20, '3'),
('Telematica', 'amargado ', 3, 1.00, '2'),
('Matemáticas', 'Estudio de las matemáticas', 3, 4.5, '1'),
('Programación', 'Estudio de la programación', 5, 4.8, '5');
    
-- Matricula 
INSERT INTO matricula( nota, estudiante_id, materia_id, grupo_id )VALUES
(3.1, 1, 2,1),
(4.1, 2, 2, 1),
(5.0, 3, 1, 2),
(3.2, 3, 2, 2),
(2.2, 3, 3, 2),
(3.0, 4, 3, 3);


-- Reporte de nombre, tipo documento, documento y programa al que pertenece el estudiante
SELECT * FROM persona;
SELECT * FROM estudiante;

SELECT 
	p.tipo_documento AS tipoDocumento,
    p.documento,
    p.nombre_completo AS nombreCompleto,
    e.programa
FROM 
	persona p
INNER JOIN estudiante e ON p.id = e.persona_id;


-- Indique la nota alcanzada en cada una de las materias que este matriculado un estudiante. 
-- Filtre por número de documento.

SELECT * FROM persona;
SELECT 
	e.codigo,
	p.tipo_documento,
    p.documento,
	p.nombre_completo,
    m.nota,
    ma.nombre
FROM 
	persona p
    INNER JOIN estudiante e ON p.id = e.persona_id
    INNER JOIN matricula m ON e.id = m.estudiante_id
    INNER JOIN materia ma ON m.materia_id = ma.id 
WHERE p.documento = 1234567;

-- Mediante el numero de grupo, muestre el nombre del profesor a cargo, codigo estudiante, nombre 
-- del estudiante y nombre de la materia que tenga asociados. 

SELECT 
	pr.nombre_completo AS nombreProfesor, 
    e.codigo AS codigoEstudiante, 
    pe.nombre_completo AS nombreEstudiante, 
    m.nombre AS nombre_materia
FROM grupo g
	INNER JOIN matricula_profesor mp ON g.id = mp.grupo_id
	INNER JOIN profesor p ON mp.profesor_id = p.id
	INNER JOIN persona pr ON p.persona_id = pr.id
	INNER JOIN matricula ma ON g.id = ma.grupo_id
	INNER JOIN estudiante e ON ma.estudiante_id = e.id
	INNER JOIN persona pe ON e.persona_id = pe.id
	INNER JOIN materia m ON ma.materia_id = m.id
WHERE g.numero_grupo = 1;
