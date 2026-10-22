trait Notificacion {
    def contacto: String
    def enviar(mensaje: String, receptor: Notificacion): String
    def recibir(mensaje: String, emisor: Notificacion): String
}

class Email (
    val direccion: String
) extends Notificacion {
    def contacto: String = direccion
    def enviar(mensaje: String, receptor: Notificacion): String = {
        s"Enviando correo: $mensaje a ${receptor.contacto}"
    }
    def recibir(mensaje: String, emisor: Notificacion): String = {
        s"Recibiendo correo de: ${emisor.contacto}, con el contenido: $mensaje"
    }
}

class SMS (
    val numero: String
) extends Notificacion {
    def contacto: String = numero
    def enviar(mensaje: String, receptor: Notificacion): String = {
        s"Enviando SMS: $mensaje a ${receptor.contacto}"
    }
    def recibir(mensaje: String, emisor: Notificacion): String = {
        s"Recibiendo SMS de: ${emisor.contacto}, con el contenido: $mensaje"
    }
}

class NotificacionPush (
    val aplicacion: String
) extends Notificacion {
    def contacto: String = aplicacion
    def enviar(mensaje: String, receptor: Notificacion): String = {
        s"Enviando Notificación: $mensaje a ${receptor.contacto}"
    }
    def recibir(mensaje: String, emisor: Notificacion): String = {
        s"Recibiendo Notificación de: ${emisor.contacto}, con el contenido: $mensaje"
    }
}

object Ejer5 {
    def push(notificacion: Notificacion, mensaje: String, receptor:Notificacion): String = {
        notificacion.enviar(mensaje, receptor)
    }
    def listen(notificacion: Notificacion, mensaje: String, emisor: Notificacion): String = {
        notificacion.recibir(mensaje, emisor)
    }
    def main(args: Array[String]): Unit = {
        val correo1 = new Email("ignaciocardenas1@upb.edu")
        val correo2 = new Email("paoloelias1@upb.edu")
        val sms1 = new SMS("+591 72598545")
        val sms2 = new SMS("+591 77213588")
        val not1 = new NotificacionPush("WhatsApp")
        val not2 = new NotificacionPush("AndroidMain") //digamos que a la parte de Android que procesa esto
        println(s"El correo ${correo1.direccion} envia la notificacion: ${push(correo1, "Hola", correo2)}")
        println(s"El numero ${sms1.numero} envia la notificacion: ${push(sms1, "Hola", sms2)}")
        println(s"La aplicacion ${not1.aplicacion} envia la notificacion: ${push(not1, "Nuevos Mensajes", not2)}")
    }

}