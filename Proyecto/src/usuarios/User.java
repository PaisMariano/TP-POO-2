package usuarios;

import java.util.ArrayList; 
import java.util.List;

import EventoDeInteres.EventoDeInteres;
import EventoDeInteres.Interesado;
import apuesta.Apuesta;
import casaDeApuesta.CasaDeApuestas;

public class User extends Interesado{

	List<Apuesta> apuestas;
	String mail;
	
		public User(){
			apuestas = new ArrayList<Apuesta>(0);
		}
		
		public User(List<Apuesta> _apuestas){
			apuestas = _apuestas;
		}
		
		//creo que hay que pasarle la apuesta a la cual se refiere la ganacia bruta y neta 
		public Float gananciaBruta() {
			Float total = new Float(0); 
			for(Apuesta apuesta : apuestas) {
				total += apuesta.gananciaBruta();
			}
			return total;
		}
		
		public Float gananciaNeta() {
			Float total = new Float(0); 
			for(Apuesta apuesta : apuestas) {
				total += apuesta.gananciaNeta();
			}
			return total;
		}
	
		public void agregarNuevaApuesta(Apuesta _apuesta) {
			apuestas.add(_apuesta);
			
		}
		
		
		public List<Apuesta> apuestasPropias(){			
			return apuestas;
			
		}

		@Override
		public void changed(EventoDeInteres eventoDeInteres) {
			//No queda claro que hace
		}

		public boolean leInteresa(EventoDeInteres eventoDeInteres) {
			return this.apostoAEsteEvento(eventoDeInteres);
		}

		private boolean apostoAEsteEvento(EventoDeInteres eventoDeInteres) {
			List<EventoDeInteres> listaDePartidosApostados = new ArrayList<EventoDeInteres>();
			for(Apuesta _apuesta : apuestas) {
				listaDePartidosApostados.add(_apuesta.getEventoDeInteres());
			}
			return listaDePartidosApostados.contains(eventoDeInteres);
		}
		
}
