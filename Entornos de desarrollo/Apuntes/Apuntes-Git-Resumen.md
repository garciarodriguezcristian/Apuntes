# 📘 Apuntes de Git - Entornos de Desarrollo

## 🧭 Comandos de Terminal Básicos
| Comando | Descripción |
|----------|--------------|
| `mkdir <nombre>` | Crea un nuevo directorio |
| `cd <carpeta>` | Entra dentro de un directorio |
| `cd ..` | Retrocede al directorio anterior |
| `ls` | Lista archivos y carpetas |
| `touch <archivo>` | Crea un archivo vacío (Linux/macOS) |
| `echo. > <archivo>` | Crea un archivo vacío (Windows) |
| `rm <archivo>` | Elimina un archivo |
| `rmdir <carpeta>` | Elimina una carpeta vacía |

---

## 🧩 Configuración Inicial de Git
| Comando | Descripción |
|----------|--------------|
| `git config --global user.name "TuNombre"` | Define tu nombre de usuario |
| `git config --global user.email "tu@email.com"` | Define tu correo electrónico |
| `git config --list` | Muestra la configuración actual |

---

## 🪣 Repositorio Local
| Comando | Descripción |
|----------|--------------|
| `git init` | Crea un nuevo repositorio Git |
| `git status` | Muestra el estado del repositorio |
| `git add <archivo>` | Añade un archivo al área de staging |
| `git add .` | Añade todos los archivos |
| `git commit -m "mensaje"` | Guarda los cambios con mensaje |
| `git commit --amend -m "mensaje"` | Se reescribe el commit anterior |
| `git log` | Muestra el historial completo de commits |
| `git log --oneline` | Historial resumido |

---

## 🌿 Ramas
| Comando | Descripción |
|----------|--------------|
| `git branch` | Muestra ramas |
| `git branch <nombre>` | Crea una nueva rama |
| `git checkout <rama>` | Cambia de rama |
| `git checkout -b <rama>` | Crea y cambia a una nueva rama |
| `git merge <rama>` | Fusiona la rama indicada |
| `git merge --abort` | Cancela un merge con conflicto |
| `git branch -d <rama>` | Elimina una rama local |

---

## ⚔️ Manejo de Conflictos
| Comando | Descripción |
|----------|--------------|
| `git merge <rama>` | Intenta combinar ramas (puede haber conflictos) |
| `git status` | Muestra archivos en conflicto |
| Editar manualmente | Resuelve conflictos editando los archivos |
| `git add <archivo>` | Marca el conflicto como resuelto |
| `git commit -m "Resuelto conflicto"` | Cierra el merge |

---

## ☁️ Conexión con GitHub
| Comando | Descripción |
|----------|--------------|
| `git remote add origin <url>` | Enlaza repositorio local con remoto |
| `git remote -v` | Verifica conexiones remotas |
| `git push -u origin master` | Sube el repositorio inicial a GitHub |
| `git push origin <rama>` | Sube una rama al remoto |
| `git pull origin <rama>` | Descarga cambios del remoto |

---

## 🔄 Otras operaciones útiles
| Comando | Descripción |
|----------|--------------|
| `git diff` | Muestra los cambios actuales |
| `git reset --hard HEAD` | Revierte todos los cambios no guardados |
| `git checkout -- <archivo>` | Restaura un archivo al último commit |
| `clear` | Limpia la pantalla del terminal |

---

