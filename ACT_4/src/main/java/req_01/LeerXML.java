package req_01;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerXML {
	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;
		Node raiz;
		try {
			analizador = fabrica.newDocumentBuilder();
			doc = analizador.parse("concierto.xml");
			raiz = doc.getDocumentElement();
			runConcierto(raiz);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void runConcierto(Node raiz) {
		NodeList nodos = raiz.getChildNodes();
		Node fecha = nodos.item(0);
		Node hora = nodos.item(1);
		System.out.println("Fecha y hora del concierto: "+fecha.getTextContent()+" "+hora.getTextContent());
		System.out.println("Participan los siguentes grupos:");
		Node nodoHijo = nodos.item(2);
		runParticipantes(nodoHijo);
	}

	private static void runParticipantes(Node nodoHijo) {
		NodeList nodos = nodoHijo.getChildNodes();
		for (int i = 0; i < nodos.getLength(); i++) {
			Node escala = nodos.item(i);
			if (escala.getNodeType() == Node.ELEMENT_NODE) {
				Node entrada = escala.getChildNodes().item(0);
				Node grupo = escala.getChildNodes().item(1);
				System.out.print("   ");
				System.out.println(entrada.getTextContent() +" "+ grupo.getTextContent());
			}
		}
	}
}
