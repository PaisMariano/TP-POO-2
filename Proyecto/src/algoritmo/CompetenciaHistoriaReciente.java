package algoritmo;

import java.util.ArrayList;
import java.util.List;

import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public class CompetenciaHistoriaReciente extends AlgoritmoProbabilidades {
	
	
	@Override
	public Float[] calcularProbabilidad(List<EventoDeportivo> historicoCompleto, Oponente _op1, Oponente _op2) { 
			
		//Calculo Historico de los ultimos 10 partidos del Oponente 1
		List<EventoDeportivo> historicoOp1 = this.calcularHistoricoIndividualUltimosDiez(historicoCompleto, _op1);
		
		//Calculo Historico de los ultimos 10 partidos del Oponente 2
		List<EventoDeportivo> historicoOp2 = this.calcularHistoricoIndividualUltimosDiez(historicoCompleto, _op2);
				
		//Calculo los coeficientes en base a los ultimos 10 partidos de cada oponente.
		return this.calcularCoeficientes(historicoOp1, _op1, historicoOp2, _op2);
	}
	
	private Float[] calcularCoeficientes(List<EventoDeportivo> histOp1, Oponente _op1, List<EventoDeportivo> histOp2, Oponente _op2) {
		
		Float coeficiente[] = new Float[3];
		Float coeficienteGanadorA, coeficienteGanadorB;
		
		coeficienteGanadorA = this.probabilidadGanador(histOp1, _op1);
		coeficienteGanadorB = this.probabilidadGanador(histOp2, _op2);		
		
		coeficiente[0] = coeficienteGanadorA / 10;
		coeficiente[1] = coeficienteGanadorB / 10;
		coeficiente[2] = (coeficiente[0] + coeficiente[1]) / 2;
		
		
		return coeficiente;
		
	}
	
	private List<EventoDeportivo> calcularHistoricoIndividualUltimosDiez(List<EventoDeportivo> hist, Oponente _op) {
		
		List<EventoDeportivo> historico = calcularHistoricoIndividual(hist, _op);
		
		for(EventoDeportivo eD : historico) {
			if (historico.size() > 10) {
				historico.remove(0);
			}
		}		
		return historico;
		
	}
	
	private List<EventoDeportivo> calcularHistoricoIndividual(List<EventoDeportivo> hist, Oponente _op) {
		
		List<EventoDeportivo> historico = new ArrayList<EventoDeportivo>();
		
		for(EventoDeportivo eD : hist) {
			if (eD.participo(_op)){
				historico.add(eD);
			}
		}
		return historico;
	}

}
