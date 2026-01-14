
// Ejercicio 1. Mejora de legibilidad en código JavaScript

// A continuación se presentan dos fragmentos de código JavaScript funcionales, pero escritos con una calidad baja o muy
// baja. Ambos programas funcionan correctamente, pero resultan difíciles de leer, entender y mantener.

// El objetivo de este ejercicio es mejorar la legibilidad del código aplicando los conocimientos vistos durante el primer
// trimestre y reforzados en esta unidad.

// 1.1. Indicaciones generales

// No cambies el comportamiento del programa.
// No añadas nueva funcionalidad.
// Mejora los nombres de variables y funciones.
// Aplica una convención de nomenclatura coherente.
// Ordena el código si es necesario.
// Elimina ambigüedades y mejora la claridad general.
// No añadas comentarios innecesarios para explicar lo obvio.

//@ts-check

// 1.2. Código A
// Este código realiza una serie de comprobaciones y devuelve un valor numérico en función de los parámetros recibidos.
/**
 * 
 * @param {Number} ValorA 
 * @param {Number} ValorB 
 * @param {Number} ValorC 
 * @returns {Number}
 */
function comprobaciones(ValorA, ValorB, ValorC) {
    let resultado = 0
    if (ValorA > 0 && ValorB > 0) {
        resultado = ValorA + ValorB
    } else if (ValorA > 0 && ValorB <= 0) {
        resultado = ValorA - ValorC
    } else if (ValorA <= 0 && ValorC > 0) {
        resultado = ValorB + ValorC
    } else {
        resultado = 0
    }
    return resultado
}

let prueba = comprobaciones(7, 9, 3)