package casaDeApuesta;

import java.math.BigDecimal; 
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import usuarios.User;
import algoritmo.*;
import emailNotifier.EmailBalanceNotifier;
import eventoDeportivo.*;
import notifier.BalanceNotifier;
import notifier.TextMessageBalanceNotifier;
import oponentes.*;

public class CasaDeApuestas {

	private List<User> usuarios;
	private AlgoritmoProbabilidades algoritmo; 
	private BalanceNotifier textMessageBalanceNotifier;
	private EmailBalanceNotifier emailBalanceNotifier;
	private List<EventoDeportivo> eventosHistoricos;
	
		public CasaDeApuestas() {
			usuarios = new ArrayList<User>();
			eventosHistoricos = new ArrayList<EventoDeportivo>();	
			this.setAlgoritmo(new CompetenciaHistoricaDirecta());
			this.setNotifier(new TextMessageBalanceNotifier());
			emailBalanceNotifier = new EmailBalanceNotifier();
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
			
			public  List<User> getUsuarios(){
				return usuarios;
			}
			//Flexibility
			public void agregarEvento(EventoDeportivo _evento) {
				eventosHistoricos.add(_evento);
			}
			
			public  List<EventoDeportivo> getEventosDeportivos(){
				return eventosHistoricos;
			}
			
			/*
			public void notificarBalanceUsuarios() {
				Integer month = new Integer(this.numeroDelMes());
				
				for(User user : usuarios) {									//No tiene que retornar un Float sino un bigdecimal
					textMessageBalanceNotifier.notifyBalance(user, month, user.gananciasBrutas(month));
				}
			}
			
			public void notificarBalanceAlMail() {
			
			for(Usuario user : usuarios){
														//Falta implementar					//No tiene que retornar un Float sino un bigdecimal
				emailBalanceNotifier.emailBalance(user,userEmail(), month, user.gananciasBrutas(month))
			}
	
			//Esto no va a aca
			private int numeroDelMes() {
				Date date = new Date();
				LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int month = localDate.getMonthValue();
				return month;

			}*/

			public List<EventoDeportivo> getEventosFinalizados(){
				//List<EventoDeportivo> list = newArra seguir		
				return eventosHistoricos;
			}
			
		
//nuevo
			
			public void calcularProbabilidadPrimerOponenteGanador(Oponente _op1, Oponente _op2) {
				algoritmo.calcularProbabilidad(eventosHistoricos, _op1, _op2);
								
			}
			public void calcularProbabilidadSegundoOponenteGanador(Oponente _op1, Oponente _op2) {
				
				
			}
			public void calcularProbabilidadEmpate(Oponente _op1, Oponente _op2) {
				
				
			}
			
			
			/*
			public Float calcularProbabilidades(Partido _partido, Resultado _resultado){
				return algoritmo.calcProb(_partido, _resultado);
			}
			*/
}
