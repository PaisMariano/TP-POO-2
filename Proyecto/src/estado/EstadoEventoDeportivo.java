package estado;

import apuesta.*;

public abstract class EstadoEventoDeportivo{

	public Boolean estaFinalizado() {
		return new Boolean(false);
	}
	
	public Boolean estaEmpezado() {
		return !this.estaFinalizado();
	} 

	public void cancelar(Apuesta _apuesta){
		_apuesta.setMonto(this.montoPenalizacion(_apuesta));
	}

	protected Float montoPenalizacion(Apuesta _apuesta){
		return _apuesta.monto();
	}

	public abstract void reactivar(Apuesta _apuesta);

}
