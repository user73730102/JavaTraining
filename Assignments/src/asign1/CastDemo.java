package asign1;

public class CastDemo {
    public static void main(String[] args) {
        Beta originalBeta = new Beta();
        
        Alfa upcasted = originalBeta; 
        upcasted.demo(); 

        if (upcasted instanceof Beta) {
            Beta downcasted = (Beta) upcasted;
            downcasted.demo();
            downcasted.betaOnlyMethod();
        }
    }
}
