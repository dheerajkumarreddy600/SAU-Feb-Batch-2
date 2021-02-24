import java.io.File;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.lang.model.util.ElementScanner14;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.time.LocalDateTime;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class vaild {

	public static void main(String[] args) {
		try{
	         File XML1 = new File("1.xml");
	            File XML2 = new File("2.xml");
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            Document d1 = dBuilder.parse(XML1);
	            Document d2 = dBuilder.parse(XML2);
	            Document output = dBuilder.newDocument();
                Document ou2= dBuilder.newDocument();
	            Element root = output.createElement("CSR_Producer");
                Element root2 = ou2.createElement("CSR_Producer");
	            output.appendChild(root);
                ou2.appendChild(root2);

	            d1.getDocumentElement().normalize();
                NodeList NL1=d1.getElementsByTagName("CSR_Producer");
               
                for(int i=0;i<NL1.getLength();i++){
                   
                    Node n1=NL1.item(i);
	            	Element e1=(Element) n1;
                    NodeList licenseList=e1.getElementsByTagName("License");
                   
                    for(int j=0;j<licenseList.getLength();j++){
                       
                        Node ln1=licenseList.item(j);
                       Element le1=(Element) ln1;
                      
                       boolean x=experity(le1);
                       if(x==false){
                         ToFile(output,root,le1);
                       }
                    }
                }
                d2.getDocumentElement().normalize();
                NodeList NL2=d1.getElementsByTagName("CSR_Producer");
                for(int i=0;i<NL2.getLength();i++){
                 
                    Node n1=NL2.item(i);
	            	Element e1=(Element) n1;
                    NodeList licenseList=e1.getElementsByTagName("License");
                    

                    for(int j=0;j<licenseList.getLength();j++){
                        Node ln1=licenseList.item(j);
                       Element le1=(Element) ln1;
                       boolean x=experity(le1);
                       if(x==false){
                         ToFile(output,root,le1);
                       }
                       else
                         ToFile(ou2,root2,le1);
                    }
                }   
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(output);
            DOMSource s2=new DOMSource(ou2);
            StreamResult file = new StreamResult(new File("validlicense.xml"));
            StreamResult file2 = new StreamResult(new File("invalidlicense.xml"));
            transformer.transform(source, file);
            transformer.transform(s2, file2);
                

        }

        catch(Exception e){
            e.printStackTrace();

        }
    }
    private static void ToFile(Document doc,Element root,Element e) throws Exception{
        Node license = doc.importNode(e, true);
        root.appendChild(license);

    }
    private static boolean experity(Element el) throws Exception{
              String expdate=el.getAttribute("License_Expiration_Date");
              SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
              LocalDateTime now = LocalDateTime.now();
             String currentdate=dtf.format(now).toString();
           
              Date d1 = simple.parse(expdate);
               Date d2 = simple.parse(currentdate);

               if (d1.compareTo(d2) > 0) {
                return false;
            }
            else if(d1.compareTo(d2) < 0){
                 return true;
            }
            return false;
    }
}