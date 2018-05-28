package apuesta;

public class Segura extends TipoApuesta { 
	
	private Float porcentajeDescuento = new Float(0.15);

	private Float descuento(){
		return new Float(100) - porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Float _porcentajeDescuento){
		porcentajeDescuento = _porcentajeDescuento;	
	}

	@Override
	protected void cancelarApuesta(Apuesta _apuesta) {
		//Asumimos que una apuesta segura tiene que ser >= a $200?
		//No se contempla el caso de que se cancele, se reactive y vuelva a cancelarse una vez mas la apuesta.  
		_apuesta.serCanceladaSiPuede();
	}

	@Override 
	public Float gananciaBruta(Apuesta _apuesta){
		return super(_apuesta) * this.descuento();
	}

}
