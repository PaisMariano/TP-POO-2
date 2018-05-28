package apuesta;

public class Cancelada extends TipoApuesta {

	@Override
	protected void cancelar(Apuesta _apuesta) {
		//Ya esta cancelada si llego aca.
	}

	@Override
	public gananciaBruta(Apuesta _apuesta){
		return _apuesta.bruta() * this.descuento()
	}

	private descuento(){
		return 0.85;
	}
}
