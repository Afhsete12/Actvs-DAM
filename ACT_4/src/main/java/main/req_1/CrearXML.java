package main.req_1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CrearXML {
	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		Document doc;
		db = factory.newDocumentBuilder();
		doc = db.newDocument();
		Element concierto = doc.createElement("concierto");
		doc.appendChild(concierto);
		addInfoConcierto(concierto, doc);
		Element participantes = doc.createElement("participantes");
		concierto.appendChild(participantes);
		infoPariticipantes(participantes, doc);
		guardar(doc);
	}
	

	
	private static void addInfoConcierto(Element concierto, Document doc) {
		Element element = null;
		String[][] arr = { { "fecha", "20-oct-2018" }, { "hora", "21:30" } };

		for (int i = 0; i < 2; i++) {
			element = doc.createElement(arr[i][0]);
			element.appendChild(doc.createTextNode(arr[i][1]));
			concierto.appendChild(element);
		}
	}

	private static void guardar(Document doc) throws TransformerException {
		TransformerFactory factConv = TransformerFactory.newDefaultInstance();
		Transformer conversor = factConv.newTransformer();
		DOMSource fuente = new DOMSource(doc);
		StreamResult resultado = new StreamResult(new File("concierto.xml"));
		conversor.transform(fuente, resultado);
	}

	private static void infoPariticipantes(Element participantes, Document doc) {
		Element participante = null;
		Element entrada = null;
		Element grupo = null;
		String[][] arr = { {"21:30","Las Ardillas de Dakota" },{"22:15","Fito y Fitipaldis"},{"23:00","ColdPlay"}};
		for (int i = 0; i < 3; i++) {
			participante = doc.createElement("participante");
			participantes.appendChild(participante);
			entrada = doc.createElement("entrada");
			entrada.appendChild(doc.createTextNode(arr[i][0]));
			participante.appendChild(entrada);
			grupo = doc.createElement("grupo");
			grupo.appendChild(doc.createTextNode(arr[i][1]));
			participante.appendChild(grupo);
		}
	}

}
