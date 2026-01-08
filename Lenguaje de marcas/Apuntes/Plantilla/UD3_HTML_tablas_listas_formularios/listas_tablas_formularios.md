# 🌟 Plantilla UD3 – HTML (con explicación ultra breve)

---

# 📌 1. LISTAS

## ✅ 1.1 Lista ordenada `<ol>`

**Sirve para listas numeradas.**

```html
<ol type="A" start="3">
  <li>Elemento</li>
  <li>Elemento</li>
</ol>
```

---

## ✅ 1.2 Lista no ordenada `<ul>`

**Lista con viñetas.**

```html
<ul style="list-style-type: square;">
  <li>Uno</li>
  <li>Dos</li>
</ul>
```

---

## ✅ 1.3 Lista anidada

**Lista dentro de otra lista.**

```html
<ul>
  <li>A
    <ul>
      <li>A1</li>
      <li>A2</li>
    </ul>
  </li>
</ul>
```

---

# 📌 2. TABLAS

## ✅ 2.1 Tabla básica `<table>`

**Estructura tabular de filas y columnas.**

```html
<table style="border:1px solid black;">
  <tr>
    <th>Nombre</th>
    <th>Edad</th>
  </tr>
  <tr>
    <td>Juan</td>
    <td>20</td>
  </tr>
</table>
```

---

## ✅ 2.2 `colspan` y `rowspan`

**Unir columnas o filas.**

```html
<table style="border:1px solid black;">
  <tr>
    <th colspan="2">Datos</th>
  </tr>
  <tr>
    <td rowspan="2">Nombre</td>
    <td>Juan</td>
  </tr>
  <tr>
    <td>Maria</td>
  </tr>
</table>
```

---

# 📌 3. FORMULARIOS

## ✅ 3.1 `<form>`

**Contenedor del formulario.**

```html
<form action="procesar.php" method="POST">
  ...
</form>
```

---

# 📌 4. CAMPOS DE FORMULARIO

## ✅ 4.1 Inputs comunes (`<input>`)

### Texto

```html
<input type="text" name="nombre" placeholder="Nombre" required>
```

### Password

```html
<input type="password" name="pass">
```

### Email

```html
<input type="email" name="correo">
```

### Checkbox

```html
<input type="checkbox" name="acepto"> Acepto
```

### Radio

```html
<input type="radio" name="genero" value="hombre"> Hombre
<input type="radio" name="genero" value="mujer"> Mujer
```

### File

```html
<input type="file" name="archivo">
```

---

# 📌 5. TEXTAREA

**Área de texto multilínea.**

```html
<textarea name="comentario" rows="4" cols="40"></textarea>
```

---

# 📌 6. SELECT (desplegable)

**Lista de opciones.**

```html
<select name="pais">
  <option value="es">España</option>
  <option value="mx">México</option>
</select>
```

### Múltiples opciones

```html
<select name="paises" multiple>
```

---

# 📌 7. BOTONES

## Enviar

```html
<button type="submit">Enviar</button>
```

## Reset

```html
<button type="reset">Reiniciar</button>
```

## Botón normal

```html
<button type="button">Click</button>
```

---

# 📌 8. ESTRUCTURA HTML BÁSICA

**Estructura mínima de cualquier página.**

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Título</title>
</head>
<body>
  <!-- Contenido -->
</body>
</html>
```

---

# 📌 9. ETIQUETAS SEMÁNTICAS

**Dan significado al contenido.**

```html
<header>Encabezado</header>
<nav>Menú</nav>
<main>Contenido</main>
<section>Sección</section>
<article>Artículo</article>
<aside>Lateral</aside>
<footer>Pie</footer>
```

---

# 📌 10. ENLACES E IMÁGENES

## Enlace

```html
<a href="https://web.com">Visitar</a>
```

## Imagen

```html
<img src="imagen.jpg" alt="Descripción">
```
