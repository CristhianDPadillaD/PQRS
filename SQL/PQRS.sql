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

create table Estados (
idEstado INT AUTO_INCREMENT PRIMARY KEY,
Estado VARCHAR(50)
);

create table PQRS (
idOpcion int primary key auto_increment,
Opcion varchar(150)
);
create table Registros (
id_Registros int primary key auto_increment,
Descripcion varchar (200),
FechaEnvio Varchar(150),
idOpcion int,
idUsuario int,
idEstado int,
foreign key (idOpcion) references PQRS (idOpcion) ,
foreign key (idUsuario) references usuario (idUsuario) ,
foreign key (idEstado) references Estados (idEstado) 
);
INSERT INTO Roles(Roll) VALUES
	('usuario'),
    ('SuperUsuario');
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

