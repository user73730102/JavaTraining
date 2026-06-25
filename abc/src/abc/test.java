package abc;

import com.mmcoe.emp.Clerk;
import com.mmcoe.emp.Employee;
import com.mmcoe.emp.Manager;

public class test {
	public static void main(String[] args)
	{
		Manager m = new Manager(1500,800);
		Clerk c = new Clerk(1200,400);
		
		showSalary(m);
		showSalary(c);
		
	}

//	private static void showSalary(Employee e) {
//		System.out.println(e.getSalary());
//		
//	}
	private static void showSalary(Employee e) {
		if(e instanceof Manager)
			System.out.println("Manager: "+e.getSalary());
		else
			System.out.println("Clerk: "+e.getSalary());
	}
}
