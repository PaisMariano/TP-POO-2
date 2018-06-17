package algoritmo;

import java.util.ArrayList;
import java.util.List;

import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public class CompetenciaHistoricaReciente extends AlgoritmoProbabilidades {
	
	
	@Override
	public Float calcularProbabilidad(List<EventoDeportivo> historicoCompleto, Oponente _op1, Oponente _op2) {
		
		List<EventoDeportivo> historicoOp = this.calcularHistoricoIndividualUltimosDiez(historicoCompleto, _op1);
		
		return this.calcularCoeficiente(historicoOp, _op1);
		
	}
	@Override
	public Float calcularProbabilidadEmpate(List<EventoDeportivo> historicoCompleto, Oponente _op1, Oponente _op2) {		
		
		return 1 - this.calcularProbabilidad(historicoCompleto, _op1, _op2) -
			       this.calcularProbabilidad(historicoCompleto, _op2, _op1);
				
	}
	
	private Float calcularCoeficiente(List<EventoDeportivo> histOp, Oponente _op) {
				
		
		return this.probabilidadGanador(histOp, _op);
			
	}
		
	
	private List<EventoDeportivo> calcularHistoricoIndividualUltimosDiez(List<EventoDeportivo> hist, Oponente _op) {
		
		List<EventoDeportivo> historico = calcularHistoricoIndividual(hist, _op);
		
			while(historico.size() > 10){
				historico.remove(0);
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
