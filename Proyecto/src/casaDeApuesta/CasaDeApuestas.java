package casaDeApuesta;

import java.math.BigDecimal; 
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import usuarios.User;
import algoritmo.*;
import eventoDeportivo.*;
import notifier.BalanceNotifier;
import notifier.TextMessageBalanceNotifier;
import oponentes.*;

public class CasaDeApuestas {

	private List<User> usuarios;
	private AlgoritmoProbabilidades algoritmo; 
	private BalanceNotifier textMessageBalanceNotifier;
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
		
			//Flexibility
			public void setAlgoritmo(AlgoritmoProbabilidades _algoritmo) {
				algoritmo = _algoritmo;
			}
			
			//Flexibility
			public void setNotifier(BalanceNotifier _notifier) {
				textMessageBalanceNotifier = _notifier;
			}

			//Flexibility
			public void agregarusuario(User _usuario) {
				usuarios.add(_usuario);
			}
			
			//Flexibility
			public void agregarEvento(EventoDeportivo _evento) {
				eventosHistoricos.add(_evento);
			}

			public void notificarBalanceUsuarios() {
				Integer month = new Integer(this.numeroDelMes());
				
				for(User user : usuarios) {
					textMessageBalanceNotifier.notifyBalance(user, month, this.ganancias());
				}
			}
		
			//Esto no va a aca
			private int numeroDelMes() {
				Date date = new Date();
				LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int month = localDate.getMonthValue();
				return month;
			}

			//Falta implementar
			private BigDecimal ganancias() {
				return null;	
			}


			public Float[] calcularProbabilidadesDe(List<EventoDeportivo> eventoHistorico, Oponente _op1, Oponente _op2) {
				return algoritmo.calcularProbabilidad(eventosHistoricos, _op1, _op2);
			}
			
			public void crearEventoDeportivo(Oponente _op1, Oponente _op2, Deporte deporte, Date unaFechaYHora, String unLugar) {
				
				//probabilidades[0] = Ganador _op1
				//probabilidades[1] = Ganador _op2
				//probabilidades[2] = Empate.    
				Float[] probabilidades = this.calcularProbabilidadesDe(this.eventosHistoricos, _op1, _op2);
			
				EventoDeportivo evento = new EventoDeportivo(deporte, _op1, _op2, unaFechaYHora, unLugar);
				
				evento.calcularCuotas(probabilidades); //Las calcula pero cuando las pasa?
				
				this.agregarEvento(evento);			
				
			}

			/*
			public Float calcularProbabilidades(Partido _partido, Resultado _resultado){
				return algoritmo.calcProb(_partido, _resultado);
			}
			*/
}
