package EventoDeInteres;

import java.util.ArrayList;
import java.util.List;

public abstract class Interesado {
	private List<EventoDeInteres> listaDeEventosInteresantes;
	
		public Interesado() {
			this.setEventos(new ArrayList<EventoDeInteres>());
		}

			public void changed(EventoDeInteres eventoDeInteres) {
				//No queda claro lo que debe hacer
			}
			
			public void setEventos(List<EventoDeInteres> _eventos) {
				listaDeEventosInteresantes = _eventos;
			}
			
			public void agregarEvento(EventoDeInteres _evento) {
				listaDeEventosInteresantes.add(_evento);
				_evento.agregarInteresado(this);
			}
}
