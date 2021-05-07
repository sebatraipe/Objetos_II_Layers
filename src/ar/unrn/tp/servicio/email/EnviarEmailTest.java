package ar.unrn.tp.servicio.email;

import java.util.ArrayList;
import java.util.List;

import ar.unrn.tp.libreria.Email;
import ar.unrn.tp.modelo.EnvioEmail;

public class EnviarEmailTest implements EnvioEmail {

	private boolean envioDeEmail = false;
	private List<Email> listaEmail = new ArrayList<>();

	@Override
	public void enviarSaludo(String destinatarioFinal, String tituloEmail, String cuerpoEmail) {
		Email email = new Email(destinatarioFinal, tituloEmail, cuerpoEmail);
		this.listaEmail.add(email);
	}

	public boolean envioCorrectoDeEmail(String direccionEmail) {
		for (Email email : this.listaEmail) {
			if (email.destinatarioFinal.equals(direccionEmail)) {
				return true;
			}
		}
		return false;
	}
}
