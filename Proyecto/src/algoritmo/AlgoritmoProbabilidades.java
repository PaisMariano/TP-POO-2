package algoritmo;

import java.util.ArrayList;
import java.util.List;

import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente; 

public abstract class AlgoritmoProbabilidades {

	public abstract Float[] calcularProbabilidad(List historialCompleto, Oponente _op1, Oponente _op2);
	
	public List calcularHistoricoEntre(List<EventoDeportivo> historialCompleto, Oponente _op1, Oponente _op2) {
		
		ArrayList<EventoDeportivo> historialEntre = new ArrayList<EventoDeportivo>();
		
		for(EventoDeportivo eD : historialCompleto) {
			
			if (eD.participaronVs(_op1, _op2)) {
					historialEntre.add(eD);
	        }	
		
		}
		return historialEntre;
		
		
	}
	
	protected List calcularHistoricoUltimosX(List subHistorico, Oponente _op1, Oponente _op2, Integer val) {
			
		while(subHistorico.size() > val) {
				
			subHistorico.remove(0);
		}
			
		return subHistorico;
	}
}

