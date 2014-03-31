CREATE DATABASE `AterrizarDB`;

CREATE TABLE `usuarios` (
  `username` varchar(45) NOT NULL AUTO_INCREMENT,
  `password` varchar(45) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `fecha` date DEFAULT NULL,
  `codigo` varchar(45) NOT NULL,
  `cuentaValida` boolean NOT NULL,

  PRIMARY KEY (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

