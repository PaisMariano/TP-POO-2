package estado;

import apuesta.Apuesta;
import factorDeCancelacionOReactivacionDeApuesta.FactorDeCancelacionOReactivacionDeApuesta;

public class Finalizado extends EstadoEventoDeportivo  implements FactorDeCancelacionOReactivacionDeApuesta{
	
	public Finalizado() {
		super(new Float(0));//No tiene penalizacion. Pero podria tenerla.
	}
	
		@Override
		public boolean estaFinalizado() {
			return true;
		}

		@Override
		public void cancelar(Apuesta _apuesta) {
			//No puede ser cancelada. Excepcion
		}

		@Override
		public void reactivar(Apuesta _apuesta){
			//No puede ser cancelada. Excepcion
		}

		@Override
		public Float penalidad(Apuesta _apuesta) {
			return penalidad;
		}
}
