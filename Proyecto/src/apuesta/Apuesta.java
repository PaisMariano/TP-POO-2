package apuesta;

import estado.*;
import eventoDeportivo.*;
import resultados.*;

public  class Apuesta {
	
	private Float montoApostado;
	private EventoDeportivo eventoDeportivo;
	private Resultado resultadoApostado;
	private TipoApuesta tipo;
	private Float cuotaConvenida;
	
	public Apuesta(Float _monto, EventoDeportivo _evento, Resultado _resultado, TipoApuesta _tipo/*, CasaDeApuestas _casa*/) {
		this.setMonto(_monto);
		eventoDeportivo = _evento;
		this.setResultadoAlQueSeApuesta(_resultado);
		this.setTipo(_tipo);
		//cuotaConvenida = _evento.cuota(_casa, _resultado) Aca lo que quiero es lo que pagaba de cuota ese partido en ese momento;
	}
	
		private void setResultadoAlQueSeApuesta(Resultado _resultado) {
			resultadoApostado = _resultado;
		}

		private void setTipo(TipoApuesta _tipo){
			tipo = _tipo;
		}

		private void setMonto(Float _monto) {
			montoApostado = _monto;	
		}
		
		public Float monto() {
			return montoApostado;
		}
		
		public Boolean empezoEvento() {
			return eventoDeportivo.empezoEvento();
		}
		
		public Float gananciaBruta() {
			return tipo.gananciaBruta(this);
		}
		
		private Float cuotaConvenida() {
			return cuotaConvenida;
		}

		public Resultado getResultadoApostado() {
			return resultadoApostado;
		}

		public Float gananciaNeta() {
			return this.gananciaBruta();
		}
		
		public void cancelar() {
			tipo.cancelar(this);
		}

		public void reactivar(){
			tipo.reactivar(this);		
		}

		//este metodo es comun para cualquier tipo de apuesta. Pero no se conserva 
		private void cancelarApuesta(){
			this.setTipo(new Cancelada());			
		}
		
		//La unica apuesta que se puede cancelar es la segura. Al reactivar vuelve al mismo tipo. 
		//Sino deberia de guardarse el ultimo tipo en una variable para volver a el, en caso de que haya mas tipos de apuestas que 			//puedan ser cancelables.  		
		public void reactivarApuesta(){
			this.setTipo(new Segura());
		}

		public Float bruta(){
			return this.cuotaConvenida() - this.monto();
		}

		public Boolean esAcertada(){
			return this.getResultadoApostado().getGanador().equals(eventoDeportivo.getGanador());
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
			this.cancelarApuesta();
			this.restarAlMonto(unMonto);
		}

		public void cancelarSiSePuede() {
			eventoDeportivo.getEstado().cancelar(this);
		}

		public void reactivarSiPuede() {
			eventoDeportivo.getEstado().reactivar(this);
		}
		
		private EstadoEventoDeportivo elEstadoDelPartidoDeLaApuesta() {
			return eventoDeportivo.getEstado();
		}

}
