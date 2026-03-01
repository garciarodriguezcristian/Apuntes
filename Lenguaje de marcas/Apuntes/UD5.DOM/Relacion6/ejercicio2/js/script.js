const productos = document.getElementById("productos")
const busqueda = document.getElementById("busqueda")

productos.addEventListener("mouseover", function (event) {
    //event.target indica el elemento exacto qeu dispara el evento.
    if (event.target.tagName === "DIV") {
        event.target.style.background = "lightblue"
    }
})
productos.addEventListener("mouseout", function (event) {
    if (event.target.tagName === "DIV") {
        event.target.style.background = ""
    }
})

busqueda.addEventListener("keydown", function (event) {
    console.log("Tecla presionada:", event.key);
})

busqueda.addEventListener("keyup", function () {

    let filtro = this.value.toLowerCase();
    let productos = document.querySelectorAll(".producto");

    productos.forEach(function (producto) {
        let nombre = producto.getAttribute("data-nombre").toLowerCase();
        if (nombre.includes(filtro)) {
            producto.style.display = "block";
        } else {
            producto.style.display = "none";
        }
    });
});
