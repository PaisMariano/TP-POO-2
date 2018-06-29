package eventoDeInteres;

import java.util.ArrayList;
import java.util.List;

public abstract class Interesado {
	
		public Interesado() {
		}

			public void recibirCambio(Interesante eventoDeInteres) {
				if(this.leInteresa(eventoDeInteres)) {
					this.notificar();
				}
			}
			
			public void notificar() {
				//Nada
			}
			
			public abstract boolean leInteresa(Interesante eventodeInteres);
}