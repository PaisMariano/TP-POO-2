package apuesta;

import casaDeApuestas.*;
import eventoDeportivo.*;
import resultados.*;

public abstract class Apuesta {
	
	private Float montoApostado;
	private EventoDeportivo eventoDeportivo;
	private Resultado resultadoApostado;
	private TipoApuesta tipo;
	
	public Apuesta(Float _monto, EventoDeportivo _evento, Resultado _resultado, TipoApuesta _tipo) {
		this.setMonto(_monto);
		eventoDeportivo = _evento;
		this.setResultadoAlQueSeApuesta(_resultado);
		tipo = _tipo;
	}
	
		private void setResultadoAlQueSeApuesta(Resultado _resultado) {
			resultadoApostado = _resultado;
		}

		public void setMonto(Float _monto) {
			if(eventoDeportivo.estaFinalizado()) {
				this.error();
			}
			montoApostado = _monto;	
		}
		
		private Exception error() {
			return new Exception("El evento ya ha finalizado. ");
		}
		
		public Float monto() {
			return montoApostado;
		}
		
		public Boolean empezoPartido() {
			return eventoDeportivo.empezo();
		}
		
		public Float gananciaBruta(CasaDeApuestas _casa) {
			return eventoDeportivo.cuota(_casa, this.getResultadoApostado()) * this.monto();
		}
		
		private Resultado getResultadoApostado() {
			return resultadoApostado;
		}

		//Falta
		public Float gananciaNeta(CasaDeApuestas _casa) {
			return this.gananciaBruta(_casa) - this.monto();
		}
		
		//No esta terminado
		public void cancelar() {
			tipo.cancelar(this);
		}
		
	
}
