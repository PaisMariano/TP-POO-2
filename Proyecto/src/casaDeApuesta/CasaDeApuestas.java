package casaDeApuesta;

import java.math.BigDecimal; 
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import EventoDeInteres.Interesante;
import EventoDeInteres.Interesado;
import usuarios.User;
import algoritmo.*;
import eventoDeportivo.*;
import notifier.*;
import oponentes.*;

public class CasaDeApuestas extends Interesado{

	private List<User> usuarios;
	private AlgoritmoProbabilidades algoritmo; 
	private BalanceNotifier notifier;
	private List<EventoDeportivo> eventosHistoricos;
	
		public CasaDeApuestas() {
			usuarios = new ArrayList<User>();
			eventosHistoricos = new ArrayList<EventoDeportivo>();	
			this.setAlgoritmo(new CompetenciaHistoricaDirecta());
			this.setNotifier(new TextMessageBalanceNotifier());
		}
		
		public CasaDeApuestas(List<User> _usuarios, AlgoritmoProbabilidades _algoritmo,BalanceNotifier _notifier, List<EventoDeportivo> _historico) {
			usuarios = _usuarios;
			this.setAlgoritmo(new CompetenciaHistoricaDirecta());
			this.setNotifier(new TextMessageBalanceNotifier());
			eventosHistoricos = _historico;		
		}
		
			public void setAlgoritmo(AlgoritmoProbabilidades _algoritmo) {
				algoritmo = _algoritmo;
			}
		
			public void setNotifier(BalanceNotifier _notifier) {
				this.notifier = _notifier;
			}

			public void agregarUsuario(User _usuario) {
				this.usuarios.add(_usuario);
			}
			
			public  List<User> getUsuarios(){
				return usuarios;
			}

			public void agregarEvento(EventoDeportivo _evento) {
				eventosHistoricos.add(_evento);
			}
			
			public  List<EventoDeportivo> getEventosDeportivos(){
				return eventosHistoricos;
			}

			public void crearUsuario(String _mail){
				int idCorrespondiente = this.cantidadDeUsuarios() + 1;
				Usuario nuevoUser = new User(idCorrespondiente, _mail);
				this.agregarUsuario(nuevoUser);
			}		

			private int cantidadDeUsuarios(){
				return usuarios.size();
			}

			public void crearApuesta(Float _monto, EventoDeportivo _evento, Resultado _resultado,  TipoApuesta tipo, User _usuario){
				Apuesta nuevaApuesta = new Apuesta (_monto, evento, _resultado, _tipo);
				_usuario.agregarNuevaApuesta(nuevaApuesta);
			}
			
			/*
			public void notificarBalanceUsuarios() {
				Integer month = new Integer(this.numeroDelMes());
				
				for(User user : usuarios) {									//No tiene que retornar un Float sino un bigdecimal
					notifier.notifyBalance(user, month, user.gananciasBrutas(month));
				}
			}
			
			public void notificarBalanceAlMail() {
			
			for(Usuario user : usuarios){
														//Falta implementar					//No tiene que retornar un Float sino un bigdecimal
				emailBalanceNotifier.emailBalance(user,userEmail(), month, user.gananciasBrutas(month))
			}
			}*/

			public List<EventoDeportivo> getEventosFinalizados(){
				//List<EventoDeportivo> list = newArra seguir		
				return eventosHistoricos;
			}
			

		

			public Float calcularProbabilidadGanador(Oponente oponente1, Oponente oponente2) {
				return this.algoritmo.calcularProbabilidad(this.eventosHistoricos, oponente1, oponente2);
			}
			
			public Float calcularProbabilidadEmpate(Oponente oponente1, Oponente oponente2) {
				return this.algoritmo.calcularProbabilidadEmpate(this.eventosHistoricos, oponente1, oponente2);
			}
		 
			@Override
			public void cambio(Interesante eventoDeInteres) {
				for(Interesante evento : interesantes) {
					 this.notificarALosUsuarosQueLeInterese(eventoDeInteres);
				}
			}

			private void notificarALosUsuarosQueLeInterese(Interesante eventoDeInteres) {
				for(User usuario : this.usuariosQueLeInteresan(eventoDeInteres)) {
					usuario.cambio(eventoDeInteres);
				}
			}

			private List<User> usuariosQueLeInteresan(Interesante eventoDeInteres) {
				List<User> resultado = new ArrayList <User>();
				for(User _user: usuarios) {
					if(_user.leInteresa(eventoDeInteres)) {
						resultado.add(_user);
					}
				}
				return resultado;

			}
			
			
}
