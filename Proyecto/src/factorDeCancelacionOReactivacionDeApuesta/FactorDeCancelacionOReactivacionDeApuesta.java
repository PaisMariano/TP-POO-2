package factorDeCancelacionOReactivacionDeApuesta;

import apuesta.Apuesta;

public interface FactorDeCancelacionOReactivacionDeApuesta {

	public void cancelar(Apuesta _apuesta);
	
	public void reactivar(Apuesta _apuesta);
	
	public Float penalidad(Apuesta _apuesta);

}
