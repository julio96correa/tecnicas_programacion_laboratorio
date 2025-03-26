package Flow

/**
 * Representa los costos de un proyecto.
 * @property esfuerzo Costo asociado al esfuerzo humano.
 * @property viaticos Gastos de viáticos.
 * @property infraestructura Costos de infraestructura.
 */
data class Costos(val esfuerzo: Double, val viaticos: Double, val infraestructura: Double)

/**
 * Representa los gastos de un proyecto.
 * @property servicios Gastos en servicios.
 * @property papeleria Gastos en papelería.
 * @property energia Costos de energía.
 */
data class Gastos(val servicios: Double, val papeleria: Double, val energia: Double)

/**
 * Representa los riesgos del proyecto en términos de porcentaje.
 */
data class Riesgos(val porcentaje: Double)

/**
 * Representa los impuestos aplicados al proyecto.
 * @property reteFuente Retención en la fuente.
 * @property reteIca Retención ICA.
 * @property iva Impuesto al valor agregado.
 */
data class Impuestos(val reteFuente: Double, val reteIca: Double, val iva: Double)

/**
 * Representa el costo total del proyecto.
 * @property costos Costos asociados.
 * @property gastos Gastos asociados.
 * @property riesgos Riesgos considerados.
 * @property impuestos Impuestos aplicados.
 * @property total Costo total del proyecto.
 */
data class CostoProyecto(
    val costos: Costos,
    val gastos: Gastos,
    val riesgos: Riesgos,
    val impuestos: Impuestos,
    val total: Double
)
