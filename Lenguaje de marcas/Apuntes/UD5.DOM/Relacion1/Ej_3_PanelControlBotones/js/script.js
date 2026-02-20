// querySelector coge solo la primera aparición
const primerBoton = document.querySelector(".boton")
primerBoton.style.backgroundColor = "lightblue"

const botonCambiar = document.getElementById("cambiarEstilo")
const botones = document.querySelectorAll(".boton")

botonCambiar.addEventListener("click", function () {
for (const boton of botones) {
    boton.style.backgroundColor = "lightgreen"
    boton.style.border = "solid 2px red"
}
})

