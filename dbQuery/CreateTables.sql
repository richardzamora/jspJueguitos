-- DROP TABLE public.juegos;
-- DROP TABLE public.usuario;
-- DROP TABLE public.empresas;
-- DROP TABLE public.generos;

CREATE TABLE public.usuario
(
    mail character(60) COLLATE pg_catalog."default" NOT NULL,
    name character(50) COLLATE pg_catalog."default" NOT NULL,
    last_name character(30) COLLATE pg_catalog."default" NOT NULL,
    nickname character(20) COLLATE pg_catalog."default" NOT NULL,
    password character(30) COLLATE pg_catalog."default" NOT NULL,
    birth_date date,
    CONSTRAINT usuario_pkey PRIMARY KEY (mail)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.usuario
    OWNER to postgres;

-----------------------------------------------------------------------------


CREATE TABLE public.empresas
(
    id serial NOT NULL,
    name character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT pk_empresas PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.empresas
    OWNER to postgres;

-----------------------------------------------------------------------------


CREATE TABLE public.generos
(
    id serial NOT NULL,
    name character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT pk_generos PRIMARY KEY (id),
    CONSTRAINT name UNIQUE (name)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.generos
    OWNER to postgres;

----------------------------------------------------------------------------

CREATE TABLE public.juegos
(
    id serial NOT NULL,
    name character varying(100) COLLATE pg_catalog."default",
    description character varying(100) COLLATE pg_catalog."default",
    release_date date,
    image bytea,
    calification double precision,
    empresa integer NOT NULL,
    genero integer NOT NULL,
    CONSTRAINT pk_juegos PRIMARY KEY (id),
    CONSTRAINT fk_juegos_empresas FOREIGN KEY (empresa)
        REFERENCES public.empresas (id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE RESTRICT,
    CONSTRAINT fk_juegos_generos FOREIGN KEY (genero)
        REFERENCES public.generos (id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.juegos
    OWNER to postgres;