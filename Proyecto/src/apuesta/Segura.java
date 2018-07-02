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
		
		public Float getPorcentajeDescuento() {
			return porcentajeDescuento;
		}

		public Float descuento(){
			return new Float(100) - porcentajeDescuento;
		}
	
		@Override
		public void cancelar(Apuesta _apuesta) {
			//Asumimos que una apuesta segura tiene que ser >= a $200?  		
			_apuesta.cancelarSiSePuede();
		}
	
		@Override
		public void reactivar(Apuesta _apuesta){
			_apuesta.reactivarApuesta();	
		}
	
		@Override
		public BigDecimal gananciaBruta(Apuesta _apuesta) {
			BigDecimal subTotal = new BigDecimal(_apuesta.monto() * _apuesta.cuotaConvenida());
			return subTotal.multiply(new BigDecimal(this.descuento())).divide(new BigDecimal(100)) ;
		} 
}
