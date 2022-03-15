import org.mariuszgromada.math.mxparser.*;


public class TempTest {

    public static double derivativeOf(double X, double Y, String function, char withrespectto){
        Argument x1 = new Argument("x = "+X);
        Argument y1 = new Argument("y = "+Y);
        if (withrespectto == 'y') {
            Expression e1 = new Expression("der("+function+", y)", x1, y1);
            double calc = e1.calculate();
            return calc;
        }
        Expression e1 = new Expression("der("+function+", x)", x1, y1);
        double calc = e1.calculate();
        return calc;
    }
    public static void main(String[] args) {

    
        //System.out.println(derivativeOf(2.4, 5.5));
    }
}
