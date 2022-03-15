import java.io.FileNotFoundException;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        config();
        //PhysicsEngine.EulersMethod(0.01, 0, 0, 2, 0, 0.056, 0.05);
        PhysicsEngine.SemiImplicitEulerMethod(0.01, 0, 0, 2, 0, 0.056, 0.05);

    }  
    public static void config() throws FileNotFoundException{
        inputReader.initValues("example_inputfile.txt");
        Parse.Parser(inputReader.heightProfile);
        
    }
}
