package ar.unrn.tp.libreria;

public class Email {

	public String destinatarioFinal;
	public String tituloEmail;
	public String cuerpoEmail;

	public Email(String destinatarioFinal, String tituloEmail, String cuerpoEmail) {
		this.destinatarioFinal = destinatarioFinal;
		this.tituloEmail = tituloEmail;
		this.cuerpoEmail = cuerpoEmail;
	}

	public void enviar() throws SmtpException {
//		Conectar con el servidor
//		Si algo sale mal, se lanza una SmtpException

//		Si todo sale bien
		System.out.println("Se envió el email correctamente");

	}

}
