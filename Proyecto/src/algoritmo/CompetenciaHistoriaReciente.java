package algoritmo;

import java.util.ArrayList;
import java.util.List;

import bbdd.BBDD;
import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public class CompetenciaHistoriaReciente implements AlgoritmoProbabilidades {
	
	//Falta implementar
	@Override
	public Float cuotaGana(List coleccionPartidos, Oponente _op1, Oponente _op2) {
		
		List subHistorico = this.ultimosX(coleccionPartidos, _op1, _op2);
				
		this.
	}
	
	private List ultimosX(List subHistorico, Oponente _op1, Oponente _op2) {
		
		ArrayList<EventoDeportivo> historico = new ArrayList<EventoDeportivo>();
		
		for(EventoDeportivo eD : coleccionPartidos) {
			
			if (eD.participaronVs(_op1, _op2)) {
					historico.add(eD);
	        }		
		
		while(subHistorico.size() > 10) {
			
			subHistorico.remove(0);
		}
		
		return subHistorico;
	}
	
	public Float cuotaEmpate(BBDD _base, Oponente _op1, Oponente _op2) {

}
