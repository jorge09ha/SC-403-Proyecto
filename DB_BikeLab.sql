CREATE DATABASE bikeLab;

Use bikeLab;

Create table role(
 idRole INT NOT NULL AUTO_INCREMENT,
 role VARCHAR(15) NOT NULL, 
 PRIMARY KEY (idRole)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `role` VALUES (1,'Admin'),(2,'User');

CREATE TABLE datosLogin (
  idLogin INT NOT NULL AUTO_INCREMENT,
  correoElectronico VARCHAR(30) NOT NULL,
  contrasenia VARCHAR(30) NOT NULL,
  idRole INT NOT NULL,
  PRIMARY KEY (idLogin),
CONSTRAINT `fk_datosLogin_role` FOREIGN KEY (`idRole`) REFERENCES `role` (`idRole`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `datosLogin` VALUES 
(1,'admin@email.com','admin123',1),(2,'jorgeh@email.com','pass123',2),(3,'luism@email.com','pass123',2);

CREATE TABLE roleDatosLogin (
  idRoleDatosLogin INT NOT NULL AUTO_INCREMENT,
  idRole INT NOT NULL,
  idLogin INT NOT NULL,
  PRIMARY KEY (idRoleDatosLogin),
CONSTRAINT `fk_roleDatosLogin_role` FOREIGN KEY (`idRole`) REFERENCES `role` (`idRole`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `fk_roleDatosLogin_datosLogin` FOREIGN KEY (`idlogin`) REFERENCES `datosLogin` (`idlogin`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `roleDatosLogin` VALUES (1,1,1),(2,2,2);
   
CREATE TABLE provincia(
idProvincia INT(11) NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50) not null,
PRIMARY KEY (idProvincia)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `provincia` VALUES 
(1,'San José'),(2,'Alajuela'),(3,'Cartago'),(4,'Heredia'),(5,'Guanacaste'),(6,'Puntarenas'),(7,'Limón');

CREATE TABLE canton(
idCanton INT(11) NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50) not null,
idProvincia INT not null,
PRIMARY KEY (idCanton),
CONSTRAINT `fk_canton_Provincia` FOREIGN KEY (`idProvincia`) REFERENCES `Provincia` (`idProvincia`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

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

CREATE TABLE distrito(
idDistrito INT(30) NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50) not null,
idCanton INT not null,
PRIMARY KEY (idDistrito),
CONSTRAINT `fk_Distrito_Canton` FOREIGN KEY (`idCanton`) REFERENCES `canton` (`idCanton`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `distrito` VALUES
(1,'El Carmen',101),(2,'Merced',101),(3,'Hospital',101),(4,'Catedral',101),(5,'Zapote',101),(6,'San Francisco de Dos Ríos',101),(7,'Uruca',101),(8,'Mata Redonda',101),(9,'Pavas',101),
(10,'Hatillo',101),(11,'San Sebastián',101),(12,'Escazú',112),(13,'San Antonio',112),(14,'San Rafael',112),(15,'Desamparados',114),(16,'San Miguel',114),(17,'San Juan de Dios',114),(18,'San Rafael Arriba',114),(19,'San Antonio',114),
(20,'Frailes',114),(21,'Patarrá',114),(22,'San Cristóbal',114),(23,'Rosario',114),(24,'Damas',114),(25,'San Rafael Abajo',114),(26,'Gravilias',114),(27,'Los Guido',114),(28,'Santiago',115),(29,'Mercedes Sur',115),
(30,'Barbacoas',115),(31,'Grifo Alto',115),(32,'San Rafael',115),(33,'Candelarita',115),(34,'Desamparaditos',115),(35,'San Antonio',115),(36,'Chires',115),(37,'San Marcos',116),(38,'San Lorenzo',116),(39,'San Carlos',116),
(40,'Aserrí',117),(41,'Tarbaca',117),(42,'Vuelta de Jorco',117),(43,'San Gabriel',117),(44,'Legua',117),(45,'Monterrey',117),(46,'Salitrillos',117),(47,'Colón',118),(48,'Guayabo',118),(49,'Tabarcia',118),
(50,'Piedras Negras',118),(51,'Picagres',118),(52,'Guadalupe',119),(53,'San Francisco',119),(54,'Calle Blancos',119),(55,'Mata de Plátano',119),(56,'Ipís',119),(57,'Rancho Redondo',119),(58,'Purral',119),(59,'Santa Ana',120),
(60,'Salitral',120),(61,'Pozos',120),(62,'Uruca',120),(63,'Piedades',120),(64,'Brasil',120),(65,'Alajuelita',102),(66,'San Josecito',102),(67,'San Antonio',102),(68,'Concepción',102),(69,'San Felipe',102),
(70,'San Isidro',103),(71,'San Rafael',103),(72,'Dulce Nombre de Jesús',103),(73,'Patalillo',103),(74,'Cascajal',103),(75,'San Ignacio',104),(76,'Guaitil',104),(77,'Palmichal',104),(78,'Cangrejal',104),(79,'Sabanillas',104),
(80,'San Juan',105),(81,'Cinco Esquinas',105),(82,'Anselmo Llorente',105),(83,'León XIII',105),(84,'Colima',105),(85,'San Vicente',106),(86,'San Jerónimo',106),(87,'Trinidad',106),(88,'San Pedro',107),(89,'Sabanilla',107),
(90,'Mercedes',107),(91,'San Rafael',107),(92,'San Pablo',108),(93,'San Pedro',108),(94,'San Juan de Mata',108),(95,'San Luis',108),(96,'Carara',108),(97,'Santa María',109),(98,'Jardín',109),(99,'Copey',109),
(100,'Curridabat',110),(101,'Granadilla',110),(102,'Sánchez',110),(103,'Tirrases',110),(104,'San Isidro del General',111),(105,'General',111),(106,'Daniel Flores',111),(107,'Rivas',111),(108,'San Pedro',111),(109,'Platanares',111),
(110,'Pejibaye',111),(111,'Cajón',111),(112,'Barú',111),(113,'Río Nuevo',111),(114,'Páramo',111),(115,'San Pablo',113),(116,'San Andrés',113),(117,'Llano Bonito',113),(118,'San Isidro',113),(119,'Santa Cruz',113),
(120,'San Antonio',113),

(121,'Alajuela',201),(122,'San José',201),(123,'Carrizal',201),(124,'San Antonio',201),(125,'Guácima',201),(126,'San Isidro',201),(127,'Sabanilla',201),(128,'San Rafael',201),(129,'Río Segundo',201),
(130,'Desamparados',201),(131,'Turrúcares',201),(132,'Tambor',201),(133,'La Garita',201),(134,'Sarapiquí',201),(135,'San Ramón',209),(136,'Santiago',209),(137,'San Juan',209),(138,'Piedades Norte',209),(139,'Piedades Sur',209),
(140,'San Rafael',209),(141,'San Isidro',209),(142,'Ángeles',209),(143,'Alfaro',209),(144,'Volio',209),(145,'Concepción',209),(146,'Zapotal',209),(147,'Peñas Blancas',209),(148,'San Lorenzo',209),(149,'Grecia',210),
(150,'San Isidro',210),(151,'San José',210),(152,'San Roque',210),(153,'Tacares',210),(154,'Puente de Piedra',210),(155,'Bolívar',210),(156,'San Mateo',211),(157,'Desmonte',211),(158,'Jesús María',211),(159,'Labrador',211),
(160,'Atenas',212),(161,'Jesús',212),(162,'Mercedes',212),(163,'San Isidro',212),(164,'Concepción',212),(165,'San José',212),(166,'Santa Eulalia',212),(167,'Escobal',212),(168,'Naranjo',213),(169,'San Miguel',213),
(170,'San José',213),(171,'Cirrí Sur',213),(172,'San Jerónimo',213),(173,'San Juan',213),(174,'El Rosario',213),(175,'Palmitos',213),(176,'Palmares',214),(177,'Zaragoza',214),(178,'Buenos Aires',214),(179,'Santiago',214),
(180,'Candelaria',214),(181,'Esquipulas',214),(182,'La Granja',214),(183,'San Pedro',215),(184,'San Juan',215),(185,'San Rafael',215),(186,'Carrillos',215),(187,'Sabana Redonda',215),(188,'Orotina',216),(189,'El Mastate',216),
(190,'Hacienda Vieja',216),(191,'Coyolar',216),(192,'La Ceiba',216),(193,'Quesada',202),(194,'Florencia',202),(195,'Buenavista',202),(196,'Aguas Zarcas',202),(197,'Venecia',202),(198,'Pital',202),(199,'La Fortuna',202),
(200,'La Tigra',202),(201,'La Palmera',202),(202,'Venado',202),(203,'Cutris',202),(204,'Monterrey',202),(205,'Pocosol',202),(206,'Zarcero',203),(207,'Laguna',203),(208,'Tapesco',203),(209,'Guadalupe',203),
(210,'Palmira',203),(211,'Zapote',203),(212,'Brisas',203),(213,'Sarchí Norte',204),(214,'Sarchí Sur',204),(215,'Toro Amarillo',204),(216,'San Pedro',204),(217,'Rodríguez',204),(218,'Upala',205),(219,'Aguas Claras',205),
(220,'San José (Pizote)',205),(221,'Bijagua',205),(222,'Delicias',205),(223,'Dos Ríos',205),(224,'Yolillal',205),(225,'Canalete',205),(226,'Los Chiles',206),(227,'Caño Negro',206),(228,'El Amparo',206),(229,'San Jorge',206),
(230,'San Rafael',207),(231,'Buenavista',207),(232,'Cote',207),(233,'Katira',207),(234,'Río Cuarto',208),(235,'Santa Rita',208),(236,'Santa Isabel',208),

(237,'Oriental',301),(238,'Occidental',301),(239,'Carmen',301),
(240,'San Nicolás',301),(241,'Aguacaliente (San Francisco)',301),(242,'Guadalupe (Arenilla)',301),(243,'Corralillo',301),(244,'Tierra Blanca',301),(245,'Dulce Nombre',301),(246,'Llano Grande',301),(247,'Quebradilla',301),(248,'Paraíso',302),(249,'Santiago',302),
(250,'Orosi',302),(251,'Cachí',302),(252,'Llanos de Santa Lucía',302),(253,'Tres Ríos',303),(254,'San Diego',303),(255,'San Juan',303),(256,'San Rafael',303),(257,'Concepción',303),(258,'Dulce Nombre',303),(259,'San Ramón',303),
(260,'Río Azul',303),(261,'Juan Viñas',304),(262,'Tucurrique',304),(263,'Pejibaye',304),(264,'Turrialba',305),(265,'La Suiza',305),(266,'Peralta',305),(267,'Santa Cruz',305),(268,'Santa Teresita',305),(269,'Pavones',305),
(270,'Tuis',305),(271,'Tayutic',305),(272,'Santa Rosa',305),(273,'Tres Equis',305),(274,'La Isabel',305),(275,'Chirripó',305),(276,'Pacayas',306),(277,'Cervantes',306),(278,'Capellades',306),(279,'San Rafael',307),
(280,'Cot',307),(281,'Potrero Cerrado',307),(282,'Cipreses',307),(283,'Santa Rosa',307),(284,'Tejar',308),(285,'San Isidro',308),(286,'Tobosi',308),(287,'Patio de Agua',308),

(288,'Heredia',401),(289,'Mercedes',401),
(290,'San Francisco',401),(291,'Ulloa',401),(292,'Varablanca',401),(293,'Barva',403),(294,'San Pedro',403),(295,'San Pablo',403),(296,'San Roque',403),(297,'Santa Lucía',403),(298,'San José de la Montaña',403),(299,'Santo Domingo',404),
(300,'San Vicente',404),(301,'San Miguel',404),(302,'Paracito',404),(303,'Santo Tomás',404),(304,'Santa Rosa',404),(305,'Tures',404),(306,'Pará',404),(307,'Santa Bárbara',405),(308,'San Pedro',405),(309,'San Juan',405),
(310,'Jesús',405),(311,'Santo Domingo',405),(312,'Purabá',405),(313,'San Rafael',406),(314,'San Josecito',406),(315,'Santiago',406),(316,'Ángeles',406),(317,'Concepción',406),(318,'San Isidro',407),(319,'San José',407),
(320,'Concepción',407),(321,'San Francisco',407),(322,'San Antonio',408),(323,'La Ribera',408),(324,'La Asunción',408),(325,'San Joaquín',409),(326,'Barrantes',409),(327,'Llorente',409),(328,'San Pablo',410),(329,'Rincón de Sabanilla',410),
(330,'Puerto Viejo',402),(331,'La Virgen',402),(332,'Horquetas',402),(333,'Llanuras del Gaspar',402),(334,'Cureña',402),

(335,'Liberia',501),(336,'Cañas Dulces',501),(337,'Mayorga',501),(338,'Nacascolo',501),(339,'Curubandé',501),
(340,'Nicoya',504),(341,'Mansión',504),(342,'San Antonio',504),(343,'Quebrada Honda',504),(344,'Sámara',504),(345,'Nosara',504),(346,'Belén de Nosarita',504),(347,'Santa Cruz',505),(348,'Bolsón',505),(349,'Veintisiete de Abril',505),
(350,'Tempate',505),(351,'Cartagena',505),(352,'Cuajiniquil',505),(353,'Diriá',505),(354,'Cabo Velas',505),(355,'Tamarindo',505),(356,'Bagaces',506),(357,'La Fortuna',506),(358,'Mogote',506),(359,'Río Naranjo',506),
(360,'Filadelfia',507),(361,'Palmira',507),(362,'Sardinal',507),(363,'Belén',507),(364,'Cañas',508),(365,'Palmira',508),(366,'San Miguel',508),(367,'Bebedero',508),(368,'Porozal',508),(369,'Las Juntas',509),
(370,'Sierra',509),(371,'San Juan',509),(372,'Colorado',509),(373,'Tilarán',510),(374,'Quebrada Grande',510),(375,'Tronadora',510),(376,'Santa Rosa',510),(377,'Líbano',510),(378,'Tierras Morenas',510),(379,'Arenal',510),
(380,'Cabeceras',510),(381,'Carmona',511),(382,'Santa Rita',511),(383,'Zapotal',511),(384,'San Pablo',511),(385,'Porvenir',511),(386,'Bejuco',511),(387,'La Cruz',502),(388,'Santa Cecilia',502),(389,'La Garita',502),
(390,'Santa Elena',502),(391,'Hojancha',503),(392,'Monte Romo',503),(393,'Puerto Carrillo',503),(394,'Huacas',503),(395,'Matambú',503),

(396,'Puntarenas',601),(397,'Pitahaya',601),(398,'Chomes',601),(399,'Lepanto',601),
(400,'Paquera',601),(401,'Manzanillo',601),(402,'Guacimal',601),(403,'Barranca',601),(404,'Isla del Coco',601),(405,'Cóbano',601),(406,'Chacarita',601),(407,'Chira',601),(408,'Acapulco',601),(409,'El Roble',601),
(410,'Arancibia',601),(411,'Espíritu Santo',602),(412,'San Juan Grande',602),(413,'Macacona',602),(414,'San Rafael',602),(415,'San Jerónimo',602),(416,'Caldera',602),(417,'Buenos Aires',603),(418,'Volcán',603),(419,'Potrero Grande',603),
(420,'Boruca',603),(421,'Pilas',603),(422,'Colinas',603),(423,'Chánguena',603),(424,'Biolley',603),(425,'Brunka',603),(426,'Miramar',603),(427,'La Unión',603),(428,'San Isidro',603),(429,'Puerto Cortés',604),
(430,'Palmar',604),(431,'Sierpe',604),(432,'Bahía Ballena',604),(433,'Piedras Blancas',604),(434,'Bahía Drake',604),(435,'Quepos',605),(436,'Savegre',605),(437,'Naranjito',605),(438,'Golfito',606),(439,'Guaycará',606),
(440,'Pavón',606),(441,'San Vito',607),(442,'Sabalito',607),(443,'Aguabuena',607),(444,'Limoncito',607),(445,'Pittier',607),(446,'Gutiérrez Braun',607),(447,'Parrita',608),(448,'Corredor',609),(449,'La Cuesta',609),
(450,'Canoas',609),(451,'Laurel',609),(452,'Jacó',610),(453,'Tárcoles',610),(454,'Lagunillas',610),(455,'Monteverde',611),(456,'Puerto Jiménez',612),

(457,'Limón',701),(458,'Valle La Estrella',701),(459,'Río Blanco',701),
(460,'Matama',701),(461,'Guápiles',702),(462,'Jiménez',702),(463,'La Rita',702),(464,'Roxana',702),(465,'Cariari',702),(466,'Colorado',702),(467,'La Colonia',702),(468,'Siquirres',703),(469,'Pacuarito',703),
(470,'Florida',703),(471,'Germania',703),(472,'El Cairo',703),(473,'Alegría',703),(474,'Reventazón',703),(475,'Bratsi',704),(476,'Sixaola',704),(477,'Cahuita',704),(478,'Telire',704),(479,'Matina',705),
(480,'Batán',705),(481,'Carrandi',705),(482,'Guácimo',706),(483,'Mercedes',706),(484,'Pocora',706),(485,'Río Jiménez',706),(486,'Duacarí',706);

CREATE TABLE usuario(
idUsuario INT(11) NOT NULL AUTO_INCREMENT,
nombre varchar(30) NOT NULL,
apellido1 varchar(30) NOT NULL,
apellido2 varchar(30) NOT NULL,
edad INT,
cedula varchar(30) NOT NULL,
direccion varchar(500) NOT NULL,
idlogin INT NOT NULL,
idProvincia INT NOT NULL,
idCanton INT NOT NULL,
idDistrito INT NOT NULL,
PRIMARY KEY (idUsuario),
CONSTRAINT `fk_Usuario_Login` FOREIGN KEY (`idlogin`) REFERENCES `datosLogin` (`idlogin`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `fk_Usuario_Provincia` FOREIGN KEY (`idProvincia`) REFERENCES `Provincia` (`idProvincia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `fk_Usuario_Canton` FOREIGN KEY (`idCanton`) REFERENCES `canton` (`idCanton`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `fk_Usuario_Distrito` FOREIGN KEY (`idDistrito`) REFERENCES `distrito` (`idDistrito`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `usuario` VALUES 
(1,'Jorge','Hernández','Araya','30','202220222','200 metros sur Hotel Villas de la Colina',2,2,212,162),
(2,'Luis','Mora','Alvarado','25','303330333','Costado este de la Iglesia',3,3,302,250);
 
CREATE TABLE proveedor(
 idProveedor INT(11) NOT NULL AUTO_INCREMENT,
 nombre VARCHAR(50) NOT NULL,
 correoElectronico VARCHAR(50) NOT NULL,
 telefono int NOT NULL, 
 PRIMARY KEY (idProveedor)
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 
INSERT INTO proveedor VALUES (1, 'Bicimax', 'bicimax@email.com', 12345678),(2, 'Cyclomundo', 'cyclomundo@email.com', 23456789),(3, 'Pedaltech', 'pedaltech@email.com', 34567890),(4, 'Bikepro', 'bikepro@email.com', 45678901),
(5, 'Accesobike', 'accesobike@email.com', 56789012),(6, 'Velozone', 'velozone@email.com', 67890123),(7, 'Bicicentro', 'bicicentro@email.com', 78901234),(8, 'Cyclotech', 'cyclotech@email.com', 89012345),
(9, 'Biciexpress', 'biciexpress@email.com', 90123456),(10, 'Accesoriosbike', 'accesoriosbike@email.com', 12345678),(11, 'Pedalpower', 'pedalpower@email.com', 23456789),(12, 'Veloarte', 'veloarte@email.com', 34567890),
(13, 'Biciworld', 'biciworld@email.com', 45678901),(14, 'Cycloworks', 'cycloworks@email.com', 56789012),(15, 'Bikestyle', 'bikestyle@email.com', 67890123),(16, 'Accesovelo', 'accesovelo@email.com', 78901234),
(17, 'Pedalmaster', 'pedalmaster@email.com', 89012345),(18, 'Velopro', 'velopro@email.com', 90123456),(19, 'Biciclismo', 'biciclismo@email.com', 12345678),(20, 'Cyclotrek', 'cyclotrek@email.com', 23456789);
 
 CREATE TABLE marca(
 idMarca INT(11) NOT NULL AUTO_INCREMENT,
 nombre VARCHAR(50) NOT NULL,
 PRIMARY KEY (idMarca)
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 
 INSERT INTO `marca` VALUES (1, 'Giant'),(2, 'Trek'),(3, 'Specialized'),(4, 'Cannondale'),(5, 'Scott'),(6, 'Santa Cruz'),(7, 'Bianchi'),(8, 'Colnago'),(9, 'Pinarello'),
 (10, 'Canyon'),(11, 'Orbea'),(12, 'Merida'),(13, 'Kona'),(14, 'Cube'),(15, 'Fuji'),(16, 'Raleigh'),(17, 'Diamondback'),(18, 'Felt'),(19, 'BMC'),(20, 'Cervelo'); 

 CREATE TABLE familiaProducto(
 idFamilia INT(11) NOT NULL AUTO_INCREMENT,
 familia VARCHAR(50) NOT NULL,
 detalle varchar(100),
 PRIMARY KEY (idFamilia)
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 
INSERT INTO `familiaProducto` VALUES
(1, 'Bicicletas', 'Bicicletas de distintos tipos'),
(2, 'Accesorios', 'Accesorios para todo tipo de bicicletas'),
(3, 'Componentes', 'Componentes o repuestos para bicicletas'),
(4, 'Vestimenta', 'Indumentaria para todo tipo de ciclista');

 CREATE TABLE tipoProducto(
 idTipo INT(11) NOT NULL AUTO_INCREMENT,
 tipoProducto VARCHAR(50) NOT NULL,
 detalle VARCHAR(100),
 idFamilia INT NOT NULL,
 PRIMARY KEY (idTipo),
 CONSTRAINT `fk_tipoProducto_familiaProducto` FOREIGN KEY (`idFamilia`) REFERENCES `familiaProducto` (`idFamilia`) 
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 
INSERT INTO `tipoProducto` VALUES
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
(18,'Portaequipajes', 'Soporte para transportar objetos en la bicicleta', 2),
(19,'Timbre', 'Campanilla para señalizar al peatón', 2),
(20,'Cargador de celular', 'Dispositivo para cargar el celular mientras se pedalea', 2),
(21,'Espejo retrovisor', 'Espejo para tener visión de la parte trasera', 2),

(22, 'Neumáticos MTB', 'Con dibujo agresivo para mayor tracción en terrenos difíciles', 3),
(23, 'Neumáticos de Ruta', 'Con banda de rodadura lisa para mayor eficiencia en pavimento', 3),
(24, 'Sillín de Gel', 'Confortable y suave en terrenos largos', 3),
(25,'Frenos de disco', 'Sistema de frenado para bicicletas', 3),
(26,'Cadenas', 'Componente de transmisión de la bicicleta', 3),
(27,'Desviadores', 'Componente para cambiar de marcha en la bicicleta', 3),
(28,'Manubrios', 'Parte de la bicicleta que se utiliza para guiar', 3),
(29,'Pedales', 'Componente de la bicicleta que se utiliza para pedalear', 3),
(30,'Ruedas', 'Componente para el movimiento de la bicicleta', 3),
(31,'Asientos', 'Parte de la bicicleta donde se sienta el ciclista', 3),
(32,'Amortiguadores', 'Componente para la absorción de impactos en la bicicleta', 3),

(33,'Camiseta', 'Camisetas técnicas para ciclistas', 4),
(34,'Short', 'Shorts para ciclistas', 4),
(35,'Medias', 'Medias deportivas para ciclistas', 4),
(36,'Guantes', 'Guantes deportivos para ciclistas', 4),
(37,'Pantalón', 'Pantalones para ciclistas', 4),
(38,'Licra', 'Licra deportivas para ciclistas', 4),
(39,'Gafas', 'Gafas deportivas para ciclistas', 4),
(40, 'Zapatos de MTB', 'Con suela de agarre para terrenos difíciles', 4),
(41, 'Zapatos de Ruta', 'Con suela rígida para mayor eficiencia en pedaleo', 4),
(42, 'Casco de MTB', 'Con visera y mayor protección en la parte trasera', 4),
(43, 'Casco de Ruta', 'Con aerodinámica optimizada para mayor velocidad', 4);

 CREATE TABLE producto(
  idProducto INT(11) NOT NULL AUTO_INCREMENT,
  nombre varchar(50) NOT NULL,
  modelo varchar(50),  
  talla char(5),
  tamanio DECIMAL(10,1),
  detalle varchar(500),
  anio INT(4),
  precio decimal(10,2) NOT NULL,
  stock INT NOT NULL,
  idTipo INT NOT NULL,
  idMarca INT NOT NULL,
  PRIMARY KEY (idProducto),
  CONSTRAINT `fk_producto_tipoProducto` FOREIGN KEY (`idTipo`) REFERENCES `tipoProducto` (`idTipo`) 
  )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `producto` VALUES
(1,'Fuji Nevada','Nevada','M',27.5,'Un elemento básico en la línea de bicicletas de montaña Fuji, disponible en tamaños de rueda de 29″ o 27,5″, la Nevada combina un cuadro rígido probado y verdadero y componentes sólidos para llevar tus aventuras todoterreno al siguiente nivel.',2023,250000,5,1,15),
(2,'GIANT XTC SLR 2 2022','XTC SLR 2','S',29,'Perfecto como su primera bicicleta de montaña, el cuadro de aluminio de grado ALUXX es liviano, capaz y duradero Versátil. La geometría cómoda pero orientada al rendimiento de Tempt le da la versatilidad tanto para los viajes alrededor del campus como para los paseos fuera de la carretera.',2022,520000,2,1,1);

CREATE TABLE proveedorProducto (
  idProveedorProducto INT NOT NULL AUTO_INCREMENT,
  idProveedor INT NOT NULL,
  idProducto INT NOT NULL,
  PRIMARY KEY (idProveedorProducto),
CONSTRAINT `fk_proveedorProducto_proveedor` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `fk_proveedorProducto_producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `proveedorProducto` VALUES (1,1,1),(2,2,2);

CREATE TABLE evento(
  idEvento INT(11) NOT NULL AUTO_INCREMENT,
  fecha DATE NOT NULL,
  nombre varchar(50) NOT NULL,
  precio decimal(10,2) NOT NULL,
  detalle varchar(500),
  direccion varchar(200),
  stock INT,
  idTipo INT,
  idProvincia INT,
  idCanton INT,
  idDistrito INT,
  PRIMARY KEY (idEvento),
CONSTRAINT `fk_evento_tipoProducto` FOREIGN KEY (`idTipo`) REFERENCES `tipoProducto` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,  
CONSTRAINT `fk_evento_provincia` FOREIGN KEY (`idProvincia`) REFERENCES `provincia` (`idProvincia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `fk_evento_canton` FOREIGN KEY (`idCanton`) REFERENCES `canton` (`idCanton`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `fk_evento_distrito` FOREIGN KEY (`idDistrito`) REFERENCES `distrito` (`idDistrito`) ON DELETE NO ACTION ON UPDATE NO ACTION
  )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
  
INSERT INTO `evento` VALUES 
(1,'2023-10-04','Vuelta a la Península de Nicoya',94200,'Las mejores playas de Guanacaste en un solo ride!, El reto está en vos!, 4 de Noviembre, Ruta 120kms 2000m ASC. ACUM., Ruta 50kms 900m ASC. ACUM., Ruta 25kms 600m ASC. ACUM.','Nicoya Crentro',400,1,5,504,340),
(2,'2023-06-18','Vuelta a la Península de Nicoya',13000,'No se lo pierdan! La inscripción incluye: Desayuno, Hidratación, Asitencia mecánica (Te lavamos la bici!), Masaje de descarga muscular, Rifas, Premios, Parqueo','Liceo de Atenas',200,1,2,212,160);

CREATE TABLE metodopago(
 idMetodo INT(11) NOT NULL AUTO_INCREMENT,
 metodopago VARCHAR(50) NOT NULL,
 PRIMARY KEY (idMetodo)
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 
INSERT INTO metodopago VALUES (1, 'Tarjeta de crédito'),(2, 'Tarjeta de débito'),(3, 'PayPal'),(4, 'Transferencia bancaria'),
(5, 'Cheque'),(6, 'Efectivo'),(7, 'SINPE móvil'); 

CREATE TABLE carrito(
  idCarrito INT(11) NOT NULL AUTO_INCREMENT,
  fecha DATE NOT NULL,
  cantidad INT,
  idUsuario INT NOT NULL,
  idProducto INT,
  idEvento INT,
  PRIMARY KEY (idCarrito),
  CONSTRAINT `fk_carrito_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,  
  CONSTRAINT `fk_carrito_producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_carrito_evento` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`idEvento`) ON DELETE NO ACTION ON UPDATE NO ACTION
  )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE carritoProducto (
  idCarritoProducto INT NOT NULL AUTO_INCREMENT,
  idCarrito INT NOT NULL,
  idProducto INT NOT NULL,
  PRIMARY KEY (idCarritoProducto),
CONSTRAINT `fk_carritoProducto_carrito` FOREIGN KEY (`idCarrito`) REFERENCES `carrito` (`idCarrito`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `fk_carritoProducto_producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE carritoEvento (
  idCarritoEvento INT NOT NULL AUTO_INCREMENT,
  idCarrito INT NOT NULL,
  idEvento INT NOT NULL,
  PRIMARY KEY (idCarritoEvento),
CONSTRAINT `fk_carritoEvento_carrito` FOREIGN KEY (`idCarrito`) REFERENCES `carrito` (`idCarrito`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `fk_carritoEvento_evento` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`idEvento`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE orden(
  idOrden INT(11) NOT NULL AUTO_INCREMENT,
  detalle varchar(500),
  montoTotal decimal(10,2) NOT NULL,
  fecha DATE NOT NULL,
  idUsuario INT,
  idMetodo INT,
  idLogin INT,
  idCarrito INT,
  PRIMARY KEY (idOrden),
CONSTRAINT `fk_orden_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,  
CONSTRAINT `fk_orden_metodopago` FOREIGN KEY (`idMetodo`) REFERENCES `metodopago` (`idMetodo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `fk_orden_datosLogin` FOREIGN KEY (`idLogin`) REFERENCES `datosLogin` (`idLogin`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `fk_orden_carrito` FOREIGN KEY (`idCarrito`) REFERENCES `carrito` (`idCarrito`) ON DELETE NO ACTION ON UPDATE NO ACTION
  )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;