package criterio;


import java.util.List;
import java.util.stream.Collectors;
import eventoDeportivo.EventoDeportivo;

public class CriterioPorLugar extends Criterio{
	private String lugar;
	
		public CriterioPorLugar(String _lugar) {
			lugar = _lugar;
		}

			@Override
			public List<EventoDeportivo> buscarEn(List<EventoDeportivo> _eventos) {
				List<EventoDeportivo> resultado = _eventos
						.stream()
						.filter(_evento -> _evento.seJugoEn(lugar))
						.collect(Collectors.toList()); //No quiero cargarme la lista original.
				return resultado;
			}

}
