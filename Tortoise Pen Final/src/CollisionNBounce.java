import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CollisionNBounce extends JPanel {
	List<Tortoise> ballsL = new ArrayList<Tortoise>();
        String[] colourlist={"Green","Rosybrown","YellowGreen","Maroon"};
	private PenField penField;
	private DrawCanvas canvas;
	private int canvasWidth;
	private int canvasHeight;
        Color colour=Color.WHITE;
        String selectedcolour;
        Color tortoisecolour=Color.GREEN;

	public CollisionNBounce(int width, int height) {
		canvasWidth = width;
		canvasHeight = height;
		
		
		

		penField = PenField.getInstance().setvalues(0, 0, canvasWidth, canvasHeight, colour, Color.WHITE);

		canvas = new DrawCanvas();

		this.setLayout(new BorderLayout());
		this.add(canvas, BorderLayout.CENTER);
		// Handling window resize. Adjust container box to fill the screen.
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Component c = (Component) e.getSource();
				Dimension dim = c.getSize();
				penField.set(0, 0, dim.width, dim.height);
			}
		});
		// Start the Tortoise bouncing
		gameStart();
	}

	/** Start the Tortoise bouncing. */
	public void gameStart() {
		Thread gameThread = new Thread() {
			public void run() {
				while (true) {
					gameUpdate();
					repaint();
					// Delay and give other thread a chance
					try {
						Thread.sleep(50);
					} catch (InterruptedException ex) {
					}
				}
			}
		};
		gameThread.start(); // Invoke GaemThread.run()
	}

	/**
	 * detects collision, bounces, calculate final velocities
	 * 
	 * @param isStriker
	 */
	public void gameUpdate() {
		// Check collision between the Tortoises and the box
		for (int i = 0; i < ballsL.size(); i++) {
			PhysicsUtils.collisionWithWall(new Rectangle(penField.minX, penField.minY, penField.maxX, penField.maxY), ballsL.get(i));
		}
		// Check collision between two Tortoises
		for (int i = 0; i < ballsL.size(); i++) {
			for (int j = 0; j < ballsL.size(); j++) {
				if (i < j) {
					PhysicsUtils.intersect(ballsL.get(i), ballsL.get(j),683,384);
				}
			}
		}
		// update positions increments
		for (int i = 0; i < ballsL.size(); i++) {
			ballsL.get(i).update(1,i);
                        
		}
	}

	/** The custom drawing panel for the bouncing Tortoise (inner class). */
class  DrawCanvas extends JPanel implements ActionListener{
            //Declaring the components to the jpanel
    JTextField text_field;
    JButton input_button;
    JLabel label_text;
    JRadioButton background1;
    JRadioButton background2;
    JRadioButton background3;
    JRadioButton background4;
    JComboBox colourchooser;
        DrawCanvas() {
            

        input_button=new JButton("Enter");
    //Inetializing the Components
    text_field=new JTextField(8);
    label_text=new JLabel("Enter number");
    background1=new JRadioButton("Grass");
    background2=new JRadioButton("Mud");
    background3=new JRadioButton("Stone");
    background4=new JRadioButton("Dry");
    colourchooser=new JComboBox(colourlist);
        ButtonGroup Group_buttons = new ButtonGroup();
        Group_buttons.add(background1);
        Group_buttons.add(background2);
        Group_buttons.add(background3);
        Group_buttons.add(background4);
           //action listerners for buttons and components
    input_button.addActionListener((ActionListener) this);
      
    background1.addActionListener((ActionListener) this);
    background2.addActionListener((ActionListener) this);
    background3.addActionListener((ActionListener) this);
    background4.addActionListener((ActionListener) this);
    colourchooser.addActionListener(this);
    //validating the text field to enter number only
    text_field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c=e.getKeyChar();
                 if(!(c>='0' && c<='9')){
                e.consume();
                //JOptionPane.showMessageDialog(null,"Please enter a number");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    
    add(label_text);
    add(text_field);
    add(input_button);
    add(background1);
    add(background2);
    add(background3);
    add(background4);
    add(colourchooser);
    
        }
        
        
    
    
    
		@Override
		public void paintComponent(Graphics g) {
			// Draw the Tortoises and field
			penField.draw(g);
			for (Tortoise ball : ballsL) {
				ball.draw(g);
                                ball.draw1(g);
                                ball.draw2(g);
                                ball.draw3(g);
                                 ball.draw4(g);
                                  ball.draw5(g);
                                  
			}
		}

		@Override
		public Dimension getPreferredSize() {
			return (new Dimension(canvasWidth, canvasHeight));
		}

                
   
                
        @Override
        public void actionPerformed(ActionEvent e) {
                 
    if(e.getSource()==background1){
        
   Color c=new Color(124,252,0);
   colour=c;
    penField=PenField.getInstance().setvalues(0, 0, canvasWidth, canvasHeight, colour, Color.WHITE);
   // penField = new PenField(0, 0, canvasWidth, canvasHeight, colour, Color.WHITE);
    
    }
     if(e.getSource()==background2){
      Color c=new Color(139,69,19);
    colour=c;
  penField=PenField.getInstance().setvalues(0, 0, canvasWidth, canvasHeight, colour, Color.WHITE);
    
    }
      if(e.getSource()==background3){
   
     Color c=new Color(112,128,144);
    colour=c;
   penField=PenField.getInstance().setvalues(0, 0, canvasWidth, canvasHeight, colour, Color.WHITE);
    
    }
      if(e.getSource()==background4){
   
   Color c=new Color(255,127,80);
    colour=c;
   penField=PenField.getInstance().setvalues(0, 0, canvasWidth, canvasHeight, colour, Color.WHITE);
    }
      if(e.getSource()==input_button){
          // adding new tortoices.
          int count=Integer.parseInt(text_field.getText().toString());
          
          for(int i=0;i<count;i++){
              try {
                  Thread.sleep(100);
              } catch (InterruptedException ex) {
                  Logger.getLogger(CollisionNBounce.class.getName()).log(Level.SEVERE, null, ex);
              }
          ballsL.add(new Tortoise(683, 350, 25, (i/2)+1, (i*50), tortoisecolour));
          System.out.println("Add tortoise");
          
          }
          
       }
      selectedcolour=(String) colourchooser.getSelectedItem();
    if(selectedcolour.equals("Green")){
        tortoisecolour=Color.GREEN;
        
        System.out.println("Green");
    
    }
     else if(selectedcolour.equals("Rosybrown")){
        tortoisecolour=new Color(188,143,143);
         System.out.println("Rosy Brown");
    
    
    }
    else if(selectedcolour.equals("YellowGreen")){
        tortoisecolour=new Color(154,205,50);
        
     System.out.println("Tan");
    
    }
    else if(selectedcolour.equals("Maroon")){
        tortoisecolour=new Color(128,0,0);
         System.out.println("maroon");
    
    
    }
       
        }

        //@Override
              

       

        
	}
}
