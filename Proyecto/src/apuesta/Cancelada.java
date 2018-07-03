package apuesta;

import java.math.BigDecimal;

public class Cancelada extends TipoApuesta {
	
	public Cancelada() {
		
	}

		@Override
		public void cancelar(Apuesta _apuesta) {
			this.errorDeApuestaCancelada();
		}
		
		@Override
		public BigDecimal gananciaBruta(Apuesta _apuesta){
			return new BigDecimal(0);
		}
		
		private Exception errorDeApuestaCancelada() {
			return new Exception("Esta apuesta no puede ser cancelada");
		}
}
