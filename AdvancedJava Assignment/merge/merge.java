import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class merge {

	public static void main(String[] args) {
		try{
	         File XML1 = new File("1.xml");
	            File XML2 = new File("2.xml");
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            Document d1 = dBuilder.parse(XML1);
	            Document d2 = dBuilder.parse(XML2);
	            Document output = dBuilder.newDocument();
	            Element root = output.createElement("CSR_Producer");
	            output.appendChild(root);
	            d1.getDocumentElement().normalize();
	            d2.getDocumentElement().normalize();
	            NodeList NL1 = d1.getElementsByTagName("CSR_Producer"); 
	            NodeList NL2 = d1.getElementsByTagName("CSR_Producer");
	            for(int i=0;i<NL1.getLength();i++ ) {
	            	Node n1=NL1.item(i);
	            	Element e1=(Element) n1;
	            for(int j=0;j<NL2.getLength();j++) {
	            	Node n2=NL2.item(j);
	            	Element e2=(Element) n2;
	            /* checking the nodes in both the files matches*/  
	            	
	            	System.out.println(e1.getAttribute("NIPR_Number"));
                    
	            	if(e1.getAttribute("NIPR_Number").equals(e2.getAttribute("NIPR_Number"))) {
	            		NodeList licence1=	e1.getElementsByTagName("License");
	            	 for(int l1=0;l1<licence1.getLength();l1++) {
	            		 Element LicenceElement1=(Element)licence1.item(l1);
	            	    NodeList licence2=e2.getElementsByTagName("License");
	            	    for(int l2=0;l2<licence2.getLength();l2++) {
		            		 Element LicenceElement2=(Element)licence2.item(l2);
	            	/* checking for licence equal */
                       if(check(LicenceElement1,LicenceElement2)) {
                    	   out(output,root,LicenceElement1);
                       }
	            	    }
	            	}
	            	
	            }
	            
	            }
         
	}
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            DOMSource source = new DOMSource(output);
	            StreamResult file = new StreamResult(new File("Mergefile.xml"));
	            transformer.transform(source, file);
                System.out.println("done");
	            
	            
	            

            
}catch(Exception e) {
	e.printStackTrace();
}
		}
	private static void  out(Document output,Element root,Element L1) throws Exception {
		 Node licence = output.importNode(L1, true);
		 root.appendChild(licence);
	}
	private static boolean check(Element e1,Element e2) {
		if(e1.getAttribute("License_Number").equals(e2.getAttribute("License_Number")) && e1.getAttribute("Date_Status_Effective").equals(e2.getAttribute("Date_Status_Effective")) )
	     return true;
	  return false;
	}
	
	}
