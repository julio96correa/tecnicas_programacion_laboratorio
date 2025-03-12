package org.example.Reactor

fun main() {
    val costos = Costos(esfuerzo = 500000.0, viaticos = 1000.0, infraestructura = 1500.0)
    val gastos = Gastos(servicios = 800.0, papeleria = 200.0, energia = 500.0)
    val porcentajeRiesgos = 20.0

    val servicio = Consultoria()
    servicio.calcularCostoTotal(costos, gastos, porcentajeRiesgos)
        .subscribe { resultado ->
            println("Version con Reactor")
            println("Costo total del proyecto: $${String.format("%,.2f", resultado.total)}")
        }}
