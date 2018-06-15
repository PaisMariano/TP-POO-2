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
			protected boolean cumpleCondicion(EventoDeportivo _evento) {
				return _evento.sucedioEn(fechaInteres);
			}
}
