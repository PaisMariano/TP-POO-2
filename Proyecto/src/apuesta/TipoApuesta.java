package apuesta;

public abstract class TipoApuesta {
	
	package Float gananciaBruta(Apuesta _apuesta){
		return _apuesta.bruta();
	}

	package abstract void cancelar(Apuesta _apuesta);

	package abstract void reactivar(Apuesta _apuesta);
	
}
