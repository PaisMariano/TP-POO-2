package criterio;

import java.util.List;
import java.util.stream.Collectors;

import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public class CriterioPorOponente extends CriterioDeBusqueda{
	private Oponente oponenteDeInteres;
	
		public CriterioPorOponente(Oponente _oponente) {
			oponenteDeInteres = _oponente;
		}

			@Override
			protected boolean cumpleCondicion(EventoDeportivo _evento) {
				return _evento.participo(oponenteDeInteres);
			}

}
