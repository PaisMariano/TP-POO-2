package criterio;


import java.util.List;
import java.util.stream.Collectors;
import eventoDeportivo.EventoDeportivo;

public class CriterioPorLugar extends CriterioDeBusqueda{
	private String lugar;
	
		public CriterioPorLugar(String _lugar) {
			lugar = _lugar;
		}

			@Override
			protected boolean cumpleCondicion(EventoDeportivo _evento) {
				return _evento.seJugoEn(lugar);
			}

}
