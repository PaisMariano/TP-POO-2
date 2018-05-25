package algoritmo;

import algoritmo.AlgoritmoProbabilidades;
import bbdd.BBDD;
import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public class CompetenciaHistoricaDirecta implements AlgoritmoProbabilidades {

	//Falta implementar
	@Override
	public Float calcularProbabilidades(BBDD _base, Oponente _oponente, EventoDeportivo _evento) {
		// TODO Auto-generated method stub
		return null;
	}

	//Competencia historica directa --> (cantidadDePartidosGanados * 0.5) /10
	
	//Historia reciente --> cantidadDeVictorias / 10; cambia por empatados.hay que delegarlo al estado ganado, perdido o empatado.
}
