package ques2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import ques2.details;

public class start {
	public static void main(String[] args)throws Exception {
        AbstractApplicationContext c = new AnnotationConfigApplicationContext(configure.class);
        details e = c.getBean(details.class);
        e.getname();
        int number = e.getnumber();
        e.getdet("male");

    }
}
