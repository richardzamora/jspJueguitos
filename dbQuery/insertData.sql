-------------------------------------------------------------
-------------------GENEROS--------------------
INSERT INTO public.generos(name) VALUES ('Accion');
INSERT INTO public.generos(name) VALUES ('Aventuras');
INSERT INTO public.generos(name) VALUES ('Plataformas');
INSERT INTO public.generos(name) VALUES ('Simulacion');
INSERT INTO public.generos(name) VALUES ('RPG');
INSERT INTO public.generos(name) VALUES ('Estrategia');
INSERT INTO public.generos(name) VALUES ('Novela Visual');
INSERT INTO public.generos(name) VALUES ('Shooter');
INSERT INTO public.generos(name) VALUES ('MOBA');
INSERT INTO public.generos(name) VALUES ('MMORPG');
-------------------------------------------------------------
-------------------EMPRESAS--------------------
INSERT INTO public.empresas(name) VALUES ('Bethesda');
INSERT INTO public.empresas(name) VALUES ('Electronic Arts');
INSERT INTO public.empresas(name) VALUES ('Bugisoft');
INSERT INTO public.empresas(name) VALUES ('Atlus');
INSERT INTO public.empresas(name) VALUES ('Nintendo');
INSERT INTO public.empresas(name) VALUES ('SEGA');
INSERT INTO public.empresas(name) VALUES ('Konami');
INSERT INTO public.empresas(name) VALUES ('Capcom');
INSERT INTO public.empresas(name) VALUES ('Riot');
INSERT INTO public.empresas(name) VALUES ('Platinum Games');
INSERT INTO public.empresas(name) VALUES ('2K Games');
-------------------------------------------------------------
-------------------USUARIOS--------------------
INSERT INTO public.usuario(mail, name, last_name, nickname, password, birth_date)
VALUES ('estebansepulveda@gmail.com', 'Esteban', 'Sepulveda', 'ES1', 'UwU', '2001-09-11');
INSERT INTO public.usuario(mail, name, last_name, nickname, password, birth_date)
VALUES ('cristiangomez@gmail.com', 'Cristian', 'Gomez', 'CR7', 'UwU', '1999-10-31');
INSERT INTO public.usuario(mail, name, last_name, nickname, password, birth_date)
VALUES ('estebanrubio@gmail.com', 'Esteban', 'Rubio', 'Gatico', 'UwU', '1986-11-09');
-------------------------------------------------------------
-------------------JUEGOS--------------------
INSERT INTO public.juegos(name, description, release_date, calification, empresa, genero)
	VALUES ( 'Persona 3', 'Adolecentes con tendencias suicidas', '2006-07-13', 5, 4, 5);
INSERT INTO public.juegos(name, description, release_date, calification, empresa, genero)
	VALUES ( 'Mafia 2', 'Mafia italiana', '2010-08-23', 4.99, 11, 1);