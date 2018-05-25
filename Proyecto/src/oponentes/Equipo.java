package oponentes;

import java.util.List;

public class Equipo extends Oponentes{
	
	private List<Deportista> plantel;
	private String nombre;
	
		public Equipo(List<Deportista> _plantel,String _nombre) {
			this.setPlantel(_plantel);
			this.setNombre(_nombre);
		}
		
			private void setNombre(String _nombre) {
				nombre = _nombre;
			}

			private void setPlantel(List<Deportista> _plantel) {
				plantel = _plantel;
			}

			@Override
			public String nombre() {
				return nombre;
			}

			/*Lo agrego por flexibilidad, se me ocurren mas parecidos. Ejemplo, reemplazar un jugador por otro. 
			public void agregarJugador(Deportista jugador) {
				plantel.add(jugador);
			}
						
			//Cambia al primer jugador, por el segundo.
			public void cambarJugador(Deportista _jugador1, Deportista _jugador2) {
				this.sacarJugador(_jugador1);
				this agregarJugador(_jugador2);	
			}

			public void sacarJugador(Deportista _jugador) {
				plantel.remove(_jugador1);
			}
			
			public void agregarJugador(Deportista _jugador) {
				plantel.add(_jugador);		
			}
			
			public cantidadDeJugadores(){
				return plantel.size();
			}
			
			*/
}