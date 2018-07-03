package apuesta;

import java.math.BigDecimal;

public class Segura extends TipoApuesta { 
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
		public BigDecimal gananciaBruta(Apuesta _apuesta) {
			BigDecimal subTotal = super.gananciaBruta(_apuesta);
			return subTotal.multiply(new BigDecimal(this.descuento())).divide(new BigDecimal(100)) ;
		} 
}
