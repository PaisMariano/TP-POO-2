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
import apuesta.Apuesta;
import apuesta.TipoApuesta;
import eventoDeportivo.*;
import notifier.*;
import oponentes.*;
import resultados.Resultado;

public class CasaDeApuestas extends Interesado{

	private List<User> usuarios;
	private AlgoritmoProbabilidades algoritmo; 
	private BalanceNotifier notifier;
	private List<EventoDeportivo> eventos;

	
		public CasaDeApuestas() {
			usuarios = new ArrayList<User>();
			eventos = new ArrayList<EventoDeportivo>();	
			this.setAlgoritmo(new CompetenciaHistoricaDirecta());
			this.setNotifier(new TextMessageBalanceNotifier());
		}
		
		public CasaDeApuestas(List<User> _usuarios, AlgoritmoProbabilidades _algoritmo,BalanceNotifier _notifier, List<EventoDeportivo> _historico) {
			usuarios = _usuarios;
			this.setAlgoritmo(new CompetenciaHistoricaDirecta());
			this.setNotifier(new TextMessageBalanceNotifier());
			eventos = _historico;		
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
				this.eventos.add(_evento);
			}
			
			public  List<EventoDeportivo> getEventosDeportivos(){
				return this.eventos;
				
			}
			
		
			public void notificarBalanceUsuarios(int unMes) {
				for(User user : this.usuarios) {									
					notifier.notifyBalance(user, unMes, user.gananciasBrutas(unMes));
				}
			}
			
		

			public List<EventoDeportivo> getEventosFinalizados(){
				List<EventoDeportivo> eventosFinalizados = new ArrayList<EventoDeportivo>();
				for (EventoDeportivo ev: this.eventos) {
					if (ev.estaFinalizado()) {
						eventosFinalizados.add(ev);
						
					}
					
				}
				
				return eventosFinalizados;
			}
		

			public Float calcularProbabilidadGanador(Oponente oponente1, Oponente oponente2) {
				return this.algoritmo.calcularProbabilidad(this.eventos, oponente1, oponente2);
			}
			
			public Float calcularProbabilidadEmpate(Oponente oponente1, Oponente oponente2) {
				return this.algoritmo.calcularProbabilidadEmpate(this.eventos, oponente1, oponente2);
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
