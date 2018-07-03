package estado;

import apuesta.Apuesta;
import factorDeCancelacionOReactivacionDeApuesta.FactorDeCancelacionOReactivacionDeApuesta;

public class EnJuego extends EstadoEventoDeportivo implements FactorDeCancelacionOReactivacionDeApuesta{
 
		public EnJuego(){
			super(new Float(30));
		}
		
			public Float penalidad(Apuesta _apuesta) {
				return _apuesta.monto() * penalidad / new Float(100);
			}
		
			@Override
			public void cancelar(Apuesta _apuesta) {
				_apuesta.cambiarElTipoDeApuestaACancelada();
				_apuesta.reducirMontoConPenalidad(this.penalidad(_apuesta));
			}
	
			@Override
			public void reactivar(Apuesta _apuesta){
				//Rompe - Con el partido en juego no se puede reactivar.
			}
	
			@Override
			public boolean estaEmpezado() {
				return true;
			}

}
