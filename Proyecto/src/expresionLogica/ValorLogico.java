package expresionLogica;

import java.util.List;

import criterio.CriterioDeBusqueda;
import eventoDeportivo.EventoDeportivo;

public class ValorLogico implements ExpresionLogica{
	//Adapter de criterios de busqueda.
	private CriterioDeBusqueda criterioDeBusqueda;
	
		public ValorLogico(CriterioDeBusqueda _criterio) {
			this.setCriterio(_criterio);
		}
		
			@Override
			public List<EventoDeportivo> getValor(List<EventoDeportivo> _eventos) {
				return criterioDeBusqueda.buscarEn(_eventos);
			}
			
			public void setCriterio(CriterioDeBusqueda _criterio) {
				criterioDeBusqueda = _criterio;
			}
			
			public CriterioDeBusqueda getCriterio() {
				return criterioDeBusqueda;
			}
	

}
