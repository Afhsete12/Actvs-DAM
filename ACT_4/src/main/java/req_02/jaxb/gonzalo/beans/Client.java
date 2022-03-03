package req_02.jaxb.gonzalo.beans;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name="cliente")

@XmlType(propOrder = {
		"idCliente",
	    "nombre",
	    "apellido",
	    "edad"
	})
public class Client {
	private int idCliente;
	private String nombre;
	private String apellido;
	private int edad;
	public Client() {
		
	}
	public Client(int id, String nombre, String apellido, int edad) {
		this.idCliente = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	@XmlAttribute(name = "id")
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idPersona) {
		this.idCliente = idPersona;
	}

	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name="apellido")
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@XmlElement(name="edad")
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	


	@Override
	public String toString() {
		return "Persona [idPersona=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+  "]";
	}
}
