DROP DATABASE IF EXISTS andalucia_db;
CREATE DATABASE IF NOT EXISTS andalucia_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE andalucia_db;

-- Crear la tabla personas con estructura adecuada
CREATE TABLE personas (
    id INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    sexo ENUM('M', 'H') NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    provincia VARCHAR(100) NOT NULL,
    municipio VARCHAR(150) NOT NULL,
    nivel_estudios VARCHAR(50),
    situacion_laboral VARCHAR(50),
    ingresos_anuales INT,
    estado_civil VARCHAR(20),
    num_hijos INT,
    nivel_socioeconomico VARCHAR(20),
    ocupacion VARCHAR(50)
);

alter table personas add column madre INT;
alter table personas add column padre INT;
alter table personas add foreign key (padre) references personas(id);
alter table personas add foreign key (madre) references personas(id);

SET FOREIGN_KEY_CHECKS=0;

LOAD DATA INFILE '/var/lib/mysql-files/data_andalucia.csv' INTO TABLE personas FIELDS TERMINATED BY ','  ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 ROWS;

SET FOREIGN_KEY_CHECKS=1;

-- Ejercicios tabla personas

-- 1. Muestra la media de salario agrupada por ocupación
select avg(ingresos_anuales/12), ocupacion from personas group by ocupacion;
-- 2. Muestra la media de salarios en cada provincia
select round(avg(ingresos_anuales),2) as media_salario, provincia from personas where not ingresos_anuales = 0 group by provincia;
-- 3. Muestra la media de edad de cada nivel socioeconómico
select avg(extract(year from now()) - extract(year from fecha_nacimiento)) as media_edad, nivel_socioeconomico from personas group by nivel_socioeconomico;
-- 4. Dime la edad de las personas de menos de 60 años ordenadas por situación laboral.
select extract(year from now()) - extract(year from fecha_nacimiento) as edad, situacion_laboral from personas where extract(year from now()) - extract(year from fecha_nacimiento) < 60
order by situacion_laboral;
-- 5. Muestra el nombre de la persona parada de más edad.
select nombre, situacion_laboral,fecha_nacimiento from personas where ingresos_anuales = 0 order by fecha_nacimiento limit 1;
-- 6. Dime la provincia con la máxima edad media.
select provincia from personas group by provincia order by avg(extract(year from now()) - extract(year from fecha_nacimiento)) desc limit 1 ;
		
        -- OTRA FORMA MAS LIMPIA
		select provincia from personas group by provincia 
        having avg(floor(datediff(now(),fecha_nacimiento)/365)) = 
        (select max(media_edad) from 
        (select avg(floor(datediff(now(),fecha_nacimiento)/365)) as media_edad from personas group by provincia)
        as t);
        select avg(floor(datediff(now(),fecha_nacimiento)/365)) as media_edad,provincia from personas group by provincia;
-- 7. Dime los hijos del ciudadano con id 1190
select concat(nombre," ", apellido), (select nombre from personas where id = 1190) as padre from personas where padre = 1190;
-- 8. Muestra los nietos del ciudadano con id = 1190
select id , nombre from personas where padre = 1190;
select id,nombre from personas where padre in (select id from personas where padre = 1190);

-- 9. Muestra la madre con más hijos
select nombre, num_hijos from personas where sexo = 'M' && num_hijos = (select max(num_hijos) from personas);

-- 10. Muestra la media de hijos por hombre
select avg(num_hijos) from personas where sexo = 'H';

-- 11. Dime la media de hijos de personas con menos de 30 años.
select avg(num_hijos) as media_hijos from personas where datediff(now(),fecha_nacimiento)/365.25 < 30;
-- 12. Muestra el valor de numero de hijos que más se repite entre las mujeres.
SELECT num_hijos as moda FROM personas
WHERE sexo = 'M'
GROUP BY num_hijos
HAVING COUNT(*) = (SELECT MAX(veces) FROM (
SELECT COUNT(*) AS veces
FROM personas
WHERE sexo = 'M'
GROUP BY num_hijos
) t
);
-- 13. Dime la media de edad de las mujeres sin hijos de Sevilla provincia
select floor(avg(datediff(now(),fecha_nacimiento)/365)) as media_edad from personas where sexo = "M" and num_hijos = 0 and provincia = "Sevilla";

-- 14. Dime la media de las modas del campo edad.
select floor(datediff(now(), fecha_nacimiento)/356) as edad from personas;

select count(*) as veces_por_edad, floor(datediff(now(), fecha_nacimiento)/356) as edad from personas group by edad;

select max(veces_por_edad) as max_veces from (
select count(*) as veces_por_edad, floor(datediff(now(), fecha_nacimiento)/356) as edad from personas group by edad)t2;

select edad from (
select count(*) as veces_por_edad, floor(datediff(now(), fecha_nacimiento)/356) as edad 
from personas 
group by edad) t
where edad = (
select max(veces_por_edad) from (
select count(*) as veces_por_edad, floor(datediff(now(), fecha_nacimiento)/356) as edad from personas group by edad)t2);

