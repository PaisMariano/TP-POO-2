package EventoDeInteres;

import java.util.ArrayList;
import java.util.List;

public abstract class EventoDeInteres {
	protected List<Interesado> interesados;

	public EventoDeInteres() {
		this.setInteresados(new ArrayList<Interesado>());
	}
		public void iChanged() {
			for(Interesado interesado : interesados) {
				interesado.changed(this);
			}
		}

		public void agregarInteresado(Interesado _interesado) {
			interesados.add(_interesado);
		}
		
		public void setInteresados(List<Interesado> _interesados) {
			interesados = _interesados;
		}

}
