public class RKutta {
    //not sure if 100% good
    public static void RKuttaMethod(double stepsize, double X, double Y, double velocityX, double velocityY, double mass, double friction){
            
        double x = X;
        double y = Y;
        double vx = velocityX;
        double vy = velocityY;
        double k1 = stepsize* beginYCalculator(X, Y, velocityX, velocityY, mass, friction);
        double k2 = stepsize* beginYCalculator(X +(stepsize/2), Y + (k1/2), velocityX, velocityY, mass, friction);
        double k3 = stepsize* beginYCalculator(X +(stepsize/2), Y +(k2/2), velocityX, velocityY, mass, friction);
        double k4 = stepsize* beginYCalculator(X +stepsize, Y + k3, velocityX, velocityY, mass, friction);
        double c1 = stepsize* beginXCalculator(X, Y, velocityX, velocityY, mass, friction);
        double c2 = stepsize* beginXCalculator(X +(stepsize/2), Y + (k1/2), velocityX, velocityY, mass, friction);
        double c3 = stepsize* beginXCalculator(X +(stepsize/2), Y +(k2/2), velocityX, velocityY, mass, friction);
        double c4 = stepsize* beginXCalculator(X +stepsize, Y + k3, velocityX, velocityY, mass, friction);
        X += stepsize *velocityX;
        Y += stepsize *velocityY;
        velocityX += (c1/6) + (c2/3) + (c3/3) + (c4/6);
        velocityY += (k1/6) + (k2/3) + (k3/3) + (k4/6);
        System.out.println(X + " " + Y + " " + velocityX + " " + velocityY );
        //System.out.println(derivativeCalculator(X, Y));
        if (Stop(velocityX, velocityY)) {
            if (StopComplete(X, Y, StaticFriction)) {
                X = (x+X)/2;
                Y = (y+Y)/2;
                return;
            }
        }
        RKuttaMethod(stepsize, X,Y,velocityX,velocityY,mass,friction);
    }
}
