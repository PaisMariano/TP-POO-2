package estado;

import apuesta.Apuesta;

public class NoComenzado extends EstadoEventoDeportivo {
	
	public NoComenzado() {
		
	}
		public  void cancelar(Apuesta _apuesta){
		
			_apuesta.cancelarApuesta();
		}

		public  void reactivar(Apuesta _apuesta){
			_apuesta.reactivar();
		}
			

		@Override
		public Float montoPenalizacion(Apuesta _apuesta){
			return _apuesta.monto() - this.descuento();
		}

		private Float descuento(){
			return new Float(200);
		}
		
}
