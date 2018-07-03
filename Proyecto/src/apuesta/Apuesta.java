package apuesta;

import java.math.BigDecimal;

import estado.*;
import eventoDeInteres.Interesante;
import eventoDeportivo.*;
import resultados.*;

public  class Apuesta {
	
	private Float montoApostado;
	private EventoDeportivo eventoDeportivo;
	private Resultado resultadoApostado;
	private TipoApuesta tipo;
	
	public Apuesta(Float _monto, EventoDeportivo _evento, Resultado _resultado, TipoApuesta _tipo) {
		// _monto > 0
		this.setMonto(_monto);
		eventoDeportivo = _evento;
		this.setResultadoAlQueSeApuesta(_resultado);
		this.setTipo(_tipo);
	}
	
		public void setTipo(TipoApuesta _tipo) {
			tipo = _tipo;
		}

		private void setResultadoAlQueSeApuesta(Resultado _resultado) {
			resultadoApostado = _resultado;
		}

		public void setMonto(Float _monto) {
			montoApostado = _monto;	
		}
		
		public Float monto() {
			return montoApostado;
		}
		
		public Boolean empezoEvento() {
			return eventoDeportivo.haComenzado();
		}
		
		public BigDecimal gananciaBruta() {
			return tipo.gananciaBruta(this);
		}
		
		Float cuotaConvenida() {
			return resultadoApostado.getCuotaApuesta(eventoDeportivo, resultadoApostado);
		}

		public Resultado getResultadoApostado() {
			return resultadoApostado;
		}

		public BigDecimal gananciaNeta() { 
			return this.gananciaBruta().subtract(new BigDecimal (montoApostado)) ;
		}
		
		public void cancelar() {
			tipo.cancelar(this);
		}

		public void reactivar(){
			tipo.reactivar(this);		
		}

		public void cambiarElTipoDeApuestaACancelada(){
			this.setTipo(new Cancelada());			
		}
		
		public void cambiarElTipoDeApuestaASegura(){
			this.setTipo(new Segura());
		}

		public boolean esAcertada(){
			return this.getResultadoApostado().getApostado().equals(eventoDeportivo.getGanador());
		}
		
		public Interesante getEventoDeInteres() {
			return eventoDeportivo;
		}
		
		public boolean esApuestaDelMes(int unMes) {	
			return this.eventoDeportivo.estaFinalizado() && this.eventoDeportivo.esDelMes(unMes); 
		}

		public void reducirMontoConPenalidad(Float i) {
			montoApostado -= i;
		}

		public EstadoEventoDeportivo elEstadoDelPartidoDeLaApuesta() {
			return eventoDeportivo.getEstado();
		}
}
