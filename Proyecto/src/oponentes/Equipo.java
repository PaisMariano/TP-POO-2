package oponentes;

import java.util.List;

public class Equipo implements Oponente {

	private List<Deportista> plantel;
	private String nombre;

	public Equipo(List<Deportista> _plantel, String _nombre) {
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

	@Override
	public Boolean es(Oponente _oppnente) {
		return this.hashCode() == _oppnente.hashCode();
	}

	/*
	 * Lo agrego por flexibilidad, se me ocurren mas parecidos. Ejemplo, reemplazar
	 * un jugador por otro.
	 */
	public void agregarDeportista(Deportista jugador) {
		plantel.add(jugador);
	}

	// Cambia al primer jugador, por el segundo.
	public void cambiarDeportista(Deportista _jugador1, Deportista _jugador2) {
		this.sacarDeportista(_jugador1);
		this.agregarJugador(_jugador2);
	}

	public void sacarDeportista(Deportista _jugador) {
		plantel.remove(_jugador);
	}

	public void agregarJugador(Deportista _jugador) {
		plantel.add(_jugador);
	}

	public Integer cantidadDeDeportistas() {
		return plantel.size();
	}

}