package apuesta;

public class Cancelada implements TipoApuesta {

	@Override
	public void cancelar(Apuesta _apuesta) {
		//Ya esta cancelada si llego aca.
	}
	
	@Override
	public void reactivar(Apuesta _apuesta) {
		_apuesta.reactivarSiPuede();
	}

	@Override
	public Float gananciaBruta(Apuesta _apuesta){
		return this.descuento(_apuesta);
	}

	private Float descuento(Apuesta _apuesta){
		return new Float(0.85 * new Float(2));
	}
}
