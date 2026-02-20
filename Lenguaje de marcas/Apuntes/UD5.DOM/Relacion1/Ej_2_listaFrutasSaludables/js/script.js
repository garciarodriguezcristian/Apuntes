const frutas = document.getElementsByTagName("li")
for (const fruta of frutas) {
    fruta.style.border = "2px dotted orange"
}

const button = document.getElementById("marcarFrutas")
button.addEventListener("click", function () {
    for (const fruta of frutas) {
        if (!fruta.textContent.includes("✅")) {
            fruta.textContent += "  ✅"
        }
        fruta.style.backgroundColor = "lightblue"

    }
})