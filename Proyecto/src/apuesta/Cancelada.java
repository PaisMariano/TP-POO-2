package apuesta;

import java.math.BigDecimal;

public class Cancelada implements TipoApuesta {

	@Override
	public void cancelar(Apuesta _apuesta) {
		//Ya esta cancelada si llego aca.
	}
	
	@Override
	//Depende del estado si se puede o no
	public void reactivar(Apuesta _apuesta) {
		_apuesta.reactivarSiPuede();
	}

	@Override
	public BigDecimal gananciaBruta(Apuesta _apuesta){
		return new BigDecimal(0);
	}

}
