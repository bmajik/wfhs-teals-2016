import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JProgressBar;


public class RightToLeftProgressBar extends JProgressBar {
	@Override
	protected void paintComponent(Graphics g) {
		  Graphics2D g2d = (Graphics2D) g;
		  g2d.scale(-1, 1); //Flips over y-axis
		  g2d.translate(-getWidth(), 0); //Moves back to old position.
		  super.paintComponent(g2d);
		}
}
