// =========================
// RELACIÓN 1 — PLANTILLA CON PSEUDOCÓDIGO
// (Deja las constantes y completa las funciones)
// =========================

let jugadorSeleccionado = null;

// ====== CONSTANTES (NO TOCAR) ======
const listaJugadores = document.getElementById("listaJugadores");

const detalleNombre = document.getElementById("detalleNombre");
const detallePosicion = document.getElementById("detallePosicion");
const detalleGoles = document.getElementById("detalleGoles");

const btnSumarGol = document.getElementById("btnSumarGol");
const btnBorrar = document.getElementById("btnBorrar");
const filtroPosicion = document.getElementById("filtroPosicion");

const formNuevoJugador = document.getElementById("formNuevoJugador");
const mensajeForm = document.getElementById("mensajeForm");

// ====== FUNCIONES A IMPLEMENTAR (las más importantes) ======

function quitarSeleccionATodos() {

    /*
    PSEUDOCÓDIGO:
    1) Obtener todas las tarjetas con ".jugador"
    2) Recorrerlas
    3) A cada una, quitarle la clase "seleccionado"
    */
    const jugadores = document.querySelectorAll(".jugador")
    jugadores.forEach(jugador => {
        jugador.classList.remove("seleccionado")
    });
}

function actualizarPanel(jugador) {
    console.log("Actualizar panel");

    /*
    PSEUDOCÓDIGO:
    SI jugador existe:
      1) Leer el nombre desde el DOM (h3.nombre dentro de la tarjeta)
      2) Leer dorsal, posición y goles desde jugador.dataset
         - dorsal: jugador.dataset.dorsal
         - posicion: jugador.dataset.posicion
         - goles: jugador.dataset.goles
      3) Pi (#dorsal)" (o solo nombre, como prefieras)
         - detallePosicion: posicion
         - detalleGoles: goles
    SI NO existe jugador:
      4) Poner "—" en los 3 campos del panel
    */
    const camposPanel = document.querySelectorAll(".detalles .label")
    if (jugador == null) {
        detalleNombre.textContent = "-"
        detallePosicion.textContent = "-"
        detalleGoles.textContent = "-"
    } else {
        const nombre = jugador.querySelector("h3.nombre").textContent
        const dorsal = jugador.dataset.dorsal
        const posicion = jugador.dataset.posicion
        const goles = jugador.dataset.goles
        detalleNombre.textContent = nombre + "(#" + dorsal + ")"
        detallePosicion.textContent = posicion
        detalleGoles.textContent = goles
    }
}

function seleccionarJugador(jugador) {

    /*
    PSEUDOCÓDIGO:
    1) Si jugador es null, no hacer nada (o actualizarPanel(null))
    2) Llamar a quitarSeleccionATodos()
    3) Añadir clase "seleccionado" al jugador clicado
    4) Guardarlo en la variable global jugadorSeleccionado
    5) Llamar a actualizarPanel(jugadorSeleccionado)
    */
    if (jugador == null) {
        actualizarPanel(null)
    } else {
        quitarSeleccionATodos()
        jugador.classList.add("seleccionado")
        jugadorSeleccionado = jugador
        actualizarPanel(jugadorSeleccionado)
    }
}

function engancharClickTarjeta(tarjeta) {
    console.log("engancharClickTarjeta");
    /*
    PSEUDOCÓDIGO:
    1) Añadir un addEventListener("click", ...)
    2) Dentro del handler, llamar a seleccionarJugador(tarjeta)
       (ojo: si usas function() puedes usar this)
    */
    tarjeta.addEventListener("click", function () {
        seleccionarJugador(tarjeta)
    })
}

function engancharClicksJugadoresExistentes() {
    console.log("Enganchar clicks jugadores");

    /*
    PSEUDOCÓDIGO:
    1) Seleccionar todas las tarjetas ".jugador"
    2) Recorrerlas
    3) A cada una, llamarle a engancharClickTarjeta(tarjeta)
    */
    const tarjetasJugadores = document.querySelectorAll(".jugador")
    tarjetasJugadores.forEach(tarjeta => {
        engancharClickTarjeta(tarjeta)
    })
}

function sumarGolSeleccionado() {
    /*
    PSEUDOCÓDIGO (dataset + DOM):
    1) Si no hay jugadorSeleccionado -> no hacer nada
    2) Leer goles actuales desde jugadorSeleccionado.dataset.goles
       - Convertir a número (Number(...))
    3) Calcular nuevosGoles = golesActuales + 1
    4) MODIFICAR dataset:
       - jugadorSeleccionado.dataset.goles = String(nuevosGoles)
    5) Actualizar texto visible en:
       - El <strong class="goles"> dentro de la tarjeta
       - detalleGoles en el panel
    */
    jugadorSeleccionado = document.querySelector(".seleccionado")
    let golesActuales = (Number(jugadorSeleccionado.dataset.goles))
    let nuevosGoles = golesActuales + 1
    jugadorSeleccionado.dataset.goles = String(nuevosGoles)
    jugadorSeleccionado.querySelector(".goles").textContent = nuevosGoles
    detalleGoles.textContent = nuevosGoles
}

