# UD 1 --- Git & GitHub (Apuntes Explicados)

## Instalación

-   **Linux (Debian/Ubuntu)** →
    `sudo apt update && sudo apt install git`\
    Instala Git desde el gestor de paquetes.
-   **Fedora** → `sudo dnf install git`\
-   **macOS (Homebrew)** → `brew install git`\
    Homebrew es el instalador más usado en Mac.
-   **Windows** → Descarga el instalador desde
    [git-scm.com](https://git-scm.com). Incluye **Git Bash**, una
    terminal especial para usar comandos Git.

## Configuración inicial

Git necesita saber quién eres para registrar tus cambios: -
`git config --global user.name "Tu Nombre"` -
`git config --global user.email "tu@correo.com"` - **Ver la
configuración actual:** `git config --list`

## Verificación

-   **Comprobar instalación:** `git --version` → Muestra la versión
    instalada.

------------------------------------------------------------------------

## Repositorios

-   **Iniciar un repositorio local:** `git init`\
    Empieza a controlar los cambios de tu proyecto. Crea una carpeta
    oculta `.git`.
-   **Clonar un repositorio remoto:** `git clone <url>`\
    Descarga una copia completa de un proyecto desde GitHub u otro
    servidor.
-   **Vincular con GitHub:** `git remote add origin <url>`\
    Conecta tu repositorio local con uno remoto (por ejemplo, el de
    GitHub).

------------------------------------------------------------------------

## Ciclo de vida de archivos

-   **Ver estado actual:** `git status`\
    Muestra qué archivos están nuevos, modificados o listos para
    confirmar.
-   **Preparar archivos para commit:**
    -   Uno: `git add archivo.txt`
    -   Todos: `git add .`
-   **Confirmar cambios:** `git commit -m "Mensaje claro"`\
    Guarda tus cambios con un mensaje que explique qué hiciste.
-   **Ver historial:**
    -   Detallado: `git log`
    -   Resumido: `git log --oneline`
    -   Con gráfico de ramas: `git log --graph --oneline --all`

------------------------------------------------------------------------

## Sincronizar con GitHub

-   **Subir cambios:** `git push origin <rama>`\
    Envía tus commits al repositorio en GitHub.
-   **Bajar cambios:** `git pull origin <rama>`\
    Descarga y combina los cambios más recientes del remoto.

------------------------------------------------------------------------

## Ramas (Branching)

Las **ramas** permiten trabajar en diferentes versiones del proyecto sin
tocar la principal. - **Listar ramas:** `git branch` - **Crear rama
nueva:** `git branch nombre_rama` - **Cambiar de rama:**
`git checkout nombre_rama` - **Crear y cambiar a la vez:**
`git checkout -b nombre_rama` - **Unir ramas:** `git merge nombre_rama`
→ Combina los cambios en la rama actual.

### Si hay conflictos:

1.  Git marca las partes con `<<<<<<<`, `=======`, `>>>>>>>`.
2.  Edita para quedarte con la versión correcta.
3.  `git add archivo`
4.  `git commit` para cerrar la fusión.

------------------------------------------------------------------------

## Pull Requests (en GitHub)

Una *Pull Request (PR)* es una solicitud para que tus cambios se revisen
antes de unirlos al proyecto principal. 1. Sube tu rama →
`git push origin nombre_rama` 2. Abre la PR en la web de GitHub. 3.
Compañeros revisan, comentan y aprueban antes de fusionar.

------------------------------------------------------------------------

## Deshacer y guardar temporalmente

-   **Deshacer el último commit (manteniendo cambios):**
    `git reset --soft HEAD^`
-   **Deshacer commit y cambios (borra todo):** `git reset --hard HEAD^`
    *(peligroso)*
-   **Revertir commit sin borrar historial:** `git revert <id_commit>` →
    crea un commit que deshace otro.
-   **Guardar trabajo temporal:** `git stash` → guarda tus cambios sin
    hacer commit.
-   **Recuperar lo guardado:** `git stash pop`

------------------------------------------------------------------------

## Tags y versiones

Los **tags** marcan versiones o hitos importantes del proyecto. -
**Crear tag:** `git tag v1.0.0` - **Listar tags:** `git tag` - **Subir
tag a GitHub:** `git push origin v1.0.0`

------------------------------------------------------------------------

## Buenas prácticas

✅ Commits pequeños y claros.\
✅ Una rama por funcionalidad.\
✅ Usa `git pull` antes de empezar a trabajar para tener la última
versión.\
✅ Revisa bien los conflictos antes de fusionar.\
✅ Evita `--hard` si ya compartiste los cambios, usa `revert` mejor.

------------------------------------------------------------------------

## Resumen de comandos

    # Repositorio
    git init
    git clone <url>
    git remote add origin <url>

    # Cambios
    git status
    git add <archivo> | git add .
    git commit -m "Mensaje"

    git log | git log --oneline

    # Subir / bajar
    git push origin <rama>
    git pull origin <rama>

    # Ramas
    git branch | git branch <rama>
    git checkout <rama> | git checkout -b <rama>
    git merge <rama>

    # Deshacer / guardar temporal
    git reset --soft HEAD^ | git reset --hard HEAD^
    git revert <id>
    git stash | git stash pop

    # Tags
    git tag v1.0.0
    git push origin v1.0.0
