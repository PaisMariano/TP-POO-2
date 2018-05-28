package apuesta;

public class Segura extends TipoApuesta {

	@Override 
	public Boolean puedeSerCancelada(Apuesta _apuesta) {
		return ! _apuesta.empezoPartido();
	}

	@Override
	protected void cancelarApuesta(Apuesta _apuesta) {
		//Aca _apuesta.cancelar();
	}

	@Override 
	public Float gananciaBruta(Apuesta _apuesta){
		
	}

}
