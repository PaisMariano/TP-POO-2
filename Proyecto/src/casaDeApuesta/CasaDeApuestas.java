package casaDeApuesta;

import java.math.BigDecimal; 
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import usuarios.User;
import algoritmo.*;
import apuesta.Apuesta;
import apuesta.ITipoApuesta;
import apuesta.TipoApuesta;
import criterio.Buscador;
import eventoDeInteres.Interesado;
import eventoDeInteres.Interesante;
import eventoDeportivo.*;
import expresionLogica.ExpresionLogica;
import notifier.*;
import oponentes.*;
import resultados.Resultado;

public class CasaDeApuestas extends Interesado{

	private List<User> usuarios;
	private AlgoritmoProbabilidades algoritmo; 
	private BalanceNotifier notifier;
	private Buscador buscador;
	private List<EventoDeportivo> eventos;

		public CasaDeApuestas() {
			usuarios = new ArrayList<User>();
			eventos = new ArrayList<EventoDeportivo>();	
			this.setAlgoritmo(new CompetenciaHistoricaDirecta());
			this.setBuscador(new Buscador());
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
			
			public void setBuscador(Buscador _buscador) {
				buscador = _buscador;
			}
			
			public List<EventoDeportivo> buscar(ExpresionLogica _expresion){
				return buscador.realizarBusquedaEn(this.getEventosFinalizados(), _expresion);
			}
			
			public void crearApuesta(User _user, Float _monto, EventoDeportivo _evento, Resultado _resultado, TipoApuesta _tipo ) {
				//Try catch la excepcion !usuarios.contains(_user)?
				Apuesta nuevaApuesta = new Apuesta(_monto, _evento, _resultado, _tipo);
				_user.agregarNuevaApuesta(nuevaApuesta);
			}
			
			
			public void notificarBalanceUsuarios(int unMes) {
				for(User user : this.usuarios) {									
					notifier.notifyBalance(user, unMes, user.gananciaBruta(unMes));
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
			public boolean leInteresa(Interesante eventoDeInteres) {
				return eventoDeInteres.haComenzado();
			}
}
