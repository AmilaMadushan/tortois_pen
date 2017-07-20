import java.awt.Toolkit;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
            JFrame frame = new JFrame("Tortoise");
            
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                              JOptionPane.showMessageDialog(null, "Enter the number of tortoises in the text field");
				frame.setContentPane(new CollisionNBounce(1366, 768));
                                frame.setFocusable(true);
                                frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/4cbogBMoi.jpg")));
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}
