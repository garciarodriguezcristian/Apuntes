# Prueba Técnica 0 - Simulacro PTs

## [Enlace Github](https://classroom.github.com/a/_bAqyymL)

### 1. Crear el siguiente árbol de directorios:

```
PT0/
└── file1
└── dir1/
    └── dir2/
        └── dir3/
        └── dir4/
    └── file2
```

**Respuesta:**
```bash
mkdir -p PT0/dir1/dir2/{dir3,dir4};
touch file1 dir1/file2
```

### 2. Mueve el directorio `dir3` dentro del directorio `dir1` y renombrarlo como `newDir3`:

**Respuesta:**
```bash
mv dir1/dir2/dir3 dir1/newDir3
```

### 3. Copia el directorio `dir4` dentro del directorio `dir1`:

**Respuesta:**
```bash
cp -r dir1/dir2/dir4 dir1
```

### 4. Busca archivos `.conf` que sean mayores a 5 KB y que hayan sido modificados en los últimos 7 días:

**Respuesta:**
```bash
find . -name "*.conf" -type f -size +5k -mtime -7
```

### 5. Busca archivos `.log` de entre 1 y 5 MB que no se hayan modificado en los últimos 30 días:

**Respuesta:**
```bash
find . -name "*.log" -size +1M -size -5M -mtime +30
```