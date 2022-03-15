import org.mariuszgromada.math.mxparser.*;


public class TempTest {

    public static double derivativeOf(double X, double Y){
        

        Argument x1 = new Argument("x = "+X);
        Argument y1 = new Argument("y = "+Y);
        Expression e1 = new Expression("der((0.1*x)+(1+y), x)", x1, y1);

        double calc = e1.calculate();

        return calc;
    }
    public static void main(String[] args) {

    
        System.out.println(derivativeOf(2.4, 5.5));
    }
}
