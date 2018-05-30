package apuesta;

import casaDeApuesta.*;
import eventoDeportivo.*;
import resultados.*;

public  class Apuesta {
	
	private Float montoApostado;
	private EventoDeportivo eventoDeportivo;
	private Resultado resultadoApostado;
	private TipoApuesta tipo;
	private Float cuotaConvenida;
	
	public Apuesta(Float _monto, EventoDeportivo _evento, Resultado _resultado, TipoApuesta _tipo, CasaDeApuestas _casa) {
		this.setMonto(_monto);
		eventoDeportivo = _evento;
		this.setResultadoAlQueSeApuesta(_resultado);
		this.setTipo(_tipo);
		//cuotaConvenida = _evento.cuota() aca lo que quiero es lo que pagaba de cuota ese partido en ese momento;
	}
	
		private void setResultadoAlQueSeApuesta(Resultado _resultado) {
			resultadoApostado = _resultado;
		}

		private void setTipo(TipoApuesta _tipo){
			tipo = _tipo;
		}

		public void setMonto(Float _monto) {
			if(eventoDeportivo.estaFinalizado()) {//Esto es redundante?
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

		public void cancelarApuesta(){
			this.setTipo(new Cancelada());			
		}
		
		public void reactivarApuesta(){
			this.setTipo(new Segura());
		}

		public Float bruta(){
			return this.cuotaConvenida() - this.monto();
		} 

		public void canceladaSiPuede(){
			eventoDeportivo.getEstado().cancelar(this);
		}	
		
		public void reactivarSiPuede(){
			eventoDeportivo.getEstado().reactivar(this);
		}

		public Boolean esAcertada(){
			this.getResultadoApostado().getGanador() equals(eventoDeportivo.getGanador());
			return this.getResultadoApostado().getGanador() = eventoDeportivo.ganador();
		}	

}
