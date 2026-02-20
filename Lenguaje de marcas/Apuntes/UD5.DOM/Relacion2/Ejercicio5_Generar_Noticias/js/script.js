const nuevoParrafo1 = document.createElement("p")
nuevoParrafo1.textContent = "Descubren una nueva especie en la selva amazónica."

const nuevoParrafo2 = document.createElement("p")
nuevoParrafo2.textContent = "Avances tecnológicos revolucionan la industria de la salud."

const nuevoParrafo3 = document.createElement("p")
nuevoParrafo3.textContent = "El mercado financiero experimenta grandes cambios."

const contenedor = document.getElementById("contenedor")
contenedor.appendChild(nuevoParrafo1)
contenedor.appendChild(nuevoParrafo2)
contenedor.appendChild(nuevoParrafo3)