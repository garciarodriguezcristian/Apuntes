// Ejercicio1

function alerta() {
    alert("¡Siente la energía Burn")
}

let imagen = document.getElementById("imgClick")
imagen.addEventListener("click", alerta)

//Ejercicio 2

let imagen2 = document.getElementById("imgHover")
const imagenOriginal = imagen2.src

function cambiarImagen() {
    imagen2.src = "https://picsum.photos/200?random=99"
}
function restablecerImagen() {
    imagen2.src = imagenOriginal
}

imagen2.addEventListener("mouseover", cambiarImagen)
imagen2.addEventListener("mouseout", restablecerImagen)

//Ejercicio 3

const teclaPresionada = document.getElementById("campoTexto")
teclaPresionada.addEventListener("keydown", function (event) {
    console.log("Tecla presionada es: " + event.key);
})

//Ejercico 4

const formulario = document.getElementById("formulario")
const nombreInput = document.getElementById("nombre")
const resultado = document.getElementById("resultado")

formulario.addEventListener("submit", function (event) {
    event.preventDefault()
    const nombre = nombreInput.value
    resultado.textContent = "Energía recargada, " + nombre + "!"
})

// Ejercicio 5

const input = document.getElementById("codigo")
const parrafo = document.getElementById("mensaje")

input.addEventListener("focus", function () {
    this.style.outline = "none"
    this.style.boxShadow = "0 0 0 2px lightgreen"
    this.style.border = " 2px solid green"
    parrafo.textContent = "Introduce tu código de energía"
})
input.addEventListener("blur", function () {
    this.style.outline = ""
    this.style.boxShadow = ""
    this.style.border = ""
    parrafo.textContent = ""
})
