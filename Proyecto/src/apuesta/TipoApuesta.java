package apuesta;

import java.math.BigDecimal;

public abstract class TipoApuesta {

	public BigDecimal gananciaBruta(Apuesta _apuesta) {
		return new BigDecimal(_apuesta.monto() * _apuesta.cuotaConvenida());
	}
	
	public void cancelar(Apuesta _apuesta) {
		_apuesta.elEstadoDelPartidoDeLaApuesta().cancelar(_apuesta);
	}
	
	public void reactivar(Apuesta _apuesta) {
		_apuesta.elEstadoDelPartidoDeLaApuesta().reactivar(_apuesta);
	}
	
}
