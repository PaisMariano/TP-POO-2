package apuesta;

public class Segura implements TipoApuesta { 
	
	private Float porcentajeDescuento = new Float(0.15);

	private Float descuento(){
		return new Float(1) - porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Float _porcentajeDescuento){
		porcentajeDescuento = _porcentajeDescuento;	
	}

	@Override
	public void cancelar(Apuesta _apuesta) {
		//Asumimos que una apuesta segura tiene que ser >= a $200?
		//No se contempla el caso de que se cancele, se reactive y vuelva a cancelarse una vez mas la apuesta.  
		_apuesta.canceladaSiPuede();
	}

	@Override
	public void reactivar(Apuesta _apuesta){
		_apuesta.reactivarApuesta();//Esto no deberia de llegar	
	}

	@Override
	public Float gananciaBruta(Apuesta _apuesta) {
		return _apuesta.bruta() * this.descuento() ;
	} 

}
