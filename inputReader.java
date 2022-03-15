import java.io.*;
import java.util.ArrayList;


public class inputReader{

    static File f;
    static FileReader fileReader;
    static BufferedReader bufferedReader;
    static String line, value;
    static ArrayList<String> lineList;
    static String[] array; //this is the returned array with all the values in their positions
    static double x0, y0, xt, yt, r, muk, mus, mukS, musS;
    static String sandPitX, sandPitY, heightProfile;
    static Tree tree1;

    public static void initValues(String name){
        getValues(name);
        x0=(Double.parseDouble(array[0]));
        y0=(Double.parseDouble(array[1]));
        xt=(Double.parseDouble(array[2]));
        yt=(Double.parseDouble(array[3]));
        r=(Double.parseDouble(array[4]));
        muk=(Double.parseDouble(array[5]));
        mus=(Double.parseDouble(array[6]));
        mukS=(Double.parseDouble(array[10]));
        musS=(Double.parseDouble(array[11]));
        tree1 = new Tree(Double.parseDouble(array[12]), Double.parseDouble(array[13]), Double.parseDouble(array[14]));
        sandPitX=array[8];
        sandPitY=array[9];
        heightProfile=array[7];
    }
    public static String[] getValues(String file) {
        

        lineList = new ArrayList<>();

        try{
            f = new File(file);
            fileReader = new FileReader(f);
            bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null){
                value = line.substring(line.lastIndexOf(" ") + 1); //it takes all the values after the last space
                lineList.add(value);
            }

            array = lineList.toArray(new String[0]); // converts from arraylist to array, it will return an array
            

        }
        catch(FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch(Exception e){
            System.out.println("General error!");
        }
        return array; // returning the String array with all the values

    }
}