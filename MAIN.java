package FMA_7AGA;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class MAIN {     
  static int xx=0;
  
	public static void main(String argv[]) {
		Catalogue catalogue = new Catalogue();
		Printer printer = new Printer();
		Book b1 = new Book(); 

		try (Scanner sc = new Scanner(System.in)) {
			while (true) {

				System.out.println(
           "1. Add More Books sorted in ascending order \n" + " ___________________________________________\n"+
           "2. Add More Books sorted in discending order \n" + " ___________________________________________\n"
						+ "3. search \n"+ " ___________________________________________\n"+
            "4. search 2 \n" + 
                        
                        " ___________________________________________\n" + "5. Delete \n"+
						 " ___________________________________________\n" + "6. Display All Books  \n"+
             " ___________________________________________\n" + "7. update book  \n"
						+ " ___________________________________________\n" + "8. Exit \n"
						+" ___________________________________________\n");
				System.out.print("Enter number to do the operation number you want do it: ");
				String choice = sc.nextLine();
				
                            switch (choice) {
                                case "1":
                                
                                    System.out.print("Enter the number of Books: ");
                                    int n = sc.nextInt();
                                    sc.nextLine();
                                    for (int i = 0; i < n; i++) {
                                        System.out.println("Book "+ (i +1) +"\n"
                                                + "___________________________________________");
                                               System.out.print("Enter id: ");
                                               String id = sc.nextLine();
                                                b1.setId(Integer.parseInt(id));

                                                System.out.print("Enter author: ");
                                                String author = sc.nextLine();
                                                b1.setAuthor(author); 

                                        System.out.print("Enter title: ");
                                        String title = sc.nextLine();
                                        b1.setTitle(title);;
                                        
                                        System.out.print("Enter genre: ");
                                        String genre = sc.nextLine();
                                        b1.setGenre(genre);

                                        System.out.print("Enter price: ");
                                        String price = sc.nextLine();
                                        b1.setPrice(Double.parseDouble(price));

                                        System.out.print("Enter pdate: ");
                                        String pdate = sc.nextLine();
                                        b1.setPublishDate(pdate);                                
                                        
                                        System.out.print("Enter Description: ");
                                        String disc = sc.nextLine();
                                        b1.setDescription(disc);
                                        System.out.println("**********************************************************\n");
                                        ArrayList<String>gg=catalogue.check(b1);
                                       if(gg.isEmpty())
                                        {catalogue.addBook(b1);
                                         }
                                        else
                                        {
                                            for(String f:gg)
                                            {
                                              System.out.println(f);
                                              System.out.println("**********************************************************\n");

                                            }
                                                                                    }
                                        
                                        System.out.println("**********************************************************\n");
                                    }
                                    break;
                                    case "2":
                                
                                    System.out.print("Enter the number of Books: ");
                                    int n2 = sc.nextInt();
                                    sc.nextLine();
                                    for (int i = 0; i < n2; i++) {
                                        System.out.println("Book "+ (i +1) +"\n"
                                                + "___________________________________________");
                                               System.out.print("Enter id: ");
                                               String id2 = sc.nextLine();
                                                b1.setId(Integer.parseInt(id2));

                                                System.out.print("Enter author: ");
                                                String author2 = sc.nextLine();
                                                b1.setAuthor(author2); 

                                        System.out.print("Enter title: ");
                                        String title2 = sc.nextLine();
                                        b1.setTitle(title2);;
                                        
                                        System.out.print("Enter genre: ");
                                        String genre2 = sc.nextLine();
                                        b1.setGenre(genre2);

                                        System.out.print("Enter price: ");
                                        String price2 = sc.nextLine();
                                        b1.setPrice(Double.parseDouble(price2));

                                        System.out.print("Enter pdate: ");
                                        String pdate2 = sc.nextLine();
                                        b1.setPublishDate(pdate2);                                
                                        
                                        System.out.print("Enter Description: ");
                                        String disc2 = sc.nextLine();
                                        b1.setDescription(disc2);
                                        System.out.println("**********************************************************\n");
                                        ArrayList<String>gg2=catalogue.check(b1);
                                       if(gg2.isEmpty())
                                        {catalogue.addBookd(b1);
                                         }
                                        else
                                        {
                                            for(String f:gg2)
                                            {
                                              System.out.println(f);
                                              System.out.println("**********************************************************\n");

                                            }
                                                                                    }
                                        
                                        System.out.println("**********************************************************\n");
                                    }
                                    break;
                                case "3":
                                    System.out.println("Enter Id,Title,Author,genre,price,discription or bdate");
                                    String title = sc.nextLine();
                                    catalogue.searchAll(title);
                                   // if(node == null)
                                     //   System.out.println("Not Found.");
                                    //else
                                      //  printer.printNode(node);
                                    break;
                                    case "4":
                                    System.out.println("Enter Id,Title,Author,genre,price,discription or bdate)");
                                    String title2 = sc.nextLine();
                                    catalogue.searchAll2(title2);
                                   // if(node == null)
                                     //   System.out.println("Not Found.");
                                    //else
                                      //  printer.printNode(node);
                                    break;
                                    case "5":
                                    System.out.println("Enter ID)");
                                    String id = sc.nextLine();
                                    catalogue.delete(id);
                                   // if(node == null)
                                     //   System.out.println("Not Found.");
                                    //else
                                      //  printer.printNode(node);
                                    break;
                                case "6":
                                printer.printAll(catalogue);
                                break;
                                case "7":
                                System.out.print("Enter id: ");
                                Scanner s = new Scanner(System.in);  
                                 int idi = s.nextInt();  
                                 catalogue.updateElementValue(idi+"");                            
                                   break;
                                      case "8":
                                   System.out.println("Thank you ");
                                   return;
                                default:
                                    System.out.println("Invalid Choice");
                                    break;
                            }
				
				System.out.println("\n\n\n");
			}
		} catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

    }
}