select avg(edad) as media_modas from (
select edad from (
select count(*) as veces_por_edad, floor(datediff(now(), fecha_nacimiento)/356) as edad 
from personas 
group by edad) t
where edad = (
select max(veces_por_edad) from (
select count(*) as veces_por_edad, floor(datediff(now(), fecha_nacimiento)/356) as edad from personas group by edad)t2))modas;

-- 15. Dime la provincia con menor edad media de las personas estudiantes.

select avg(floor(datediff(now(), fecha_nacimiento)/365)) as media_edad_provincia, provincia from
 personas where 
 situacion_laboral = "Estudiante" 
 group by provincia order by media_edad_provincia asc limit 1;

-- 16. Órdename los municipios por numero total de hijos en cada uno.
select municipio, sum(num_hijos) as suma_hijos from personas group by municipio order by suma_hijos desc;

-- 17. ordena las provincias por mayor número medio de hijos por mujer (tasa de natalidad)
select avg(num_hijos),provincia from personas where sexo = "M" group by provincia;

-- 18. Dime los municipios que no superan la tasa de reemplazo (más de 2 hijos por mujer) pero tienen un salario medio mayor a 3000 euros al mes
select municipio from personas where sexo = "M" group by municipio having avg(num_hijos) <= 2 and avg(ingresos_anuales/12) > 3000;

-- 19. Dime la provincia con la moda de edad más alta.


-- 20. Dime los 5 sevillanos (municipio) de más edad ordenados por la longitud de su apellido.
select * from
(select apellido,FLOOR(DATEDIFF(NOW(), fecha_nacimiento)/365.25) as edad from personas
where municipio = "Sevilla" order by edad desc limit 5)j 
order by char_length(apellido);

-- 21. Dime el municicpio con menos tasa de natalidad (num_hijos por mujer) de entre los municipios de Huelva con salario medio menor de 20000 euros anuales .
select municipio, avg(num_hijos) as tasa_natalidad from personas where sexo = "M" and provincia = "Huelva" group by municipio having avg(ingresos_anuales) < 20000 order by tasa_natalidad asc limit 1;













-- EXAMEN DAM --

-- 1 dime el nombre y apellido de los cinco malagueños (provincia) de más edad
select nombre, apellido, FLOOR(DATEDIFF(NOW(), fecha_nacimiento)/365.25)as edad 
from personas 
where provincia = "Malaga" 
order by FLOOR(DATEDIFF(NOW(), fecha_nacimiento)/365.25) desc limit 5;

-- 2 dime el maximo de ingresos anuales que tiene una persona con estudios primarios.
select max(ingresos_anuales) from personas where nivel_estudios = "Primarios";

-- 3  dime la edad media de las personas cuya ocupación comience por la letra A
select avg(FLOOR(DATEDIFF(NOW(), fecha_nacimiento)/365.25)) as media_edad from personas where ocupacion like "A%";

-- 4  Dime las 3 primeras letras del estado civil de las personas de Dos Hermanas (pueblo, no que tengan hermanas).
select substring(estado_civil,1,3) from personas where municipio = "Dos Hermanas";

-- 5  Cuenta el numero de personas que son padre siendo mujer o madre siendo hombre
select count(*) as total from personas where
(sexo = "M" and id in (select padre from personas where padre is not null))
or (sexo = "H" and id in (select madre from personas where madre is not null));

-- 6  Dime la moda del estado civil
select count(*) as veces, estado_civil from personas group by estado_civil; 

select max(veces) from (
select count(*) as veces, estado_civil from personas group by estado_civil
) s1;


select estado_civil from (
select count(*) as veces, estado_civil from personas group by estado_civil
) t where veces = (
select max(veces) from (
select count(*) as veces, estado_civil from personas group by estado_civil
) s1
);

-- 7  Dime cuantos municipios diferentes de la provincia de Cádiz aparecen en la base de datos. 
select count(distinct municipio) as municipios_cadiz from personas where provincia = "Cadiz";

-- 8  Dime la media de ingresos_anuales agrupada por estado_civil.
select round(avg(ingresos_anuales)) as media_ingresos, estado_civil from personas group by estado_civil;

-- 9  Dime los abuelos de la persona con id 2088
select nombre, apellido from personas 
where id = (select madre from personas where id = (select madre from personas where id = 2088))
   or id = (select padre from personas where id = (select madre from personas where id = 2088))
   or id = (select madre from personas where id = (select padre from personas where id = 2088))
   or id = (select padre from personas where id = (select padre from personas where id = 2088));

-- 10 Dime los nietos de la persona con id 1093
select nombre from personas 
where padre in (select id from personas where padre = 1093 or madre = 1093) 
or madre in (select id from personas where padre = 1093 or madre = 1093);

-- 11 Dime la media de numero de hijos por mujer.
select avg(num_hijos) from personas where sexo = "M";

