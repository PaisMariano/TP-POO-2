package eventoDeInteres;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Matchers;

import eventoDeportivo.EventoDeportivo;

public abstract class Interesante {//Observer
	protected List<Interesado> interesados;

	public Interesante() {
		this.setInteresados(new ArrayList<Interesado>());
	}
	
		public void notificarCambio() {
			for(Interesado interesado : interesados) {
				interesado.recibirCambio(this);
			}
		}

		public void agregarInteresado(Interesado _interesado) {
			interesados.add(_interesado);
		}
		
		public void setInteresados(List<Interesado> _interesados) {
			interesados = _interesados;
		}

		public List<Interesado> interesados() {
			return interesados;
		}

		public abstract  boolean haComenzado();	
		
		public abstract boolean haTerminado();
		
		
}