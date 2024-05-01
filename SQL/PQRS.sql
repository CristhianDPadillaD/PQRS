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

insert into Roles(Roll) values 
('Persona Natural'),
('Funcionario');

insert into usuario(Nombre,Apellido,Cedula,Correo,Contraseña,idroll) values
('Stiven','Burbano','1233232232','lindo@gmaul.com','lindo123',1);

insert into PQRS (opcion)values 
('Pregunta'),
('Queja'),
('Reclamo'),
('Sugerencia');

insert into Estados (Estado) values 
('revisado '),
('por revisar');

insert into Registros (Descripcion,FechaEnvio,idOpcion,idUsuario,idEstado) values 
('porqueria de trabajo','28/04/2024',3,1,2);