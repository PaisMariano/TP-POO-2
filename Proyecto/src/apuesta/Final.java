package apuesta;

import java.math.BigDecimal;

public class Final implements TipoApuesta {

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
		return new BigDecimal (_apuesta.cuotaConvenida() * _apuesta.monto());
	}
	
	private Exception errorApuestaFinal() {
		return new Exception("Este tipo de apuesta no puede ser cancelada o reactivada.");
	}

}
