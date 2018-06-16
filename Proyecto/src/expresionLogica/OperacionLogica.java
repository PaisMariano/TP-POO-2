package expresionLogica;

import java.util.List;

import criterio.Criterio;
import eventoDeportivo.EventoDeportivo;

public abstract class OperacionLogica implements ExpresionLogica{
	private ExpresionLogica expresionIzq;
	private ExpresionLogica expresionDer;
	
		public OperacionLogica(ExpresionLogica expresionIzquierda, ExpresionLogica expresionDerecha) {
			this.setExpresionIzquierda(expresionIzquierda);
			this.setExpresionDerecha(expresionDerecha);
		}
	
			public ExpresionLogica getExpresionIzquierda() {
				return expresionIzq;
			}
			
			public ExpresionLogica getExpresionDerecha() {
				return expresionDer;
			}
			
			public void setExpresionIzquierda(ExpresionLogica _expresionIzquierda) {
				expresionIzq = _expresionIzquierda;
			}
			
			public void setExpresionDerecha(ExpresionLogica _expresionDerecha) {
				expresionDer = _expresionDerecha;
			}
			
			@Override
			public abstract List<EventoDeportivo> getValor(List<EventoDeportivo> _eventos);
}