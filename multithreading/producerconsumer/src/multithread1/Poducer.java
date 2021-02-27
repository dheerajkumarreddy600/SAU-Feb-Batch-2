package multithread1;
import java.util.*;

public class Poducer extends Thread {
	private static final int MAX_SIZE=4;
	private final 	ArrayList<String> queue=new ArrayList<String>();
	Scanner sc= new Scanner(System.in);
	@Override
	public void run()
	{	
		try{
			while(true) {
				produce();
			}
		}
			catch(Exception e) {
				
			}
		}
  private synchronized  void produce() throws Exception{
	         while(queue.size()==MAX_SIZE) {
	        	 System.out.println("queue is full of tasks");
	        	 wait();
	         }
	         System.out.println("enter any task");
	         
	         String st=sc.nextLine();
	         queue.add(st);
	         System.out.println("task produced");
             notify();
  }
  public synchronized String consume() throws Exception{
	    notify();
	    while(queue.isEmpty()) {
	    	wait();
	    }
	    String st=queue.get(0);
	    queue.remove(st);
	    return st;
	    
	    
  }
		
		
	}
       
       

