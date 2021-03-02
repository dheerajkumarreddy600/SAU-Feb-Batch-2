package ques2;

import org.springframework.stereotype.Component;
@Component

public class details {
	   String name = "dheeraj";
       int number = 1;
   public void getname() {
           System.out.println("dheeraj");
       }

       public int getnumber()
       {
           return number;
       }

       public void getdet(String det)throws  Exception {

           System.out.println("details = " + det);
           
       }
}
