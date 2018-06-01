package resultados;

import oponentes.*;

public class Empate extends Resultado {
	
	Oponente nadie; 
	
	public Empate() { 
		nadie = new None();
	}

		@Override
		//Aca quiero un nullObject
		public Oponente getGanador() {
			return nadie;//
		}

}
