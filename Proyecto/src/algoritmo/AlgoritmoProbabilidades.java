package algoritmo;

import java.util.ArrayList;
import java.util.List;

import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente; 

public abstract class AlgoritmoProbabilidades {

	public abstract Float[] calcularProbabilidad(List<EventoDeportivo> historialCompleto, Oponente _op1, Oponente _op2);
	
	public List<EventoDeportivo> calcularHistoricoEntre(List<EventoDeportivo> historialCompleto, Oponente _op1, Oponente _op2) {
		
		ArrayList<EventoDeportivo> historialEntre = new ArrayList<EventoDeportivo>();
		
		for(EventoDeportivo eD : historialCompleto) {
			
			if (eD.participaronVs(_op1, _op2)) {
					historialEntre.add(eD);
	        }			
		}
		return historialEntre;
		
	}
	
	protected Float probabilidadGanador(List<EventoDeportivo> hist, Oponente _op) {
		
		Float probabilidad = new Float(0);
		
		for(EventoDeportivo eD : hist) {
			if (eD.getGanador() == _op) {
				probabilidad += 1;
			}
		}
		return probabilidad;
	}
	
}	


