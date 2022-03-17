import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Arrow {
    Arrow arrow;
    public static double xPos = 10;
    public static double yPos = 50;
    public static Point2D.Double p = new Point2D.Double(50,50);
    public static Point2D.Double p2 = new Point2D.Double(xPos,yPos);
    public static Line2D.Double line = new Line2D.Double(p,p2);


    public static void moveArrow(double x, double y)
    {
        xPos += x;
        yPos += y;
    }

    public static void draw(Graphics2D g2)
    {
        Color b = new Color(51,153,255);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.RED);
        g2.draw(line);
    }
}
