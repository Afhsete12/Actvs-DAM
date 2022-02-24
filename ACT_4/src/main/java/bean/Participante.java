package bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "participante")
public class Participante {
	private String h_entrada;
	private String nombre;
	
	public Participante() {
		super();
	}

	public Participante(String h_entrada, String nombre) {
		super();
		this.h_entrada = h_entrada;
		this.nombre = nombre;
	}
	
	@XmlElement(name="entrada")
	public String getH_entrada() {
		return h_entrada;
	}

	public void setH_entrada(String h_entrada) {
		this.h_entrada = h_entrada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}