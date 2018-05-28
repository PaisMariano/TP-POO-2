package estado;

public abstract class EstadoEventoDeportivo {

	public Boolean estaFinalizado() {
		return new Boolean(false);
	}
	
	protected Exception errorCancelar() {
		return new Exception("La apuesta no puede ser cancelada");
	}

	public Boolean empezo() {
		return ! this.estaFinalizado();
	}

	public abstract void cancelar(Apuesta _apuesta){
		_apuesta.setMonto(this.montoPenalizacion(_apuesta))
	}

	public Float montoPenalizacion(Apuesta _apuesta){
		return _apuesta.monto();
	}

	public abstract void reactivar(Apuesta _apuesta);

}
