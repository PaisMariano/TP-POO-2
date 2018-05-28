package resultados;

import oponentes.*;

public class Empate extends Resultado {

	@Override
	//Aca quiero un nullObject
	public Oponente getGanador() {
		return new None();//
	}

}
