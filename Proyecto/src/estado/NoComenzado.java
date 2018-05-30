package estado;

public class NoComenzado extends EstadoEventoDeportivo {
	
	public NoComenzado() {
		
	}
		public abstract void cancelar(Apuesta _apuesta){
			super(_apuesta);/*Si se quisiera calcular la ganancia de la casa de apuestas este seria un problema*/
			_apuesta.sercancelada();
		}

		public abstract void reactivar(Apuesta _apuesta){
			_apuesta.reactivar();
		}
			

		@Override
		public Float montoPenalizacion(Apuesta _apuesta){
			return super(_apuesta) - this.descuento();
		}

		private Float descuento(){
			return new Float(200);
		}
		
}
