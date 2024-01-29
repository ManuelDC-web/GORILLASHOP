create database productosbd;
use productosbd;
create table familias
(id_familia int not null auto_increment primary key,
descripcion  varchar(45) not null
);
insert into familias values(1,"Camisas");
insert into familias values(2,"Pantalones");
insert into familias values(3,"Faldas");
insert into familias values(4,"Cinturones");

create table productos
(id_producto int not null auto_increment primary key,
descripcion varchar(45) not null,
marca varchar(45),
precio_unitario dec(9,2),
stock int,
fecha_alta date,
id_familia int not null,
foreign key(id_familia) references familias(id_familia)
);
insert into productos
values(1,"camisa blanca S Mujer", "Nisu",
125,50,current_date(), 1);
insert into productos
values(2,"camisa verde L Mujer", "lois",
60,50,current_date(), 1);
insert into productos
values(3,"camisa negra XL Hombre", "Nisu",
36,50,current_date(), 1);
create table usuarios
( 
username varchar(30) not null primary key,
password varchar(20) not null,
nombre varchar(25),
apellidos varchar(45),
created_at date,
enabled int default 1
);

insert into usuarios values("ramon","ramoncin","ramon","perez solera","2021-01-23",1);
insert into usuarios values("eva","evita","eva","goma blanca","2022-03-12",1);
insert into usuarios values("sara","sarita","sara","varas folclore","2022-05-24",1);
insert into usuarios values("tomas","tomasin","tomas","escu","2019-11-06",1);


create table roles
(id_rol int auto_increment primary key,
nombre varchar(20) not null
);
insert into roles values(1,"ROL_ADMON");
insert into roles values(2,"ROL_COMERCIAL");
insert into roles values(3,"ROL_RRHH");
insert into roles values(4,"ROL_CLIENTE");



create table usuario_con_roles
( username varchar(20) not null,
id_rol int not null,
foreign key(username) references usuarios(username),
foreign key(id_rol) references roles(id_rol),
primary key(username,id_rol)
);

insert into usuario_con_roles values("ramon",1);
insert into usuario_con_roles values("sara",2);
insert into usuario_con_roles values("sara",3);
insert into usuario_con_roles values("eva",4);
insert into usuario_con_roles values("tomas",4);

commit;

create table pedidos
(id_pedido int not null auto_increment primary key,
estado varchar(10) not null,
created_at date,
username varchar(20) not null,
foreign key(username) references usuarios(username),
check(estado in("ACTIVO","TERMINADO","CARRITO","ENVIADO"))
);

insert into pedidos values(1, "TERMINADO", current_date(),"tomas");
insert into pedidos values(2, "TERMINADO", current_date(),"tomas");
insert into pedidos values(3, "TERMINADO", current_date(),"eva");


create table pedido_con_productos
(numero_orden int not null auto_increment primary key,
id_pedido int not null,
id_producto int not null,
cantidad int,
precio_pedido dec(9,2),
foreign key(id_pedido) references pedidos(id_pedido),
foreign key(id_producto) references productos(id_producto)
);

insert into pedido_con_productos values(1,1,1,2,35);
insert into pedido_con_productos values(2,1,2,4,40);
insert into pedido_con_productos values(3,1,3,1,36);
insert into pedido_con_productos values(4,2,1,2,35);
insert into pedido_con_productos values(5,2,2,4,40);
insert into pedido_con_productos values(6,3,1,20,35);
insert into pedido_con_productos values(7,3,2,34,40);
commit;

create user ufamilias identified by 'ufamilias';
grant all privileges on productosbd.* to ufamilias;

