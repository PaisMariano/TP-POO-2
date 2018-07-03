package estado;

import apuesta.Apuesta;
import factorDeCancelacionOReactivacionDeApuesta.FactorDeCancelacionOReactivacionDeApuesta;

public class NoComenzado extends EstadoEventoDeportivo implements FactorDeCancelacionOReactivacionDeApuesta{
	
		public NoComenzado() {
			super(new Float(200));
		}
	
			@Override
			public boolean noHacomenzado()  {
				return true;
			}
		
			@Override
			public void cancelar(Apuesta _apuesta) {
				_apuesta.cambiarElTipoDeApuestaACancelada();
				_apuesta.reducirMontoConPenalidad(this.penalidad());
			}
		
			@Override
			public void reactivar(Apuesta _apuesta){
				_apuesta.cambiarElTipoDeApuestaASegura();
			}
}
