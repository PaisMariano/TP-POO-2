package criterio;

import java.util.List;
import eventoDeportivo.EventoDeportivo;
import expresionLogica.ExpresionLogica;

public abstract class Criterio implements ExpresionLogica{

	//Template
	@Override
	public List<EventoDeportivo> getValor(List<EventoDeportivo> _eventos) {
		return this.buscarEn(_eventos);
	}
	
	//Hook
	public abstract List<EventoDeportivo> buscarEn(List<EventoDeportivo> _eventos);

}
