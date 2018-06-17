package expresionLogica;

import java.util.ArrayList;
import java.util.List;

import eventoDeportivo.EventoDeportivo;

public class OR extends OperacionLogica {

	public OR(ExpresionLogica expresionLogica, ExpresionLogica expresionDerecha) {
		super(expresionDerecha, expresionDerecha);
	}

		@Override
		public List<EventoDeportivo> getValor(List<EventoDeportivo> _eventos) {
			List<EventoDeportivo> resultado = new ArrayList<EventoDeportivo>();
			this.sumarTodosLosElementos(resultado, this.getExpresionIzquierda().getValor(_eventos));
			this.sumarTodosLosElementos(resultado, this.getExpresionDerecha().getValor(_eventos));
			return  resultado; 
			//this.getExpresionIzquierda().getValor(_eventos)) + this.getExpresionDerecha().getValor(_eventos));		
		} 
		
		private void sumarTodosLosElementos(List<EventoDeportivo> listA, List<EventoDeportivo> listB) {
			for(EventoDeportivo evento : listB) {
				if(!listA.contains(evento)) {
					listA.add(evento);
				}
			}
		}
}
