package criterio;

import java.util.ArrayList;
import java.util.List;
import eventoDeportivo.EventoDeportivo;
import expresionLogica.ExpresionLogica;

public abstract class Criterio implements ExpresionLogica{

	
	@Override
	public List<EventoDeportivo> getValor(List<EventoDeportivo> _eventos) {
		return this.buscarEn(_eventos);
	}
	
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
