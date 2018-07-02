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

		void cambiarElTipoDeApuestaACancelada(){
			this.setTipo(new Cancelada());			
		}
		
		public void cambiarElTipoDeApuestaASegura(){
			this.setTipo(new Segura());
		}

		public boolean esAcertada(){
			return this.getResultadoApostado().getApostado().equals(eventoDeportivo.getGanador());
		}

		public void cancelarApuestaConPartidoNoComenzado() {
			this.cancelarApuestaRestandole(this.penalidadPartidoNoComenzado());//Asumimos que el monto es mayor a 200.
		}
		
		private void restarAlMonto(Float unaPenalidad) {
			this.setMonto(Math.max(this.montoApostado - unaPenalidad, new Float(0))); //El maximo entre 0 y el monto menos la penalidad. Con esto salvo la diferencia de si la apuesta es menor a 200$
		}
		
		private Float penalidadPartidoNoComenzado() {
			Float descuentoDe200pesos = new Float(200); 
			return descuentoDe200pesos;
		}

		public void cancelarApuestaConPartidoEnJuego() {
			this.cancelarApuestaRestandole(this.penalidadPartidoEnJuego());
		}

		private Float penalidadPartidoEnJuego() {
			Float descuentoPorcentaje = new Float(30);
			return this.montoApostado * descuentoPorcentaje;
		}	
		
		private void cancelarApuestaRestandole(Float unMonto) {
			this.cambiarElTipoDeApuestaACancelada();
			this.restarAlMonto(unMonto);
		}

		public void cancelarSiSePuede() {
			this.elEstadoDelPartidoDeLaApuesta().cancelar(this);
		}

		public void reactivarSiPuede() {
			this.elEstadoDelPartidoDeLaApuesta().reactivar(this);
		}
		
		public EstadoEventoDeportivo elEstadoDelPartidoDeLaApuesta() {
			return eventoDeportivo.getEstado();
		}

		public Interesante getEventoDeInteres() {
			return eventoDeportivo;
		}
		
		public boolean esApuestaDelMes(int unMes) {	
			return this.eventoDeportivo.estaFinalizado() && this.eventoDeportivo.esDelMes(unMes); 
		}
}
