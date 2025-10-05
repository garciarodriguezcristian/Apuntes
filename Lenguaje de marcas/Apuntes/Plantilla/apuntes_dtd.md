# 🔑 Elementos de DTD

## Índice
- [🔑 Elementos de DTD](#-elementos-de-dtd)
  - [Índice](#índice)
  - [1. `<!ELEMENT>`](#1-element)
    - [Tipos de contenido](#tipos-de-contenido)
    - [Ocurrencias](#ocurrencias)
  - [2. `<!ATTLIST>`](#2-attlist)
    - [Tipos comunes](#tipos-comunes)
    - [Ocurrencias en atributos](#ocurrencias-en-atributos)
  - [3. `<!DOCTYPE>`](#3-doctype)
    - [Tipos](#tipos)
- [📌 Resumen](#-resumen)

---

## 1. `<!ELEMENT>`

Define un elemento XML y qué contenido puede tener.

### Tipos de contenido
- `(#PCDATA)` → texto.  
- Elementos hijos → el elemento puede contener otros elementos en una secuencia.  
- Mezcla de texto y elementos → `( #PCDATA | hijo )*`  

### Ocurrencias
- `+` → al menos una vez.  
- `*` → cero o más veces.  
- `?` → opcional (una o ninguna vez).  

**👉 Ejemplos:**
```dtd
<!ELEMENT titulo (#PCDATA)>
<!ELEMENT persona (nombre, edad?)>
<!ELEMENT lista (item+)>
<!ELEMENT parrafo (#PCDATA | negrita | cursiva)*>
```

---

## 2. `<!ATTLIST>`

Define atributos de un elemento.

### Tipos comunes
- `CDATA` → texto libre.  
- `ID` → identificador único.  
- `IDREF` → referencia a un `ID` definido en el documento.  
- `NMTOKEN` → nombres válidos.  
- Enumeración → lista cerrada de valores.  

### Ocurrencias en atributos
- `#REQUIRED` → obligatorio.  
- `#IMPLIED` → opcional.  
- `#FIXED "valor"` → valor fijo.  

**👉 Ejemplos:**
```dtd
<!ELEMENT libro (#PCDATA)>
<!ATTLIST libro
    categoria CDATA #IMPLIED
    id ID #REQUIRED>
    
<!ELEMENT producto (#PCDATA)>
<!ATTLIST producto
    estado (nuevo | usado | reacondicionado) "nuevo">
```

---

## 3. `<!DOCTYPE>`

Define el tipo de documento y enlaza con la DTD.

### Tipos
- **Interna** → dentro del XML.  
- **Externa** → en un archivo aparte (`SYSTEM` o `PUBLIC`).  

**👉 Ejemplos:**
```dtd
<!-- DTD interna -->
<!DOCTYPE libro [
  <!ELEMENT libro (titulo, autor, editorial)>
  <!ELEMENT titulo (#PCDATA)>
  <!ELEMENT autor (#PCDATA)>
  <!ELEMENT editorial (#PCDATA)>
]>

<!-- DTD externa -->
<!DOCTYPE libro SYSTEM "libro.dtd">
```

---

# 📌 Resumen
- `<!ELEMENT>` → define elementos de texto o compuestos.  
- Ocurrencias `+`, `*`, `?` → controlan repeticiones.  
- `<!ATTLIST>` → define atributos (tipo, obligatoriedad, valores permitidos).  
- `<!DOCTYPE>` → enlaza con la DTD (interna o externa).  
