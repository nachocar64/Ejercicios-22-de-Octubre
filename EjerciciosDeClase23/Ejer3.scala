trait Transporte {
    def costo(distancia: Double): Double
}

class Taxi (
    val placa: String
) extends Transporte {
    def costo(distancia: Double): Double = {
        distancia * 3 
    }
}

class Bus (
    val placa: String,
    val linea: Int
) extends Transporte {
    def costo(distancia: Double): Double = {
        distancia * 0.5 
    }
}

object Ejer3 {
    def calcularViaje(transporte: Transporte, distancia: Double): Double = {
        transporte.costo(distancia)
    }
    def main(args: Array[String]): Unit = {
        val taxi1 = new Taxi("676SXE")
        println(calcularViaje(taxi1, 6))
        val bus1 = new Bus("768BXE", 904)
        println(calcularViaje(bus1, 9))
    }
}