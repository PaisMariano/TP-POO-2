package apuesta;

import java.math.BigDecimal;

public class Cancelada implements TipoApuesta {
	
	public Cancelada() {
		
	}

		@Override
		public void cancelar(Apuesta _apuesta) {
			this.errorDeApuestaCancelada();
		}
		
		@Override
		//Depende del estado del partido si se puede o no
		public void reactivar(Apuesta _apuesta) {
			_apuesta.reactivarSiPuede();
		}
	
		@Override
		public BigDecimal gananciaBruta(Apuesta _apuesta){
			return new BigDecimal(0);
		}
		
		private Exception errorDeApuestaCancelada() {
			return new Exception("Esta apuesta no puede ser cancelada");
		}
}
