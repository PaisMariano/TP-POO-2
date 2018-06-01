package estado;

import apuesta.Apuesta;

public class EnJuego extends EstadoEventoDeportivo{

	
	private Float porcentajeDesc = new Float (30);

		public EnJuego(){

		}

		private Float descuento(){
			return new Float(100) - porcentajeDesc;
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
			return super.montoPenalizacion(_apuesta) * this.porcentaje();
		}
	
		public Float porcentaje(){
			return new Float(100) - this.descuento();
		}


}
