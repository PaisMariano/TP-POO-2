package apuesta;

public class Final extends TipoApuesta {

	@Override
	protected void cancelarApuesta(Apuesta _apuesta) {
		//No deberia de llegar aca.
	}

	@Override
	public gananciaBruta(Apuesta _apuesta){
		return super(_apuesta);
	}
}
