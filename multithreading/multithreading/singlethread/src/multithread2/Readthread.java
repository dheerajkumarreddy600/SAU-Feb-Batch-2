package multithread2;
import java.io.BufferedReader;


import java.io.FileReader;
public class Readthread  extends Thread{

	public static void main(String[] args) throws Exception {
		int count =0;
		String line;
	long t1=	System.currentTimeMillis();
		FileReader file = new FileReader("C:\\Users\\Mdheeraj kumar reddy\\eclipse-workspace\\multithread2\\src\\text.txt");  
        BufferedReader br = new BufferedReader(file);  
        
        while((line = br.readLine()) != null) {  
            
            String words[] = line.split(" ");  
            
           
            count = count + words.length;  
        }
        
       long t2 =System.currentTimeMillis();
       long t=t2-t1;
        System.out.println(count);
        System.out.println("time taken ="+t+" milliseconds");	      
        }

	}


