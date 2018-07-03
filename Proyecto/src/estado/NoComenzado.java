package estado;

import apuesta.Apuesta;
import factorDeCancelacionOReactivacionDeApuesta.FactorDeCancelacionOReactivacionDeApuesta;

public class NoComenzado extends EstadoEventoDeportivo implements FactorDeCancelacionOReactivacionDeApuesta{
	
		public NoComenzado() {
			super(new Float(200));
		}
		
			@Override
			public void cancelar(Apuesta _apuesta) {
				_apuesta.cambiarElTipoDeApuestaACancelada();
				_apuesta.reducirMontoConPenalidad(this.penalidad(_apuesta));
			}
		
			@Override
			public void reactivar(Apuesta _apuesta){
				_apuesta.cambiarElTipoDeApuestaASegura();
			}

			@Override
			public Float penalidad(Apuesta _apuesta) {
				return penalidad;
			}
}
