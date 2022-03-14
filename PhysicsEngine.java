public class PhysicsEngine{


    public static double gravity = 9.81;
    public static double nextX;
    public static double nextY;

    public static double EulersMethod(double stepsize, double X, double Y){
        double nextX = (X + stepsize);
        double nextY = (Y + stepsize*derivativeCalculator(Y, X));
        return 1;
    }
    /**
     * 
     * @param positionX position of the ball
     * @param positionY
     * @param velocityX velocity in m/s
     * @param velocityY
     * @param mass in kg
     * @param friction friction coefficient
     * @return
     */
    public static double beginXCalculator(double positionX, double positionY, double velocityX,  double velocityY ,double mass, double friction){
        double velocityThing = velocityX/Math.sqrt(Math.pow(velocityX, 2)+ Math.pow(velocityY, 2)+ Math.pow(((derivativeCalculator(positionX,positionY)*velocityX)+(derivativeCalculator(positionY,positionX)*velocityY)),2));
        double frictionThing = (friction*mass*gravity)/(Math.sqrt(1+Math.pow(derivativeCalculator(positionX,positionY), 2)+ Math.pow(derivativeCalculator(positionY,positionX), 2)));
        double gravityThing = (mass*gravity*derivativeCalculator(positionX,positionY))/(1+Math.pow(derivativeCalculator(positionX,positionY), 2)+ Math.pow(derivativeCalculator(positionY,positionX), 2));
        System.out.println(frictionThing);
        System.out.println(gravityThing);
        return -gravityThing-(velocityThing*frictionThing);
    }
    public static double beginYCalculator(double positionX, double positionY, double velocityX,  double velocityY ,double mass, double friction){
        double velocityThing = velocityY/Math.sqrt(Math.pow(velocityX, 2)+ Math.pow(velocityY, 2)+ Math.pow(((derivativeCalculator(positionX,positionY)*velocityX)+(derivativeCalculator(positionY,positionX)*velocityY)),2));
        double frictionThing = (friction*mass*gravity)/(Math.sqrt(1+Math.pow(derivativeCalculator(positionX,positionY), 2)+ Math.pow(derivativeCalculator(positionY,positionX), 2)));
        double gravityThing = (mass*gravity*derivativeCalculator(positionY,positionX))/(1+Math.pow(derivativeCalculator(positionX,positionY), 2)+ Math.pow(derivativeCalculator(positionY,positionX), 2));
        System.out.println(frictionThing);
        System.out.println(gravityThing);
        return -gravityThing-(velocityThing*frictionThing);
    }
    /**
     * first param will determine 
     * @param X
     * @param Y
     * @return
     */
    public static double derivativeCalculator(double X, double Y){
        double first = mathFunction.Function(X,Y);
        double second = mathFunction.Function(X+0.00000001,Y);
        return (second - first)/0.00000001;
    }

    public static double derivativeX(String pTerm, int val){
        
        String coeffString = "";
        int i;
        for(i = 0; pTerm.charAt(i) != 'x'; i++){
            if(pTerm.charAt(i) == ' '){
                continue;
            }
            coeffString += (pTerm.charAt(i));
        }

        long coeff = Long.parseLong(coeffString);


        String powerString = "";

        for(i = i + 2; i != pTerm.length() && pTerm.charAt(i) != ' '; i++){
            
            powerString += pTerm.charAt(i);
        }

        long power = Long.parseLong(powerString);

        return coeff * power * (double)Math.pow(val, power-1);
    }

    static double derivativeVal(String poly, int val){

        double ans = 0;

        int i = 0;
        String[] stSplit = poly.split("\\+");

        while( i < stSplit.length){
            ans = (ans + derivativeX(stSplit[i], val));
            i++;
        }

        return ans;
    }
}