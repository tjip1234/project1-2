import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.Border;
import javax.swing.JPanel; 
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class golfApp extends JFrame implements ActionListener
{
    private JFrame frame;
    JButton startButton;
    JButton configButton;
    public static golfApp2 golfing;
    Image img = Toolkit.getDefaultToolkit().getImage("res/golf.png");
    Image dcl = Toolkit.getDefaultToolkit().getImage("res/dcl.png");
    public static int y1 = 5;
    public static int x2 = 505;
    public static int y2 = 300;
    
    public golfApp() 
    {
        setTitle("Welcome Window");
        setLayout( null );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.BOLD, 30));
        configButton = new JButton("Config");
        configButton.setFont(new Font("Arial", Font.BOLD, 30));
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
                g.drawImage(dcl, 60, 35, this);
                setBackground(new Color(185,227,228));
                //g.drawImage(img, 0, -10, null);
                // declaration.setBounds(60, 2, 300, 50);
                // add(declaration);
                startButton.setBorder(border);
                startButton.setBackground(new Color(140,199,62));
                startButton.setOpaque(true);
                startButton.addMouseListener
                (
                    new MouseListener()
                    {
                        @Override
                        public void mouseClicked(MouseEvent e) 
                        {
                            startButton.setForeground(new Color(239,79,53));   
                        }

                        @Override
                        public void mousePressed(MouseEvent e) 
                        {
                            startButton.setForeground(new Color(239,79,53));  
                        }
                        @Override
                        public void mouseReleased(MouseEvent e) 
                        {
                            startButton.setForeground(new Color(239,79,53));    
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) 
                        {
                            startButton.setForeground(new Color(239,79,53)); 
                        }

                        @Override
                        public void mouseExited(MouseEvent e) 
                        {
                            startButton.setForeground(new Color(0,0,0));  
                        } 
                    }
                );
                startButton.setBounds(80, 190, 120, 60);
                add(startButton);

                
                configButton.setBorder(border);
                configButton.setBackground(new Color(140,199,62));
                configButton.setOpaque(true);
                configButton.addMouseListener
                (
                    new MouseListener()
                    {
                        @Override
                        public void mouseClicked(MouseEvent e) 
                        {
                            configButton.setForeground(new Color(239,79,53));   
                        }

                        @Override
                        public void mousePressed(MouseEvent e) 
                        {
                            configButton.setForeground(new Color(239,79,53));  
                        }
                        @Override
                        public void mouseReleased(MouseEvent e) 
                        {
                            configButton.setForeground(new Color(239,79,53));    
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) 
                        {
                            configButton.setForeground(new Color(239,79,53)); 
                        }

                        @Override
                        public void mouseExited(MouseEvent e) 
                        {
                            configButton.setForeground(new Color(0,0,0));  
                        } 
                    }
                );
                configButton.setBounds(80, 260, 120, 60);
                add(configButton);
               

            }
            protected void paintBorder(Graphics g) 
            {
                g.setColor(new Color(197,41,48));

            }
        });


        startButton.addActionListener(this);
        configButton.addActionListener(this);
        setBounds(800,300,385,380);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(startButton)) {
            this.dispose();
            new golfApp3();
            
            
        }
        else if(e.getSource().equals(configButton)){
            this.dispose();
            System.exit(0);
        }
    }

    public static void main(String[] args) throws Exception
    {
        new golfApp();
    }  
}
