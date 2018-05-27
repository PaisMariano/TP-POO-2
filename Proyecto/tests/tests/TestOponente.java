package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import oponentes.Oponentes;
import oponentes.Equipo;
import oponentes.Oponente;
import oponentes.Deportista;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class TestOponente {
	Oponente oponente;
	Deportista deportista;
	Date fNac= new Date(1,2,88);
	Equipo unEquipo;
	List <Deportista>deportistas;
	
	
	@BeforeEach
	void setUp() throws Exception {
		deportista = new Deportista("Juan","Perez",fNac,"Adrogue");
		oponente = new Deportista( "Maria Marta","SerraLima",fNac,"Adrogue");
		deportistas = new ArrayList<Deportista>();
		mockList = spy(deportistas);
	}

	@Test
	void unNuevoDeportistaCuentaConNombreFNacYDireccion() {
		assertEquals("Juan Perez", deportista.nombre());		
		assertEquals("Adrogue", deportista.getLugarDeNacimiento());		
		assertEquals(new Date(1,2,88), deportista.getFnacimiento());
		assertEquals(oponente.nombre(), "Maria Marta SerraLima");
		equals(oponente.es(new Deportista( "Maria Marta","SerraLima",fNac,"Adrogue")));
		
		}
	
	@Test
	void testAgregarUnDeportistaAlEquipo() {
		
		
	}


}
