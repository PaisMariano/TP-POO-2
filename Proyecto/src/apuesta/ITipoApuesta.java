package apuesta;

import java.math.BigDecimal;

public interface ITipoApuesta {
		
		public abstract BigDecimal gananciaBruta(Apuesta _apuesta);

		public abstract void cancelar(Apuesta _apuesta);

		public abstract void reactivar(Apuesta _apuesta);
}
