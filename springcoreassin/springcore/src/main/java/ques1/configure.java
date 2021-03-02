package ques1;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
public class configure {
	 @Bean(name="rectangle")
	    public rectangle createReactangleobject() {
	        List<String> colors = new ArrayList<>();
	        colors.add("pink");
	        colors.add("red");
	        colors.add("yellow");
	        return new rectangle(getpointP1(),getpointP2(),getpointP3(),getpointP4(),colors);
	    }

	    @Bean(name="points 1")
	    public points getpointP1() {
	        return new points(30,20);
	    }

	    @Bean(name="points 2")
	    public points getpointP2() {
	        return new points(40,10);
	    }

	    @Bean(name="points 3")
	    public points getpointP3() {
	        return new points(60,10);
	    }

	    @Bean(name="points 4")
	    public points getpointP4() {
	        return new points(20,10);
	    }
}
