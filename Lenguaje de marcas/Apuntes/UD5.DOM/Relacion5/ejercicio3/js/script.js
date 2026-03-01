const numero1 = parseFloat(document.getElementById("numero1").value)
const numero2 = parseFloat(document.getElementById("numero2").value)
const botonSumar = document.getElementById("btnSumar")



function sumar() {
    const resultado = parseFloat(numero1) + parseFloat(numero2)
    document.getElementById("resultado").textContent = resultado
    botonSumar.style.background = "lightgreen"
    botonSumar.addEventListener("blur", function () {
        this.style.background = ""
    })
}

function restar() {
    const resultado = parseFloat(numero1) - parseFloat(numero2)
    document.getElementById("resultado").textContent = resultado
    //Añadido: Resalto el botón que tiene el foco para saber que operación se ha hecho
    document.getElementById("btnRestar").style.background = "lightgreen"
    document.getElementById("btnRestar").addEventListener("blur", function () {
        this.style.background = ""
    })
}
function multiplicar() {
    const resultado = parseFloat(numero1) * parseFloat(numero2)
    document.getElementById("resultado").textContent = resultado
    //Añadido: Resalto el botón que tiene el foco para saber que operación se ha hecho
    document.getElementById("btnMultiplicar").style.background = "lightgreen"
    document.getElementById("btnMultiplicar").addEventListener("blur", function () {
        this.style.background = ""
    })
}

function dividir() {
    if (numero2 > 0) {
        const resultado = parseFloat(numero1) / parseFloat(numero2)
        document.getElementById("resultado").textContent = resultado
        document.getElementById("btnDividir").style.background = "lightgreen"
        document.getElementById("btnDividir").addEventListener("blur", function () {
            this.style.background = ""
        })
    } else {
        alert("No se puede dividir entre 0 o negativo")
    }
}

document.getElementById("btnSumar").addEventListener("click", sumar)
document.getElementById("btnRestar").addEventListener("click", restar)
document.getElementById("btnMultiplicar").addEventListener("click", multiplicar)
document.getElementById("btnDividir").addEventListener("click", dividir)



