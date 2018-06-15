package criterio;

import java.util.List;
import java.util.stream.Collectors;

import eventoDeportivo.Deporte;
import eventoDeportivo.EventoDeportivo;

public class CriterioPorDeporte extends Criterio{
	private Deporte deporteDeInteres;
	
		public CriterioPorDeporte(Deporte _deporte){
			deporteDeInteres = _deporte; //Sin setter, no quiero que perdure en  el tiempo
		}

			@Override
			public List<EventoDeportivo> buscarEn(List<EventoDeportivo> _eventos) {
				List<EventoDeportivo> resultado = _eventos
						.stream()
						.filter(_evento -> _evento.esDeDeporte(deporteDeInteres))
						.collect(Collectors.toList()); //No quiero cargarme la lista original.
				return resultado;
			}

}