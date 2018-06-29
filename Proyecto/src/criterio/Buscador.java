package criterio;

import java.util.List;

import eventoDeportivo.EventoDeportivo;
import expresionLogica.ExpresionLogica;

public class Buscador {
	
		public Buscador() {
		}
			
			//No creo que esta clase sea necesaria, pero me gustaria "abstraer" a 
			//la casa de apuestas del hecho de realizar busquedas (sobre todo  de todas las relaciones que se deberian de dar entre 
			//esta y las clases participantes.)
		
			public List<EventoDeportivo> realizarBusquedaEn(List<EventoDeportivo> _eventos, ExpresionLogica _expresionCriterio) {
				return _expresionCriterio.getValor(_eventos);
			}						
}
