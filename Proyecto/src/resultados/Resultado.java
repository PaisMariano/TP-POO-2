package resultados;

import identificables.*;
import oponentes.Oponente;

public abstract class Resultado implements Identificable{
	
		public abstract Oponente getGanador();

		@Override
		public Boolean es(Object _object) {
			return new Boolean (this.hashCode() == _object.hashCode());
		}


}
