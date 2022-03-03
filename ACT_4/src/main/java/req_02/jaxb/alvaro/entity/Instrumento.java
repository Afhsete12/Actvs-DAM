package req_02.jaxb.alvaro.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "instrumento")
public class Instrumento {

	private String nombre;
	private String material;
	private String sonido;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getSonido() {
		return sonido;
	}

	public void setSonido(String sonido) {
		this.sonido = sonido;
	}

	@Override
	public String toString() {
		return "Instrumento [nombre=" + nombre + ", material=" + material + ", sonido=" + sonido + "]";
	}
}
