package req_02.jaxb.alvaro.view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import req_02.jaxb.alvaro.entity.Instrumento;
import req_02.jaxb.alvaro.entity.Musico;

public class Test {

	public static void main(String[] args) {
		JAXBContext contexto;
		Scanner sc = new Scanner(System.in);
		boolean continuar = true;

		while (continuar == true) {
			System.out.println("Si quieres pasar de objeto a xml pulsa 1");
			System.out.println("Si quieres pasar de xml a objeto pulsa 2");
			System.out.println("Si quieres salir pulsa 3");
			int opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				try {
					contexto = JAXBContext.newInstance(Musico.class);
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

					Musico musico = new Musico("Ramon", "Espina", "melendi", 43);
					Instrumento instrumento = new Instrumento();
					instrumento.setNombre("guitarrra");
					instrumento.setMaterial("madera");
					instrumento.setSonido("acustico");
					Instrumento instrumento1 = new Instrumento();
					instrumento1.setNombre("microfono");
					instrumento1.setMaterial("metal");
					instrumento1.setSonido("acustico");
					List<Instrumento> listaInstrumento = new ArrayList<>();
					listaInstrumento.add(instrumento);
					listaInstrumento.add(instrumento1);
					musico.setListaInstrumentos(listaInstrumento);

					m.marshal(musico, System.out);
					m.marshal(musico, new File("musicos.xml"));
				} catch (JAXBException e) {
					System.out.println("Error convertiendo el objeto a formato XML");
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					contexto = JAXBContext.newInstance(Musico.class);

					Unmarshaller u = contexto.createUnmarshaller();
					File fichero = new File("musicos.xml");
					if (fichero.exists()) {
						Musico musico = (Musico) u.unmarshal(fichero);

						System.out.println(musico);
					} else {
						System.out.println("Fichero XML no encontrado");
						System.out.println("Prueba a usar la opcion uno primero");
					}

				} catch (JAXBException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("has elegido finalizar el programa!");
				continuar = false;
				break;
			}
		}
		sc.close();
	}

}


