create table usuarios(
id bigint not null auto_increment,
nome varchar (100) not null,
idade int (20) not null,
sexo varchar (30) not null,
email varchar (250) not null,
senha varchar (100) not null,
primary key (id)
);