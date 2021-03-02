package ques1;

import org.w3c.dom.css.Rect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class start {
	 
		 public static void main( String[] args ) {
	        ApplicationContext c = new AnnotationConfigApplicationContext(configure.class);
	        rectangle rect = (rectangle) c.getBean("rectangle");
	        System.out.println("Coordinates   are :" + rect.getP1().getX() + ", " + rect.getP1().getY());
	        System.out.println("Coordinates    are :" + rect.getP2().getX() + ", " + rect.getP2().getY());
	        System.out.println("Coordinates   are :" + rect.getP3().getX() + ", " + rect.getP3().getY());
	        System.out.println("Coordinates  are :" + rect.getP4().getX() + ", " + rect.getP4().getY());

	        List<String> colors = rect.colors();
	        System.out.println("List of quadilaterals : ");
	        for (int i = 0; i<colors.size(); i++) {
	                System.out.println(colors.get(i) + " ");
	        }

	        System.out.println("Height of the rectangle  :" + rect.getHeight());
	        System.out.println("Width of the rectangle :" + rect.getWidth());
            

	    }
}
