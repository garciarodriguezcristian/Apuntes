const canciones = document.querySelectorAll("li")
for (const cancion of canciones) {
    cancion.style.color = "green";
    cancion.textContent = cancion.textContent + " 🎶";
}