package usuarios;

import java.math.BigDecimal; 
import java.util.ArrayList; 
import java.util.List;

import apuesta.Apuesta;
import eventoDeInteres.Interesado;
import eventoDeInteres.Interesante;

public class User extends Interesado{
	private List<Apuesta> apuestas;
	private String mail;
	
		public User(String _mail){
			this.setMail(_mail);
			apuestas = new ArrayList<Apuesta>();
		}
		
			public void setMail(String _mail) {
				mail = _mail;
			}
			
			public BigDecimal gananciaBruta(int unMes) {
				BigDecimal total = new BigDecimal(0); 
				for(Apuesta apuesta : this.apuestasDelMes(unMes)) {
					total.add(apuesta.gananciaBruta());
				}
				return total;
			}
			
			
			private List<Apuesta> apuestasDelMes(int unMes) {
				List<Apuesta> apuestasDelMes= new ArrayList<Apuesta>();
			
				for(Apuesta ap: apuestas) {
					if(ap.esApuestaDelMes(unMes)) {
						apuestasDelMes.add(ap);
					}
					
				}
				return apuestasDelMes;
			}

			public BigDecimal gananciaNeta(int unMes) {
				BigDecimal total = new BigDecimal(0); 
				for(Apuesta apuesta : this.apuestasDelMes(unMes)) {
					total.add(apuesta.gananciaNeta());
				}
				return total;
			}
		
			public void agregarNuevaApuesta(Apuesta _apuesta) {
				apuestas.add(_apuesta);
				_apuesta.getEventoDeInteres().agregarInteresado(this);
			}
			
			public List<Apuesta> apuestasPropias(){			
				return apuestas;	
			}
	
			@Override
			public boolean leInteresa(Interesante eventoDeInteres) {
				return this.apostoAEsteEvento(eventoDeInteres);
			}
	
			private boolean apostoAEsteEvento(Interesante eventoDeInteres) {
				List<Interesante> listaDePartidosApostados = new ArrayList<Interesante>();
				for(Apuesta _apuesta : apuestas) {
					listaDePartidosApostados.add(_apuesta.getEventoDeInteres());
				}
				return listaDePartidosApostados.contains(eventoDeInteres);
			}

			
			
			public String getMail() {

				return this.mail ;
			}
			
}