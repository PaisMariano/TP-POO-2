package estado;

import apuesta.Apuesta;
import factorDeCancelacionOReactivacionDeApuesta.FactorDeCancelacionOReactivacionDeApuesta;

public class NoComenzado extends EstadoEventoDeportivo implements FactorDeCancelacionOReactivacionDeApuesta{
	@Override
	public boolean noHacomenzado()  {
		return true;
	}
	@Override
		public  void cancelar(Apuesta _apuesta){
			//_apuesta.cancelarApuestaConPartidoNoComenzado();
		}
	@Override
		public  void reactivar(Apuesta _apuesta){
			_apuesta.cambiarElTipoDeApuestaASegura();
		}
	@Override
	public void setPenalidad(Float _penalidad) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Float getPenalidad() {
		// TODO Auto-generated method stub
		return null;
	}
		
}
