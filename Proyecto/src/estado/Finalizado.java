package estado;

import apuesta.Apuesta;
import factorDeCancelacionOReactivacionDeApuesta.FactorDeCancelacionOReactivacionDeApuesta;

public class Finalizado extends EstadoEventoDeportivo  implements FactorDeCancelacionOReactivacionDeApuesta{
	
	public Finalizado() {
		
	}
	
		@Override
		public boolean estaFinalizado() {
			return true;
		}

		@Override
		public void cancelar(Apuesta _apuesta) {
			//NO puede ser cancelada. Excepcion?
		}

		@Override
		public void reactivar(Apuesta _apuesta){
			//Tampoco deberia ser reactivada con el partido finalizado.
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
