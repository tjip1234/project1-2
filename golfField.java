import java.util.Arrays;
import java.util.Random;
public class golfField
{
    public static int[] database = new int[680];
    public int low = -20;
    public int high = 100;
    public int[] fill()
    {
        Random randNum = new Random();
        for (int i=0; i<database.length; i++)
        {
            database[i]=randNum.nextInt(high-low);
        }
        return database;
    }
}
