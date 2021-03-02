package ques1;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class rectangle {
	 int height, width;
	 @Autowired
     @Qualifier("points 1")
     private points p1;

     @Autowired
     @Qualifier("points 2")
     private points p2;

     @Autowired
     @Qualifier("points 3")
     private points p3;
     
     @Autowired
     @Qualifier("points 4")
     private points p4;
     public points getP1() {
         return p1;
     }
     private List<String> colors;

     public rectangle(points p1, points p2, points p3, points p4, List<String> colors) {
         this.p1 = p1;
         this.p2 = p2;
         this.p3 = p3;
         this.p4 = p4;
         this.colors = colors;
     }

     public void setP1(points p1) {
         this.p1 = p1;
     }

     public void setP2(points p2) {
         this.p2 = p2;
     }

     public void setP3(points p3) {
         this.p3 = p3;
     }

     public void setP4(points p4) {
         this.p4 = p4;
     }

     public points getP2() {
         return p2;
     }

     public points getP3() {
         return p3;
     }

     public points getP4() {
         return p4;
     }
     public int getHeight() {
         this.height = p1.getY() - p4.getY();
         return this.height;
     }

     public int getWidth() {
         this.width = p2.getX() - p1.getX();
         return this.width;
     }
     public List<String> colors() {
         return colors;
     }

	
}

