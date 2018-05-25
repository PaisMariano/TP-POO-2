package oponentes;

public class Oponentes implements Oponente {

	@Override
	public String nombre() {
		return null;
	}

	@Override
	public boolean es(Oponente _oppnente) {
		return this.hashCode() == _oppnente.hashCode();
	}

}
