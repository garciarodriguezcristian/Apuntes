const botonAñadirProducto = document.getElementById("btnAniadirProducto")
let precioTotal = 0

function aniadirProducto() {
    const listaProductos = document.getElementById("listaProductos")
    const nombreProducto = document.getElementById("inputNombreProducto").value
    const precio = parseFloat(document.getElementById("inputPrecioProducto").value)
    if (nombreProducto && precio > 0) {
        const nuevoElementoLista = document.createElement("li")
    
        nuevoElementoLista.textContent = nombreProducto + " - " + precio + "€"
        listaProductos.appendChild(nuevoElementoLista)
        precioTotal += precio
        document.querySelector("h2").textContent = 
        "Total " + listaProductos.childElementCount + " productos: " + precioTotal + "€";
    } else {
        alert("Introduce un nombre y un precio válido")
    }
    
}

botonAñadirProducto.addEventListener("click", aniadirProducto)


