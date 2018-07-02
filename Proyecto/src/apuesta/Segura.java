package apuesta;

import java.math.BigDecimal;

public class Segura implements TipoApuesta { 
	private Float porcentajeDescuento;
	
	public Segura() {
		this.setPorcentajeDescuento(new Float(15));
	}
	
		public void setPorcentajeDescuento(Float _n) {
			porcentajeDescuento = _n;
		}

		private Float descuento(){
			return new Float(100) - porcentajeDescuento;
		}
	
		@Override
		public void cancelar(Apuesta _apuesta) {
			//Asumimos que una apuesta segura tiene que ser >= a $200?  		
			_apuesta.cancelarSiSePuede();
		}
	
		@Override
		public void reactivar(Apuesta _apuesta){
			_apuesta.reactivarApuesta();//Esto no deberia de llegar	
		}
	
		@Override
		public BigDecimal gananciaBruta(Apuesta _apuesta) {
			return _apuesta.gananciaBruta().multiply(new BigDecimal(this.descuento())) ;
		} 
}
