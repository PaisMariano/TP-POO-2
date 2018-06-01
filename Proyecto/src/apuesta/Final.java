package apuesta;

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
	public Float gananciaBruta(Apuesta _apuesta) {
		return _apuesta.bruta(); 
	}

}
