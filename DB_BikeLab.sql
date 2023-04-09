CREATE DATABASE bikelab;
Use bikelab;

CREATE TABLE provincia(
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(15) not null,
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE canton(
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) not null,
  provincia_id INT not null,
  PRIMARY KEY (id),
  KEY `fk_canton_provincia_idx` (`provincia_id`),
  CONSTRAINT `fk_canton_provincia` FOREIGN KEY (`provincia_id`) REFERENCES `provincia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE distrito(
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  canton_id INT NOT NULL,
  PRIMARY KEY (id),
  KEY `fk_distrito_canton_idx` (`canton_id`),
  CONSTRAINT `fk_distrito_canton` FOREIGN KEY (`canton_id`) REFERENCES `canton` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

Create table rol(
  id INT NOT NULL AUTO_INCREMENT,
  rol VARCHAR(15) NOT NULL, 
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE usuario(
  id INT NOT NULL AUTO_INCREMENT,
  nombre varchar(30) NOT NULL,
  apellido1 varchar(30) NOT NULL,
  apellido2 varchar(30) NOT NULL,
  telefono varchar(20),
  cedula varchar(30),
  direccion varchar(500),
  correo VARCHAR(30) NOT NULL,
  contrasenia VARCHAR(30) NOT NULL,
  rol_id INT NOT NULL DEFAULT 2,
  provincia_id INT,
  canton_id INT,
  distrito_id INT,
  PRIMARY KEY (id),
  KEY `fk_datoslogin_rol_idx` (`rol_id`),
  KEY `fk_usuario_provincia_idx` (`provincia_id`),
  KEY `fk_usuario_canton_idx` (`canton_id`),
  KEY `fk_usuario_distrito_idx` (`distrito_id`),
  CONSTRAINT `fk_Usuario_rol` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_provincia` FOREIGN KEY (`provincia_id`) REFERENCES `provincia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_canton` FOREIGN KEY (`canton_id`) REFERENCES `canton` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_distrito` FOREIGN KEY (`distrito_id`) REFERENCES `distrito` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
); 

CREATE TABLE proveedor(
 id INT NOT NULL AUTO_INCREMENT,
 nombre VARCHAR(50) NOT NULL,
 correo VARCHAR(50) NOT NULL,
 telefono int NOT NULL, 
 PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

 CREATE TABLE marca(
   id INT NOT NULL AUTO_INCREMENT,
   nombre VARCHAR(50) NOT NULL,
   PRIMARY KEY (id)
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

 CREATE TABLE familiaproducto(
   id INT NOT NULL AUTO_INCREMENT,
   familia VARCHAR(50) NOT NULL,
   detalle varchar(100),
   PRIMARY KEY (id)
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

 CREATE TABLE tipoproducto(
  id INT NOT NULL AUTO_INCREMENT,
  tipo VARCHAR(50) NOT NULL,
  detalle VARCHAR(100),
  familia_id INT NOT NULL,
  PRIMARY KEY (id),
  KEY `fk_tipo_familia_idx` (`familia_id`),
  CONSTRAINT `fk_tipo_familiaproducto` FOREIGN KEY (`familia_id`) REFERENCES `familiaproducto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

 CREATE TABLE producto(
  id INT NOT NULL AUTO_INCREMENT,
  nombre varchar(50) NOT NULL,
  modelo varchar(50),  
  talla char,
  tamanio FLOAT,
  detalle varchar(500),
  anio INT,
  precio FLOAT NOT NULL,
  stock INT NOT NULL,
  imagen varchar(50),
  tipo_id INT NOT NULL,
  marca_id INT NOT NULL,
  PRIMARY KEY (id),
  KEY `fk_producto_tipo_idx` (`tipo_id`),
  KEY `fk_producto_marca_idx` (`marca_id`),
  CONSTRAINT `fk_producto_tipoproducto` FOREIGN KEY (`tipo_id`) REFERENCES `tipoproducto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_marca` FOREIGN KEY (`marca_id`) REFERENCES `marca` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE proveedorproducto (
  proveedor_id INT NOT NULL,
  producto_id INT NOT NULL,
  PRIMARY KEY (proveedor_id,producto_id),
  KEY `fk_proveedorproducto_proveedor_idx` (`proveedor_id`),
  KEY `fk_proveedorproducto_producto_idx` (`producto_id`),
  CONSTRAINT `fk_proveedorproducto_proveedor` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_proveedorproducto_producto` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE evento(
  id INT NOT NULL AUTO_INCREMENT,
  fecha DATE NOT NULL,
  nombre varchar(50) NOT NULL,
  precio FLOAT NOT NULL,
  detalle varchar(500),
  direccion varchar(200) NOT NULL,
  stock INT NOT NULL,
  imagen varchar(50),
  tipo_id INT NOT NULL,
  provincia_id INT NOT NULL,
  canton_id INT NOT NULL,
  distrito_id INT NOT NULL,
  PRIMARY KEY (id),
  KEY `fk_evento_tipo_idx` (`tipo_id`),
  KEY `fk_evento_provincia_idx` (`provincia_id`),
  KEY `fk_evento_canton_idx` (`canton_id`),
  KEY `fk_evento_distrito_idx` (`distrito_id`),
  CONSTRAINT `fk_evento_tipoproducto` FOREIGN KEY (`tipo_id`) REFERENCES `tipoproducto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,  
  CONSTRAINT `fk_evento_provincia` FOREIGN KEY (`provincia_id`) REFERENCES `provincia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evento_canton` FOREIGN KEY (`canton_id`) REFERENCES `canton` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evento_distrito` FOREIGN KEY (`distrito_id`) REFERENCES `distrito` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE metodopago(
 id INT NOT NULL AUTO_INCREMENT,
 metodopago VARCHAR(50) NOT NULL,
 PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE carrito(
  id INT NOT NULL AUTO_INCREMENT,
  fecha DATE NOT NULL,
  cantidad INT NOT NULL,
  usuario_id INT NOT NULL,
  producto_id INT,
  evento_id INT,
  PRIMARY KEY (id,usuario_id),
  KEY `fk_conciertos_usuario_idx` (`usuario_id`),
  KEY `fk_conciertos_producto_idx` (`producto_id`),
  KEY `fk_conciertos_evento_idx` (`evento_id`),
  CONSTRAINT `fk_carrito_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,  
  CONSTRAINT `fk_carrito_producto` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_carrito_evento` FOREIGN KEY (`evento_id`) REFERENCES `evento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE carritoproducto (
  carrito_id INT NOT NULL,
  producto_id INT NOT NULL,
  PRIMARY KEY (carrito_id,producto_id),
  KEY `fk_carritoproducto_carrito_idx` (`carrito_id`),
  KEY `fk_carritoproducto_producto_idx` (`producto_id`),
  CONSTRAINT `fk_carritoproducto_carrito` FOREIGN KEY (`carrito_id`) REFERENCES `carrito` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_carritoproducto_producto` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE carritoevento (
  carrito_id INT NOT NULL,
  evento_id INT NOT NULL,
  PRIMARY KEY (carrito_id,evento_id),
  KEY `fk_carritoevento_carrito_idx` (`carrito_id`),
  KEY `fk_carritoevento_evento_idx` (`evento_id`),
  CONSTRAINT `fk_carritoevento_carrito` FOREIGN KEY (`carrito_id`) REFERENCES `carrito` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_carritoevento_evento` FOREIGN KEY (`evento_id`) REFERENCES `evento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE orden(
  id INT NOT NULL AUTO_INCREMENT,
  detalle varchar(500),
  montototal FLOAT NOT NULL,
  fecha DATE NOT NULL,
  usuario_id INT NOT NULL,
  metodo_id INT NOT NULL,
  carrito_id INT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY (usuario_id,carrito_id),
  KEY `fk_orden_usuario_idx` (`usuario_id`),
  KEY `fk_orden_metodo_idx` (`metodo_id`),
  KEY `fk_orden_carrito_idx` (`carrito_id`),
  CONSTRAINT `fk_orden_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,  
  CONSTRAINT `fk_orden_metodopago` FOREIGN KEY (`metodo_id`) REFERENCES `metodopago` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_carrito` FOREIGN KEY (`carrito_id`) REFERENCES `carrito` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
); 


/*----------------------------------------------------- INSERT -----------------------------------------------------*/

INSERT INTO `provincia` VALUES 
(1,'San José'),(2,'Alajuela'),(3,'Cartago'),(4,'Heredia'),(5,'Guanacaste'),(6,'Puntarenas'),(7,'Limón');

INSERT INTO `canton` VALUES 
(101,'San José',1),(102,'Alajuelita',1),(103,'Vázquez de Coronado',1),(104,'Acosta',1),(105,'Tibás',1),(106,'Moravia',1),(107,'Montes de Oca',1),(108,'Turrubares',1),(109,'Dota',1),
(110,'Curridabat',1),(111,'Pérez Zeledón',1),(112,'Escazú',1),(113,'León Cortés',1),(114,'Desamparados',1),(115,'Puriscal',1),(116,'Tarrazú',1),(117,'Aserrí',1),(118,'Mora',1),(119,'Goicoechea',1),
(120,'Santa Ana',1),

(201,'Alajuela',2),(202,'San Carlos',2),(203,'Zarcero',2),(204,'Sarchí',2),(205,'Upala',2),(206,'Los Chiles',2),(207,'Guatuso',2),(208,'Río Cuarto',2),(209,'San Ramón',2),
(210,'Grecia',2),(211,'San Mateo',2),(212,'Atenas',2),(213,'Naranjo',2),(214,'Palmares',2),(215,'Poás',2),(216,'Orotina',2),

(301,'Cartago',3),(302,'Paraíso',3),(303,'La Unión',3),(304,'Jiménez',3),(305,'Turrialba',3),(306,'Alvarado',3),(307,'Oreamuno',3),(308,'El Guarco',3),

(401,'Heredia',4),(402,'SARAPIQUI',4),(403,'Barva',4),(404,'Santo Domingo',4),(405,'Santa Bárbara',4),(406,'San Rafael',4),(407,'San Isidro',4),(408,'Belén',4),(409,'Flores',4),(410,'San Pablo',4),

(501,'Liberia',5),(502,'La Cruz',5),(503,'Hojancha',5),(504,'Nicoya',5),(505,'Santa Cruz',5),(506,'Bagaces',5),(507,'Carrillo',5),(508,'Cañas',5),(509,'Abangares',5),
(510,'Tilarán',5),(511,'Nandayure',5),

(601,'Puntarenas',6),(602,'Esparza',6),(603,'Buenos Aires',6),(604,'Osa',6),(605,'Quepos',6),(606,'Golfito',6),(607,'Coto Brus',6),(608,'Parrita',6),(609,'Corredores',6),
(610,'Garabito',6),(611,'Monteverde',6),(612,'Puerto Jiménez',6),

(701,'Limón',7),(702,'Pococí',7),(703,'Siquirres',7),(704,'Talamanca',7),(705,'Matina',7),(706,'Guácimo',7);

INSERT INTO `distrito` VALUES
(10101,'Carmen',101), (10102,'Merced',101), (10103,'Hospital',101), (10104,'Catedral',101), (10105,'Zapote',101), (10106,'San Francisco de Dos Ríos',101), (10107,'Uruca',101), (10108,'Mata Redonda',101), (10109,'Pavas',101), (10110,'Hatillo',101), (10111,'San Sebastián',101), (10201,'Escazú',102), (10202,'San Antonio',102), (10203,'San Rafael',102), (10301,'Desamparados',103),
(10302,'San Miguel',103), (10303,'San Juan de Dios',103), (10304,'San Rafael Arriba',103), (10305,'San Antonio',103), (10306,'Frailes',103), (10307,'Patarrá',103), (10308,'San Cristóbal',103), (10309,'Rosario',103), (10310,'Damas',103), (10311,'San Rafael Abajo',103), (10312,'Gravilias',103), (10313,'Los Guido',103), (10401,'Santiago',104), (10402,'Mercedes Sur',104), (10403,'Barbacoas',104), (10404,'Grifo Alto',104),
(10405,'San Rafael',104), (10406,'Candelarita',104), (10407,'Desamparaditos',104), (10408,'San Antonio',104), (10409,'Chires',104), (10501,'San Marcos',105), (10502,'San Lorenzo',105), (10503,'San Carlos',105), (10601,'Aserrí',106), (10602,'Tarbaca',106), (10603,'Vuelta de Jorco',106), (10604,'San Gabriel',106), (10605,'Legua',106), (10606,'Monterrey',106), (10607,'Salitrillos',106), (10701,'Colón',107),
(10702,'Guayabo',107), (10703,'Tabarcia',107), (10704,'Piedras Negras',107), (10705,'Picagres',107), (10706,'Jaris',107), (10707,'Quitirrisí',107), (10801,'Guadalupe',108), (10802,'San Francisco',108), (10803,'Calle Blancos',108), (10804,'Mata de Plátano',108), (10805,'Ipís',108), (10806,'Rancho Redondo',108), (10807,'Purral',108), (10901,'Santa Ana',109), (10902,'Salitral',109),
(10903,'Pozos',109), (10904,'Uruca',109), (10905,'Piedades',109), (10906,'Brasil',109), (11001,'Alajuelita',110), (11002,'San Josecito',110), (11003,'San Antonio',110), (11004,'Concepción',110), (11005,'San Felipe',110), (11101,'San Isidro',111), (11102,'San Rafael',111), (11103,'Dulce Nombre de Jesús',111), (11104,'Patalillo',111), (11105,'Cascajal',111), (11201,'San Ignacio',112),
(11202,'Guaitil',112), (11203,'Palmichal',112), (11204,'Cangrejal',112), (11205,'Sabanillas',112), (11301,'San Juan',113), (11302,'Cinco Esquinas',113), (11303,'Anselmo Llorente',113), (11304,'León XIII',113), (11305,'Colima',113), (11401,'San Vicente',114), (11402,'San Jerónimo',114), (11403,'La Trinidad',114), (11501,'San Pedro',115), (11502,'Sabanilla',115), (11503,'Mercedes',115),
(11504,'San Rafael',115), (11601,'San Pablo',116), (11602,'San Pedro',116), (11603,'San Juan de Mata',116), (11604,'San Luis',116), (11605,'Carara',116), (11701,'Santa María',117), (11702,'Jardín',117), (11703,'Copey',117), (11801,'Curridabat',118), (11802,'Granadilla',118), (11803,'Sánchez',118), (11804,'Tirrases',118), (11901,'San Isidro de El General',119), (11902,'El General',119),
(11903,'Daniel Flores',119), (11904,'Rivas',119), (11905,'San Pedro',119), (11906,'Platanares',119), (11907,'Pejibaye',119), (11908,'Cajón',119), (11909,'Barú',119), (11910,'Río Nuevo',119), (11911,'Páramo',119), (11912,'La Amistad',119), (12001,'San Pablo',120), (12002,'San Andrés',120), (12003,'Llano Bonito',120), (12004,'San Isidro',120), (12005,'Santa Cruz',120), (12006,'San Antonio',120),

(20101,'Alajuela',201), (20102,'San José',201), (20103,'Carrizal',201), (20104,'San Antonio',201), (20105,'Guácima',201), (20106,'San Isidro',201), (20107,'Sabanilla',201), (20108,'San Rafael',201), (20109,'Río Segundo',201), (20110,'Desamparados',201), (20111,'Turrúcares',201), (20112,'Tambor',201), (20113,'Garita',201), (20114,'Sarapiquí',201), (20201,'San Ramón',202),
(20202,'Santiago',202), (20203,'San Juan',202), (20204,'Piedades Norte',202), (20205,'Piedades Sur',202), (20206,'San Rafael',202), (20207,'San Isidro',202), (20208,'Ángeles',202), (20209,'Alfaro',202), (20210,'Volio',202), (20211,'Concepción',202), (20212,'Zapotal',202), (20213,'Peñas Blancas',202), (20214,'San Lorenzo',202), (20301,'Grecia',203),
(20302,'San Isidro',203), (20303,'San José',203), (20304,'San Roque',203), (20305,'Tacares',203), (20307,'Puente de Piedra',203), (20308,'Bolívar',203), (20401,'San Mateo',204), (20402,'Desmonte',204), (20403,'Jesús María',204), (20404,'Labrador',204), (20501,'Atenas',205), (20502,'Jesús',205), (20503,'Mercedes',205), (20504,'San Isidro',205), (20505,'Concepción',205),
(20506,'San José',205), (20507,'Santa Eulalia',205), (20508,'Escobal',205), (20601,'Naranjo',206), (20602,'San Miguel',206), (20603,'San José',206), (20604,'Cirrí Sur',206), (20605,'San Jerónimo',206), (20606,'San Juan',206), (20607,'El Rosario',206), (20608,'Palmitos',206), (20701,'Palmares',207), (20702,'Zaragoza',207), (20703,'Buenos Aires',207), (20704,'Santiago',207),
(20705,'Candelaria',207), (20706,'Esquipulas',207), (20707,'La Granja',207), (20801,'San Pedro',208), (20802,'San Juan',208), (20803,'San Rafael',208), (20804,'Carrillos',208), (20805,'Sabana Redonda',208), (20901,'Orotina',209), (20902,'El Mastate',209), (20903,'Hacienda Vieja',209), (20904,'Coyolar',209), (20905,'La Ceiba',209), (21001,'Quesada',210), (21002,'Florencia',210),
(21003,'Buenavista',210), (21004,'Aguas Zarcas',210), (21005,'Venecia',210), (21006,'Pital',210), (21007,'La Fortuna',210), (21008,'La Tigra',210), (21009,'La Palmera',210), (21010,'Venado',210), (21011,'Cutris',210), (21012,'Monterrey',210), (21013,'Pocosol',210), (21101,'Zarcero',211), (21102,'Laguna',211), (21103,'Tapesco',211), (21104,'Guadalupe',211),
(21105,'Palmira',211), (21106,'Zapote',211), (21107,'Brisas',211), (21201,'Sarchí Norte',212), (21202,'Sarchí Sur',212), (21203,'Toro Amarillo',212), (21204,'San Pedro',212), (21205,'Rodríguez',212), (21301,'Upala',213), (21302,'Aguas Claras',213), (21303,'San José',213), (21304,'Bijagua',213), (21305,'Delicias',213), (21306,'Dos Ríos',213), (21307,'Yolillal',213),
(21308,'Canalete',213), (21401,'Los Chiles',214), (21402,'Caño Negro',214), (21403,'El Amparo',214), (21404,'San Jorge',214), (21501,'San Rafael',215), (21502,'Buenavista',215), (21503,'Cote',215), (21504,'Katira',215), (21601,'Río Cuarto',216), (21602,'Santa Rita',216), (21603,'Santa Isabel',216),

(30101,'Oriental',301), (30102,'Occidental',301), (30103,'Carmen',301), (30104,'San Nicolás',301), (30105,'Aguacaliente',301), (30106,'Guadalupe',301), (30107,'Corralillo',301), (30108,'Tierra Blanca',301), (30109,'Dulce Nombre',301), (30110,'Llano Grande',301), (30111,'Quebradilla',301), (30201,'Paraíso',302), (30202,'Santiago',302), (30203,'Orosi',302), (30204,'Cachí',302),
(30205,'Llanos de Santa Lucía',302), (30206,'Birrisito',302), (30301,'Tres Ríos',303), (30302,'San Diego',303), (30303,'San Juan',303), (30304,'San Rafael',303), (30305,'Concepción',303), (30306,'Dulce Nombre',303), (30307,'San Ramón',303), (30308,'Río Azul',303), (30401,'Juan Viñas',304), (30402,'Tucurrique',304), (30403,'Pejibaye',304), (30404,'La Victoria',304), (30501,'Turrialba',305),
(30502,'La Suiza',305), (30503,'Peralta',305), (30504,'Santa Cruz',305), (30505,'Santa Teresita',305), (30506,'Pavones',305), (30507,'Tuis',305), (30508,'Tayutic',305), (30509,'Santa Rosa',305), (30510,'Tres Equis',305), (30511,'La Isabel',305), (30512,'Chirripó',305), (30601,'Pacayas',306), (30602,'Cervantes',306), (30603,'Capellades',306), (30701,'San Rafael',307),
(30702,'Cot',307), (30703,'Potrero Cerrado',307), (30704,'Cipreses',307), (30705,'Santa Rosa',307), (30801,'El Tejar',308), (30802,'San Isidro',308), (30803,'Tobosi',308), (30804,'Patio de Agua',308),

(40101,'Heredia',401), (40102,'Mercedes',401), (40103,'San Francisco',401), (40104,'Ulloa',401), (40105,'Varablanca',401), (40201,'Barva',402), (40202,'San Pedro',402), (40203,'San Pablo',402), (40204,'San Roque',402), (40205,'Santa Lucía',402), (40206,'San José de la Montaña',402), (40301,'Santo Domingo',403), (40302,'San Vicente',403), (40303,'San Miguel',403), (40304,'Paracito',403),
(40305,'Santo Tomás',403), (40306,'Santa Rosa',403), (40307,'Tures',403), (40308,'Pará',403), (40401,'Santa Bárbara',404), (40402,'San Pedro',404), (40403,'San Juan',404), (40404,'Jesús',404), (40405,'Santo Domingo',404), (40406,'Purabá',404), (40501,'San Rafael',405), (40502,'San Josecito',405), (40503,'Santiago',405), (40504,'Ángeles',405), (40505,'Concepción',405),
(40601,'San Isidro',406), (40602,'San José',406), (40603,'Concepción',406), (40604,'San Francisco',406), (40701,'San Antonio',407), (40702,'La Ribera',407), (40703,'La Asunción',407), (40801,'San Joaquín',408), (40802,'Barrantes',408), (40803,'Llorente',408), (40901,'San Pablo',409), (40902,'Rincón de Sabanilla',409), (41001,'Puerto Viejo',410), (41002,'La Virgen',410), (41003,'Las Horquetas',410),
(41004,'Llanuras del Gaspar',410),(41005,'Cureña',410),

(50101,'Liberia',501), (50102,'Cañas Dulces',501), (50103,'Mayorga',501), (50104,'Nacascolo',501), (50105,'Curubandé',501), (50201,'Nicoya',502), (50202,'Mansión',502), (50203,'San Antonio',502), (50204,'Quebrada Honda',502), (50205,'Sámara',502), (50206,'Nosara',502), (50207,'Belén de Nosarita',502), (50301,'Santa Cruz',503), (50302,'Bolsón',503), (50303,'Veintisiete de Abril',503),
(50304,'Tempate',503), (50305,'Cartagena',503), (50306,'Cuajiniquil',503), (50307,'Diriá',503), (50308,'Cabo Velas',503), (50309,'Tamarindo',503), (50401,'Bagaces',504), (50402,'La Fortuna',504), (50403,'Mogote',504), (50404,'Río Naranjo',504), (50501,'Filadelfia',505), (50502,'Palmira',505), (50503,'Sardinal',505), (50504,'Belén',505), (50601,'Cañas',506), (50602,'Palmira',506), (50603,'San Miguel',506),
(50604,'Bebedero',506), (50605,'Porozal',506), (50701,'Las Juntas',507), (50702,'Sierra',507), (50703,'San Juan',507), (50704,'Colorado',507), (50801,'Tilarán',508), (50802,'Quebrada Grande',508), (50803,'Tronadora',508), (50804,'Santa Rosa',508), (50805,'Líbano',508), (50806,'Tierras Morenas',508), (50807,'Arenal',508), (50808,'Cabeceras',508), (50901,'Carmona',509),
(50902,'Santa Rita',509), (50903,'Zapotal',509), (50904,'San Pablo',509), (50905,'Porvenir',509), (50906,'Bejuco',509), (51001,'La Cruz',510), (51002,'Santa Cecilia',510), (51003,'La Garita',510), (51004,'Santa Elena',510), (51101,'Hojancha',511), (51102,'Monte Romo',511), (51103,'Puerto Carrillo',511), (51104,'Huacas',511), (51105,'Matambú',511), (60101,'Puntarenas',601),
(60102,'Pitahaya',601), (60103,'Chomes',601), (60104,'Lepanto',601), (60105,'Paquera',601), (60106,'Manzanillo',601), (60107,'Guacimal',601), (60108,'Barranca',601), (60109,'Monte Verde',601), (60110,'Isla del Coco',601), (60111,'Cóbano',601), (60112,'Chacarita',601), (60113,'Chira',601), (60114,'Acapulco',601), (60115,'El Roble',601), (60116,'Arancibia',601),
(60201,'Espíritu Santo',602), (60202,'San Juan Grande',602), (60203,'Macacona',602), (60204,'San Rafael',602), (60205,'San Jerónimo',602), (60206,'Caldera',602), (60301,'Buenos Aires',603), (60302,'Volcán',603), (60303,'Potrero Grande',603), (60304,'Boruca',603), (60305,'Pilas',603), (60306,'Colinas',603), (60307,'Chánguena',603), (60308,'Biolley',603), (60309,'Brunka',603),
(60401,'Miramar',604), (60402,'La Unión',604), (60403,'San Isidro',604), (60501,'Puerto Cortés',605), (60502,'Palmar',605), (60503,'Sierpe',605), (60504,'Bahía Ballena',605), (60505,'Piedras Blancas',605), (60506,'Bahía Drake',605), (60601,'Quepos',606), (60602,'Savegre',606), (60603,'Naranjito',606), (60701,'Golfito',607), (60702,'Puerto Jiménez',607), (60703,'Guaycará',607),
(60704,'Pavón',607),(60801,'San Vito',608), (60802,'Sabalito',608), (60803,'Aguabuena',608), (60804,'Limoncito',608), (60805,'Pittier',608), (60806,'Gutiérrez Braun',608), (60901,'Parrita',609), (61001,'Corredor',610), (61002,'La Cuesta',610), (61003,'Canoas',610), (61004,'Laurel',610), (61101,'Jacó',611), (61102,'Tárcoles',611), (61103,'Lagunillas',611),

(70101,'Limón',701), (70102,'Valle La Estrella',701), (70103,'Río Blanco',701), (70104,'Matama',701), (70201,'Guápiles',702), (70202,'Jiménez',702), (70203,'Rita',702), (70204,'Roxana',702), (70205,'Cariari',702), (70206,'Colorado',702), (70207,'La Colonia',702), (70301,'Siquirres',703), (70302,'Pacuarito',703), (70303,'Florida',703), (70304,'Germania',703),
(70305,'El Cairo',703), (70306,'Alegría',703), (70307,'Reventazón',703), (70401,'Bratsi',704), (70402,'Sixaola',704), (70403,'Cahuita',704), (70404,'Telire',704), (70501,'Matina',705), (70502,'Batán',705), (70503,'Carrandi',705), (70601,'Guácimo',706), (70602,'Mercedes',706), (70603,'Pocora',706), (70604,'Río Jiménez',706), (70605,'Duacarí',706);


INSERT INTO `rol` VALUES (1,'Admin'),(2,'User');


INSERT INTO usuario (nombre, apellido1, apellido2, telefono, cedula, direccion, correo, contrasenia, rol_id, provincia_id, canton_id, distrito_id)
VALUES ('Juan', 'Perez', 'Gomez', '123456789', '1234567890', 'Calle 1 #123', 'juanperez@email.com', 'password', 2, 1, 101, 10101),
       ('Maria', 'Gonzalez', 'Rodriguez', '987654321', '0987654321', 'Calle 2 #456', 'mariagonzalez@email.com', '123456', 2, 2, 201, 20101),
       ('Jorge', 'Hernández', 'Araya', '22223333', '0987654321', '200 metros sur Hotel Villas de la Colina', 'jorgeh@email.com', 'pass123', 2, 3, 301, 30101),
       ('Luis', 'Mora', 'Alvarado', '66665555', '303330333', 'Costado este de la Iglesia, Casa color amarilla', 'luism@email.com', '123456', 2, 4, 401, 40101);

INSERT INTO proveedor VALUES (1, 'Bicimax', 'bicimax@email.com', 12345678),(2, 'Cyclomundo', 'cyclomundo@email.com', 23456789),(3, 'Pedaltech', 'pedaltech@email.com', 34567890),(4, 'Bikepro', 'bikepro@email.com', 45678901),
(5, 'Accesobike', 'accesobike@email.com', 56789012),(6, 'Velozone', 'velozone@email.com', 67890123),(7, 'Bicicentro', 'bicicentro@email.com', 78901234),(8, 'Cyclotech', 'cyclotech@email.com', 89012345),
(9, 'Biciexpress', 'biciexpress@email.com', 90123456),(10, 'Accesoriosbike', 'accesoriosbike@email.com', 12345678),(11, 'Pedalpower', 'pedalpower@email.com', 23456789),(12, 'Veloarte', 'veloarte@email.com', 34567890),
(13, 'Biciworld', 'biciworld@email.com', 45678901),(14, 'Cycloworks', 'cycloworks@email.com', 56789012),(15, 'Bikestyle', 'bikestyle@email.com', 67890123),(16, 'Accesovelo', 'accesovelo@email.com', 78901234),
(17, 'Pedalmaster', 'pedalmaster@email.com', 89012345),(18, 'Velopro', 'velopro@email.com', 90123456),(19, 'Biciclismo', 'biciclismo@email.com', 12345678),(20, 'Cyclotrek', 'cyclotrek@email.com', 23456789);

INSERT INTO `marca` VALUES (1, 'Giant'),(2, 'Trek'),(3, 'Specialized'),(4, 'Cannondale'),(5, 'Scott'),(6, 'Santa Cruz'),(7, 'Bianchi'),(8, 'Colnago'),(9, 'Pinarello'),
 (10, 'Canyon'),(11, 'Orbea'),(12, 'Merida'),(13, 'Kona'),(14, 'Cube'),(15, 'Fuji'),(16, 'Raleigh'),(17, 'Diamondback'),(18, 'Felt'),(19, 'BMC'),(20, 'Cervelo'); 

INSERT INTO `familiaproducto` VALUES
(1, 'Bicicletas', 'Bicicletas de distintos tipos'),
(2, 'Accesorios', 'Accesorios para todo tipo de bicicletas'),
(3, 'Componentes', 'Componentes o repuestos para bicicletas'),
(4, 'Vestimenta', 'Indumentaria para todo tipo de ciclista');

INSERT INTO `tipoproducto` VALUES
(1, 'MTB', 'Ideal para terrenos montañosos', 1),
(2, 'RUTA', 'Perfecta para viajes largos', 1),
(3, 'EBIKE', 'Bicicletas de montaña con asistencia eléctrica al pedaleo', 1),
(4, 'DOWNHILL', 'Bicicletas para competir en los senderos más técnicos y rápidos', 1),
(5, 'GRAVEL', 'Bicicletas diseñadas para competiciones de ciclocross', 1),
(6, 'BMX', 'Ideal para saltos y acrobacias', 1),
(7, 'KIDS', 'Bicicleta de tamaño reducido para que los niños', 1),
(11, 'Luces', 'Recargables y de alta luminosidad', 2),
(12, 'Bolsas de viaje', 'Lleva todo lo que necesitas contigo', 2),
(13, 'Infladores', 'Mantén tus neumáticos en óptimas condiciones', 2),
(14, 'Porta botella', 'Hidratación al alcance de tus manos', 2),
(15, 'Soporte para celular', 'Accesorio para bicicletas que permite sostener un celular mientras se anda en la bicicleta', 2),
(16, 'Candados', 'Accesorio para bicicletas que permite asegurar la bicicleta para evitar robos', 2),
(17, 'Bombas de aire', 'Accesorio para bicicletas que permite inflar las ruedas de la bicicleta', 2),
(18, 'Portaequipajes', 'Soporte para transportar objetos en la bicicleta', 2),
(19, 'Timbre', 'Campanilla para señalizar al peatón', 2),
(20, 'Cargador de celular', 'Dispositivo para cargar el celular mientras se pedalea', 2),
(21, 'Espejo retrovisor', 'Espejo para tener visión de la parte trasera', 2),
(22, 'Neumáticos MTB', 'Con dibujo agresivo para mayor tracción en terrenos difíciles', 3),
(23, 'Neumáticos de Ruta', 'Con banda de rodadura lisa para mayor eficiencia en pavimento', 3),
(24, 'Sillín de Gel', 'Confortable y suave en terrenos largos', 3),
(25, 'Frenos de disco', 'Sistema de frenado para bicicletas', 3),
(26, 'Cadenas', 'Componente de transmisión de la bicicleta', 3),
(27, 'Desviadores', 'Componente para cambiar de marcha en la bicicleta', 3),
(28, 'Manubrios', 'Parte de la bicicleta que se utiliza para guiar', 3),
(29, 'Pedales', 'Componente de la bicicleta que se utiliza para pedalear', 3),
(30, 'Ruedas', 'Componente para el movimiento de la bicicleta', 3),
(31, 'Asientos', 'Parte de la bicicleta donde se sienta el ciclista', 3),
(32, 'Amortiguadores', 'Componente para la absorción de impactos en la bicicleta', 3),
(33, 'Camiseta', 'Camisetas técnicas para ciclistas', 4),
(34, 'Short', 'Shorts para ciclistas', 4),
(35, 'Medias', 'Medias deportivas para ciclistas', 4),
(36, 'Guantes', 'Guantes deportivos para ciclistas', 4),
(37, 'Pantalón', 'Pantalones para ciclistas', 4),
(38, 'Licra', 'Licra deportivas para ciclistas', 4),
(39, 'Gafas', 'Gafas deportivas para ciclistas', 4),
(40, 'Zapatos de MTB', 'Con suela de agarre para terrenos difíciles', 4),
(41, 'Zapatos de Ruta', 'Con suela rígida para mayor eficiencia en pedaleo', 4),
(42, 'Casco de MTB', 'Con visera y mayor protección en la parte trasera', 4),
(43, 'Casco de Ruta', 'Con aerodinámica optimizada para mayor velocidad', 4);

INSERT INTO `producto` VALUES
(1,'Fuji Nevada','Nevada','M',27.5,'Un elemento básico en la línea de bicicletas de montaña Fuji, disponible en tamaños de rueda de 29″ o 27,5″, la Nevada combina un cuadro rígido probado y verdadero y componentes sólidos para llevar tus aventuras todoterreno al siguiente nivel.',2023,250000,5,NULL,1,15),
(2,'GIANT XTC SLR 2 2022','XTC SLR 2','S',29,'Perfecto como su primera bicicleta de montaña, el cuadro de aluminio de grado ALUXX es liviano, capaz y duradero Versátil. La geometría cómoda pero orientada al rendimiento de Tempt le da la versatilidad tanto para los viajes alrededor del campus como para los paseos fuera de la carretera.',2022,520000,2,NULL,1,1);

INSERT INTO `proveedorProducto` VALUES (1,1),(2,2);

INSERT INTO `evento` VALUES 
(1,'2023-10-04','Vuelta a la Península de Nicoya',94200,'Las mejores playas de Guanacaste en un solo ride!, El reto está en vos!, 4 de Noviembre, Ruta 120kms 2000m ASC. ACUM., Ruta 50kms 900m ASC. ACUM., Ruta 25kms 600m ASC. ACUM.','Nicoya Crentro',400,NULL,1,5,502,50201),
(2,'2023-06-18','Recreativa Atenas',13000,'No se lo pierdan! La inscripción incluye: Desayuno, Hidratación, Asitencia mecánica (Te lavamos la bici!), Masaje de descarga muscular, Rifas, Premios, Parqueo','Liceo de Atenas',200,NULL,1,2,205,20501);

INSERT INTO metodopago VALUES 
(1, 'Tarjeta de crédito'),(2, 'Tarjeta de débito'),(3, 'PayPal'),(4, 'Transferencia bancaria'),(5, 'Cheque'),(6, 'Efectivo'),(7, 'SINPE móvil'); 


