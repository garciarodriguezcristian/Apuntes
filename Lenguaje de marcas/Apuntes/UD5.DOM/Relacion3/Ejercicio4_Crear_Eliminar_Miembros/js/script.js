const trompetista = document.createElement("li")
trompetista.textContent = "Trompetista"
const integrantes = document.getElementById("integrantes")
integrantes.appendChild(trompetista)

const listaIntegrantes = document.querySelectorAll("li")

for (const integrante of listaIntegrantes) {
    if (integrante.textContent.trim() == "Batería") {
        integrante.remove()
    }
}