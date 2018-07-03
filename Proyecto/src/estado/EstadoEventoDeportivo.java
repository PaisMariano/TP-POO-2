package estado;

import factorDeCancelacionOReactivacionDeApuesta.FactorDeCancelacionOReactivacionDeApuesta;

public abstract class EstadoEventoDeportivo implements FactorDeCancelacionOReactivacionDeApuesta{
	protected Float penalidad;
	
	public EstadoEventoDeportivo(Float _penalidad) {
		this.setPenalidad(_penalidad);
	}
	
		public boolean estaFinalizado() {
			return false;
		}
		
		public boolean estaEmpezado() {
			return false;
		} 
	
		public boolean noHacomenzado() {
			return false;
		}
		
		public void setPenalidad(Float _penalidad) {
			penalidad = _penalidad;
		}
	
		public Float penalidad() {
			return penalidad;
		}
}
