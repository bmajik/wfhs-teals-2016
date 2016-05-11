import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class UserInterface {
	private JFrame masterFrame;
	private JPanel container = new JPanel();
	private JPanel wizard1 = new JPanel();
	private JPanel wizard2 = new JPanel();
	private final Font masterFont = new Font("Courier", Font.PLAIN, 12);
	private JProgressBar leftHealth = new JProgressBar();
	private JProgressBar rightHealth = new JProgressBar();
	private GridBagConstraints layoutManager = new GridBagConstraints();
	
	
	
	private JPanel healthBarContainerLeft()
	{
		 JPanel health1 = new JPanel();
		 
		
		health1.setBackground(Color.red);
		health1.setAlignmentX(Component.LEFT_ALIGNMENT);
		return health1;
	}
	private JPanel healthBarContainerRight(){
		JPanel health2 = new JPanel();
		
		
		health2.setBackground(Color.blue);
		health2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		return health2;
	}
	private JPanel bottomHalf(){
		JPanel bottomHalf = new JPanel();
		bottomHalf.setBackground(Color.white);
		
		bottomHalf.setBorder(BorderFactory.createLineBorder(Color.black));
		return bottomHalf;
	}
public UserInterface(abstractWizard w1, abstractWizard w2)
{
	JLabel Health = new JLabel("Health:" + w1.getHP());
	JLabel Health2 = new JLabel("Health:"+ w2.getHP());
	Container pane = new Container();
	
	pane.setLayout(new GridBagLayout());
	
	layoutManager.fill = GridBagConstraints.HORIZONTAL;
	layoutManager.gridx = 0;
	layoutManager.gridy = 0;
	layoutManager.weightx = .5;
	layoutManager.weighty = .5;		
	pane.add(Health, layoutManager);
	
	layoutManager.gridx++;
	Health2.setAlignmentX(Component.RIGHT_ALIGNMENT);
	pane.add(Health2, layoutManager);
	
	layoutManager.gridy++;
	layoutManager.gridx--;
	layoutManager.insets = new Insets(0,0,0,10);
	pane.add(healthBarContainerLeft(), layoutManager);
	
	layoutManager.gridx++;
	layoutManager.insets = new Insets(0,10,0,0);
	pane.add(healthBarContainerRight(), layoutManager);
	
	wizard1.add(leftWizard(w1.getName()));
	wizard2.add(rightWizard(w2.getName()));
	wizard1.setBackground(Color.white);
	wizard2.setBackground(Color.white);
	
	layoutManager.insets = new Insets(0,0,0,0);	
	layoutManager.fill = GridBagConstraints.BOTH;
	layoutManager.gridy++;
	layoutManager.gridx--;	
	layoutManager.anchor = GridBagConstraints.BASELINE_LEADING;
	pane.add(wizard1, layoutManager);
	
	
	layoutManager.gridx++;
	layoutManager.anchor = GridBagConstraints.BASELINE_TRAILING;
	pane.add(wizard2, layoutManager);
	
	layoutManager.gridy++;
	layoutManager.gridx--;
	layoutManager.gridwidth = 2;	
	pane.add(bottomHalf(), layoutManager);
	
	
	masterFrame = new JFrame();
	masterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	masterFrame.setLayout((new BorderLayout()));
	masterFrame.setSize(1000,700);	
	masterFrame.add(pane);
	masterFrame.setVisible(true);
	
	masterFrame.getContentPane().setBackground(Color.yellow);
}

public JTextArea leftWizard(String name){
	JTextArea wizard2 = new JTextArea();
	
	
	
wizard2.setFont(masterFont);
	
	

	wizard2.setText(name + 
				   "\n                    ____");
	wizard2.append("\n                  .'* *.'");
	wizard2.append("\n               __/_*_*(_");
	wizard2.append("\n              / _______ \\");
	wizard2.append("\n             _\\_)/___\\(_/_");
	wizard2.append("\n            / _((\\- -/))_ \\");
	wizard2.append("\n            \\ \\())(-)(()/ /");
	wizard2.append("\n             ' \\(((()))/ '");
	wizard2.append("\n            / ' \\)).))/ ' \\");
	wizard2.append("\n           / _ \\ - | - /_  \\");
	wizard2.append("\n          (   ( .;''';. .'  )");
	wizard2.append("\n          _\\\"__ /    )\\ __\"/_");
	wizard2.append("\n            \\/  \\   ' /  \\/");
	wizard2.append("\n             .'  '...' ' )");
	wizard2.append("\n              / /  |  \\ \\");
	wizard2.append("\n             / .   .   . \\");
	wizard2.append("\n            /   .     .   \\");
	wizard2.append("\n           /   /   |   \\   \\");
	wizard2.append("\n         .'   /    b    '.  '.");
	wizard2.append("\n     _.-'    /     Bb     '-. '-._");
	wizard2.append("\n _.-'       |      BBb       '-.  '-.");



	return wizard2;
}
public JTextArea rightWizard(String name){
	JTextArea wizard1 = new JTextArea();
	
	
	wizard1.setFont(masterFont);
	wizard1.append(name +
				   "\n\n                 _,._      ");
	wizard1.append("\n     .||,       /_ _\\\\     ");
	wizard1.append("\n    \\.`',/      |'L'| |    ");
	wizard1.append("\n    = ,. =      | -,| L    ");
	wizard1.append("\n    / || \\    ,-'\\\"/,'`.   ");
	wizard1.append("\n      ||     ,'   `,,. `.  ");
	wizard1.append("\n      ,|____,' , ,;' \\| |  ");
	wizard1.append("\n     (3|\\    _/|/'   _| |  ");
	wizard1.append("\n      ||/,-''  | >-'' _,\\\\ ");
	wizard1.append("\n      ||'      ==\\ ,-'  ,' ");
	wizard1.append("\n      ||       |  V \\ ,|   ");
	wizard1.append("\n      ||       |    |` |   ");
	wizard1.append("\n      ||       |    |   \\  ");
	wizard1.append("\n      ||       |    \\    \\ ");
	wizard1.append("\n      ||       |     |    \\");
	wizard1.append("\n      ||       |      \\_,-'");
	wizard1.append("\n      ||       |___,,--\")_\\");
	wizard1.append("\n      ||         |_|   ccc/");
	wizard1.append("\n      ||        ccc/       ");
	wizard1.append("\n      ||");
	

	return wizard1;
}
}