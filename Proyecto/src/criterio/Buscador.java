package criterio;

import java.util.List;

import eventoDeportivo.EventoDeportivo;
import expresionLogica.ExpresionLogica;

public class Buscador {
	
		public Buscador() {
		}
		
			public List<EventoDeportivo> realizarBusquedaEn(List<EventoDeportivo> _eventos, ExpresionLogica _expresionCriterio) {
				return _expresionCriterio.getValor(_eventos);
			}						
}
