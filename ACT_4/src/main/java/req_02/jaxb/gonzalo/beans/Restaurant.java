package req_02.jaxb.gonzalo.beans;


import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="restaurant")
public class Restaurant {
	private String nombre;
	private String ciudad;
	private List<Client> clientes;

	
	public Restaurant() {
		
		clientes = new ArrayList<Client>();
	}
	@XmlElement(name = "cliente")
	
	@XmlElementWrapper(name = "clientes")
	public List <Client> getClientes(){
		return clientes;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
}
