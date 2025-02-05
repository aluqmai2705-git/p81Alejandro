create database if not exists p81Alejandro;

 use p81Alejandro;

/*
veterinario: id numérico (clave primaria), 
nif (único, no puede ser nulo), 
nombre, dirección, teléfono, email
*/


create table if not exists veterinarios(
`idVeterinario` int(10) not null default '0',
`nif` varchar(9)  not null default '0',
`name` varchar(13),
`address` varchar(50),
`phoneNumber` varchar(18),
`email` varchar(25),

constraint `pk_veterinarios` PRIMARY KEY (`idVeterinario`)
);
/*
id numérico (clave primaria), número de chip (único), 
nombre, peso, fecha de nacimiento, tipo (perro, gato, otros)
*/


create table if not exists `mascotas`(
`idMascota` int(10) not null default '0',
`idVeterinario` int(10) default null,
`chip` varchar(9),
`name` varchar(10),
`peso` double(5 , 2),
`fechaNacim` date ,
`tipo` varchar(6),

constraint `pk_vets`PRIMARY KEY (`idVets`),
CONSTRAINT `fk_vets_veterinarios` FOREIGN KEY (`idVeterinario`) 
REFERENCES `veterinarios` (`idVeterinario`)
ON DELETE SET NULL
);