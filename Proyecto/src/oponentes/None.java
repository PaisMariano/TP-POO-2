package oponentes;

public class None implements Oponente{

	@Override
	public String nombre() {
		return " ";
	}

	@Override
	public Boolean es(Oponente primerOponente) {
		return new Boolean(false);
	}

}
