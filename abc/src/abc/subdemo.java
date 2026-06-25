package abc;

public class subdemo<T,P> extends DEmo<T> {
	private P temp;

	public subdemo(T data, P temp) {
		super(data);
		this.temp = temp;
	}

	public P getTemp() {
		return temp;
	}

	public void setTemp(P temp) {
		this.temp = temp;
	}
	public static void main(String[] args) {
		subdemo<String, Integer> sd= new subdemo<String, Integer>("Mona", 99);
		System.out.println(sd.getData()+"\t"+sd.getTemp());
	}
}
