public class GameEngine {
    
    public double radiusTarget = 0.10;
    public boolean inHole(double endX,double endY){
        double distance = Math.sqrt(Math.pow((endX - inputReader.xt), 2) + Math.pow((endY - inputReader.yt), 2));
        if (distance >= radiusTarget){
            return false;
        }
        else{
            return true;
        }
    }
}
