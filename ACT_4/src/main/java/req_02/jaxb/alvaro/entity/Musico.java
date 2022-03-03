package req_02.jaxb.alvaro.entity;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="musico")
@XmlType(propOrder = {
		"nombre",
		"apellidos",
		"edad",
		"grupo",
		"listaInstrumentos"
	})
public class Musico {

	private String nombre;
	
	private String apellidos;
	private String grupo;
	private int edad;
	private List<Instrumento> listaInstrumentos;
	
	public Musico() {
		super();
	}
	


	public Musico(String nombre, String apellidos, String grupo, int edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.grupo = grupo;
		this.edad = edad;
		listaInstrumentos= new ArrayList<>();
	}



	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@XmlElement(name = "instrumento")
	@XmlElementWrapper(name = "instrumentos")
	public List<Instrumento> getListaInstrumentos() {
		return listaInstrumentos;
	}



	public void setListaInstrumentos(List<Instrumento> listaInstrumentos) {
		this.listaInstrumentos = listaInstrumentos;
	}



	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getGrupo() {
		return grupo;
	}


	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}



	@Override
	public String toString() {
		return "Musico [nombre=" + nombre + ", apellidos=" + apellidos + ", grupo=" + grupo + ", edad=" + edad
				+ ", listaInstrumentos=" + listaInstrumentos + "]";
	}
	
	
	
	
}
