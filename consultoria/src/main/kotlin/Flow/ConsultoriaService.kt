package Flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Servicio para calcular el costo total de un proyecto de consultoría.
 */
class ConsultoriaService {
    /**
     * Calcula el costo total del proyecto.
     *
     * @param costos Costos del proyecto.
     * @param gastos Gastos adicionales del proyecto.
     * @param porcentajeRiesgos Porcentaje de riesgos aplicados.
     * @return Un `Flow` que emite un `CostoProyecto` con el cálculo total.
     */
    fun calcularCostoTotal(costos: Costos, gastos: Gastos, porcentajeRiesgos: Double): Flow<CostoProyecto> {
        return flow {
            val totalCostos = costos.esfuerzo + costos.viaticos + costos.infraestructura
            val totalGastos = gastos.servicios + gastos.papeleria + gastos.energia
            val totalRiesgos = (totalCostos + totalGastos) * porcentajeRiesgos

            val retFuente = (totalCostos + totalGastos + totalRiesgos) * 0.11
            val reteIca = retFuente * 0.01
            val iva = (totalCostos + totalGastos + totalRiesgos + retFuente + reteIca) * 0.19

            val total = totalCostos + totalGastos + totalRiesgos + retFuente + reteIca + iva

            emit(CostoProyecto(
                costos, gastos, Riesgos(porcentajeRiesgos), Impuestos(retFuente, reteIca, iva), total
            ))
        }
    }
}