function filtrarPorPosicion(valorFiltro) {
    /*
    PSEUDOCÓDIGO:
    1) Obtener todas las tarjetas ".jugador"
    2) Para cada tarjeta:
       - Leer posicionTarjeta = tarjeta.dataset.posicion
       - Si valorFiltro === "todas" -> mostrar
       - Si no:
           - Si posicionTarjeta === valorFiltro -> mostrar
           - Si no -> ocultar
    3) Para ocultar/mostrar:
       - style.display = "block" / "none"
       (o "grid"/"flex" según tu CSS, pero en el enunciado vale block)
    */
    const tarjetasJugadores = document.querySelectorAll("#listaJugadores .jugador")
    tarjetasJugadores.forEach(tarjeta => {
        let posicionTarjeta = tarjeta.dataset.posicion
        if (valorFiltro === "todas" || posicionTarjeta === valorFiltro) {
            tarjeta.style.display = "block"
        } else {
            tarjeta.style.display = "none"
        }

    });
}

function crearTarjetaJugador(nombre, dorsal, posicion, goles) {
    /*
    PSEUDOCÓDIGO (crear nodos + dataset):
    1) Crear <article>
    2) Añadir clase "jugador"
    3) (opcional) poner tabIndex = 0
    4) Asignar dataset:
       - tarjeta.dataset.dorsal = dorsal
       - tarjeta.dataset.posicion = posicion
       - tarjeta.dataset.goles = goles
    5) Crear la estructura interna (puedes usar innerHTML):
       - h3.nombre con el nombre
       - p.meta con dorsal y posicion
       - p.stats con <strong class="goles">goles</strong>
    6) Engancharle click (engancharClickTarjeta)
    7) Devolver la tarjeta creada
    */
    const tarjeta = document.createElement("article")
    tarjeta.classList.add("jugador")
    tarjeta.tabIndex = 0
    tarjeta.dataset.dorsal = String(dorsal)
    tarjeta.dataset.posicion = String(posicion)
    tarjeta.dataset.goles = String(goles)

    tarjeta.innerHTML = `
    <h3 class="nombre">${nombre}</h3>
    <p class="meta">Dorsal <strong class="dorsal">${dorsal}</strong> · <span class="posicion">${posicion}</span></p>
    <p class="stats">Goles: <strong class="goles">${goles}</strong></p>
    `;

    engancharClickTarjeta(tarjeta)
    return tarjeta
}

function validarNuevoJugador(nombre, dorsal, goles) {
    /*
    PSEUDOCÓDIGO:
    1) Crear boolean ok = true
    2) Si nombre vacío -> ok = false
    3) Si dorsal < 1 o NaN -> ok = false
    4) Si goles < 0 o NaN -> ok = false
    5) Devuelve ok (1 return como máximo)
    */
    let datosCorrectos = true
    if (nombre === "") datosCorrectos = false
    if (dorsal < 1) datosCorrectos = false
    if (goles < 0) datosCorrectos = false

    return datosCorrectos
}

function mostrarMensajeFormulario(texto) {
    /*
    PSEUDOCÓDIGO:
    1) mensajeForm.textContent = texto
    */
    mensajeForm.textContent = texto
}

function anadirJugadorDesdeFormulario() {
    /*
    PSEUDOCÓDIGO (submit):
    1) Leer valores:
       - nombre (trim)
       - dorsal (Number)
       - posicion (value del select)
       - goles (Number)
    2) Validar con validarNuevoJugador(...)
    3) Si OK:
       - crear tarjeta con crearTarjetaJugador(...)
       - appendChild a listaJugadores
       - reset del form
       - mensaje "ok"
    4) Si NO OK:
       - mensaje de error
    */
    const nombre = document.getElementById("nuevoNombre").value.trim()
    const dorsal = Number(document.getElementById("nuevoDorsal").value)
    const posicion = document.getElementById("nuevaPosicion").value
    const goles = Number(document.getElementById("nuevosGoles").value)

    if (validarNuevoJugador(nombre, dorsal, goles)) {
        const tarejta = crearTarjetaJugador(nombre, dorsal, posicion, goles)
        listaJugadores.appendChild(tarejta)
        formNuevoJugador.reset()
        mostrarMensajeFormulario("Jugador añadido correctamente")
    } else {
        console.log("Error al crear jugador");

    }
}

function borrarSeleccionado() {
    /*
    PSEUDOCÓDIGO:
    1) Si no hay jugadorSeleccionado -> no hacer nada
    2) Guardar referencia: aBorrar = jugadorSeleccionado
    3) Poner jugadorSeleccionado = null (para evitar líos)
    4) aBorrar.remove()
    5) Buscar el primer ".jugador" que quede
       - Si existe: seleccionarJugador(primero)
       - Si no: actualizarPanel(null)
    */
if (jugadorSeleccionado) {
    const aBorrar = jugadorSeleccionado
    jugadorSeleccionado = null
    aBorrar.remove()
    const primerJugador = document.querySelector(".jugador")
    if (primerJugador) {
        seleccionarJugador(primerJugador)
    } else {
        actualizarPanel(null)
    }
}
}

// ====== LISTENERS (NO TOCAR estructura, solo llamar a tus funciones) ======
btnSumarGol.addEventListener("click", function () {
    sumarGolSeleccionado();
});

btnBorrar.addEventListener("click", function () {
    borrarSeleccionado();
});

filtroPosicion.addEventListener("change", function () {
    filtrarPorPosicion(this.value);
});

formNuevoJugador.addEventListener("submit", function (event) {
    event.preventDefault();
    anadirJugadorDesdeFormulario();
});

// ====== INICIO ======

engancharClicksJugadoresExistentes();

// Selección inicial del primer jugador (si existe)
const primerJugador = document.querySelector(".jugador");
if (primerJugador) {
    seleccionarJugador(primerJugador);
} else {
    actualizarPanel(null);
}