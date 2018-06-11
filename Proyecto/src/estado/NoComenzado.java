package estado;

import apuesta.Apuesta;
import factorDeCancelacionOReactivacionDeApuesta.FactorDeCancelacionOReactivacionDeApuesta;

public class NoComenzado extends EstadoEventoDeportivo implements FactorDeCancelacionOReactivacionDeApuesta{
	
	public NoComenzado() {
		
	}
		public  void cancelar(Apuesta _apuesta){
			_apuesta.cancelarApuestaConPartidoNoComenzado();
		}

		public  void reactivar(Apuesta _apuesta){
			_apuesta.reactivarApuesta();
		}
		
}
