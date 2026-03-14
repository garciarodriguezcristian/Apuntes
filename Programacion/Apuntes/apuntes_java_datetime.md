# Apuntes -- Biblioteca `java.time` (Java)

## Índice

1. [LocalDate](#1-localdate)
2. [LocalTime](#2-localtime)
3. [LocalDateTime](#3-localdatetime)
4. [Duration](#4-duration)
5. [Period](#5-period)
6. [DateTimeFormatter](#6-datetimeformatter)
7. [Ejemplos útiles](#7-ejemplos-útiles)

------------------------------------------------------------------------

# 1. `LocalDate`

Representa **una fecha sin hora**.

``` java
import java.time.LocalDate;
```

## Crear fechas

``` java
LocalDate.now()
```

Devuelve la **fecha actual del sistema**.

``` java
LocalDate.of(año, mes, dia)
```

Crea una fecha indicando **año, mes y día**.

``` java
LocalDate.parse("yyyy-MM-dd")
```

Convierte un **texto en fecha**.

## Modificar fecha

``` java
plusDays()
plusWeeks()
plusMonths()
plusYears()
```

Suman tiempo a la fecha.

``` java
minusDays()
minusWeeks()
minusMonths()
minusYears()
```

Restan tiempo a la fecha.

## Comparar fechas

``` java
isBefore()
isAfter()
isEqual()
```

Permiten comparar fechas.

## Obtener información

``` java
getDayOfMonth()
getDayOfWeek()
getMonth()
getYear()
getDayOfYear()
```

Devuelven partes de la fecha.

## Otros métodos

``` java
isLeapYear()
```

Comprueba si el año es bisiesto.

------------------------------------------------------------------------

# 2. `LocalTime`

Representa **una hora sin fecha**.

``` java
import java.time.LocalTime;
```

## Crear horas

``` java
LocalTime.now()
LocalTime.of(hora, minuto)
LocalTime.parse("HH:mm")
```

Permiten obtener la hora actual o crear una hora específica.

## Modificar hora

``` java
plusHours()
plusMinutes()
plusSeconds()
plusNanos()
```

Suman tiempo.

``` java
minusHours()
minusMinutes()
minusSeconds()
minusNanos()
```

Restan tiempo.

## Comparar horas

``` java
isBefore()
isAfter()
equals()
```

Permiten comparar dos horas.

## Obtener partes de la hora

``` java
getHour()
getMinute()
getSecond()
getNano()
```

Devuelven los componentes de la hora.

------------------------------------------------------------------------

# 3. `LocalDateTime`

Representa **fecha y hora juntas**.

``` java
import java.time.LocalDateTime;
```

## Crear fecha y hora

``` java
LocalDateTime.now()
LocalDateTime.of(año, mes, dia, hora, minuto)
LocalDateTime.parse("yyyy-MM-ddTHH:mm")
```

Permiten obtener la fecha y hora actuales o crear una específica.

## Modificar fecha y hora

``` java
plusDays()
plusHours()
plusMinutes()
plusSeconds()
plusWeeks()
plusMonths()
plusYears()
```

Suman tiempo.

``` java
minusDays()
minusHours()
minusMinutes()
minusSeconds()
minusWeeks()
minusMonths()
minusYears()
```

Restan tiempo.

## Comparar fechas

``` java
isBefore()
isAfter()
isEqual()
```

Permiten comparar fechas con hora.

## Obtener partes

``` java
getYear()
getMonth()
getDayOfMonth()
getHour()
getMinute()
getSecond()
```

Devuelven partes de la fecha o la hora.

## Convertir a otras clases

``` java
toLocalDate()
toLocalTime()
```

Permiten separar fecha y hora.

------------------------------------------------------------------------

# 4. `Duration`

Representa **una duración de tiempo entre dos instantes**.

``` java
import java.time.Duration;
```

## Crear duración

``` java
Duration.between(inicio, fin)
Duration.ofHours()
Duration.ofMinutes()
Duration.ofSeconds()
```

Permiten calcular o crear duraciones.

## Obtener duración

``` java
toHours()
toMinutes()
toSeconds()
toMillis()
```

Devuelven la duración en distintas unidades.

------------------------------------------------------------------------

# 5. `Period`

Representa **diferencias entre fechas**.

``` java
import java.time.Period;
```

## Crear periodo

``` java
Period.between(fecha1, fecha2)
```

Calcula la diferencia entre fechas.

## Obtener valores

``` java
getYears()
getMonths()
getDays()
```

Devuelven años, meses y días de diferencia.

------------------------------------------------------------------------

# 6. `DateTimeFormatter`

Sirve para **dar formato a fechas y horas**.

``` java
import java.time.format.DateTimeFormatter;
```

## Crear formato

``` java
DateTimeFormatter.ofPattern("formato")
```

Define el formato de salida.

Ejemplo:

``` java
"dd/MM/yyyy HH:mm"
```

## Formatear fecha

``` java
fecha.format(formato)
```

Convierte una fecha a texto con formato.

## Parsear fecha

``` java
LocalDateTime.parse(texto, formato)
```

Convierte texto en fecha usando un formato.

------------------------------------------------------------------------

# 7. Ejemplos útiles

## Calcular fin de evento

``` java
fin = inicio.plusMinutes(duracion);
```

## Comprobar si una fecha es anterior

``` java
fecha1.isBefore(fecha2);
```

## Comprobar si un evento está ocurriendo ahora

``` java
ahora.isAfter(inicio) && ahora.isBefore(fin);
```

## Detectar solapamiento de intervalos

``` java
inicio1.isBefore(fin2) && inicio2.isBefore(fin1);
```
