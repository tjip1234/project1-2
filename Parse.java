import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Parse
 */

public class Parse {

    public static void main(String[] args) throws FileNotFoundException{
        String h = "(7 + * 8)sin(x)/cos(y) + 7";
        Parser(h);
    }

    public static void Parser(String s) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter("mathFunction.java");
        writer.write("public class mathFunction {");
        writer.println();
        writer.write("public double Function(double x, double y){");
        writer.println();
        String mathLine = "";
        while (!s.isEmpty()) {
            switch (s.charAt(0)) {
                case 's':
                    if (s.substring(0, 3).equals("sin")) {
                        mathLine += "Math.sin";
                        s = s.replaceFirst(s.substring(0, 3), "");
                        break;  
                    }
                    mathLine += s.charAt(0);
                    s = s.replaceFirst(s.substring(0, 1), "");
                    break;

                case 'c':
                mathLine += "Math.cos";
                s = s.replaceFirst(s.substring(0, 3), "");
                    break;
                case 'e':
                mathLine += "Math.exp";
                s= s.replaceFirst(s.substring(0, 3), "");
                    break;
                case 'l':
                mathLine += "Math.log";
                s = s.replaceFirst(s.substring(0, 3), "");
                    break;
                default:
                    mathLine += s.charAt(0);
                    s = s.substring(1);
                    break;
            }
        }
        writer.write("return " + mathLine + ";");
        writer.println();
        writer.write("}}");
        writer.close();
    }

}