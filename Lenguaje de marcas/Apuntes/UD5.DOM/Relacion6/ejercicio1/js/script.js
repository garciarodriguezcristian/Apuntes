document.getElementById("pedidoForm").addEventListener("submit", function (event) {
    let nombre = document.getElementById("nombre").value;
    let email = document.getElementById("email").value;
    let cantidad = document.getElementById("cantidad").value;

    if (nombre === "" || email === "" || cantidad <= 0) {
        console.log("Error: Todos los campos son obligatorios y la cantidad debe ser mayor a 0");
        event.preventDefault(); // Evita el envío del formulario
    } else {
        console.log("Formulario enviado correctamente");
    }
});

let camposFormulario = document.querySelectorAll("#pedidoForm input, #pedidoForm select")
camposFormulario.forEach(campo => {
    campo.addEventListener("focus", function () {
        this.style.outline = "none";
        this.style.boxShadow = "0 0 0 3px lightgreen";
        this.style.border = "2px solid green";
    })
})

camposFormulario.forEach(campo => {
    campo.addEventListener("blur", function () {
        this.style.outline = "";
        this.style.boxShadow = "";
        this.style.border = "";
    })
})

const producto = document.getElementById("producto")
producto.addEventListener("change", function () {
    console.log(producto.value);
    
})
