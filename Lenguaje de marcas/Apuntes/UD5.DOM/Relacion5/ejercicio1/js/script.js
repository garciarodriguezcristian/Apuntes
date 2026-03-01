const lista = document.getElementById("lista")
const btnAniadir = document.getElementById("btnAniadir")
const btnBorrar = document.getElementById("btnBorrar")
const btnEditar = document.getElementById("btnEditar")

function aniadirElementoLista() {
    const nuevoElemento = document.createElement("li")
    nuevoElemento.textContent = "Elemento " + (lista.childElementCount + 1)
    lista.appendChild(nuevoElemento)
}
function eliminarElementoLista() {
    if (lista.lastElementChild) {
        lista.lastElementChild.remove()
    } else {
        alert("No hay elementos que borrar")
    }
}

function editarElementoLista() {
    lista.lastElementChild.textContent = "Elemento editado"
}
// Funcion que crea un nuevo elemento y lo reemplaza por el último de la lista
function reemplazarUltimoElementoLista() {
    const nuevoElemento = document.createElement("li");
    nuevoElemento.innerHTML = "Elemento editado";
    lista.replaceChild(nuevoElemento, lista.lastElementChild);
}



btnAniadir.addEventListener("click", aniadirElementoLista)
btnBorrar.addEventListener("click", eliminarElementoLista)
btnEditar.addEventListener("click", editarElementoLista)