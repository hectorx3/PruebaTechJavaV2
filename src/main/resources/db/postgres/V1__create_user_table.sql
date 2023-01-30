CREATE TABLE IF NOT EXISTS alumnos
(
    id_alumno               SERIAL PRIMARY KEY,
    nombre                  varchar(80),
    ap_paterno              varchar(80),
    ap_materno              varchar(80),
    activo                  boolean not null default true
);

CREATE TABLE IF NOT EXISTS materias
(
    id_materia                SERIAL PRIMARY KEY,
    nombre                    varchar(80),
    activo                    boolean       not null default true
);

CREATE TABLE IF NOT EXISTS calificaciones
(
    id_calificacion          SERIAL PRIMARY KEY,
    id_materia               int not null,
    id_alumno                int not null,
    activo                   boolean not null default true,
    fecha_registro           timestamp,
    calificacion             decimal(10,2),
    foreign key (id_materia) references materias (id_materia),
    foreign key (id_alumno) references alumnos (id_alumno)
);

insert into alumnos(nombre,ap_paterno,ap_materno,activo) values ('John','Dow','Down',true);
insert into materias(nombre,activo) values ('matematicas',true);
insert into materias(nombre,activo) values ('programacion I',true);
insert into materias(nombre,activo) values ('ingenieria de sofware',true);