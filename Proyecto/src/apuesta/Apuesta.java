package apuesta;

import casaDeApuesta.*;
import eventoDeportivo.*;
import resultados.*;

public abstract class Apuesta {
	
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
			return tipo = _tipo;
		}

		package void setMonto(Float _monto) {
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
			return eventoDeportivo.empezoPartido();
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

		package void cancelarApuesta(){
			this.setTipo(new Cancelada());			
		}
		
		package void reactivarApuesta(){
			this.setTipo(new Reactivada());
		}

		package Float bruta(){
			reuturn this.cuotaConvenida() - this.monto();
		} 

		package void serCanceladaSiPuede(){
			eventoDeportivo.getEstado().cancelar(this);
		}	
}
