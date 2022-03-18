import java.io.*;
import java.util.ArrayList;


public class velocityReader{

    static File f;
    static FileReader fileReader;
    static BufferedReader bufferedReader;
    static String line, valueY, valueX;
    public static ArrayList<String> xList;
    public static ArrayList<String> yList;
    static String[] arrayX, arrayY; //this is the returned array with all the values in their positions
    static double[][] velArray;
    static String[][] velStringArr;
    static int count=0;
    static double valueTemp;

    public static void main(String[] args) {
            //in the folllowing lines all the variables will be filled with the correspondant array values
    }
    public static double[][] getValues(String file) {
        

        xList = new ArrayList<>();
        yList = new ArrayList<>();

        try{
            file = "trails.txt";
            f = new File(file);
            fileReader = new FileReader(f);
            bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null){
                String[] parts = line.split(",");
                valueY = parts[1];
                valueX = parts[0];
                xList.add(valueX);
                yList.add(valueY);
                count++;
            }
            velArray = new double[2][count];
            arrayX = xList.toArray(new String[0]); // converts from arraylist to array, it will return an array
            arrayY = yList.toArray(new String[0]); // converts from arraylist to array, it will return an array
            
            for(int i=0; i<count; i++){
                valueTemp=(Double.parseDouble(arrayX[i]));
                velArray[0][i]=valueTemp;
            }

            for(int i=0; i<count; i++){
                valueTemp=(Double.parseDouble(arrayY[i]));
                velArray[1][i]=valueTemp;
            }

            System.out.println(velArray[0][0]);

    
        }
        catch(FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch(Exception e){
            System.out.println("General error!");
        }
        return velArray; // returning the String array with all the values

    }
}
