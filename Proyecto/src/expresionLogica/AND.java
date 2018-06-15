package expresionLogica;

import java.util.List;

import eventoDeportivo.EventoDeportivo;

public class AND extends OperacionLogica {

	public AND(ExpresionLogica expresionIzquierda, ExpresionLogica expresionDerecha) {
		super(expresionIzquierda, expresionDerecha);
	}

		@Override
		public List<EventoDeportivo> getValor(List<EventoDeportivo> _eventos) {
			return this.getExpresionIzquierda().getValor(this.getExpresionDerecha().getValor(_eventos));
		}

}
