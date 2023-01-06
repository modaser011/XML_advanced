package FMA_7AGA;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Printer {

	public void printNode(Node node) {
		if (node == null) {
			System.out.println("Node is NULL");
			return;
		}
		Element eElement = (Element) node;
		System.out.println("Book ID: " + eElement.getAttribute("ID"));
		System.out.println("Author: " + eElement.getElementsByTagName("Author").item(0).getTextContent());
		System.out.println("Title: " + eElement.getElementsByTagName("Title").item(0).getTextContent());
		System.out.println("Genre: " + eElement.getElementsByTagName("Genre").item(0).getTextContent());
		System.out.println("Price: " + eElement.getElementsByTagName("Price").item(0).getTextContent());
		System.out.println("Publish_Date: " + eElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
		System.out.println("Description: " + eElement.getElementsByTagName("Description").item(0).getTextContent());

	}

	public void printAll(Catalogue catalogue) {
		Document doc = catalogue.doc;
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

		NodeList nodeList = doc.getElementsByTagName("BOOK");

		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			System.out.println("\nNode Name: " + node.getNodeName());
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
		System.out.println("Book ID: " + eElement.getAttribute("ID"));
		System.out.println("Author: " + eElement.getElementsByTagName("Author").item(0).getTextContent());
		System.out.println("Title: " + eElement.getElementsByTagName("Title").item(0).getTextContent());
		System.out.println("Genre: " + eElement.getElementsByTagName("Genre").item(0).getTextContent());
		System.out.println("Price: " + eElement.getElementsByTagName("Price").item(0).getTextContent());
		System.out.println("Publish_Date: " + eElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
		System.out.println("Description: " + eElement.getElementsByTagName("Description").item(0).getTextContent());
			}
		}
	}
}
