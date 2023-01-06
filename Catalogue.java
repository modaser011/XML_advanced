package FMA_7AGA;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.text.SimpleDateFormat;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import java.util.Scanner;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import java.util.Date;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.text.DateFormat;
import java.text.ParseException;
public class Catalogue {
    Document doc;
	Element root ;
	String path = "C:\\Users\\modaser\\Downloads\\XML-\\XML-\\Catalogue.xml" ;
	public Catalogue() {
		try {
			getDocument();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void getDocument() throws SAXException, IOException, ParserConfigurationException {

		File xmlFile = new File(path);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();
		if(xmlFile.length() > 0){
			doc = db.parse(xmlFile);
			root = doc.getDocumentElement();
		}else{
			doc = db.newDocument();
			root = doc.createElement("catalogue");
			doc.appendChild(root);

		}
	}

	public void addBook(Book B1) throws IOException, ParserConfigurationException, SAXException {

		Element BOOK = doc.createElement("BOOK");
		root.appendChild(BOOK);
		Attr bookId = doc.createAttribute("ID");
		bookId.setValue(B1.getId()+"");
		BOOK.setAttributeNode(bookId);
		Element anauthor = doc.createElement("Author");
		Element atitle = doc.createElement("Title");
		Element agenre = doc.createElement("Genre");
		Element aprice = doc.createElement("Price");
		Element apublishDate = doc.createElement("Publish_Date");
		Element adescription = doc.createElement("Description");
		
		anauthor.appendChild(doc.createTextNode(B1.getAuthor()));
		atitle.appendChild(doc.createTextNode(B1.getTitle()));
		agenre.appendChild(doc.createTextNode(B1.getGenre()));
		aprice.appendChild(doc.createTextNode((B1.getPrice()+"")));
		apublishDate.appendChild(doc.createTextNode(B1.getPublishDate()));
		adescription.appendChild(doc.createTextNode(B1.getDescription()));

		BOOK.appendChild(anauthor);
		BOOK.appendChild(atitle);
		BOOK.appendChild(agenre);
		BOOK.appendChild(aprice);
		BOOK.appendChild(apublishDate);
		BOOK.appendChild(adescription);

		sort();

		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = factory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		DOMSource domSource = new DOMSource(doc);
		StreamResult streamResult = new StreamResult(new File("Catalogue.xml"));
		try {
			transformer.setOutputProperty ( OutputKeys.INDENT, "yes" );
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");
			transformer.transform(domSource, streamResult);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	public void addBookd(Book B1) throws IOException, ParserConfigurationException, SAXException {

		Element BOOK = doc.createElement("BOOK");
		root.appendChild(BOOK);
		Attr bookId = doc.createAttribute("ID");
		bookId.setValue(B1.getId()+"");
		BOOK.setAttributeNode(bookId);
		Element anauthor = doc.createElement("Author");
		Element atitle = doc.createElement("Title");
		Element agenre = doc.createElement("Genre");
		Element aprice = doc.createElement("Price");
		Element apublishDate = doc.createElement("Publish_Date");
		Element adescription = doc.createElement("Description");
		
		anauthor.appendChild(doc.createTextNode(B1.getAuthor()));
		atitle.appendChild(doc.createTextNode(B1.getTitle()));
		agenre.appendChild(doc.createTextNode(B1.getGenre()));
		aprice.appendChild(doc.createTextNode((B1.getPrice()+"")));
		apublishDate.appendChild(doc.createTextNode(B1.getPublishDate()));
		adescription.appendChild(doc.createTextNode(B1.getDescription()));

		BOOK.appendChild(anauthor);
		BOOK.appendChild(atitle);
		BOOK.appendChild(agenre);
		BOOK.appendChild(aprice);
		BOOK.appendChild(apublishDate);
		BOOK.appendChild(adescription);

		sortd();

		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = factory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		DOMSource domSource = new DOMSource(doc);
		StreamResult streamResult = new StreamResult(new File("Catalogue.xml"));
		try {
			transformer.setOutputProperty ( OutputKeys.INDENT, "yes" );
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");
			transformer.transform(domSource, streamResult);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	public boolean checkdate(String d){
	if(d.matches("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}"))
{
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
sdf.setLenient(false);
try {
Date d1=sdf.parse(d);
return true;
} catch (ParseException e) {
return false;
}
}
else
  return false;
}
	public static boolean checkauth(String s) {
		return s != null && s.matches("^[a-zA-Z]*$");
	}

	public ArrayList<String> check(Book bb) {
		ArrayList<String>cc=new ArrayList<>();
		ArrayList<String>cc2=new ArrayList<>();
cc2.add("Drama");cc2.add("Fiction");cc2.add("Science");
		cc.clear();
		int x=0;
		int f=0;
		NodeList nodeList = doc.getElementsByTagName("BOOK");
		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				String anID=eElement.getAttribute("ID");
				if(bb.getId()==Integer.parseInt(anID))
				{cc.add("id is found please enter another id");}
			}
		}
		if(bb.getAuthor().length()==0)
			{cc.add("authur can't be null");}
		if(bb.getGenre().length()==0)
			{cc.add("Genre can't be null");}
		if(bb.getTitle().length()==0)
			{cc.add("title can't be null");}
		if(bb.getPublishDate().length()==0)
			{cc.add("date can't be null");}
		if (!checkdate(bb.getPublishDate()))
		{ cc.add("date should be in the right form "); }
		if (!checkauth(bb.getAuthor()))
		{ cc.add("auther should be has characters (a-z) only"); }
		for (String ss : cc2) {
			if(bb.getGenre().equals(ss))
			{f++;}
		}
		if(f==0)
		{ cc.add("Genre must be from this list (Science, Fiction, Drama)"); }

		return cc;
	}
	public Node search(String elem) {
		NodeList nodeList = doc.getElementsByTagName("BOOK");
		Node ans = null;
		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				String aTitle = eElement.getElementsByTagName("Title").item(0).getTextContent();
				String anAuthor = eElement.getElementsByTagName("Author").item(0).getTextContent();
				if (aTitle.toLowerCase().equals(elem.toLowerCase())
						|| anAuthor.toLowerCase().equals(elem.toLowerCase())) {
					ans = node;
				}
			}
		}
		return ans;
	}
	
	public void searchAll(String elem) {
		int x =0 ;
		NodeList nodeList = doc.getElementsByTagName("BOOK");
		//Node ans = null;
		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				String anID=eElement.getAttribute("ID");
				String aTitle = eElement.getElementsByTagName("Title").item(0).getTextContent();
				String anAuthor = eElement.getElementsByTagName("Author").item(0).getTextContent();
				String aGenre = eElement.getElementsByTagName("Genre").item(0).getTextContent();
				String aPrice = (eElement.getElementsByTagName("Price").item(0).getTextContent());
				String aPublish_Date = eElement.getElementsByTagName("Publish_Date").item(0).getTextContent();
				String aDescription=eElement.getElementsByTagName("Description").item(0).getTextContent();

				if (aTitle.toLowerCase().equals(elem.toLowerCase())
						|| anAuthor.toLowerCase().equals(elem.toLowerCase())||
						anID.toLowerCase().equals(elem.toLowerCase())||
						aGenre.toLowerCase().equals(elem.toLowerCase())||
						aPrice.toLowerCase().equals(elem.toLowerCase())||
						aPublish_Date.toLowerCase().equals(elem.toLowerCase())||
						aDescription.toLowerCase().equals(elem.toLowerCase()))  {
							x++;
							Element eeElement = (Element) node;
							System.out.println("Book ID: " + eeElement.getAttribute("ID"));
							System.out.println("Author: " + eeElement.getElementsByTagName("Author").item(0).getTextContent());
							System.out.println("Title: " + eeElement.getElementsByTagName("Title").item(0).getTextContent());
							System.out.println("Genre: " + eeElement.getElementsByTagName("Genre").item(0).getTextContent());
							System.out.println("Price: " + eeElement.getElementsByTagName("Price").item(0).getTextContent());
							System.out.println("Publish_Date: " + eeElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
							System.out.println("Description: " + eeElement.getElementsByTagName("Description").item(0).getTextContent());
											System.out.println("_______________________________________________________");

				}
			}

		}
	}
	public void searchAll2(String elem) {
		int x=0;
				NodeList nodeList = doc.getElementsByTagName("BOOK");
				//Node ans = null;
				for (int itr = 0; itr < nodeList.getLength(); itr++) {
					Node node = nodeList.item(itr);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) node;
						String anID=eElement.getAttribute("ID");
						String aTitle = eElement.getElementsByTagName("Title").item(0).getTextContent();
						String anAuthor = eElement.getElementsByTagName("Author").item(0).getTextContent();
						String aGenre = eElement.getElementsByTagName("Genre").item(0).getTextContent();
						String aPrice = (eElement.getElementsByTagName("Price").item(0).getTextContent());
						String aPublish_Date = eElement.getElementsByTagName("Publish_Date").item(0).getTextContent();
						String aDescription=eElement.getElementsByTagName("Description").item(0).getTextContent();

						if (aTitle.toLowerCase().contains(elem.toLowerCase())
								|| anAuthor.toLowerCase().contains(elem.toLowerCase())||
								anID.toLowerCase().contains(elem.toLowerCase())||
								aGenre.toLowerCase().contains(elem.toLowerCase())||
								aPrice.toLowerCase().contains(elem.toLowerCase())||
								aPublish_Date.toLowerCase().contains(elem.toLowerCase())||
								aDescription.toLowerCase().contains(elem.toLowerCase())) {
									x++;
									Element eeElement = (Element) node;
									System.out.println("Book ID: " + eeElement.getAttribute("ID"));
									System.out.println("Author: " + eeElement.getElementsByTagName("Author").item(0).getTextContent());
									System.out.println("Title: " + eeElement.getElementsByTagName("Title").item(0).getTextContent());
									System.out.println("Genre: " + eeElement.getElementsByTagName("Genre").item(0).getTextContent());
									System.out.println("Price: " + eeElement.getElementsByTagName("Price").item(0).getTextContent());
									System.out.println("Publish_Date: " + eeElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
									System.out.println("Description: " + eeElement.getElementsByTagName("Description").item(0).getTextContent());
													System.out.println("_______________________________________________________");

						}
					}

				}
			if(x==0)
			System.out.println("Not found");
		}
	public void updateElementValue (String Id) {
		int x=0;
		NodeList nodeList = doc.getElementsByTagName("BOOK");
		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
			String Idi = eElement.getAttribute("ID");
				if (Idi.toLowerCase().equals(Id.toLowerCase())) {
x++;
Scanner sc = new Scanner(System.in);
Scanner sc2 = new Scanner(System.in);  

while (true) {
	System.out.println(
"1. modify author \n" + " ___________________________________________\n"
+ "2. modify title \n"+ " ___________________________________________\n"+
"3. modify genre \n" + " ___________________________________________\n" 
+ "4. modify price \n"+			 " ___________________________________________\n" +
 "5. modify date  \n"+ " ___________________________________________\n" 
 + "6. modify discription \n"+" ___________________________________________\n"
 + "7. exit \n"+" ___________________________________________\n");

	System.out.print("Enter number to do the operation number you want do it: ");
	String choice = sc.nextLine();
	
				switch (choice) {
					case "1":
									System.out.print("Enter author: ");
									String author = sc.nextLine();
									if(author.length()==0)
			                     {System.out.println("authur can't be null");
								break;
								}
								if (!checkauth(author))
								{ System.out.println("auther should be has characters (a-z) only"); break;}
		
	
									Node name = eElement.getElementsByTagName("Author").item(0).getFirstChild();
									name.setNodeValue(author);	
									TransformerFactory factory = TransformerFactory.newInstance();
									Transformer transformer = null;
									try {
										transformer = factory.newTransformer();
									} catch (TransformerConfigurationException e) {
										e.printStackTrace();
									}
									DOMSource domSource = new DOMSource(doc);
									StreamResult streamResult = new StreamResult(new File("Catalogue.xml"));
									try {
										transformer.setOutputProperty ( OutputKeys.INDENT, "yes" );
									transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");
										transformer.transform(domSource, streamResult);
									} catch (TransformerException e) {
										e.printStackTrace();
									}
                System.out.println("modefied");
					
									break;
					case "2":
					System.out.print("Enter title: ");
					String title = sc.nextLine();
					if(title.length()==0)
				{System.out.println("title can't be null");break;}
					Node name2 = eElement.getElementsByTagName("Title").item(0).getFirstChild();
					name2.setNodeValue(title);	
					
					TransformerFactory factory2 = TransformerFactory.newInstance();
		Transformer transformer2 = null;
		try {
			transformer2 = factory2.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		DOMSource domSource2 = new DOMSource(doc);
		StreamResult streamResult2 = new StreamResult(new File("Catalogue.xml"));
		try {
			transformer2.setOutputProperty ( OutputKeys.INDENT, "yes" );
        transformer2.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");
			transformer2.transform(domSource2, streamResult2);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
                System.out.println("modefied");
					break;
						case "3":
						int f=0;
						System.out.print("Enter genre: ");
						String genre = sc.nextLine();
						if(genre.length()==0)
			{ System.out.println("Genre can't be null"); break;}
			ArrayList<String>cc2=new ArrayList<>();
            cc2.add("Drama");cc2.add("Fiction");cc2.add("Science");
			for (String ss : cc2) {
				if(genre.equals(ss))
				{f++;}
			}
			if(f==0)
		{ System.out.println("Genre must be from this list (Science, Fiction, Drama)");break; }
						Node name3 = eElement.getElementsByTagName("Genre").item(0).getFirstChild();
						name3.setNodeValue(genre);	
						TransformerFactory factory3 = TransformerFactory.newInstance();
						Transformer transformer3 = null;
						try {
							transformer3 = factory3.newTransformer();
						} catch (TransformerConfigurationException e) {
							e.printStackTrace();
						}
						DOMSource domSource3 = new DOMSource(doc);
						StreamResult streamResult3 = new StreamResult(new File("Catalogue.xml"));
						try {
							transformer3.setOutputProperty ( OutputKeys.INDENT, "yes" );
						transformer3.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");
							transformer3.transform(domSource3, streamResult3);
						} catch (TransformerException e) {
							e.printStackTrace();
						}
						
					System.out.println("modefied");
	
						break;
						case "4":	
						
						System.out.print("Enter price: ");
						double price = sc.nextDouble();
						Node name4 = eElement.getElementsByTagName("Price").item(0).getFirstChild();
						name4.setNodeValue(price+"");	
						TransformerFactory factory4 = TransformerFactory.newInstance();
						Transformer transformer4 = null;
						try {
							transformer4 = factory4.newTransformer();
						} catch (TransformerConfigurationException e) {
							e.printStackTrace();
						}
						DOMSource domSource4 = new DOMSource(doc);
						StreamResult streamResult4 = new StreamResult(new File("Catalogue.xml"));
						try {
							transformer4.setOutputProperty ( OutputKeys.INDENT, "yes" );
						transformer4.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");
							transformer4.transform(domSource4, streamResult4);
						} catch (TransformerException e) {
							e.printStackTrace();
						}
						
					System.out.println("modefied");
						
						break;
					case "5":
					
					System.out.print("Enter pdate: ");
					String pdate = sc2.nextLine();
				if(pdate.length()==0)
					{System.out.println("date can't be null");break;}
				if (!checkdate(pdate))
				{ System.out.println("date should be in the right form ");break;}
					Node name5 = eElement.getElementsByTagName("Publish_Date").item(0).getFirstChild();
					name5.setNodeValue(pdate);	
					TransformerFactory factory5 = TransformerFactory.newInstance();
					Transformer transformer5 = null;
					try {
						transformer5 = factory5.newTransformer();
					} catch (TransformerConfigurationException e) {
						e.printStackTrace();
					}
					DOMSource domSource5 = new DOMSource(doc);
					StreamResult streamResult5 = new StreamResult(new File("Catalogue.xml"));
					try {
						transformer5.setOutputProperty ( OutputKeys.INDENT, "yes" );
					transformer5.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");
						transformer5.transform(domSource5, streamResult5);
					} catch (TransformerException e) {
						e.printStackTrace();
					}
					
                System.out.println("modefied");
				
					break;
					   case "6":
					   System.out.print("Enter Description: ");
					   String disc = sc2.nextLine();
					   Node name6 = eElement.getElementsByTagName("Description").item(0).getFirstChild();
					   name6.setNodeValue(disc);	
					   TransformerFactory factory6 = TransformerFactory.newInstance();
					   Transformer transformer6 = null;
					   try {
						   transformer6 = factory6.newTransformer();
					   } catch (TransformerConfigurationException e) {
						   e.printStackTrace();
					   }
					   DOMSource domSource6 = new DOMSource(doc);
					   StreamResult streamResult6 = new StreamResult(new File("Catalogue.xml"));
					   try {
						transformer6.setOutputProperty ( OutputKeys.INDENT, "yes" );
					transformer6.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");
						transformer6.transform(domSource6, streamResult6);
					} catch (TransformerException e) {
						e.printStackTrace();
					}
				   System.out.println("modefied");
						 
					   break;
					   case "7":
					   return;
					   default:
						System.out.println("Invalid Choice");
						break;
				}
	}
				}
	}
}
		if(x==0)
		System.out.println("Not found");
        }

