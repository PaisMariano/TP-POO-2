package apuesta;

public class Cancelada implements TipoApuesta {

	@Override
	public void cancelar(Apuesta _apuesta) {
		//Ya esta cancelada si llego aca.
	}
	
	@Override
	public void reactivar(Apuesta _apuesta) {
		_apuesta.reactivarSiPuede();//Depende del estado si se puede o no
	}

	@Override
	public Float gananciaBruta(Apuesta _apuesta){
		return new Float(0);
	}

}
