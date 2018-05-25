package apuesta;

import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public class ApuestaFinal extends Apuesta{

	public ApuestaFinal(Float _monto, EventoDeportivo _evento, Oponente _oponente) {
		super(_monto, _evento, _oponente);
	}

	@Override
	public void cancelar() {
		//No hace nada. Deberia tirar excepcion?
	}
	
}
