package multithread1;

public class Consumer extends Thread {
	private Poducer producer;
	public Consumer (Poducer producer) {
		this.producer=producer;
	}
	@Override()
	public void run() {
		try {
			while(true) {
			String st=	producer.consume();
			System.out.println("Consumed by" +Thread.currentThread().getName() +" Task="+st);
			}
			
		}
		catch(Exception e) {
			
		}
	}

}
