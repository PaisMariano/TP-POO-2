package estado;

import apuesta.Apuesta;
import factorDeCancelacionOReactivacionDeApuesta.FactorDeCancelacionOReactivacionDeApuesta;

public class EnJuego extends EstadoEventoDeportivo implements FactorDeCancelacionOReactivacionDeApuesta{


		public EnJuego(){

		}
	
		@Override
		public void cancelar(Apuesta _apuesta) {
				_apuesta.cancelarApuestaConPartidoEnJuego();
		}
	
		@Override
		public void reactivar(Apuesta _apuesta){
			//No puede ser reactivada. Excepcion?
		}

}
