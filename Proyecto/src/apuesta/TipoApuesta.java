package apuesta;

public interface TipoApuesta {
		
		public abstract Float gananciaBruta(Apuesta _apuesta);

		public abstract void cancelar(Apuesta _apuesta);

		public abstract void reactivar(Apuesta _apuesta);
		
}
