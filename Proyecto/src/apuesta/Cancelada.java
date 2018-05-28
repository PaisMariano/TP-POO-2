package apuesta;

public class Cancelada extends TipoApuesta {

	@Override
	protected void cancelar(Apuesta _apuesta) {
		//Ya esta cancelada si llego aca.
	}
	
	@Override
	protected void reactivar(Apuesta _apuesta) {
		_apuesta.reactivarApuesta()
	}

	@Override
	public gananciaBruta(Apuesta _apuesta){
		return super(_apuesta) * this.descuento()
	}

	private descuento(){
		return 0.85;
	}
}
