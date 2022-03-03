package req_02.jaxb.gonzalo.view;

import java.io.File;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import req_02.jaxb.gonzalo.entity.Client;
import req_02.jaxb.gonzalo.entity.Restaurant;

public class Main {

	public static void main(String[] args) {

		JAXBContext contexto;
		try {
			
			contexto = JAXBContext.newInstance(Restaurant.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}

		Marshaller m;
		try {
			
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			Restaurant ciudadreal = new Restaurant();
			ciudadreal.setCiudad("Ciudad Real");
			ciudadreal.setNombre("Foster´s Hollywood");
			
			ciudadreal.getClientes().add(new Client(1, "Homer", "Simpson", 38));
			ciudadreal.getClientes().add(new Client(2, "Lisa", "Simpson", 8));
			ciudadreal.getClientes().add(new Client(3, "Bart", "Simpson", 11));
			ciudadreal.getClientes().add(new Client(4, "Marge", "Simpson", 35));
			ciudadreal.getClientes().add(new Client(5, "Magie", "Simpson", 3));
			
			
			
			
			
			m.marshal(ciudadreal, System.out);
			m.marshal(ciudadreal, new File("restaurante_ciudad_real.xml"));
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
