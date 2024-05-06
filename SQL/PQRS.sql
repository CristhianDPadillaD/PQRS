drop database if exists Pqrs;
CREATE DATABASE IF NOT EXISTS Pqrs;
USE Pqrs;

create table Roles (
idroll int primary key auto_increment,
Roll varchar(150)
);

create table usuario (
idUsuario int primary key auto_increment,
Nombre varchar(150),
Apellido varchar (150),
Cedula varchar (150),
Correo varchar(150),
Contraseña varchar(150),
idroll int,
foreign key (idroll) references Roles (idroll) 
);
INSERT INTO Roles(Roll) VALUES ("usuario"), ("SuperUsuario");
INSERT INTO usuario(Nombre, Apellido, Cedula, Correo, Contraseña, idroll) VALUES 
('Cristhian', 'Padilla', '105108', 'dctm', 'admin', 2);


    
create table Estados (
idEstado INT AUTO_INCREMENT PRIMARY KEY,
Estado VARCHAR(50)
);
INSERT INTO Estados(Estado) VALUES ("Revisado"), ("Sin Revizar");

create table PQRS (
idOpcion int primary key auto_increment,
Opcion varchar(150)
);
INSERT INTO PQRS(Opcion) VALUES ("Preguntas"), ("Quejas"), ("Reclamos"), ("Sugerencias");

create table Registros (
id_Registros int primary key auto_increment,
Descripcion varchar (200),
FechaEnvio date,
idOpcion int,
idUsuario int,
idEstado int,
foreign key (idOpcion) references PQRS (idOpcion) ,
foreign key (idUsuario) references usuario (idUsuario) ,
foreign key (idEstado) references Estados (idEstado) 
);

    
DELIMITER //

	CREATE PROCEDURE AgregarUsuario(
	IN	P_Nombre varchar(150),
	IN P_Apellido varchar (150),
	IN P_Cedula varchar (150),
	IN P_Correo varchar(150),
	IN P_Contraseña varchar(150),
	IN P_idroll int
	)
	BEGIN
		INSERT INTO usuario(Nombre, Apellido, Cedula, Correo, Contraseña, idroll)
		VALUES (p_Nombre, P_Apellido, P_Cedula, P_Correo, P_Contraseña, P_idroll);
	END //

	DELIMITER ;
    
DELIMITER //

CREATE PROCEDURE AgregarRegistro(
    IN P_Descripcion varchar(150),
    IN P_FechaEnvio date,
    IN P_idOpcion int,
    IN P_idUsuario int,
    IN P_idEstado int
)
BEGIN
    INSERT INTO Registros(Descripcion, FechaEnvio, idOpcion, idUsuario, idEstado)
    VALUES (P_Descripcion, P_FechaEnvio, P_idOpcion, P_idUsuario, P_idEstado);
END //

DELIMITER ;

