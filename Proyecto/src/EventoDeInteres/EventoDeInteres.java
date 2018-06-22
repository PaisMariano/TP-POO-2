package EventoDeInteres;

import java.util.ArrayList;
import java.util.List;

public abstract class EventoDeInteres {
	private List<Interesado> interesados;

	public EventoDeInteres() {
		interesados = new ArrayList<Interesado>();
	}
	
	public EventoDeInteres(ArrayList<Interesado> _interesados) {
		interesados = _interesados;
	}

		public void iChanged() {
			for(Interesado interesado : interesados) {
				interesado.changed(this);
			}
		}

		public void agregarInteresado(Interesado _interesado) {
			interesados.add(_interesado);
		}

}
