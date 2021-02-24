package multithread1;

public class Producerconsumer {

	public static void main(String[] args) {
		Poducer producer =new Poducer();
		
		
		Consumer consumer=new Consumer(producer);
		Consumer consumer1=new Consumer(producer);
		producer.setName("p1");
		consumer.setName("c1");
		consumer1.setName("c2");
		producer.start();
		consumer.start();
		consumer1.start();
	}

}
