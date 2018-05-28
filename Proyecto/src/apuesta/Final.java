package apuesta;

public class Final implements TipoApuesta {

	@Override
	public void cancelar(Apuesta _apuesta) {
		// No deberia llegar aca.
	}

	@Override
	public void reactivar(Apuesta _apuesta) {
		// No deberia llegar aca.
	}

	@Override
	public Float gananciaBruta(Apuesta _apuesta) {
		return _apuesta.bruta();
	}

}
