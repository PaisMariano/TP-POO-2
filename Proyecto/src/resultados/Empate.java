package resultados;

import eventoDeportivo.EventoDeportivo;
import oponentes.*;

public class Empate extends Resultado {
	
	public Empate() { 
		
	}

	@Override
	public Oponente getApostado() {
		return null;
	}

	@Override
	public Float getCuotaApuesta(EventoDeportivo _evento, Resultado _resultadoApostado) {
		return _evento.getCuotaEmpate();
	}

}
