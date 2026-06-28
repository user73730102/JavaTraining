package asign1;

public class Beta extends Alfa {
    public Beta() {
        super();
        System.out.println("Beta constructor called");
    }

    @Override
    public void demo() {
        System.out.println("This is demo from Beta");
    }

    public void betaOnlyMethod() {
        System.out.println("This method is only in Beta class");
    }
}
