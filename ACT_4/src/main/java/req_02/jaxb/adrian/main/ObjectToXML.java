package req_02.jaxb.adrian.main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import req_02.jaxb.adrian.beans.Concierto;
import req_02.jaxb.adrian.beans.Participante;


public class ObjectToXML {
	public static void main(String[] args) throws JAXBException {
		JAXBContext context;
		context = JAXBContext.newInstance(Concierto.class);
		Marshaller m;
		m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		Concierto concierto = new Concierto("20-oct-2018","21:30");
		concierto.getParticipantes().add(new Participante("21:30","Las Ardillas de Dakota"));
		concierto.getParticipantes().add(new Participante("22:15","Fito y Fitipaldis"));
		concierto.getParticipantes().add(new Participante("23:00","ColdPlay"));		
		m.marshal(concierto, System.out);
		m.marshal(concierto, new File("otro_concierto.xml"));
	}
}

