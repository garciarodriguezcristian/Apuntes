const animales = document.getElementsByClassName("animal")
for (const animal of animales) {
    animal.style.backgroundColor = "lightyellow"
}

const boton = document.getElementById("resaltarAnimales")
boton.addEventListener("click", function () {
for(const animal of animales) {
    animal.style.backgroundColor = "lightgreen"
    animal.style.fontSize = "30px"
}
})