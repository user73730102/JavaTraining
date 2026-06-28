package asign3;

public class Book {
	private String title;
	private Member mbr;
	public Book(String title) {
		this.title=title;
	}
	
	@Override
	public String toString() {
		return "Book [Title=" + title + "]";
	}

	public void status() {
		if(mbr==null)
			System.out.println(title+ " not issued to a member ");
		else
			System.out.println(title+ " is issued to a member " +mbr);
	}

	public void issue(Member m) {
		if (this.mbr == m) {
			return;
		}
		if (this.mbr != null) {
			System.out.println("Book is already issued to " + mbr);
			return;
		}
		mbr=m;
		m.issue(this);	
		
	}

	public void revoke(Member m) {
		if (this.mbr == null) {
			return;
		}
		if (this.mbr != m) {
			System.out.println("Book is not issued to this member");
			return;
		}
		this.mbr = null;
		m.revoke(this);
	}
}
