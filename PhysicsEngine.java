import java.math.BigDecimal;
class PhysicsEngine{

        public static double gravity = 9.81;
        public static double StaticFriction = 0.2;
        public static double nextX;
        public static double nextY;
        public static int count = 0;
        public static double epsilon = 0.1;
        public static double epsilon2 = 0.15;
        
        public static void EulersMethod(double stepsize, double X, double Y, double velocityX, double velocityY, double mass, double friction){

            double x = X;
            double y = Y;
            double vx = velocityX;
            double vy = velocityY;
            
            X += stepsize *velocityX;
            Y += stepsize *velocityY;
            velocityX += stepsize * beginXCalculator(x,y,vx,vy,mass,friction );
            velocityY += stepsize * beginYCalculator(x,y,vx,vy,mass,friction );
            System.out.println(derivativeCalculator(X, Y));
            System.out.println(X + " " + Y + " " + velocityX + " " + velocityY );

            if (Stop(velocityX, velocityY)) {
                if (StopComplete(X, Y, StaticFriction)) {
                    X = (x+X)/2;
                    Y = (y+Y)/2;
                    System.out.println(X + " " + Y + " " + velocityX + " " + velocityY );
                    return;
                }
            }
    
            EulersMethod(stepsize, X,Y,velocityX,velocityY,mass,friction);
        }
        public static void SemiImplicitEulerMethod(double stepsize, double X, double Y, double velocityX, double velocityY, double mass, double friction){
            
            double x = X;
            double y = Y;
            double vx = velocityX;
            double vy = velocityY;
            velocityX += stepsize * beginXCalculator(x,y,vx,vy,mass,friction );
            velocityY += stepsize * beginYCalculator(x,y,vx,vy,mass,friction );
            X += stepsize *velocityX;
            Y += stepsize *velocityY;
            System.out.println(derivativeCalculator(X, Y));
            System.out.println(X + " " + Y + " " + velocityX + " " + velocityY );
            if (Stop(velocityX, velocityY)) {
                if (StopComplete(X, Y, StaticFriction)) {
                    X = (x+X)/2;
                    Y = (y+Y)/2;
                    System.out.println(X + " " + Y + " " + velocityX + " " + velocityY );
                    return;
                }
            }
            SemiImplicitEulerMethod(stepsize, X,Y,velocityX,velocityY,mass,friction);
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


        public static void RKuttaMethod(double stepsize, double X, double Y, double velocityX, double velocityY, double mass, double friction){
    
            double x = X;
            double y = Y;
            double vx = velocityX;
            double vy = velocityY;
            double k1 = stepsize* beginYCalculator(X, Y, velocityX, velocityY, mass, friction);
            X += stepsize *velocityX;
            Y += stepsize *velocityY;
            velocityX += stepsize * beginXCalculator(x,y,vx,vy,mass,friction );
            velocityY += stepsize * beginYCalculator(x,y,vx,vy,mass,friction );
            System.out.println(X + " " + Y + " " + velocityX + " " + velocityY );
            System.out.println(derivativeCalculator(X, Y));
            if (Stop(velocityX, velocityY)) {
                if (StopComplete(X, Y, StaticFriction)) {
                    X = (x+X)/2;
                    Y = (y+Y)/2;
                    return;
                }
            }

    
            RKuttaMethod(stepsize, X,Y,velocityX,velocityY,mass,friction);
        }

    public static boolean Stop(double X, double Y){
           if(Math.abs(X)-epsilon2<0 && Math.abs(Y)-epsilon2<0){
                return true;
           }
           return false;
        }
    

    public static double Phase3XCalculator(double positionX, double positionY, double velocityX,  double velocityY ,double mass, double friction){
        double velocityThing = velocityX/Math.sqrt(Math.pow(velocityX, 2)+ Math.pow(velocityY, 2)+ Math.pow(((derivativeCalculator(positionX,positionY)*velocityX)+(derivativeCalculator(positionY,positionX)*velocityY)),2));
        double frictionThing = (friction*mass*gravity)/(Math.sqrt(1+Math.pow(derivativeCalculator(positionX,positionY), 2)+ Math.pow(derivativeCalculator(positionY,positionX), 2)));
        double gravityThing = (mass*gravity*derivativeCalculator(positionX,positionY))/(1+Math.pow(derivativeCalculator(positionX,positionY), 2)+ Math.pow(derivativeCalculator(positionY,positionX), 2));
        //System.out.println(frictionThing);
       // System.out.println(gravityThing);
        return -gravityThing-(velocityThing*frictionThing);
    }
    public static double Phase3YCalculator(double positionX, double positionY, double velocityX,  double velocityY ,double mass, double friction){
        double velocityThing = velocityY/Math.sqrt(Math.pow(velocityX, 2)+ Math.pow(velocityY, 2)+ Math.pow(((derivativeCalculator(positionX,positionY)*velocityX)+(derivativeCalculator(positionY,positionX)*velocityY)),2));
        double frictionThing = (friction*mass*gravity)/(Math.sqrt(1+Math.pow(derivativeCalculator(positionX,positionY), 2)+ Math.pow(derivativeCalculator(positionY,positionX), 2)));
        double gravityThing = (mass*gravity*derivativeCalculator(positionY,positionX))/(1+Math.pow(derivativeCalculator(positionX,positionY), 2)+ Math.pow(derivativeCalculator(positionY,positionX), 2));
        //System.out.println(frictionThing);
        //System.out.println(gravityThing);
        return -gravityThing-(velocityThing*frictionThing);
    }
    /**
     * first param will determine 
     * @param X
     * @param Y
     * @return
     */


    public static boolean StopComplete(double X, double Y, double staticfriction){
        if((derivativeCalculator(X,Y) ==  0) && (derivativeCalculator(Y,X) == 0) || (Math.abs(derivativeCalculator(X, Y))  - epsilon < 0) && (Math.abs(derivativeCalculator(Y, X)) - epsilon < 0 )){ // range
            return true;
        }
        else if(derivativeCalculator(X,Y) == 0 || derivativeCalculator(Y,X) == 0 || (Math.abs(derivativeCalculator(X, Y))  - epsilon < 0) || (Math.abs(derivativeCalculator(Y, X)) - epsilon < 0 )){ 
            if(staticfriction > Math.sqrt(Math.pow(derivativeCalculator(X,Y), 2) + Math.pow(derivativeCalculator(Y,X), 2))){
                return true;
            }
        }
        return false;
    }
        public static double beginXCalculator(double positionX, double positionY, double velocityX,  double velocityY ,double mass, double friction){

            double xThing = (-gravity*derivativeCalculator(positionX, positionY)) - (friction*gravity*velocityX)/(Math.sqrt(Math.pow(velocityX, 2) + Math.pow(velocityY, 2)));
            return xThing;
        }

        public static double beginYCalculator(double positionX, double positionY, double velocityX,  double velocityY ,double mass, double friction){

            double yThing = (-gravity*derivativeCalculator(positionY, positionX)) - (friction*gravity*velocityY)/(Math.sqrt(Math.pow(velocityX, 2) + Math.pow(velocityY, 2)));
            return yThing;
        }

        /**
         * first param will determine 
         * @param X
         * @param Y
         * @return
         */
        public static double derivativeCalculator(double X, double Y){
            BigDecimal first = BigDecimal.valueOf(mathFunction.Function(X,Y));
            BigDecimal second = BigDecimal.valueOf(mathFunction.Function(X+0.00000000000000001,Y));
            BigDecimal devision = BigDecimal.valueOf((0.00000000000000001));
            BigDecimal third = (second.subtract(first)).divide(devision);
            return third.longValueExact();
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
