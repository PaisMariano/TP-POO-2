package criterio;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import eventoDeportivo.EventoDeportivo;

public class CriterioPorFecha extends Criterio{
	private Date fechaInteres;
	
		public CriterioPorFecha(Date _fecha){
			fechaInteres = _fecha; //Sin setter, no quiero que perdure en  el tiempo
		}

			@Override
			public List<EventoDeportivo> buscarEn(List<EventoDeportivo> _eventos) {
				List<EventoDeportivo> resultado = _eventos
						.stream()
						.filter(_evento -> _evento.sucedioEn(fechaInteres))
						.collect(Collectors.toList()); //No quiero cargarme la lista original.
				return resultado;
			}
}
