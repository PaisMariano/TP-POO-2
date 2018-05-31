package eventoDeportivo;

import java.util.Date; 
import java.util.ArrayList;
import java.util.List;

import casaDeApuesta.*;
import estado.*;
import oponentes.*;
import resultados.*;

public class EventoDeportivo {
	
	Deporte deporte;
	List<Oponente> oponentes;
	String lugar; //String o clase?
	Date fechaYHora;
	EstadoEventoDeportivo estado;
	Resultado resultado;
	private float cuotaGanador1;
	private float cuotaGanador2;
	private float cuotaEmpate;



		public EventoDeportivo(Deporte _deporte, Oponente oponente1, Oponente oponente2,Date unaFechaYHora,String unLugar) {

			deporte = _deporte;
			oponentes = new ArrayList<Oponente>(2);
			this.setOponentes(oponente1, oponente2);
			estado = new NoComenzado();
			resultado = new Empate(); //Esto no sirve si por ejemplo se usara un ganador (considerando None o un Oponente?)
			fechaYHora= unaFechaYHora;
			lugar= unLugar;
		}

			private void setOponentes(Oponente _oponente1, Oponente _oponente2) {
				oponentes.add(_oponente1);
				oponentes.add(_oponente2);
			}
			
			public Boolean participo(Oponente _oponente) {
				return oponentes.contains(_oponente);
			}
			
			public Boolean participaronVs(Oponente _oponente1, Oponente _oponente2) {
				return this.participo(_oponente1) && this.participo(_oponente2);
			}

			public Boolean estaFinalizado() {
				return estado.estaFinalizado();
			}
			
			public Boolean empezoEvento() {
				return ! this.estaFinalizado();
			}

			public void setResultado(Resultado _resultado){
				resultado = _resultado;
			}
			
			public void calcularCuotas(Float[] _probabilidades){
				this.cuotaGanador1 = 1 + (1 - _probabilidades[0]);
				this.cuotaGanador2 = 1 + (1 - _probabilidades[1]);
				this.cuotaEmpate   = 1 + (1 - _probabilidades[2]);
			}
			
			private Oponente primerOponente() {
				return oponentes.get(0);
			}
			
			private Oponente segundoOponente() {
				return oponentes.get(1);
			}

			private Exception errorNoParticipa() {
				return new Exception("El oponente no pertenece a este evento.");
			}

			public EstadoEventoDeportivo getEstado(){
				return estado;
			}

			public Resultado getResultado(){
				return resultado;
			}

			public Oponente getGanador(){
				return resultado.getGanador();
			}

			/*
			public cuota(Casa _casa, Resultado _resultado){
				return 1 + (1 - this.prob(_casa, _resultado));
			}

			private prob(_casa, _resultado){
				return _casa.calcProb(this, _resultado);
			}
			+*/
}
