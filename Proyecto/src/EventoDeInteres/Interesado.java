package EventoDeInteres;

import java.util.ArrayList;
import java.util.List;

public abstract class Interesado {
	protected List<EventoDeInteres> listaDeEventosInteresantes;
	
		public Interesado() {
			this.setEventos(new ArrayList<EventoDeInteres>());
		}

			public abstract void changed(EventoDeInteres eventoDeInteres);
			
			public void setEventos(List<EventoDeInteres> _eventos) {
				listaDeEventosInteresantes = _eventos;
			}
			
			public void agregarEventoDeInteres(EventoDeInteres _evento) {
				listaDeEventosInteresantes.add(_evento);
				_evento.agregarInteresado(this);
			}
}
