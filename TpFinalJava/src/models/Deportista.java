package src.models;

import java.sql.Date;

public class Deportista implements Oponente {
	String nombre;
	String apellido;
	Date fechaNacimiento;
	String lugarDeNacimiento;
	
	public Deportista(String nombre,String apellido,Date fechaNacimiento,String  lugarDeNacimiento) {
		
		this.nombre=nombre;
		this.apellido = apellido;
		this.fechaNacimiento=fechaNacimiento;
		this.lugarDeNacimiento=lugarDeNacimiento;
		
	}
	
}
