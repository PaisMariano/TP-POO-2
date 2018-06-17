package criterio;

import java.util.ArrayList;
import java.util.List;
import eventoDeportivo.EventoDeportivo;
import expresionLogica.ExpresionLogica;

public abstract class CriterioDeBusqueda {

	//Template
	public List<EventoDeportivo> buscarEn(List<EventoDeportivo> _eventos){
		List<EventoDeportivo> resultado = new ArrayList<EventoDeportivo>();
			for(EventoDeportivo _evento : _eventos) {
				if(this.cumpleCondicion(_evento)) {
					resultado.add(_evento);
				}
			}
		return resultado;
	}

	//Hook
	protected abstract boolean cumpleCondicion(EventoDeportivo _evento);

}
