package resultados;

import oponentes.Oponente;

public class Ganado extends Resultado {

	private Oponente ganador;
	
	public Ganado(Oponente _ganador) {
		ganador = _ganador;
	}
	
		@Override
		public Oponente getGanador() {
			return ganador;
		}

}
