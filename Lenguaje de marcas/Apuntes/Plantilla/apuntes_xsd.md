# 🔑 Elementos de XSD

## Índice
1. [<xs:element>](#1-xselement)
2. [<xs:complexType>](#2-xscomplextype)
3. [<xs:sequence>](#3-xssequence)
4. [<xs:simpleType>](#4-xssimpletype)
5. [<xs:restriction>](#5-xsrestriction)
6. [<xs:pattern>](#6-xspattern)
7. [<xs:enumeration>](#7-xsenumeration)
8. [<xs:attribute>](#8-xsattribute)
9. [<xs:minInclusive> / <xs:maxInclusive>](#9-xsmininclusive--xsmaxinclusive)
10. [minOccurs / maxOccurs](#10-minoccurs--maxoccurs)
11. [Resumen](#-resumen)

---

## 1. `<xs:element>`
Define un elemento XML que puede aparecer en el documento.

**Atributos más usados:**
- `name`: nombre del elemento.  
- `type`: tipo de dato (ejemplo: `xs:string`, `xs:integer`).  
- `minOccurs` / `maxOccurs`: definen la cardinalidad (cuántas veces puede repetirse el elemento).  

**Puede contener:**
- Un `simpleType` (para valores simples con restricciones).  
- Un `complexType` (para elementos con subelementos o atributos).  

**👉 Ejemplo:**
```xml
<xs:element name="elemento1" type="xs:string"/>
```

---

## 2. `<xs:complexType>`
Define un tipo de dato complejo, es decir, un elemento que puede contener otros elementos y atributos.  

Se usa cuando un nodo XML no solo tiene texto, sino una estructura interna.  

**👉 Ejemplo:**
```xml
<xs:complexType>
    <xs:sequence>
        <xs:element name="elemento1" type="xs:string"/>
        <xs:element name="elemento2" type="xs:string"/>
    </xs:sequence>
</xs:complexType>
```

---

## 3. `<xs:sequence>`
Indica que los elementos hijos deben aparecer en el orden exacto en que se definen.  

- Si quisieras que aparecieran en **cualquier orden**, se usa `<xs:all>`.  
- Si debe ser **uno u otro**, se usa `<xs:choice>`.  

**👉 Ejemplo:**
```xml
<xs:sequence>
  <xs:element name="elemento1"/>
  <xs:element name="elemento2"/>
</xs:sequence>
```

---

## 4. `<xs:simpleType>`
Define un tipo de dato simple (sin subelementos, solo texto).  

Generalmente se usa con **restricciones (`restrictions`)**.  
Se aplica cuando quieres limitar un `xs:string`, `xs:integer`, `xs:decimal`, etc.  

**👉 Ejemplo:**
```xml
<xs:simpleType>
  <xs:restriction base="xs:string">
    <xs:pattern value="\d{3}-\d{3}-\d{3}"/>
  </xs:restriction>
</xs:simpleType>
```

---

## 5. `<xs:restriction>`
Sirve para restringir un tipo de dato base (`string`, `integer`, `decimal`, etc.) con reglas como:

- `pattern` → expresiones regulares (regex).  
- `enumeration` → lista de valores permitidos.  
- `minInclusive` / `maxInclusive` → límites numéricos.  
- `minLength` / `maxLength` → longitud mínima o máxima para cadenas.  

**👉 Ejemplo (email con regex):**
```xml
<xs:restriction base="xs:string">
  <xs:pattern value="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}"/>
</xs:restriction>
```

---

## 6. `<xs:pattern>`
Restringe un `string` con una **expresión regular**.  

**Ejemplos:**
- Email → `[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}`  
- Teléfono → `\d{3}-\d{3}-\d{3}`  
- Código → `A\d{3}`  

---

## 7. `<xs:enumeration>`
Restringe el valor a un **conjunto cerrado de opciones**.  

**👉 Ejemplo:**
```xml
<xs:restriction base="xs:string">
  <xs:enumeration value="valor1"/>
  <xs:enumeration value="valor2"/>
  <xs:enumeration value="valor3"/>
</xs:restriction>
```

---

## 8. `<xs:attribute>`
Define un **atributo XML** (no un elemento).  

**Atributos importantes:**
- `name`: nombre del atributo.  
- `type`: tipo del dato.  
- `use`: puede ser `"required"` (obligatorio) o `"optional"`.  

**👉 Ejemplo:**
```xml
<xs:attribute name="codigo" use="required">
  <xs:simpleType>
    <xs:restriction base="xs:string">
      <xs:pattern value="A\d{3}"/>
    </xs:restriction>
  </xs:simpleType>
</xs:attribute>
```

---

## 9. `<xs:minInclusive>` / `<xs:maxInclusive>`
Restringen valores numéricos a un **rango**.  

**👉 Ejemplo:**
```xml
<xs:restriction base="xs:integer">
  <xs:minInclusive value="1900"/>
  <xs:maxInclusive value="2025"/>
</xs:restriction>
```

---

## 10. `minOccurs` / `maxOccurs`
Se aplican a elementos dentro de un `complexType`.  

- `minOccurs="0"` → opcional.  
- `maxOccurs="unbounded"` → repetición ilimitada.  

**👉 Ejemplo:**
```xml
<xs:element name="elemento1" minOccurs="1" maxOccurs="5"/>
```

---

# 📌 Resumen
- **Elementos simples** → texto con restricciones.  
- **Elementos complejos** → con subelementos.  
- **Restricciones** → por patrón, enumeración, rango, etc.  
- **Atributos** → obligatorios o opcionales.  

