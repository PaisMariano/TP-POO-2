package resultados;

import oponentes.*;

public class Empate extends Resultado {
	
	public Empate() { 
		super(new None());
	}

	@Override
	public Oponente getGanador() {
		return ganador;
	}

}
