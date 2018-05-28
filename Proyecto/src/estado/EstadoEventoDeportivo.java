package estado;

public abstract class EstadoEventoDeportivo {

	public Boolean estaFinalizado() {
		return new Boolean(false);
	}
	
	protected Exception errorCancelar() {
		return new Exception("La apuesta no puede ser cancelada");
	}

	public abstract void activar();
	
	public abstract void desactivar();

	public Boolean empezo() {
		return ! this.estaFinalizado();
	}
}
