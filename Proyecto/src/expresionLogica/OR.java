package expresionLogica;

import java.util.List;

import eventoDeportivo.EventoDeportivo;

public class OR extends OperacionLogica {

	public OR(ExpresionLogica expresionLogica, ExpresionLogica expresionDerecha) {
		super(expresionDerecha, expresionDerecha);
	}

		@Override
		public List<EventoDeportivo> getValor(List<EventoDeportivo> _eventos) {
			return  this.getExpresionIzquierda().getValor(_eventos); 
					//this.getExpresionDerecha().getValor(_eventos));
					
		}

}
