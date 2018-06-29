package criterio;

import java.util.List;
import java.util.stream.Collectors;

import eventoDeportivo.Deporte;
import eventoDeportivo.EventoDeportivo;

public class CriterioPorDeporte extends CriterioDeBusqueda{
	private Deporte deporteDeInteres;
	
		public CriterioPorDeporte(Deporte _deporte){
			deporteDeInteres = _deporte; //Sin setter, no quiero que perdure en  el tiempo
		}

			@Override
			protected boolean cumpleCondicion(EventoDeportivo _evento) {
				return _evento.esDeDeporte(deporteDeInteres);
			}

}