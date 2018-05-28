package apuesta;

public class Final extends TipoApuesta {

	@Override
	protected Boolean puedeSerCancelada(Apuesta _apuesta) {
		return new Boolean(false); 
	}

	@Override
	protected void cancelarApuesta(Apuesta _apuesta) {
		//No deberia de llegar aca.
	}

	@Override
	public gananciaBruta(){
		return _apuesta.cuotaConvenida() * this.monto()
	}
}
