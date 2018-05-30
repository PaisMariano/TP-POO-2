package oponentes;

import identificables.*;

public class None implements Oponente, Identificable {

	@Override
	public String nombre() {
		return " ";
	}


	public Boolean es(Object _object) {
		return new Boolean(false);
	}

}
