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
	
	public Apuesta(Float _monto, EventoDeportivo _evento, Resultado _resultado, TipoApuesta _tipo, /*CasaDeApuestas _casa*/) {
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

		//este metodo es comun para cualquier tipo de apuesta. Pero no se conserva 
		public void cancelarApuesta(){
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

		public void canceladaSiPuede(){
			eventoDeportivo.getEstado().cancelar(this);
		}	
		
		public void reactivarSiPuede(){
			eventoDeportivo.getEstado().reactivar(this);
		}

		public Boolean esAcertada(){
			return this.getResultadoApostado().getGanador().equals(eventoDeportivo.getGanador());
		}	

}
