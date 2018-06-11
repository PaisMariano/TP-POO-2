package resultados;

import oponentes.Oponente;

public class Ganado extends Resultado {
	
	public Ganado(Oponente _ganador) {
		super(_ganador);
	}
	
		@Override
		public Oponente getGanador() {
			return ganador;
		}

}
