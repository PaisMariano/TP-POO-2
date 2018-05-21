package models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CasaDeApuestas {

	private List<User> usuarios;
	private AlgoritmoProbabilidades algoritmo; 
	private BalanceNotifier textMessageBalanceNotifier;
	
		public CasaDeApuestas() {
			usuarios = new ArrayList<User>();
			this.setAlgoritmo(new CompetenciaHistoricaDirecta());
			this.setNotifier(new TextMessageBalanceNotifier());
		}
		
			//Flexibilidad:
			public void agregarusuario(User _usuario) {
				usuarios.add(_usuario);
			}
		
			public void setAlgoritmo(AlgoritmoProbabilidades _algoritmo) {
				algoritmo = _algoritmo;
			}
			
			public Float calcularProbabilidades(Partido _partido) {
				return algoritmo.calcularProbabilidades(_partido);
			}
			
			public void setNotifier(BalanceNotifier _notifier) {
				textMessageBalanceNotifier = _notifier;
			}
			
			public void notificarBalanceUsuarios() {
				Integer month = new Integer(this.numeroDelMes());
				
				for(User user : usuarios) {
					textMessageBalanceNotifier.notifyBalance(user, month, this.ganancias());
				}
			}
			
			//LLevar esto al calendario?
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
}
