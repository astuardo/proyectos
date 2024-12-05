--CREATE TABLE CLIENTES(
--    ID BIGINT NOT NULL AUTO_INCREMENT,
--    NOMBRE VARCHAR(20) NOT NULL,
--    APELLIDO VARCHAR(20) NOT NULL,
--    FNACIMIENTO DATE NOT NULL,
--    DNI VARCHAR(20) NOT NULL,
--    DIRECCION VARCHAR(30),
--    CIUDAD VARCHAR(20) NOT NULL,
--    PAIS VARCHAR(20) NOT NULL
--    PRIMARY KEY (ID)
--)
--CREATE TABLE PRODUCTOS(ID BIGINT NOT NULL AUTO_INCREMENT,
--    NOMBRE VARCHAR(20),
--    DESCRIPCION VARCHAR(30),
--    PRECIO INT NOT NULL,
--    STOCK INT NOT NULL
--);
--CREATE TABLE EMPRESAS (
--    ID BIGINT NOT NULL AUTO_INCREMENT,
--    NOMBRE VARCHAR(20),
--    RUBRO VARCHAR(30)
--);

INSERT INTO empresas(nombre, rubro) VALUES('Technology S.A','Venta de Insumos Tecnológicos');

INSERT INTO clientes(nombre, apellido, dni, direccion, fnacimiento, ciudad, pais, empresa_id)
    VALUES('ALFREDO','TEST', 12123123-4,'Del Angel 1137', '1994-01-01','San Felipe','Chile', 1);
INSERT INTO clientes(nombre, apellido, dni, direccion, fnacimiento, ciudad, pais, empresa_id)
    VALUES('ALEJANDRO','BONILLA',12345678-9,'San Jose 1134','1995-02-02','Los Andes','Chile', 1);
INSERT INTO clientes(nombre, apellido, dni, direccion, fnacimiento, ciudad, pais, empresa_id)
    VALUES('PEDRO','PINTO',9876543-2,'12 de Febrero 1532','1996-03-03','San Felipe','Chile', 1);
INSERT INTO clientes(nombre, apellido, dni, direccion, fnacimiento, ciudad, pais, empresa_id)
    VALUES('PABLO','BLANCO',11123321-8,'Huerfanos 234','1997-04-04','Santiago','Chile', 1);
INSERT INTO clientes(nombre, apellido, dni, direccion, fnacimiento, ciudad, pais, empresa_id)
    VALUES('JUAN','RUIZ',14578543-6,'Agustinas 456','1998-05-05','Santiago','Chile', 1);
INSERT INTO clientes(nombre, apellido, dni, direccion, fnacimiento, ciudad, pais, empresa_id)
    VALUES('BELEN','MORA',23432123-7,'Las Heras 617','1999-06-06','Concepcion','Chile', 1);

INSERT INTO productos(nombre, descripcion, precio, stock) VALUES('Pantalla 24 Pulgadas','Pantalla para el escritorio',100000,10);
INSERT INTO productos(nombre, descripcion, precio, stock) VALUES('Cable HDMI','Cable para conectar pantallas',5000,100);
INSERT INTO productos(nombre, descripcion, precio, stock) VALUES('Teclado Mecánico','Teclado USB para computador',50000,20);
INSERT INTO productos(nombre, descripcion, precio, stock) VALUES('Laptop','Laptop para Trabajar',1000000,5);
INSERT INTO productos(nombre, descripcion, precio, stock) VALUES('Mouse Bluetooth','Mouse Genérico',12500,20);
INSERT INTO productos(nombre, descripcion, precio, stock) VALUES('Cable USB-C','Cable para móvil',5000,25);
INSERT INTO productos(nombre, descripcion, precio, stock) VALUES('Tarjeta de Video','Componente para PC',760000,10);
INSERT INTO productos(nombre, descripcion, precio, stock) VALUES('Placa de Video','Placa para componentes de PC',80000,15);
INSERT INTO productos(nombre, descripcion, precio, stock) VALUES('Memoria RAM','Memoria para PC',90000,18);
INSERT INTO productos(nombre, descripcion, precio, stock) VALUES('SSD','Disco duro para PC',105000,10);

