import java.io.FileNotFoundException;

public class Main implements Runnable{
    public static int EngineChoice = 0;
    public static boolean run = false;
    public static int count = 1;
    public static int c = 0;
    public static Thread t;
    public static Object LOCK = new Object();
    public static Object LOCK2 = new Object();
    public static double xV = 0.0;
    public static double yV = 0.0;
    public static double Velocities[][];
    public static void main(String[] args) throws FileNotFoundException  {
        config();
        //PhysicsEngine.EulersMethod(0.01, 0, 0, 2, 0, 0.056, 0.05);
        t = new Thread(new Main()) {};
        t.start();
        synchronized (LOCK2) {
        while (true) {
                try { 
                    c = 0;
                    run = false;
                    LOCK2.wait();
                 }
                catch (InterruptedException e) {
                    
                    // treat interrupt as exit request
                }
                if (c > 0) {
                    unlock();
                    for (int i = 0; i < c; i++) {
                        Main.xV = Main.Velocities[0][i];
                        Main.yV = Main.Velocities[1][i];
                        
                        Engine();
                        checkIfHitTarget(Ball.X, Ball.Y);

                        }
                    run = false;
                         
                }
                else{
                    unlock();
                    Engine();
                    checkIfHitTarget(Ball.X, Ball.Y);
                    run = false;
                }

                

        }
    }
        
    }  
    public static void Engine(){
        switch (EngineChoice) {
            case 0:
            PhysicsEngine.EulersMethod(0.01, Ball.X, Ball.Y, xV, yV, 0.056);
                break;
            case 1:
            PhysicsEngine.SemiImplicitEulerMethod(0.01, Ball.X, Ball.Y, xV, yV, 0.056);
                break;
            case 2:
            PhysicsEngine.rungeKutta4(0.005, Ball.X, Ball.Y, xV, yV);
                break;
            case 3:
            PhysicsEngine.rungeKutta2(0.005, Ball.X, Ball.Y, xV, yV);   
                break;
            default:
            PhysicsEngine.SemiImplicitEulerMethod(0.01, Ball.X, Ball.Y, xV, yV, 0.056);
                break;
        }
    }
    public static void config() throws FileNotFoundException{
        Velocities = velocityReader.getValues("trails.txt");
        inputReader.initValues("example_inputfile.txt");
        Parse.Parser(inputReader.heightProfile);
        if(mathFunction.CheckSand(inputReader.x0, inputReader.y0)){
            PhysicsEngine.friction = inputReader.mus;
            PhysicsEngine.StaticFriction = inputReader.musS;
        }
        else{ 
            PhysicsEngine.friction = inputReader.muk;
            PhysicsEngine.StaticFriction = inputReader.mukS;
        }
        Ball.X = inputReader.x0;
        Ball.Y = inputReader.y0;
        Ball.prevX = inputReader.x0;
        Ball.prevY = inputReader.y0;
        
    }
    public static void checkIfHitTarget(double x, double y){
        if (Math.pow((x-inputReader.xt), 2)+Math.pow((y-inputReader.yt), 2) <= Math.pow(inputReader.r, 2) ) {
            System.out.println("you won");
        }
    }
    public static void unlock(){
        run = true;
        synchronized (LOCK) {
            LOCK.notifyAll();
        }
    }
    public static void unlock2(){
        synchronized (LOCK2) {
            LOCK2.notifyAll();
        }
    }
    @Override
    public void run() {
        
        new golfApp();
        int count2 =0;
        synchronized (LOCK) {
        while (true) {
            try { LOCK.wait(); }
            catch (InterruptedException e) {
                // treat interrupt as exit request
            }
            while(run){
                golfApp3.golfing.UpdateBall((int)(Ball.X * 100), (int)(Ball.Y * 100));
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
        }


    }
}
