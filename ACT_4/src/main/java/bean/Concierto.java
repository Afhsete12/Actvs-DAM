package bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="concierto")
public class Concierto {
	private String fecha;
	private String hora;
	private List<Participante> participantes;
	
	public Concierto() {
		super();
	}
	
	public Concierto(String fecha, String hora) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		participantes = new ArrayList<Participante>();
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	@XmlElement(name = "participante")
	@XmlElementWrapper(name = "participantes")
	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}
	
	
}
