package org.example.Reactor

import reactor.core.publisher.Mono

class Consultoria{
    fun calcularCostoTotal(costos: Costos, gastos: Gastos, porcentajeRiesgos: Double): Mono<CostoProyecto> {
        return Mono.fromSupplier {
            val totalCostos = costos.esfuerzo + costos.viaticos + costos.infraestructura
            val totalGastos = gastos.servicios + gastos.papeleria + gastos.energia
            val totalRiesgos = (totalCostos + totalGastos) * porcentajeRiesgos

            val retFuente = (totalCostos + totalGastos + totalRiesgos) * 0.11
            val reteIca = retFuente * 0.01
            val iva = (totalCostos + totalGastos + totalRiesgos + retFuente + reteIca) * 0.19

            val total = totalCostos + totalGastos + totalRiesgos + retFuente + reteIca + iva

            CostoProyecto(
                costos, gastos, Riesgos(porcentajeRiesgos), Impuestos(retFuente, reteIca, iva), total
            )
        }
    }
}