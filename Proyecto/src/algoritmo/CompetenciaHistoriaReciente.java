package algoritmo;

import java.util.ArrayList;
import java.util.List;

import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public class CompetenciaHistoriaReciente extends AlgoritmoProbabilidades {
	
	
	@Override
	public Float[] calcularProbabilidad(List historicoCompleto, Oponente _op1, Oponente _op2) {
		
		//Calculo Historico completo entre los dos oponentes.
		List subHistorico = this.calcularHistoricoEntre(historicoCompleto, _op1, _op2); 
			
		//Calculo Historico de los ultimos 10 partidos entre los dos oponentes.
		subHistorico = this.calcularHistoricoUltimosX(subHistorico, _op1, _op2, 10);
		
		//Calculo la probabilidad en base a los ultimos 10 partidos.
		return this.probabilidad(subHistorico, _op1, _op2, 10);
	}
	
	private Float[] probabilidad(List<EventoDeportivo> subHistorico, Oponente _op1, Oponente _op2, Integer cantidadATraer) {
		
		Float coeficiente[] = new Float[3];
		float coeficienteGanadorA, coeficienteGanadorB, coeficienteEmpate;
		
		coeficienteGanadorA = this.probabilidadGanador(subHistorico, _op1);
		coeficienteGanadorB = this.probabilidadGanador(subHistorico, _op2);
		coeficienteEmpate   = cantidadATraer - coeficienteGanadorA - coeficienteGanadorB;
		
		
		coeficiente[0] = coeficienteGanadorA / cantidadATraer;
		coeficiente[1] = coeficienteGanadorB / cantidadATraer;
		coeficiente[2] = coeficienteEmpate / cantidadATraer;
		
		
		return coeficiente;
		
	}
	
	private Integer probabilidadGanador(List<EventoDeportivo> subHistorico, Oponente _op1) {
		
		Integer probabilidad = new Integer(0);
		
		for(EventoDeportivo eD : subHistorico) {
			if (eD.getResultado() = _op1) {
				probabilidad += 1;
			}
		}
		
		return probabilidad;
		
	}

}
