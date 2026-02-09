# Unidad Didáctica 4 – FLEXBOX

La clave es saber QUÉ se mueve:
	•	el CONTENEDOR (padre)
	•	los ITEMS (cajas hijas)
	•	el TEXTO (contenido dentro de la caja)

⸻

# 1. Conceptos básicos

Flexbox es un sistema de diseño que trabaja siempre con padre → hijos.
```css
.contenedor {
  display: flex;
}
```

	•	El elemento con display: flex es el CONTENEDOR FLEX
	•	Solo los hijos directos se convierten en items flex

⸻

# 2. Ejes de Flexbox (fundamental en examen)

Flexbox NO piensa en horizontal/vertical, piensa en ejes.
	•	Eje principal (main axis) → lo define flex-direction
	•	Eje secundario (cross axis) → perpendicular al principal

## flex-direction

```css
/* Define la dirección del eje principal. */

flex-direction: row;          /* horizontal (por defecto) */
flex-direction: column;       /* vertical */
flex-direction: row-reverse;
flex-direction: column-reverse;
```
⚠️ Todas las alineaciones dependen de este eje.

⸻

# 3. PROPIEDADES QUE AFECTAN AL CONTENEDOR

Estas propiedades SIEMPRE van en el padre y afectan a todos los items.

⸻

## 3.1 justify-content
👉 Mueve LOS ITEMS COMO GRUPO
	•	Actúa sobre el eje principal
	•	Reparte las cajas hijas

```css
justify-content: flex-start;
justify-content: center;
justify-content: flex-end;
justify-content: space-between;
justify-content: space-around;
justify-content: space-evenly;

✔️ Mueve cajas
❌ No mueve texto
```
⸻

## 3.2 align-items

👉 Alinea LOS ITEMS en el eje secundario
```css
align-items: stretch;   /* por defecto */
align-items: flex-start;
align-items: center;
align-items: flex-end;
align-items: baseline;
	•	Alinea todas las cajas a la vez
	•	Necesita que el contenedor tenga altura

✔️ Mueve cajas
❌ No mueve texto
```

⸻

## 3.3 flex-wrap

👉 Controla si los items bajan de línea
```css
flex-wrap: nowrap;   /* por defecto */
flex-wrap: wrap;
flex-wrap: wrap-reverse;
```

⸻

 ## 3.4 align-content

👉 Alinea FILAS completas
```css
align-content: flex-start;
align-content: center;
align-content: space-between;

⚠️ SOLO funciona si hay varias filas (flex-wrap: wrap)
```
⸻

## 1. PROPIEDADES QUE AFECTAN A LOS ITEMS

Estas propiedades van en los hijos.

⸻

## 4.1 flex-grow

👉 Cuánto puede crecer un item
```css
flex-grow: 1;

	•	Reparte el espacio sobrante
	•	Cuanto mayor el número, más crece
```
⸻

##  4.2 flex-shrink

👉 Cuánto puede encogerse un item
```css
flex-shrink: 1;   /* por defecto */
flex-shrink: 0;   /* no se encoge */
```

⸻

## 4.3 flex-basis

👉 Tamaño base del item
```css
flex-basis: auto;
flex-basis: 200px;
```

⸻

##  4.4 flex (abreviatura)
```css
flex: 1 1 auto;
flex: 2 1 300px;
Orden:
	1.	flex-grow
	2.	flex-shrink
	3.	flex-basis
```

⸻

##  4.5 align-self

👉 Alinea UN SOLO ITEM
```css
align-self: flex-start;
align-self: center;
align-self: flex-end;

	•	Rompe la alineación general
```
⸻

## 1. PROPIEDADES QUE AFECTAN AL TEXTO (NO FLEXBOX)

### Estas propiedades NO mueven cajas.

⸻

## 5.1 text-align
```css
text-align: left;
text-align: center;
text-align: right;

✔️ Mueve texto horizontalmente
❌ No mueve cajas
```

⸻

##  5.2 line-height
```css
line-height: 1.5;
line-height: 40px;
```

	•	Controla la altura de línea del texto
⸻

## 1. RESUMEN CLAVE PARA EXAMEN
```
Quiero mover	Propiedad
Cajas en eje principal	justify-content
Cajas en eje secundario	align-items
Un solo item	align-self
Repartir espacio	flex-grow
Evitar que se encoja	flex-shrink: 0
Tamaño base	flex-basis
Texto	text-align


⸻

7. Pregunta mágica antes de escribir CSS
	1.	¿Estoy en el contenedor o en el item?
	2.	¿Cuál es el eje principal?
	3.	¿Quiero mover cajas o texto?
	4.	¿A todos o solo a uno?

Si respondes esto, Flexbox deja de ser ensayo-error.
