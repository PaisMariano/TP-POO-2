package estado;

import apuesta.Apuesta;
import factorDeCancelacionOReactivacionDeApuesta.FactorDeCancelacionOReactivacionDeApuesta;

public class EnJuego extends EstadoEventoDeportivo implements FactorDeCancelacionOReactivacionDeApuesta{
	private Float penalidad;

		public EnJuego(){
			this.setPenalidad(new Float(200));
		}
		
		
		@Override
		public void setPenalidad(Float _penalidad) {
			penalidad = _penalidad;
		}
		
		public Float getPenalidad() {
			return penalidad;
		}
	
		@Override
		public void cancelar(Apuesta _apuesta) {
				_apuesta.cambiarElTipoDeApuestaACancelada();
				_apuesta.reducirMontoConPenalidad(this.penalidad());
		}
	
		private Float penalidad() {
			return penalidad;
		}

		@Override
		public void reactivar(Apuesta _apuesta){
			//No puede ser reactivada. Excepcion?
		}

		@Override
		public boolean estaEmpezado() {
			return true;
		}

}
