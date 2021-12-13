create schema libreriaGUI;
use libreriagui;
create table libro(
	codigo     integer   not null primary key,
    nombre     char(60)  not null,
    cantidad   integer   not null,
    anio       integer   null
);
select * from LIBRO;
insert into libro (codigo, nombre, cantidad, anio) values (102, 'el olvido que seremos', 50, 1976);
insert into libro (codigo, nombre, cantidad, anio) values (103, 'la maria', 80, 1950);
insert into libro (codigo, nombre, cantidad, anio) values (104, 'el amor en los tiempos del colera', 100, 1990);
insert into libro (codigo, nombre, cantidad, anio) values (105, 'condores no entierran todos los dias', 200, 1980);

select codigo, nombre, cantidad, anio from libro where codigo=101;

update libro set cantidad=45, anio=1990 where codigo=101;

delete from libro where codigo=101;

