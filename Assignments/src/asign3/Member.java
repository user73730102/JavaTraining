package asign3;

public class Member {
	private String name;
	private Book bk;
	public Member(String name) {
		this.name=name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " Member [Name="+name+"]";
	}

	public void status(){
		if(bk==null)
			System.out.println(name+" has not issued book");
		else
			System.out.println(name+ " has issued a book "+bk);
	}
	
	public void issue(Book b) {
		if (this.bk == b) {
			return;
		}
		if (this.bk != null) {
			System.out.println("Member has already issued a book");
			return;
		}
		bk=b;
	}
	
	public void revoke(Book b) {
		if (this.bk == null) {
			return;
		}
		if (this.bk != b) {
			System.out.println("Member has not issued this book");
			return;
		}
		bk=null;
	}
}
