package estado;

import factorDeCancelacionOReactivacionDeApuesta.FactorDeCancelacionOReactivacionDeApuesta;

public abstract class EstadoEventoDeportivo implements FactorDeCancelacionOReactivacionDeApuesta{

	public boolean estaFinalizado() {
		return false;
	}
	
	public boolean estaEmpezado() {
		return false;
	} 

	public boolean noHacomenzado() {
		return false;
	}


	
	
}
