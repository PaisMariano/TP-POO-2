package algoritmo;

import bbdd.BBDD;
import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public interface AlgoritmoProbabilidades {

	Float calcularProbabilidades(BBDD _base, Oponente _oponente, EventoDeportivo _evento);

}
