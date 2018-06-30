package resultados;

import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public abstract class Resultado{
		
		public abstract Oponente getApostado();
		
		public abstract Float getCuotaApuesta(EventoDeportivo _evento, Resultado _resultadoApostado);

		public Boolean equals(Resultado unResultado) {
			// TODO Auto-generated method stub
			return null;
		}

}
