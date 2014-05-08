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

/*

| Field              | Type             | Null | Key | Default | Extra          |
+--------------------+------------------+------+-----+---------+----------------+
| id                 | int(11) unsigned | NO   | PRI | NULL    | auto_increment |
| nombre             | varchar(20)      | YES  |     | NULL    |                |
| apellido           | varchar(20)      | YES  |     | NULL    |                |
| nombreUsuario      | varchar(20)      | YES  |     | NULL    |                |
| password           | varchar(20)      | YES  |     | NULL    |                |
| email              | varchar(20)      | YES  |     | NULL    |                |
| codigoDeValidacion | varchar(20)      | YES  |     | NULL    |                |
| fechaNacimiento    | date             | YES  |     | NULL    |                |
| cuentaValida       | tinyint(1)       | YES  |     | NULL    |                |
+--------------------+------------------+------+-----+---------+----------------
+-----------+------------+------+-----+---------+-------+
| Field     | Type       | Null | Key | Default | Extra |
+-----------+------------+------+-----+---------+-------+
| id        | int(11)    | NO   | PRI | 0       |       |
| estado    | tinyint(1) | YES  |     | NULL    |       |
| idUsuario | int(11)    | YES  |     | NULL    |       |
+-----------+------------+------+-----+---------+-------+
+-----------+------------------+------+-----+---------+----------------+
| Field     | Type             | Null | Key | Default | Extra          |
+-----------+------------------+------+-----+---------+----------------+
| id        | int(11) unsigned | NO   | PRI | NULL    | auto_increment |
| llegada   | date             | YES  |     | NULL    |                |
| salida    | date             | YES  |     | NULL    |                |
| idAsiento | int(11)          | YES  |     | NULL    |                |
+-----------+------------------+------+-----+---------+----------------+
| Field   | Type    | Null | Key | Default | Extra |
+---------+---------+------+-----+---------+-------+
| id      | int(11) | NO   | PRI | 0       |       |
| idVuelo | int(11) | YES  |     | NULL    |      

mysql> describe vuelo;
+---------+---------+------+-----+---------+-------+
| Field   | Type    | Null | Key | Default | Extra |
+---------+---------+------+-----+---------+-------+
| id      | int(11) | NO   | PRI | 0       |       |
| idTramo | int(11) | YES  |     | NULL    |       |
+---------+---------+------+-----+---------+-------+
  */








