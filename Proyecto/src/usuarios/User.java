package usuarios;

import java.util.ArrayList;
import java.util.List;

import apuesta.Apuesta;
import casaDeApuesta.CasaDeApuestas;

public class User {

	List<Apuesta> apuestas;
	
		public User(){
			apuestas = new ArrayList<Apuesta>(0);
		}
		
		public Float gananciaBruta(CasaDeApuestas _casa) {
			Float total = new Float(0); 
			for(Apuesta apuesta : apuestas) {
				total += apuesta.gananciaBruta(_casa);
			}
			return total;
		}
		
		public Float gananciaNeta(CasaDeApuestas _casa) {
			Float total = new Float(0); 
			for(Apuesta apuesta : apuestas) {
				total += apuesta.gananciaNeta(_casa);
			}
			return total;
		}
	
}
