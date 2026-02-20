// Al cargar la página:
// Cambia el color de fondo de las noticias impares a lightgray.
// Cambia el color del texto de las noticias pares a blue.
// Añade un emoji 🔥 al inicio de cada noticia.

const noticias = document.getElementsByClassName("noticia")
for (let i = 0; i < noticias.length; i++) {
    if (i % 2 == 0) {
        noticias[i].style.backgroundColor = "lightgray"
    } else {
        noticias[i].style.backgroundColor = "blue"
    }
    noticias[i].textContent = "🔥  " + noticias[i].textContent
}