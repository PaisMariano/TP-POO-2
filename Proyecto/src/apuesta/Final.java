package apuesta;

public class Final extends TipoApuesta {

	private Exception errorCancelar() {
		return new Exception("La apuesta no puede ser cancelada");
	}

	@Override
	protected Boolean puedeSerCancelada(Apuesta _apuesta) {
		Boolean no = new Boolean(false); 
		return no;
	}

	@Override
	protected void cancelarApuesta(Apuesta _apuesta) {
		this.errorCancelar();
	}
}