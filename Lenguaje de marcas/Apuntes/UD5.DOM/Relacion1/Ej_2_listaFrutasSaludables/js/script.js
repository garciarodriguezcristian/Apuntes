const frutas = document.getElementsByTagName("li")
for (const fruta of frutas) {
    fruta.style.border = "2px solid orange"
}

const button = document.getElementById("marcarFrutas")
button.addEventListener("click", function () {
    for (const fruta of frutas) {
        fruta.style.backgroundColor = "lightblue"
        fruta.textContent +="  ✅"

    }
})