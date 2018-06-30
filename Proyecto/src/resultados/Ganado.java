package resultados;

import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public class Ganado extends Resultado {
	protected Oponente ganador;
	
	public Ganado(Oponente _ganador) {
		ganador = _ganador;
	}
	
		@Override
		public Oponente getApostado() {
			return ganador;
		}

		@Override
		public Float getCuotaApuesta(EventoDeportivo _evento, Resultado _resultadoApostado) {
			Float resultado = _evento.getCuotaOponente2();  
			int n = _evento.getOponentes().indexOf(_resultadoApostado.getApostado());
			if(n == 0) {
				resultado = _evento.getCuotaOponente1();
			}
			return resultado;
		}
 
}
