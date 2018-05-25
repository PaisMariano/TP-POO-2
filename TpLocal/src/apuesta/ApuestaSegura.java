package apuesta;

import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public class ApuestaSegura extends Apuesta{

	public ApuestaSegura(Float _monto, EventoDeportivo _evento, Oponente _oponente) {
		super(_monto, _evento, _oponente);
	}

		@Override
		public void cancelar() {
			//Falta implementar
		}
	
}