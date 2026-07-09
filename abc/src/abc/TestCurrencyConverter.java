@FunctionalInterface   
public inteface Currency{
    double dollarValue();

    static double convert(Currency source,Currency target, amount){
        return target.dollarValue()/source.dollarValue*amount;
    }
    Currency USD=()->1.0;
    Currency INR=()->95.0;
    Currency AED=()->3.70;

}
class TestCurrencyConverter{
    public static void main(String[] args) {
        System.out.println(USD,INR,100);
    }
    
}