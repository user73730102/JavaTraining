package asign2;

public class Stock implements Holder, Broker, Exchange{

public void viewQuote() {
    System.out.println("Viewing quote");
}

public void getQuote() {
    System.out.println("Getting quote");
}

public void setQuote() {
    System.out.println("Setting quote");
}
}
