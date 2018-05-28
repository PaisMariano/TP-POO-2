package apuesta;

public abstract class TipoApuesta {
	
	public void cancelar(Apuesta _apuesta) {
		if(this.puedeSerCancelada(_apuesta)) {
			this.cancelarApuesta(_apuesta);
		}
	}

	protected abstract Boolean puedeSerCancelada(Apuesta _apuesta);
	
	protected abstract Float gananciaBruta();

	protected abstract void cancelarApuesta(Apuesta _apuesta);
}
