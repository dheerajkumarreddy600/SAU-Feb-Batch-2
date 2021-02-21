import java.io.File;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilder;



import org.w3c.dom.NodeList;

import org.w3c.dom.Node;


import java.io.*;
import java.util.*;

class obj{
    int rollno;
    int marks;
    String subject;
    obj(int rollno, int marks, String subject)
    {
        this.rollno=rollno;
        this.marks=marks;
        this.subject=subject;
    }
}
public class details implements Serializable {
    static class result implements Serializable{
        int rollno,marks;
        result(int rollno,int marks){
            this.rollno=rollno;
            this.marks=marks;
        }
    }

   
    public static void main(String args[])throws Exception
    {
        System.out.println("success");
        details s=new details();
        ArrayList<obj> a= new ArrayList<>();
        try{
            HashMap<Integer,Integer> hm=new HashMap<>();

            File inputFile = new File("xml.txt");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("student");
            obj[] items =new obj[nList.getLength()];

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);


                Element ele = (Element) nNode;

                int roll=Integer.parseInt(ele.getElementsByTagName("roll").item(0).getTextContent());
                int marks=Integer.parseInt(ele.getElementsByTagName("marks").item(0).getTextContent());
                String subject=(ele.getElementsByTagName("subject").item(0).getTextContent());
                items[temp]=new obj(roll,marks,subject);
            }
            
            for(int i=0;i<nList.getLength();i++){
                if(!hm.containsKey(items[i].rollno)){
                    hm.put(items[i].rollno,items[i].marks);
                }else{
                   
                    hm.put(items[i].rollno,hm.get(items[i].rollno)+items[i].marks);
                }
            }

            result[] arr =new result[3];
            int i=0;
            for(int key:hm.keySet()){
                arr[i++]=new result(key,hm.get(key));
            }


        

            FileOutputStream fs=new FileOutputStream("text.txt");
            
            ObjectOutputStream out = new ObjectOutputStream(fs);
            for(i=0;i<3;i++) {

                out.writeObject(arr[i]);
               
            }
            out.flush();
            out.close();
            


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }}