package bbdd;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public class BaseDeDatos implements BBDD{
	
	private List<EventoDeportivo> historicoEventos;
	
		public BaseDeDatos() {
			this.historicoEventos = new ArrayList<EventoDeportivo>(0);
		}

		public BaseDeDatos(List<EventoDeportivo> _partidos) {
			this.historicoEventos = _partidos;
		}
			
			public void agregarPartido(EventoDeportivo _evento) {
				if(! _evento.estaFinalizado()) {
					this.errorNoFinalizado();
				}
				this.agregarPartidoFinalizado(_evento);
			}

			private void agregarPartidoFinalizado(EventoDeportivo _evento) {
				this.historicoEventos.add(_evento);
			}
			
			//Ver
			private Exception errorNoFinalizado() {
				return new Exception("El evento aun no ha fnalizado.");
			}
		
			public List historicoCompleto(Oponente _op1, Oponente _op2) {
				
				ArrayList<EventoDeportivo> historico = new ArrayList<EventoDeportivo>();
				
				for(EventoDeportivo eD : this.historicoEventos) {
					
					if (eD.participaronVs(_op1, _op2)) {
						
						historico.add(eD);
			        			
			        }
					
				}
				
				return historico;
			}
			
			public List historicoUltimosN(Oponente _op1, Oponente _op2) {
				
				ArrayList<EventoDeportivo> historico = new ArrayList<EventoDeportivo>();
				Integer ultimosN = new Integer(10);
				
				for(EventoDeportivo eD : this.historicoEventos) {
					
					if (eD.participaronVs(_op1, _op2)) {
						
						historico.add(eD);
			        			
			        }
					
				}
				
				
				return historico;
				
			}
}
