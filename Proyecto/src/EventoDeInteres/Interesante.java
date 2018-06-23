package EventoDeInteres;

import java.util.ArrayList;
import java.util.List;

public abstract class Interesante {
	protected List<Interesado> interesados;

	public Interesante() {
		this.setInteresados(new ArrayList<Interesado>());
	}
		public void cambie() {
			for(Interesado interesado : interesados) {
				interesado.cambio(this);
			}
		}

		public void agregarInteresado(Interesado _interesado) {
			interesados.add(_interesado);
		}
		
		public void setInteresados(List<Interesado> _interesados) {
			interesados = _interesados;
		}

}
