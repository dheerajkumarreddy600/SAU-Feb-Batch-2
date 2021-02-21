import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.*;

class creat{
    String subject;
    int rollno;
    int marks;   
    creat(int rollno, int marks, String subject)
    {
        this.rollno=rollno;
        this.marks=marks;
        this.subject=subject;
    }
}
public class seral {
    private static final String CSV = ",";
    static class result implements Serializable{
        int rollno,marks;
        result(int rollno,int marks){
            this.rollno=rollno;
            this.marks=marks;
        }
    }
    public static void main(String args[])
    {
        ArrayList<creat> a= new ArrayList<>();
        try{
            HashMap<Integer,Integer> hm=new HashMap<>();
            File file = new File("xml.txt");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("top.csv"), "UTF-8"));
            DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = db.newDocumentBuilder();
            Document d = dB.parse(file);
            d.getDocumentElement().normalize();
            System.out.println("Root:" + d.getDocumentElement().getNodeName());
            NodeList list = d.getElementsByTagName("student");

            creat[] items =new creat[list.getLength()];

            for (int i = 0; i < list.getLength(); i++) {

                Node n = list.item(i);


                Element ele = (Element) n;

                int roll=Integer.parseInt(ele.getElementsByTagName("roll").item(0).getTextContent());
                int marks=Integer.parseInt(ele.getElementsByTagName("marks").item(0).getTextContent());
                String subject=(ele.getElementsByTagName("subject").item(0).getTextContent());
                items[i]=new creat(roll,marks,subject);
            }
            
            for(int i=0;i<list.getLength();i++){
                if(hm.containsKey(items[i].rollno)){
                    hm.put(items[i].rollno,hm.get(items[i].rollno)+items[i].marks);
                }else{
                    hm.put(items[i].rollno,items[i].marks);
                }
            }

            result[] arr =new result[list.getLength()/3];
            int i=0;
            for(int key:hm.keySet()){
                arr[i++]=new result(key,hm.get(key));
            }

            

               FileOutputStream f=new FileOutputStream("text.txt");
               ObjectOutputStream out = new ObjectOutputStream(f);
               for(i=0;i<list.getLength()/3;i++) {
                   out.writeObject(arr[i]);
   
               }
               out.flush();
               out.close();
   

             


             FileInputStream fin = new FileInputStream("text.txt");
             ObjectInputStream in = new ObjectInputStream(fin);
 
             for(i=0;i<list.getLength()/3;i++) {
                 arr[i] = (result) in.readObject();
             }
             in.close();
             fin.close();


         
            
            
           


            Arrays.sort(arr,new Comparator<result>() {
                @Override
                public int compare(result o1, result o2) {
                    if(o1.marks>o2.marks) return 1;
                    else if(o1.marks<o2.marks) return -1;
                    return 0;
                }
            });


            StringBuffer Line = new StringBuffer();
            Line.append("Rank,Number,Total Marks");
            bw.write(Line.toString());
            bw.newLine();
            for(int j=0;j<list.getLength()/3;j++){
                Line = new StringBuffer();
                Line.append(j+1);
                Line.append(CSV);
                Line.append(arr[j].rollno);
                Line.append(CSV);
                Line.append(arr[j].marks);
                System.out.println(Line.toString());
                bw.write(Line.toString());
                bw.newLine();
            }
            bw.flush();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }}