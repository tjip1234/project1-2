import org.mariuszgromada.math.mxparser.*;


public class TempTest {

    public static double derivativeOf(double X){
        

        Argument x1 = new Argument("x = "+X);
        Expression e1 = new Expression("der((0.1*x)+1, x)", x1);

        double calc = e1.calculate();

        return calc;
    }
    public static void main(String[] args) {

    
        System.out.println(derivativeOf(2.4));
    }
}
