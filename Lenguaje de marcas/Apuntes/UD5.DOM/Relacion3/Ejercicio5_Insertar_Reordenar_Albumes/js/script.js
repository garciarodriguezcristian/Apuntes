// Instrucciones:

// Al cargar la página:
// Crea un nuevo <li> con el álbum "Xapomelon" - La Pegatina".
// Insértalo antes de "L'odore Della Morte".
// Agrega otro álbum "Street Gigs" - The Locos" al final de la lista.

const referencia = document.getElementById("albumes")

const nuevoAlbum = document.createElement("li")
nuevoAlbum.textContent = '"Xapomelon" - La Pegatina"'

const nuevoAlbum2 = document.createElement("li")
nuevoAlbum2.textContent = '"Street Gigs" - The Locos"'

referencia.insertBefore(nuevoAlbum, document.getElementById("talco"))
referencia.appendChild(nuevoAlbum2)