CREATE DATABASE Aterrizar;

CREATE TABLE Usuario (
  id int(11) NOT NULL AUTO_INCREMENT,
  nombreUsuario varchar(20),
  password varchar(20),
  nombre varchar(20),
  apellido varchar(20),
  email varchar(20),
  fecha date,
  codigoDeValidacion varchar(20),
  cuentaValida boolean,

  PRIMARY KEY (id)
);

CREATE TABLE tramo (
  id int(11) NOT NULL AUTO_INCREMENT,
  llegada date,
  salida date,
  idAsiento int(11),

  PRIMARY KEY (id),
  FOREIGN KEY (idAsiento)
  REFERENCES asiento(id)
);

CREATE TABLE vuelo(
  id int(11) NOT NULL AUTO_INCREMENT,
  idTramo int(11),

  PRIMARY KEY (id),
  FOREIGN KEY (idTramo)
  REFERENCES tramo(id)
);

CREATE TABLE asiento(
  id int(11) NOT NULL AUTO_INCREMENT,
  estado boolean,
  idUsuario int(11),

  PRIMARY KEY (id),
  FOREIGN KEY (idUsuario)
  REFERENCES Usuario(id)
);

#---------------------------------------------------------

USE Aterrizar;