-- 12 Dime los 5 granadinos (provincia) que más cobran ordenados por la longitud en letras de su ocupacion.


-- 13 Dime la provincia con menos ingresos anuales de media.
select provincia, avg(ingresos_anuales) as media from personas group by provincia order by media asc limit 1;

	-- otra forma con subconsultas
    select provincia, avg(ingresos_anuales) as media from personas group by provincia;
    select min(media) from 
    (select provincia, avg(ingresos_anuales) as media from personas group by provincia)t;
    
    select provincia from (
    select provincia, avg(ingresos_anuales) as media from personas group by provincia
    ) t
    where media = (
    select min(media) from 
    (select provincia, avg(ingresos_anuales) as media from personas group by provincia)t2
    );
    

-- 14 Dime la provincia que tiene a los jubilados con menores ingresos anuales de media.
select avg(ingresos_anuales) as ingresos, provincia from personas where situacion_laboral = "Jubilado" group by provincia order by ingresos asc limit 1;

	-- otra forma con subconsultas
    select avg(ingresos_anuales) as media, provincia from personas where situacion_laboral = "Jubilado" group by provincia;
    
    select min(media) from (
    select avg(ingresos_anuales) as media from personas where situacion_laboral = "Jubilado" group by provincia
    ) t ;
    
    select provincia, media from (
    select avg(ingresos_anuales) as media, provincia from personas where situacion_laboral = "Jubilado" group by provincia
    ) t 
    where media = (
    select min(media) from (
    select avg(ingresos_anuales) as media from personas where situacion_laboral = "Jubilado" group by provincia
    ) t2
    );

-- 15 Dime el municipio con mas ingresos anuales sin contar a las personas que no cobran nada.
select municipio, sum(ingresos_anuales) as total from personas where not ingresos_anuales = 0  group by municipio;

select max(total) as top_ingresos from (
select municipio, sum(ingresos_anuales) as total from personas where not ingresos_anuales = 0  group by municipio
) t ;

select municipio, total from (
select municipio, sum(ingresos_anuales) as total from personas where not ingresos_anuales = 0  group by municipio
) t 
where total = (
select max(total)as top_ingresos from (
select municipio, sum(ingresos_anuales) as total from personas where not ingresos_anuales = 0  group by municipio
) t2 
);


-- 16 dime la media de edad de las personas con algun hijo con nombre empezando por la L.
select floor(avg(datediff(now(), fecha_nacimiento)/365)) as edad from personas where num_hijos > 0 && nombre like 'L%';


-- 17 Dime la edad media de las personas que sean hermanas (de padre o de madre) de las personas de Málaga municipio.
select floor(avg(datediff(now(), fecha_nacimiento)/365)) from personas;

select padre from personas where municipio = "Málaga" and padre is not null;
select madre from personas where municipio = "Málaga" and madre is not null;

select floor(avg(datediff(now(), fecha_nacimiento)/365)) as media_edad from personas 
where padre in 
(select padre from personas where municipio = "Málaga" and padre is not null)
or madre in 
(select madre from personas where municipio = "Málaga" and madre is not null);


-- 18 Dime la media de salarios anuales agrupados por el dia del mes en el que nacieron.
select avg(ingresos_anuales)as media_salario, extract(day from fecha_nacimiento) as dia from personas group by extract(day from fecha_nacimiento);

-- 19 Muestra la fecha de nacimiento en dia, mes y año de los jubilados que viven en Córdoba.
select date_format(fecha_nacimiento, '%d / %m / %Y') as fecha_nacimiento from personas where ocupacion = "Jubilado" and provincia = "Córdoba";

-- 20 Muestra la cantidad de personas que nacieron en cada década del siglo XX.
SELECT count(*), floor(extract(year from fecha_nacimiento) / 10) * 10 AS decada from personas group by decada;

-- 21. Muestra las 3 provincias con más edad media entre las personas casadas.
select floor(avg(DATEDIFF(NOW(), fecha_nacimiento)/365.25)) as edad_media, provincia from personas 
where estado_civil in ('Casado', 'Casada') group by provincia order by edad_media desc limit 3;

-- 22. Muestra el municipio (o municipios) con más personas paradas.
select max(personas_paradas) from (select count(*) as personas_paradas from personas where not situacion_laboral in ('Autónomo','Empleado') group by municipio) top;

select municipio, count(*) as prdonas_paradas from personas where not situacion_laboral in ('Autónomo','Empleado') group by municipio;

select municipio, personas_paradas from (
select municipio, count(*) as personas_paradas from personas where not situacion_laboral in ('Autónomo','Empleado') group by municipio)t
where personas_paradas = (
select max(personas_paradas) from (select count(*) as personas_paradas from personas where not situacion_laboral in ('Autónomo','Empleado') group by municipio) top);
-- 23. Muestra cada municipio junto con el valor máximo de ingresos_anuales de entre las personas que son padres.
select municipio, max(ingresos_anuales) max_ingresos from personas where num_hijos > 0 group by municipio;








