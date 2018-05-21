package models;

import java.util.List;

public class Equipo {
	
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

			/*Lo agrego por flexibilidad, se me ocurren mas parecidos. Ejemplo, reemplazar un jugador por otro. 
			public void agregarJugador(Deportista jugador) {
				plantel.add(jugador);
			}
			
			
			public String getNombre() {
				return nombre;
			}
			*/
			
}
