package eventoDeportivo;

import java.util.Date; 
import java.util.ArrayList;
import java.util.List;

import EventoDeInteres.Interesante;
import casaDeApuesta.*;
import estado.*;
import oponentes.*;
import resultados.*;

public class EventoDeportivo extends Interesante {
	
	Deporte deporte;
	List<Oponente> oponentes;
	String lugar; 
	Date fechaYHora;
	EstadoEventoDeportivo estado;
	Resultado resultado;
	private float cuotaGanador1;
	private float cuotaGanador2;
	private float cuotaEmpate;


		public EventoDeportivo(CasaDeApuestas unaCasaDeApuestas,Deporte _deporte, Oponente oponente1, Oponente oponente2,Date unaFechaYHora,String unLugar) {
			deporte = _deporte;
			oponentes = new ArrayList<Oponente>(2);
			this.setOponentes(oponente1, oponente2);
			estado = new NoComenzado();
			resultado = new Empate(); 
			fechaYHora= unaFechaYHora;
			lugar= unLugar;
			cuotaGanador1 = this.calcularCuota(unaCasaDeApuestas.calcularProbabilidadGanador(oponente1, oponente2));
			cuotaGanador2 = this.calcularCuota(unaCasaDeApuestas.calcularProbabilidadGanador(oponente2, oponente1));
			cuotaEmpate   = this.calcularCuota(unaCasaDeApuestas.calcularProbabilidadEmpate(oponente1, oponente2));
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
				this.cambie();
			}
			
			public Float calcularCuota(Float _probabilidad){
				return 1 + (1 - _probabilidad);
			}
						
			public float getCuotaOponente1() {
				return this.cuotaGanador1;
				
			}
			public float getCuotaOponente2() {
				return this.cuotaGanador2;
				
			}
			public float getCuotaEmpate() {
				return this.cuotaEmpate;
				
			}
			public  Deporte getDeporte() {
				return this.deporte;
			}
			
			public String nombreDeporte() {
				return this.deporte.getNombre();
			}

			public EstadoEventoDeportivo getEstado(){
				return estado;
			}
			public void  setEstado(EstadoEventoDeportivo _estado){
				this.estado = _estado;
				this.cambie();
			}
		
			
			public Resultado getResultado(){
				return resultado;
			}

			public Oponente getGanador(){
				return resultado.getApostado();
			}

			public boolean esDeDeporte(Deporte deporteDeInteres) {
				return this.nombreDeporte().equals(deporteDeInteres.getNombre());
			}

			public boolean seJugoEn(String _lugar) {
				return lugar.equals(_lugar);
			}

			public boolean sucedioEn(Date fechaInteres) {
				return fechaInteres.getYear() == fechaYHora.getYear() &&
						fechaInteres.getMonth() == fechaYHora.getMonth() &&
						 fechaInteres.getDay() == fechaYHora.getDay();
			}

			public List<Oponente> getOponentes() {
				return this.oponentes;
			}

		

			public boolean esDelMes(int unMes) {
				
				return this.fechaYHora.getMonth()== unMes;
			}

}
