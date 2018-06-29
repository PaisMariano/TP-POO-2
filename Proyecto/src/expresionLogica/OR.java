package expresionLogica;

import java.util.ArrayList;
import java.util.List;

import eventoDeportivo.EventoDeportivo;

public class OR extends OperacionLogica {

	public OR(ExpresionLogica expresionIzquierda, ExpresionLogica expresionDerecha) {
		super(expresionIzquierda, expresionDerecha);
	}

		@Override
		public List<EventoDeportivo> getValor(List<EventoDeportivo> _eventos) {
			List<EventoDeportivo> resultado = new ArrayList<EventoDeportivo>();
			this.sumarTodosLosElementos(resultado, this.getExpresionIzquierda().getValor(_eventos));
			this.sumarTodosLosElementos(resultado, this.getExpresionDerecha().getValor(_eventos));
			return  resultado; 		
		} 
		
		private void sumarTodosLosElementos(List<EventoDeportivo> listA, List<EventoDeportivo> listB) {
			for(EventoDeportivo evento : listB) {
				if(!listA.contains(evento)) {//Agrego esta linea para no tener elementos repetidos
					listA.add(evento);
				}
			}
		}
}
