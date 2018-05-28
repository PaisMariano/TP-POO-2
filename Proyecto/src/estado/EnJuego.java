package estado;


public class EnJuego extends EstadoEventoDeportivo{

	public EnJuego(){

	}

	private Float descuento(){
		return new Float(100) - new Float(30);
	}

	@Override
	public void cancelar(Apuesta _apuesta) {
		Float montoPenalizado = _apuesta.monto() * this.descuento(); 
		_apuesta.setMonto(montoPenalizado);		
	}

	@Override
	public void reactivar(Apuesta _apuesta){
		//No puede ser reactivada. Excepcion?
	}

	@Override 
	public Float montoPenalizacion(Apuesta _apuesta){
		return super(_apuesta) * this.porcentaje();
	}

	public Integer porcentaje(){
		return new Integer(100) - this.descuento();
	}

	public Integer descuento(){
		return new Integer(30);
	}

}
