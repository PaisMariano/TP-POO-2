package EventoDeInteres;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Matchers;

import eventoDeportivo.EventoDeportivo;

public abstract class Interesante {//Observer
	protected List<Interesado> interesados;
	private EventoDeportivo evento;
	
	public Interesante() {
		this.setInteresados(new ArrayList<Interesado>());
	}
	
		public Interesante(EventoDeportivo _evento) {
			evento = _evento;
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
		
		public boolean haComenzado() {
			return evento.empezoEvento();
		}
		
		public boolean haTerminado() {
			return evento.estaFinalizado();
		}

		public List<Interesado> interesados() {
			return interesados;
		}

}