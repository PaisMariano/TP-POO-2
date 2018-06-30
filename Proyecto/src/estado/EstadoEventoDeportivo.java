package estado;

import factorDeCancelacionOReactivacionDeApuesta.FactorDeCancelacionOReactivacionDeApuesta;

public abstract class EstadoEventoDeportivo implements FactorDeCancelacionOReactivacionDeApuesta{

	public Boolean estaFinalizado() {
		return new Boolean(false);
	}
	
	public Boolean estaEmpezado() {
		return false;
	} 

	public Boolean noHacomenzado() {
		return false;
	}


	
	
}
