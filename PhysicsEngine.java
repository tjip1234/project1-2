public class PhysicsEngine{

    public int positionX;
    public int positionY;
    public double[] velocity;
    public double[][] frictionArray;
    public double gravity;
    public double mass;

    public int[] calculator(double stepSize, int positionX, int positionY, double[] velocity, double[][] frictionArray, double gravity){
            
        return null;
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