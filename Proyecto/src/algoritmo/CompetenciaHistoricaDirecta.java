package algoritmo;

import java.util.List;

import algoritmo.AlgoritmoProbabilidades;
import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public class CompetenciaHistoricaDirecta extends AlgoritmoProbabilidades {

	@Override	
	public Float calcularProbabilidad(List<EventoDeportivo> historicoCompleto, Oponente _op1, Oponente _op2) {
	
		List<EventoDeportivo> historico = this.calcularHistoricoEntre(historicoCompleto, _op1, _op2);
	
		return calcularCoeficiente(historico, _op1);
	}
	
	@Override
	public Float calcularProbabilidadEmpate(List<EventoDeportivo> historicoCompleto, Oponente _op1, Oponente _op2) {		
		
		return (this.calcularProbabilidad(historicoCompleto, _op1, _op2) +
			    this.calcularProbabilidad(historicoCompleto, _op2, _op1)) / 2;
				
	}
	
	private Float calcularCoeficiente(List<EventoDeportivo> historico, Oponente _op) {
		
		return (this.probabilidadGanador(historico, _op) / sizeConsistente(historico));
		
	}	
	
	private Float sizeConsistente(List historico) {
		
		int size = historico.size();
		
		if (size == 0) {
			size = 1;
		}
		return (float) size;
	}
	
}
