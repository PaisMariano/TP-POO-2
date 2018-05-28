package estado;

public class Finalizado extends EstadoEventoDeportivo {
	
	public Finalizado() {
		
	}
	
		public Boolean estaFinalizado() {
			return new Boolean(true);
		}

		@Override
		public void activar() {
			//Falta
			
		}

		@Override
		public void desactivar() {
			//Falta
		}
		
		
		
}
