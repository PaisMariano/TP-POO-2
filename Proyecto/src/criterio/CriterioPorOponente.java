package criterio;

import java.util.List;
import java.util.stream.Collectors;

import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public class CriterioPorOponente extends Criterio{
	private Oponente oponenteDeInteres;
	
		public CriterioPorOponente(Oponente _oponente) {
			oponenteDeInteres = _oponente;
		}

			@Override
			public List<EventoDeportivo> buscarEn(List<EventoDeportivo> _eventos) {
				List<EventoDeportivo> resultado = _eventos
						.stream()
						.filter(_evento -> _evento.participo(oponenteDeInteres))
						.collect(Collectors.toList()); //No quiero cargarme la lista original.
				return resultado;
			}

}
