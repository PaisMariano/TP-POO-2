package apuesta;

import java.math.BigDecimal;

public class Final extends TipoApuesta {

	@Override
	public void cancelar(Apuesta _apuesta) {
		this.errorApuestaFinal();
	}

	@Override
	public void reactivar(Apuesta _apuesta) {
		this.errorApuestaFinal();
	}

	@Override
	public BigDecimal gananciaBruta(Apuesta _apuesta) {
		return super.gananciaBruta(_apuesta);
	}
	
	private Exception errorApuestaFinal() {
		return new Exception("Este tipo de apuesta no puede ser cancelada o reactivada.");
	}

}
