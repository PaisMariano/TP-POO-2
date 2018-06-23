package EventoDeInteres;

import java.util.ArrayList;
import java.util.List;

public abstract class Interesado {
	protected List<Interesante> interesantes;
	
		public Interesado() {
			this.setInteresantes(new ArrayList<Interesante>());
		}

			public abstract void cambio(Interesante eventoDeInteres);
			
			public void setInteresantes(List<Interesante> _eventos) {
				interesantes = _eventos;
			}
			
			public void agregarInteresante(Interesante _evento) {
				interesantes.add(_evento);
				_evento.agregarInteresado(this);
			}
}
