package apuesta;

import java.math.BigDecimal;

public class Final implements TipoApuesta {

	@Override
	public void cancelar(Apuesta _apuesta) {
		// Error? No deberia llegar aca, no es cancelable.
	}

	@Override
	public void reactivar(Apuesta _apuesta) {
		// Error? No deberia llegar aca, no es reactivable entonces no es cancelable.
	}

	@Override
	public BigDecimal gananciaBruta(Apuesta _apuesta) {
		return _apuesta.gananciaBruta(); 
	}

}
