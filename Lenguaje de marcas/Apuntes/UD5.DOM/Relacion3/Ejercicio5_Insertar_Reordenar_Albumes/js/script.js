// Instrucciones:

// Al cargar la página:
// Crea un nuevo <li> con el álbum "Xapomelon" - La Pegatina".
// Insértalo antes de "L'odore Della Morte".
// Agrega otro álbum "Street Gigs" - The Locos" al final de la lista.

const nuevoAlbum = document.createElement("li")
nuevoAlbum.textContent = '"Xapomelon" - La Pegatina"'

document.getElementById("albumes").insertBefore(nuevoAlbum, document.getElementById("talco"))