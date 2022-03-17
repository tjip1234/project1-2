import java.math.BigDecimal;
import org.mariuszgromada.math.mxparser.*;
class PhysicsEngine{
    public static double gravity = 9.81;
    public static double StaticFriction = 0.2;
    public static double nextX;
    public static double nextY;
    public static int count = 0;
    public static double epsilon = 0.1;
    public static double epsilon2 = 0.015;
    public static double friction = 0.1;
    public static double stepsize = 0.01;

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
            Ball.X = X;
            Ball.Y = Y;
            Ball.Z = mathFunction.Function(X, Y);
            //double slope = (Y-y)/(X-x);
            //double intercept = y - slope * x;
            Ball.X = X;
            Ball.Y = Y;
            golfApp.golfing.UpdateBall((int)(Ball.X * 100),(int)(Ball.Y * 100));
            if(mathFunction.CheckSand(X, Y)){
                friction = inputReader.mus;
                StaticFriction = inputReader.musS;
            }
            else{ 
                friction = inputReader.muk;
                StaticFriction = inputReader.mukS;
            }
            //TODO fix this
            if (X < inputReader.tree1.X + inputReader.tree1.R && X > inputReader.tree1.X - inputReader.tree1.R && Y < inputReader.tree1.Y + inputReader.tree1.R && Y > inputReader.tree1.Y - inputReader.tree1.R) {
                Ball.X = Ball.prevX;
                Ball.Y = Ball.prevY;
                Ball.Z = Ball.prevZ;
                return;
            }
            if (mathFunction.Function(X,Y) < 0) {
                Ball.X = Ball.prevX;
                Ball.Y = Ball.prevY;
                Ball.Z = Ball.prevZ;
                return;
            }
            if (Stop(velocityX, velocityY)) {
                if (StopComplete(X, Y, StaticFriction)) {
                    X = (x+X)/2;
                    Y = (y+Y)/2;
                    Ball.prevX = X;
                    Ball.prevY = Y;
                    Ball.prevZ = mathFunction.Function(X, Y);
                    System.out.println(X + " " + Y + " " + velocityX + " " + velocityY );
                    return;
                    
                }
            }
            EulersMethod(stepsize, X,Y,velocityX,velocityY,mass,friction);
        }
    public static void SemiImplicitEulerMethod(double stepsize, double X, double Y, double velocityX, double velocityY, double mass){
            
            double x = X;
            double y = Y;
            double vx = velocityX;
            double vy = velocityY;
            velocityX += stepsize * beginXCalculator(x,y,vx,vy,mass,friction );
            velocityY += stepsize * beginYCalculator(x,y,vx,vy,mass,friction );
            X += stepsize *velocityX;
            Y += stepsize *velocityY;
            //System.out.println(derivativeCalculator(X, Y));
            System.out.println(X + " " + Y + " " + velocityX + " " + velocityY );
            if(mathFunction.CheckSand(X, Y)){
                friction = inputReader.mus;
                StaticFriction = inputReader.musS;
            }
            else{ 
                friction = inputReader.muk;
                StaticFriction = inputReader.mukS;
            }

            //TODO fix this
            if (X < inputReader.tree1.X + inputReader.tree1.R && X > inputReader.tree1.X - inputReader.tree1.R && Y < inputReader.tree1.Y + inputReader.tree1.R && Y > inputReader.tree1.Y - inputReader.tree1.R) {
                Ball.X = Ball.prevX;
                Ball.Y = Ball.prevY;
                Ball.Z = Ball.prevZ;
                return;
            }
            if (mathFunction.Function(X,Y) < 0) {
                Ball.X = Ball.prevX;
                Ball.Y = Ball.prevY;
                Ball.Z = Ball.prevZ;
                return;
            }
            if (Stop(velocityX, velocityY)) {
                if (StopComplete(X, Y, StaticFriction)) {
                    X = (x+X)/2;
                    Y = (y+Y)/2;
                    System.out.println(X + " " + Y + " " + velocityX + " " + velocityY );
                    return;
                }
            }
            Ball.X = X;
            Ball.Y = Y;
            //golfApp.golfing.UpdateBall((int)(Ball.X * 100),(int)(Ball.Y * 100));

            SemiImplicitEulerMethod(stepsize, X,Y,velocityX,velocityY,mass);
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
            //double k1 = stepsize* beginYCalculator(X, Y, velocityX, velocityY, mass, friction);
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
        return -gravityThing-(velocityThing*frictionThing);
    }
    public static double Phase3YCalculator(double positionX, double positionY, double velocityX,  double velocityY ,double mass, double friction){
        double velocityThing = velocityY/Math.sqrt(Math.pow(velocityX, 2)+ Math.pow(velocityY, 2)+ Math.pow(((derivativeCalculator(positionX,positionY)*velocityX)+(derivativeCalculator(positionY,positionX)*velocityY)),2));
        double frictionThing = (friction*mass*gravity)/(Math.sqrt(1+Math.pow(derivativeCalculator(positionX,positionY), 2)+ Math.pow(derivativeCalculator(positionY,positionX), 2)));
        double gravityThing = (mass*gravity*derivativeCalculator(positionY,positionX))/(1+Math.pow(derivativeCalculator(positionX,positionY), 2)+ Math.pow(derivativeCalculator(positionY,positionX), 2));
        return -gravityThing-(velocityThing*frictionThing);
    }
    public static boolean StopComplete(double X, double Y, double staticfriction){
        if((derivativeOf(X,Y,inputReader.heightProfile,'x') ==  0) && (derivativeOf(X,Y,inputReader.heightProfile,'y') == 0) || (Math.abs(derivativeCalculator(X, Y))  - epsilon < 0) && (Math.abs(derivativeCalculator(Y, X)) - epsilon < 0 )){ // range
            return true;
        }
        else if(derivativeOf(X,Y,inputReader.heightProfile,'x') == 0 || derivativeOf(X,Y,inputReader.heightProfile,'y') == 0 || (Math.abs(derivativeCalculator(X, Y))  - epsilon < 0) || (Math.abs(derivativeCalculator(Y, X)) - epsilon < 0 )){ 
            if(staticfriction > Math.sqrt(Math.pow(derivativeOf(X,Y,inputReader.heightProfile,'x'), 2) + Math.pow(derivativeOf(X,Y,inputReader.heightProfile,'y'), 2))){
                return true;
            }
        }
        return false;
    }

    public static double beginXCalculator(double positionX, double positionY, double velocityX,  double velocityY ,double mass, double friction){
        double xThing = (-gravity*derivativeOf(positionX,positionY,inputReader.heightProfile,'x')) - (friction*gravity*velocityX)/(Math.sqrt(Math.pow(velocityX, 2) + Math.pow(velocityY, 2)));
        return xThing;
    }

    public static double beginYCalculator(double positionX, double positionY, double velocityX,  double velocityY ,double mass, double friction){
        double yThing = (-gravity*derivativeOf(positionX,positionY,inputReader.heightProfile,'y')) - (friction*gravity*velocityY)/(Math.sqrt(Math.pow(velocityX, 2) + Math.pow(velocityY, 2)));
        return yThing;
    }

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
        

    public static double derivativeCalculator(double X, double Y){
        BigDecimal first = BigDecimal.valueOf(mathFunction.Function(X,Y));
        BigDecimal second = BigDecimal.valueOf(mathFunction.Function(X+0.00000000000000001,Y));
        BigDecimal devision = BigDecimal.valueOf((0.00000000000000001));            
        BigDecimal third = (second.subtract(first)).divide(devision);
        return third.longValueExact();
    }
    }
