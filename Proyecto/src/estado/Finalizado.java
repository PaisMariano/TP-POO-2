package estado;

import apuesta.Apuesta;

public class Finalizado extends EstadoEventoDeportivo {
	
	public Finalizado() {
		
	}
	
		public Boolean estaFinalizado() {
			return new Boolean(true);
		}

		@Override
		public void cancelar(Apuesta _apuesta) {
			//NO puede ser cancelada. Excepcion?
		}
		@Override
		public void reactivar(Apuesta _apuesta){
			//Tampoco deberia ser reactivada con el partido finalizado.
		}

}
