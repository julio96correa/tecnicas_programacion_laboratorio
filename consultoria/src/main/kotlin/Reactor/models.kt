package org.example.Reactor

data class Costos(val esfuerzo: Double, val viaticos: Double, val infraestructura: Double)
data class  Gastos(val servicios: Double, val papeleria: Double, val energia: Double)
data class Riesgos(val porcentaje: Double)
data class Impuestos(val reteFuente: Double, val reteIca: Double, val iva:Double)
data class CostoProyecto(val constos: Costos, val gastos: Gastos, val riesgos: Riesgos, val impuestos: Impuestos, val total: Double)
