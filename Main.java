import java.io.FileNotFoundException;

public class Main implements Runnable{
    public static boolean run = false;
    public static int count = 1;
    public static Thread t;
    public static Object LOCK = new Object();
    public static Object LOCK2 = new Object();
    public static double xV = 0.0;
    public static double yV = 0.0;
    public static void main(String[] args) throws FileNotFoundException  {
        config();
        //PhysicsEngine.EulersMethod(0.01, 0, 0, 2, 0, 0.056, 0.05);
        t = new Thread(new Main()) {};
        t.start();
        synchronized (LOCK2) {
        while (true) {
                try { LOCK2.wait(); }
                catch (InterruptedException e) {
                    // treat interrupt as exit request
                }
            
                unlock();
                PhysicsEngine.SemiImplicitEulerMethod(0.01, Ball.X, Ball.Y, xV, yV, 0.056);
                
            
            count++;
            count--;
        }
    }
        

    }  
    public static void config() throws FileNotFoundException{
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
        
    }
    public static void unlock(){
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
            while(!(golfApp.golfing == null)){
                golfApp.golfing.UpdateBall((int)(Ball.X * 100), (int)(Ball.Y * 100));
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
