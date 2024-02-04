create database productosbd;
use productosbd;
create table familias
(id_familia int not null auto_increment primary key,
imagen varchar(45),
descripcion  varchar(45) not null
);
insert into familias values(1,"/IMG/Camisetas.png","Camisetas");
insert into familias values(2,"/IMG/Pantalones.png","Pantalones");
insert into familias values(3,"/IMG/Abrigos.png","Abrigos");
insert into familias values(4,"/IMG/Mochilas.png","Mochilas");

create table productos
(id_producto int not null auto_increment primary key,
imagen varchar(45),
descripcion varchar(45) not null,
marca varchar(45),
precio_unitario dec(9,2),
stock int,
fecha_alta date,
id_familia int not null,
foreign key(id_familia) references familias(id_familia)
);
insert into productos
values(1,"","Camiseta Blanca", "Nike",
125,50,current_date(), 1);
insert into productos
values(2,"","Camiseta Negra", "Adidas",
60,50,current_date(), 1);
insert into productos
values(3,"","Camiseta Gris", "Puma",
36,50,current_date(), 1);

insert into productos
values(4,"","Pantalón chandal", "Nike",
125,50,current_date(), 2);
insert into productos
values(5,"","Pantalón vaquero", "Primark",
125,50,current_date(), 2);
insert into productos
values(6,"","Pantalón de Pana", "Grimey",
125,50,current_date(), 2);

insert into productos
values(7,"","Abrigo Blanco", "Nike",
125,50,current_date(), 3);
insert into productos
values(8,"","Abrigo negro", "Adidas",
125,50,current_date(), 3);
insert into productos
values(9,"","Abrigo marrón", "The North Face",
125,50,current_date(), 3);

insert into productos
values(10, "", "Mochila blanca", "Nike",
125,50,current_date(), 4);
insert into productos
values(11,"","Mochila negra", "Adidas",
125,50,current_date(), 4);
insert into productos
values(12,"","Mochila gris", "Puma",
125,50,current_date(), 4);
create table usuarios
( 
username varchar(30) not null primary key,
password varchar(20) not null,
nombre varchar(25),
apellidos varchar(45),
created_at date,
enabled int default 1
);

insert into usuarios values("manuel","manuelin","Manuel","Domínguez","2021-01-23",1);
insert into usuarios values("alex","alexin","Alex","Martínez","2022-03-12",1);
insert into usuarios values("Sara","Sarita","Sara","Varas Folclore","2022-05-24",1);
insert into usuarios values("tomas","tomasin","Tomas","Escu","2019-11-06",1);


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

insert into usuario_con_roles values("manuel",1);
insert into usuario_con_roles values("alex",2);
insert into usuario_con_roles values("sara",3);
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
insert into pedidos values(2, "TERMINADO", current_date(),"manuel");



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
commit;

create user ufamilias identified by 'ufamilias';
grant all privileges on productosbd.* to ufamilias;

