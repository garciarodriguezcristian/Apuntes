const buscador = document.getElementById('buscador');
const listaLibros = document.querySelector('#lista-libros ul');
const listaFavoritos = document.querySelector('#favoritos ul');


//1. Busqueda de libros
buscador.addEventListener("keyup", function () {
    function filtrarLibros(lista) {
        for (const libro of lista) {
            let nombreLibro = libro.textContent.toLowerCase()
            let autorLibro = libro.getAttribute("data-autor").toLowerCase()

            if (nombreLibro.includes(filtro) || autorLibro.includes(filtro)) {
                libro.style.display = "block";
            } else {
                libro.style.display = "none";
            }
        }
    }
    let filtro = this.value.toLowerCase()
    let libros = document.querySelectorAll('#lista-libros ul li')
    let librosFavoritos = document.querySelectorAll('#favoritos ul li')

    filtrarLibros(libros)
    filtrarLibros(librosFavoritos)

    // for (const libro of libros) {
    //     let nombreLibro = libro.textContent.toLowerCase()
    //     let autorLibro = libro.getAttribute("data-autor").toLowerCase()

    //     if (nombreLibro.includes(filtro) || autorLibro.includes(filtro)) {
    //         libro.style.display = "block";
    //     } else {
    //         libro.style.display = "none";
    //     }
    // }
})

// 2. Agregar a favoritos

listaLibros.addEventListener("mouseover", function (event) {
    if (event.target.tagName === "LI") {

        //guardo el li sobre el que está el ratón
        const liOriginal = event.target

        // Guardo el contenido original de ese li
        //esto tanto como el innerHTML guarda el contenido dentro de <li>"contenido"</li>
        //como los atributos data-autor estan fuera del <li "atributos "> "contenido" </li>
        // tengo que guardar el atributo a parte, en este caso el autor que es
        //<li data-autor="nombre autor"> "nombre libro" </li>
        const tituloDelOriginal = liOriginal.textContent
        const autor = event.target.getAttribute("data-autor")


        const botonFavoritos = document.createElement("button")
        if (!event.target.querySelector(".boton-favoritos")) {
            botonFavoritos.textContent = "Añadir a favoritos"
            botonFavoritos.className = "boton-favoritos"
            botonFavoritos.style.marginLeft = "10px"
            event.target.appendChild(botonFavoritos)
        }
        botonFavoritos.addEventListener("click", function () {
            //creo el botonEliminar para añadirlo a li en favoritos
            const botonEliminar = document.createElement("button")
            botonEliminar.textContent = "Eliminar"
            botonEliminar.className = "btnEliminar"
            botonEliminar.style.marginLeft = "10px"

            //creo nuevo li con los datos del libro original
            //más un atributo nuevo con el titulo del libro para comparar y no añadirlo 2 veces a favoritos
            const nuevoLi = document.createElement("li")
            nuevoLi.textContent = tituloDelOriginal
            nuevoLi.setAttribute("data-autor", autor)
            nuevoLi.setAttribute("data-titulo", tituloDelOriginal)
            nuevoLi.appendChild(botonEliminar)

            //Compruebo si el libro ya está en favoritos
            let librosFavoritos = document.querySelectorAll("#favoritos ul li")
            let existe = false

            for (const libroFavorito of librosFavoritos) {
                // guardo el autor y el titulo del libro que esto recorriendo en el for
                const autorFavorito = libroFavorito.getAttribute("data-autor")
                const tituloFavorito = libroFavorito.getAttribute("data-titulo")
                //comparo si el titulo y autor del libro que está en favoritos
                // coincide con los del libro que hay al pulsar el boton "Añadir a favoritos"
                if (tituloFavorito == tituloDelOriginal && autorFavorito == autor) {
                    existe = true
                }
            }
            if (existe) {
                alert("El libro ya está en favoritos")
            } else {
                listaFavoritos.appendChild(nuevoLi)
            }


        })
    }
})

listaLibros.addEventListener("mouseout", function (event) {
    if (event.target.tagName === "LI") {
        const botonEliminar = event.target.querySelector(".boton-favoritos")
        event.target.removeChild(botonEliminar)
    }
})

//3. Eliminar de favoritos
listaFavoritos.addEventListener("click", function (event) {
    //si el elemento al que se hace click tiene la clase "btnEliminar"
    //elimino al padre de ese elemento
    if (event.target.className == "btnEliminar") {
        event.target.parentElement.remove()
    }
})

// 4. Modificar informacion del libro
listaLibros.addEventListener("dblclick", function (event) {
    if (event.target.tagName === "LI") {
        const li = event.target
        if (!li.querySelector("input")) {
            const input = document.createElement("input");
            input.type = "text";
            input.placeholder = "Nuevo nombre";
            input.style.marginLeft = "10px";
            li.appendChild(input)
            input.addEventListener("keyup", function (event) {
                if (event.key == "Enter") {
                    li.textContent = input.value
                }
            })
        }
    }
})

// 5. Ordenar la lista de libros

//Creo los botones
const botonOrdenarAutor = document.createElement("button")
const botonOrdenarTitulo = document.createElement("button")

//les doy atributos y contenido
botonOrdenarAutor.textContent = "Ordenar por Autor"
botonOrdenarAutor.style.marginRight = " 10px"
botonOrdenarTitulo.textContent = "Ordenar por Título"
botonOrdenarTitulo.style.marginLeft = " 10px"

//los inserto antes de la lista en el html
document.getElementById("lista-libros").insertBefore(botonOrdenarAutor, listaLibros)
document.getElementById("lista-libros").insertBefore(botonOrdenarTitulo, listaLibros)

//funcion ordenar lista por título
function ordenarPorTitulo() {
    let cambiados = true
    // Mientras haya algun cambio al pasar por el for sigo en el while
    while (cambiados) {
        const libros = document.querySelectorAll("#lista-libros li")
        cambiados = false
        for (let i = 0; i < libros.length - 1; i++) {
            const libroActual = libros[i]
            const libroSiguiente = libros[i + 1]

            const tituloActual = libroActual.textContent.toLowerCase()
            const tituloSiguiente = libroSiguiente.textContent.toLowerCase()

            if (tituloActual > tituloSiguiente) {
                listaLibros.insertBefore(libroSiguiente, libroActual)
                cambiados = true
            }
        }
    }
}
function ordenarPorAutor() {
    let cambiados = true
    while (cambiados) {
        const libros = document.querySelectorAll("#lista-libros li")
        cambiados = false
        for (let i = 0; i < libros.length - 1; i++) {
            const libroActual = libros[i]
            const libroSiguiente = libros[i + 1]

            const autorActual = libroActual.getAttribute("data-autor").toLowerCase()
            const autorSiguiente = libroSiguiente.getAttribute("data-autor").toLowerCase()

            if (autorActual > autorSiguiente) {
                listaLibros.insertBefore(libroSiguiente, libroActual)
                cambiados = true
            }
        }
    }
}
botonOrdenarTitulo.addEventListener("click", ordenarPorTitulo)
botonOrdenarAutor.addEventListener("click", ordenarPorAutor)
