package estado;

import apuesta.Apuesta;
import factorDeCancelacionOReactivacionDeApuesta.FactorDeCancelacionOReactivacionDeApuesta;

public class EnJuego extends EstadoEventoDeportivo implements FactorDeCancelacionOReactivacionDeApuesta{


		public EnJuego(){

		}

		private Float descuento(){
			Float porcentajeDesc = new Float (30);
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
