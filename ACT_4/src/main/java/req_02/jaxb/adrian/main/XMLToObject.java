package req_02.jaxb.adrian.main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import req_02.jaxb.adrian.beans.Concierto;
import req_02.jaxb.adrian.beans.Participante;



public class XMLToObject {
	public static void main(String[] args) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Concierto.class);
		Unmarshaller u = context.createUnmarshaller();
		File file = new File("otro_concierto.xml");
		if (file.exists()) {
			Concierto c = (Concierto) u.unmarshal(file);
			System.out.println(c.getFecha()+" "+c.getHora());
			for (Participante p : c.getParticipantes()) {
				System.out.println(p.getH_entrada()+"  "+p.getNombre());		
			}
		}
	}
}
