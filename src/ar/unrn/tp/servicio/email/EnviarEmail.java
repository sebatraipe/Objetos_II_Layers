package ar.unrn.tp.servicio.email;

import ar.unrn.tp.libreria.Email;
import ar.unrn.tp.libreria.SmtpException;
import ar.unrn.tp.modelo.EnvioEmail;

public class EnviarEmail implements EnvioEmail {

	@Override
	public void enviarSaludo(String destinatarioFinal, String tituloEmail, String cuerpoEmail) {
		try {
			Email email = new Email(destinatarioFinal, tituloEmail, cuerpoEmail);
			email.enviar();
		} catch (SmtpException e) {
			throw new RuntimeException("Error..." + e.getMessage());
		}
	}
}
