create table farmacia(
id bigint not null auto_increment,
nome varchar (100) not null,
endereco varchar (100) not null,
tipo_farmacia_enum varchar (100) not null,

primary key (id)
);