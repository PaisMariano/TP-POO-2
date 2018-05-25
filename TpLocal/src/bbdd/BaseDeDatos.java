package bbdd;

import java.util.ArrayList;
import java.util.List;

import eventoDeportivo.EventoDeportivo;

public class BaseDeDatos implements BBDD{
	
	private List<EventoDeportivo> resultados;
	
		public BaseDeDatos() {
			resultados = new ArrayList<EventoDeportivo>(0);
		}

		public BaseDeDatos(List<EventoDeportivo> _partidos) {
			resultados = _partidos;
		}
			
			public void agregarPartido(EventoDeportivo _evento) {
				if(! _evento.estaFinalizado()) {
					this.errorNoFinalizado();
				}
				this.agregarPartidoFinalizado(_evento);
			}

			private void agregarPartidoFinalizado(EventoDeportivo _evento) {
				resultados.add(_evento);
			}
			
			//Ver
			private Exception errorNoFinalizado() {
				return new Exception("El evento aun no ha fnalizado.");
			}
}