	void delete(String key)
	{
		int x=0;
		NodeList nodeList = doc.getElementsByTagName("BOOK");
		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				String Id = eElement.getAttribute("ID");
				if (Id.toLowerCase().equals(key.toLowerCase())) {
					x++;
					doc.getDocumentElement().removeChild(node);
					TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = factory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		DOMSource domSource = new DOMSource(doc);
		StreamResult streamResult = new StreamResult(new File("Catalogue.xml"));
		try {
			transformer.setOutputProperty ( OutputKeys.INDENT, "yes" );
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");
			transformer.transform(domSource, streamResult);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
					
                System.out.println("Successfully deleted");

	}
}

		}
		if(x==0)
System.out.println("Not found");

	}
	public void sort(){
        ArrayList<Book> books = new ArrayList<>();
        //NodeList list = root.getChildNodes() ;
		NodeList list2 = doc.getElementsByTagName("BOOK");
        for (int i=0 ; i< list2.getLength(); i++){
			Book b1=new Book();
			Node n =list2.item(i);
			Element eElement = (Element) n;
			b1.setId(Integer.valueOf(eElement.getAttribute("ID")));
			b1.setAuthor(eElement.getElementsByTagName("Author").item(0).getTextContent());
			b1.setTitle(eElement.getElementsByTagName("Title").item(0).getTextContent());
			b1.setGenre(eElement.getElementsByTagName("Genre").item(0).getTextContent());
			b1.setPrice(Double.parseDouble( eElement.getElementsByTagName("Price").item(0).getTextContent()));
			b1.setPublishDate(eElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
			b1.setDescription(eElement.getElementsByTagName("Description").item(0).getTextContent());
            books.add(b1);
        }

		while (doc.getElementsByTagName("BOOK").getLength()!=0)
		doc.getDocumentElement().removeChild((Node)list2.item(0));

        Collections.sort(books);

		for (Book B1 : books){

			Element BOOK = doc.createElement("BOOK");

			root.appendChild(BOOK);
			Attr bookId = doc.createAttribute("ID");
			bookId.setValue(B1.getId()+"");

			BOOK.setAttributeNode(bookId);
			Element anauthor = doc.createElement("Author");
			Element atitle = doc.createElement("Title");
			Element agenre = doc.createElement("Genre");
			Element aprice = doc.createElement("Price");
			Element apublishDate = doc.createElement("Publish_Date");
			Element adescription = doc.createElement("Description");

			anauthor.appendChild(doc.createTextNode(B1.getAuthor()));
			atitle.appendChild(doc.createTextNode(B1.getTitle()));
			agenre.appendChild(doc.createTextNode(B1.getGenre()));
			aprice.appendChild(doc.createTextNode((B1.getPrice()+"")));
			apublishDate.appendChild(doc.createTextNode(B1.getPublishDate()));
			adescription.appendChild(doc.createTextNode(B1.getDescription()));

			BOOK.appendChild(anauthor);
			BOOK.appendChild(atitle);
			BOOK.appendChild(agenre);
			BOOK.appendChild(aprice);
			BOOK.appendChild(apublishDate);
			BOOK.appendChild(adescription);
		}
    }

	public void sortd(){
        ArrayList<Book> books = new ArrayList<>();
        //NodeList list = root.getChildNodes() ;
		NodeList list2 = doc.getElementsByTagName("BOOK");
        for (int i=0 ; i< list2.getLength(); i++){
			Book b1=new Book();
			Node n =list2.item(i);
			Element eElement = (Element) n;
			b1.setId(Integer.valueOf(eElement.getAttribute("ID")));
			b1.setAuthor(eElement.getElementsByTagName("Author").item(0).getTextContent());
			b1.setTitle(eElement.getElementsByTagName("Title").item(0).getTextContent());
			b1.setGenre(eElement.getElementsByTagName("Genre").item(0).getTextContent());
			b1.setPrice(Double.parseDouble( eElement.getElementsByTagName("Price").item(0).getTextContent()));
			b1.setPublishDate(eElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
			b1.setDescription(eElement.getElementsByTagName("Description").item(0).getTextContent());
            books.add(b1);
        }

		while (doc.getElementsByTagName("BOOK").getLength()!=0)
		doc.getDocumentElement().removeChild((Node)list2.item(0));

        Collections.sort(books,Collections.reverseOrder());

		for (Book B1 : books){

			Element BOOK = doc.createElement("BOOK");

			root.appendChild(BOOK);
			Attr bookId = doc.createAttribute("ID");
			bookId.setValue(B1.getId()+"");

			BOOK.setAttributeNode(bookId);
			Element anauthor = doc.createElement("Author");
			Element atitle = doc.createElement("Title");
			Element agenre = doc.createElement("Genre");
			Element aprice = doc.createElement("Price");
			Element apublishDate = doc.createElement("Publish_Date");
			Element adescription = doc.createElement("Description");

			anauthor.appendChild(doc.createTextNode(B1.getAuthor()));
			atitle.appendChild(doc.createTextNode(B1.getTitle()));
			agenre.appendChild(doc.createTextNode(B1.getGenre()));
			aprice.appendChild(doc.createTextNode((B1.getPrice()+"")));
			apublishDate.appendChild(doc.createTextNode(B1.getPublishDate()));
			adescription.appendChild(doc.createTextNode(B1.getDescription()));

			BOOK.appendChild(anauthor);
			BOOK.appendChild(atitle);
			BOOK.appendChild(agenre);
			BOOK.appendChild(aprice);
			BOOK.appendChild(apublishDate);
			BOOK.appendChild(adescription);
		}
}
}
