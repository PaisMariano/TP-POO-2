package resultados;

import oponentes.Oponente;

public abstract class Resultado{
	
	protected Oponente ganador;
	
		public Resultado(Oponente _ganador) {
			ganador = _ganador;
		}
	
		public abstract Oponente getGanador();

}
