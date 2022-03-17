import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.Hashtable;
import java.awt.image.BufferedImage;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


public class golfApp2 implements ActionListener
{
    //void invoke(goldFile);
    int xPos = 0;
    int yPos = 0;
    private int str_control;
    private int drc_control;
    public static double xPosition = 10;
    public static double yPosition = 50;
    public static Point2D.Double p = new Point2D.Double(50,50);
    public static Point2D.Double p2 = new Point2D.Double(xPosition,yPosition);
    public static Line2D.Double line = new Line2D.Double(p,p2);
    Icon hit = new ImageIcon("res/button.png");
    Icon stop = new ImageIcon("res/stop.png");
    Image east = Toolkit.getDefaultToolkit().getImage("res/East.png");
    Image ball = Toolkit.getDefaultToolkit().getImage("res/golfball.png");
    Image compass = Toolkit.getDefaultToolkit().getImage("res/compass.png");
    //Component east = Toolkit.getDefaultToolkit().getImage("/Users/vantsevvictor/Downloads/Project 1-2/Golf/res/East.png");
    //Image field = Toolkit.getDefaultToolkit().getImage("/Users/vantsevvictor/Downloads/Project 1-2/Golf/res/field.png");
    Image field = Toolkit.getDefaultToolkit().getImage(ImageFile.imagename());
    JFrame frame = new JFrame();
    JPanel panel_1 = new JPanel();
    JPanel panel_2 = new JPanel();
    JSlider slider_strength = new JSlider(0, 100, 0);
    JSlider slider_direction = new JSlider(0, 360, 0);
    JButton hitButton = new JButton(hit);
    JButton stopButton = new JButton(stop);
    JLabel buttonname = new JLabel("HIT");
    JLabel stopname = new JLabel("STOP");
    JLabel strength = new JLabel("Strength: ");
    JLabel direction = new JLabel("Direction: ");
    JLabel eastarr = new JLabel("--->");
    JLabel ballable = new JLabel(new ImageIcon(ball));
    JLabel complable = new JLabel(new ImageIcon(compass));
    JLabel fieldy = new JLabel(new ImageIcon(field));
    JLabel eastarrow = new JLabel(new ImageIcon(east));
    Border border = BorderFactory.createLineBorder(new Color(0,0,0), 4);
    Border porder = BorderFactory.createLineBorder(new Color(0,0,0), 1); 
    public int a;
    public int b;
    Double HitStrength = 0.0;
    public golfApp2()
    {
        //Frame
        frame.setTitle("Playing Window");
        frame.setLayout( null );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setBounds(300,200,680,ImageFile.height+130);
        
        //Label
        complable.setBounds(610, ImageFile.height-70, 60, 60);

        //Panel_1
        panel_1.setLayout( null ); 
        //panel_1.setBackground(new Color(126,150,50));
        panel_1.setBounds(0,0,680,ImageFile.height);
        panel_1.setBorder(porder);
        //panel_1.add(ballable);
        //panel_1.add(complable);

        //Panel_2
        panel_2.setLayout( null );
        panel_2.setBackground(new Color(220,217,217));
        panel_2.setBounds(0,ImageFile.height,680,130);
        panel_2.setBorder(porder);

        //Slider_1
        slider_strength.setMajorTickSpacing(10);
        slider_strength.setPaintTicks(true);
        slider_strength.setPaintLabels(true);
        Hashtable position = new Hashtable();
        position.put(0, new JLabel("0"));
        position.put(10, new JLabel("10"));
        position.put(20, new JLabel("20"));
        position.put(30, new JLabel("30"));
        position.put(40, new JLabel("40"));
        position.put(50, new JLabel("50"));
        position.put(60, new JLabel("60"));
        position.put(70, new JLabel("70"));
        position.put(80, new JLabel("80"));
        position.put(90, new JLabel("90"));
        position.put(100, new JLabel("100"));
        slider_strength.setLabelTable(position); 

        //Slider_2
        slider_direction.setMajorTickSpacing(45);
        slider_direction.setPaintTicks(true);
        slider_direction.setPaintLabels(true);
        Hashtable dosition = new Hashtable();
        dosition.put(0, new JLabel("East"));
        dosition.put(45, new JLabel("NE"));
        dosition.put(90, new JLabel("Nord"));
        dosition.put(135, new JLabel("NW"));
        dosition.put(180, new JLabel("West"));
        dosition.put(225, new JLabel("SW"));
        dosition.put(270, new JLabel("South"));
        dosition.put(315, new JLabel("SE"));
        dosition.put(360, new JLabel("East"));
        slider_direction.setLabelTable(dosition); 

        //Button
        hitButton.setBorder(border);
        hitButton.setBackground(new Color(200,200,200));
        hitButton.setOpaque(true);
        hitButton.addMouseListener(
            new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e) 
                {
                    hitButton.setBorder(BorderFactory.createLineBorder(new Color(192,30,37),6));
                }

                @Override
                public void mousePressed(MouseEvent e) 
                {
                    hitButton.setBorder(BorderFactory.createLineBorder(new Color(192,30,37),6));
                }

                @Override
                public void mouseReleased(MouseEvent e) 
                {
                    hitButton.setBorder(BorderFactory.createLineBorder(new Color(192,30,37),6));
                }

                @Override
                public void mouseEntered(MouseEvent e) 
                {
                    hitButton.setBorder(BorderFactory.createLineBorder(new Color(192,30,37),6));
                }

                @Override
                public void mouseExited(MouseEvent e) 
                {
                    hitButton.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),4));
                } 
            }
        );
        hitButton.addActionListener(this);
        hitButton.setBounds(508, 6, 60, 60);

        //Button
        stopButton.setBorder(border);
        stopButton.setBackground(new Color(200,200,200));
        stopButton.setOpaque(true);
        stopButton.addMouseListener(
            new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e) 
                {
                    stopButton.setBorder(BorderFactory.createLineBorder(new Color(192,30,37),6));
                }

                @Override
                public void mousePressed(MouseEvent e) 
                {
                    stopButton.setBorder(BorderFactory.createLineBorder(new Color(192,30,37),6));
                }

                @Override
                public void mouseReleased(MouseEvent e) 
                {
                    stopButton.setBorder(BorderFactory.createLineBorder(new Color(192,30,37),6));
                }

                @Override
                public void mouseEntered(MouseEvent e) 
                {
                    stopButton.setBorder(BorderFactory.createLineBorder(new Color(192,30,37),6));
                }

                @Override
                public void mouseExited(MouseEvent e) 
                {
                    stopButton.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),4));
                } 
            }
        );
        stopButton.addActionListener(this);
        stopButton.setBounds(592, 6, 60, 60);

        //Arrows
        eastarrow.setBounds(50, 50, 300, 300);
        
        //Slider
        slider_strength.addChangeListener(new ChangeListener() 
        {
            public void stateChanged(ChangeEvent e) 
            {
                str_control=((JSlider)e.getSource()).getValue();
                HitStrength = str_control/20.0;
            }
        });


        //Slider
        slider_direction.addChangeListener(new ChangeListener() 
        {
            public void stateChanged(ChangeEvent e) 
            {
                drc_control=((JSlider)e.getSource()).getValue();
                Main.xV = Math.cos(drc_control * 3.6 * (Math.PI/180))*HitStrength;
                Main.yV = Math.sin(drc_control * 3.6 * (Math.PI/180))*HitStrength;
            }
        });

        //Label 
        buttonname.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonname.setForeground(new Color(0,0,0));
        buttonname.setBounds(522, 50, 60, 60);

        //Label 
        stopname.setFont(new Font("Arial", Font.PLAIN, 20));
        stopname.setForeground(new Color(0,0,0));
        stopname.setBounds(596, 50, 110, 60);

        //Label 
        strength.setFont(new Font("Arial", Font.PLAIN, 20));
        strength.setForeground(new Color(0,0,0));
        strength.setBounds(30, 7, 110, 30);

        //Label 
        direction.setFont(new Font("Arial", Font.PLAIN, 20));
        direction.setForeground(new Color(0,0,0));
        direction.setBounds(30, 33, 110, 60);

        //Label 
        eastarr.setFont(new Font("Arial", Font.PLAIN, 20));
        eastarr.setForeground(new Color(0,0,0));
        eastarr.setBounds(40, 40, 110, 100);
        
        //Label 
        ballable.setBounds((int)(ImageFile.width/2 + Ball.X*100),(int)(ImageFile.height/2 + Ball.Y*100),50, 50);

        slider_strength.setBounds(130, 4, 350, 50);
        slider_direction.setBounds(130, 47, 350, 50);

        fieldy.setBounds(0, 0, 680, ImageFile.height);
        
        panel_1.add(ballable);
        panel_1.add(complable);
        panel_1.add(fieldy);
        panel_2.add(hitButton);
        panel_2.add(buttonname);
        panel_2.add(stopButton);
        panel_2.add(stopname);
        panel_2.add(slider_strength);
        panel_2.add(slider_direction);
        panel_2.add(strength);
        panel_2.add(direction);
        frame.add(panel_1);
        frame.add(panel_2);
        frame.setVisible(true);
        
    }

    public void UpdateBall(int xPos, int yPos){
        ballable.setBounds(ImageFile.width/2 + xPos, ImageFile.height/2 + yPos, 50, 50);
        System.out.println("update");
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(hitButton)) 
        {
            Main.unlock2();
        }
        else if (e.getSource().equals(stopButton)) 
        {
            frame.dispose();
        }
    }

    public static void moveArrow(double x, double y)
    {
        xPosition += x;
        yPosition += y;
    }

    public static void draw(Graphics2D g2)
    {
        Color b = new Color(51,153,255);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.RED);
        g2.draw(line);
    }

}