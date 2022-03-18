import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.Border;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class golfApp3 extends JFrame implements ActionListener
{
    private JFrame frame;
    JButton submitButton;
    JRadioButton eulerButton;
    JRadioButton simplButton;
    JRadioButton rkButton;
    JRadioButton rkButton2;
    ButtonGroup G1;
    public static golfApp2 golfing;
    Image img = Toolkit.getDefaultToolkit().getImage("res/golf.png");
    //Image dcl = Toolkit.getDefaultToolkit().getImage("/Users/vantsevvictor/Downloads/Project 1-2/Golf/res/dcl.png");
    public static int y1 = 5;
    public static int x2 = 505;
    public static int y2 = 300;
    
    public golfApp3() 
    {
        setTitle("Welcome Window");
        setLayout( null );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 30));

        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));

        // Initialization of object of "JRadioButton" class.
        eulerButton = new JRadioButton();
        // Initialization of object of "JRadioButton" class.
        simplButton = new JRadioButton();
        // Initialization of object of "JRadioButton" class.
        rkButton = new JRadioButton();
        // Initialization of object of "JRadioButton" class.
        rkButton2 = new JRadioButton();
        // Initialization of object of "ButtonGroup" class.
        G1 = new ButtonGroup();
  
  
        // JLabel declaration = new JLabel("GOLF");
        // declaration.setFont(new Font("Arial", Font.BOLD, 30));
        Border border = BorderFactory.createLineBorder(new Color(0,0,0), 4);
        // g.drawImage(img, 120, 100, this);
        setContentPane(new JPanel() 
        {   
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, this);
                //g.drawImage(dcl, 60, 35, this);
                setBackground(new Color(185,227,228));
                //g.drawImage(img, 0, -10, null);
                // declaration.setBounds(60, 2, 300, 50);
                // add(declaration);
                eulerButton.setText("Euler Method");
                simplButton.setText("Semi-Implicit Euler’s Method");
                rkButton.setText("Runge Kutta");
                rkButton2.setText("Runge Kutta 2");
                
                eulerButton.setBounds(10, 0, 120, 50);
                simplButton.setBounds(10, 31, 250, 50);
                rkButton.setBounds(10, 61, 120, 50);
                rkButton2.setBounds(10, 91, 120, 50);

                submitButton.setBorder(border);
                submitButton.setBackground(new Color(140,199,62));
                submitButton.setOpaque(true);
                submitButton.addMouseListener
                (
                    new MouseListener()
                    {
                        @Override
                        public void mouseClicked(MouseEvent e) 
                        {
                            submitButton.setForeground(new Color(239,79,53));   
                        }

                        @Override
                        public void mousePressed(MouseEvent e) 
                        {
                            submitButton.setForeground(new Color(239,79,53));  
                        }
                        @Override
                        public void mouseReleased(MouseEvent e) 
                        {
                            submitButton.setForeground(new Color(239,79,53));    
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) 
                        {
                            submitButton.setForeground(new Color(239,79,53)); 
                        }

                        @Override
                        public void mouseExited(MouseEvent e) 
                        {
                            submitButton.setForeground(new Color(0,0,0));  
                        } 
                    }
                );
                submitButton.setBounds(80, 205, 120, 60);
                add(submitButton);
                G1.add(eulerButton);
                G1.add(simplButton);
                G1.add(rkButton);
                G1.add(rkButton2);
                add(eulerButton);
                add(simplButton);
                add(rkButton);
                add(rkButton2);
            }
            protected void paintBorder(Graphics g) 
            {
                g.setColor(new Color(197,41,48));

            }

            
        });


        submitButton.addActionListener(this);
        setBounds(430,200,385,351);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
        if (eulerButton.isSelected())
        {
            if (e.getSource().equals(submitButton))
            {
                this.dispose();
                Main.EngineChoice = 0;
                golfing = new golfApp2();
            }  
        }
        else if (simplButton.isSelected())
        {
            if (e.getSource().equals(submitButton))
            {
                this.dispose();
                Main.EngineChoice = 1;
                golfing = new golfApp2();
            }  
        }
        else if (rkButton.isSelected())
        {
            if (e.getSource().equals(submitButton))
            {
                this.dispose();
                Main.EngineChoice = 2;
                golfing = new golfApp2();
            }  
        }
        else if (rkButton2.isSelected())
        {
            if (e.getSource().equals(submitButton))
            {
                this.dispose();
                Main.EngineChoice = 3;
                golfing = new golfApp2();
            }  
        }
    }

    public static void main(String[] args) throws Exception
    {
        
    }  
}

