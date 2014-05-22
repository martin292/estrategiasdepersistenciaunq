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
  idVuelo int(11), #Nuevo

  PRIMARY KEY (id)
  #FOREIGN KEY (idAsiento)
  #REFERENCES asiento(id)
  #FOREIGN KEY (idVuelo)
  #REFERENCES vuelo(id)
);

CREATE TABLE vuelo(
  id int(11) NOT NULL AUTO_INCREMENT,
  idAerolinea int(11), #Nuevo
  
  #Origen y Destino
  #Categoria

  PRIMARY KEY (id)
  #FOREIGN KEY (idAerolinea)
  #REFERENCES aerolinea(id)
);

CREATE TABLE asiento(
  id int(11) NOT NULL AUTO_INCREMENT,
  estado boolean,
  idUsuario int(11),
  idTramo int(11),
  
  PRIMARY KEY (id)
  #FOREIGN KEY (idUsuario)
  #REFERENCES Usuario(id)
);

CREATE TABLE aerolinea( #Nuevo
  id int(11) NOT NULL AUTO_INCREMENT,
  
  PRIMARY KEY (id)
);

CREATE TABLE categoria(
  id int(11) NOT NULL AUTO_INCREMENT,
  precio int(5),
  cat varchar(8),
  
  PRIMARY KEY (id)
);


#---------------------------------------------------------

USE Aterrizar;



