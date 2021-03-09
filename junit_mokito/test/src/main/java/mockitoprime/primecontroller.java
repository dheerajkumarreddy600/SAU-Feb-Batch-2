package mockitoprime;

public class primecontroller {
	prime pc;
	public boolean Prime(int n) {
		return pc.isPrime(n);
	}
	public prime getObj() {
		return pc;
	}
	public void setObj(prime pc) {
		this.pc = pc;
	}
}
