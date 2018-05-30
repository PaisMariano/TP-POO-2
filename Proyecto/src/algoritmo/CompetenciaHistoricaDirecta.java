package algoritmo;

import java.util.List;

import algoritmo.AlgoritmoProbabilidades;
import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public class CompetenciaHistoricaDirecta extends AlgoritmoProbabilidades {

	@Override
	public Float[] calcularProbabilidad(List historicoCompleto, Oponente _op1, Oponente _op2) {
		//Calculo el historico completo de ambos oponentes.
		List historico = this.calcularHistoricoEntre(historicoCompleto, _op1, _op2);
		//Calculo los coeficientes en base al historico completo.
		return calcularCoeficientes(historico, _op1, _op2);
	}
	
	private Float[] calcularCoeficientes(List<EventoDeportivo> historico, Oponente _op1, Oponente _op2) {
		
		Float coeficiente[] = new Float[3];
		Float coeficienteGanadorA, coeficienteGanadorB, coeficienteEmpate;
		
		
		coeficienteGanadorA = this.probabilidadGanador(historico, _op1);
		coeficienteGanadorB = this.probabilidadGanador(historico, _op2);
		coeficienteEmpate   = historico.size() - coeficienteGanadorA - coeficienteGanadorB;
		
		
		coeficiente[0] = coeficienteGanadorA / sizeConsistente(historico);
		coeficiente[1] = coeficienteGanadorB / sizeConsistente(historico);
		coeficiente[2] = (coeficiente[0] + coeficiente[1]) / 2;
		
		return coeficiente;
	}
	
	private Float sizeConsistente(List historico) {
		
		int size = historico.size();
		
		if (size == 0) {
			size = 1;
		}
		return (float) size;
	}
	
}
