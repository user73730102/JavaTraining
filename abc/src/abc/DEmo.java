package abc;

public class DEmo <T>{
	private T data;

	public DEmo(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	public static void main(String[] args) {
		DEmo<String> d1=new DEmo<String>("Hola");
		System.out.println(d1.getData());
	}
	
}
