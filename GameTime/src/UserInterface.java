import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.text.DefaultCaret;

public class UserInterface {

	private abstractWizard leftWizard = null;
	private abstractWizard rightWizard = null;
	private Container pane = new Container();
	private JFrame masterFrame;
	private JPanel container = new JPanel();
	private JPanel wizard1 = new JPanel();
	private JPanel wizard2 = new JPanel();
	private final Font masterFont = new Font("Courier", Font.PLAIN, 12);
	private JProgressBar leftHealth = new JProgressBar();
	private JProgressBar rightHealth = new RightToLeftProgressBar();
	private GridBagConstraints layoutManager = new GridBagConstraints();
	private JLabel leftHealthText = new JLabel();
	private JLabel rightHealthText = new JLabel();
	private JLabel leftIntellectText = new JLabel();
	private JLabel rightIntellectText = new JLabel();
	private JLabel leftAttunementText = new JLabel();
	private JLabel rightAttunementText = new JLabel();
	private JScrollPane BottomPanel = new JScrollPane();
	private JTextArea BottomHalf = new JTextArea(5, 30);
    JFrame f;
    JTextArea ta;
    JScrollPane scrolltxt;
	public void update() {
		updateLeftHealth(leftWizard.getHP());
		updateLeftHealthText(leftWizard.getHP());
		updateRightHealth(rightWizard.getHP());
		updateRightHealthText(rightWizard.getHP());
		
	}
	public void updateLeftHealth(int currentHealthPercent){		
		leftHealth.setValue(currentHealthPercent);
		leftHealth.revalidate();
		leftHealth.repaint();
	}

	public void updateRightHealth(int currentHealthPercent){
		rightHealth.setValue(currentHealthPercent);
		rightHealth.revalidate();
		rightHealth.repaint();
	}

	public void updateLeftHealthText(int health){
		leftHealthText.setText("Health:" + health);
	}

	public void updateRightHealthText(int health){
		rightHealthText.setText("Health:" + health);
	}
	private void healthBarContainerLeft()
	{		 		 	
		leftHealth.setBackground(Color.red);
		leftHealth.setAlignmentX(Component.LEFT_ALIGNMENT);
	}

	private void healthBarContainerRight(){
		rightHealth.setBackground(Color.blue);
		rightHealth.setAlignmentX(Component.RIGHT_ALIGNMENT);
	}
	ArrayList<String> StoringInfo = new ArrayList<String>();
	int counterX = 0;
	
	
	// Moving Text from the console and putting it into the bottom box
	// Allows the battling to be read
	public JTextArea ActionBox(String temp){
		
		// Because the Amount of strings we want to pass in keeps going up,
		// this was the easiest way i could implement an ever changing variable
		StoringInfo.add(temp);
		
		while (counterX < StoringInfo.size()){
			BottomHalf.append(StoringInfo.get(counterX));
			if (StoringInfo.get(counterX) != null){
			BottomHalf.append("\n");
			}
			counterX++;
		}
		return BottomHalf;	
	}
	public JTextArea AnnounceWinner (abstractWizard x, abstractWizard y){
		if (x.getHP() < 1){
			BottomHalf.append("Wizard " + y.getName() + " is the Winner of this battle!");
		}
		if (y.getHP() < 1){
			BottomHalf.append("Wizard " + x.getName() + " is the Winner of this battle!");
		}
		return BottomHalf;
		
	}
	public UserInterface(abstractWizard w1, abstractWizard w2)
	{
		BottomHalf.setBackground(Color.white);		
		BottomHalf.setBorder(BorderFactory.createLineBorder(Color.black));
		
		leftWizard = w1;
		rightWizard = w2;
		
		rightHealth.setStringPainted(true);
		rightHealth.setForeground(Color.green);
		
		leftHealth.setStringPainted(true);
		leftHealth.setForeground(Color.green);
		
		rightHealth.setMinimum(0);
		leftHealth.setMinimum(0);
	
		leftHealthText.setText("Health:"+ leftWizard.getHP());
		rightHealthText.setText("Health:"+ rightWizard.getHP());
		leftIntellectText.setText("Intellect" + leftWizard.getIntellect());
		rightIntellectText.setText("Intellect" + leftWizard.getIntellect());
		leftAttunementText.setText("Attunement" + leftWizard.getAttunement());
		rightAttunementText.setText("Attunement" + leftWizard.getAttunement());
		
		
		leftHealth.setMaximum(leftWizard.getHP());
		leftHealth.setValue(leftWizard.getHP());
		rightHealth.setMaximum(rightWizard.getHP());	
		rightHealth.setValue(rightWizard.getHP());
		
		pane.setLayout(new GridBagLayout());
		
		layoutManager.fill = GridBagConstraints.HORIZONTAL;
		layoutManager.gridx = 0;
		layoutManager.gridy = 0;
		layoutManager.weightx = .5;
		layoutManager.weighty = .5;		
		pane.add(leftHealthText, layoutManager);
		
		layoutManager.gridx++;
		pane.add(leftIntellectText, layoutManager);
		
		layoutManager.gridx++;
		pane.add(leftAttunementText, layoutManager);
		
		
		
		
		layoutManager.gridx++;
		rightHealthText.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pane.add(rightHealthText, layoutManager);
		
		layoutManager.gridx++;
		pane.add(rightIntellectText, layoutManager);
		
		layoutManager.gridx++;
		pane.add(rightAttunementText, layoutManager);
		
		
		layoutManager.gridy++;
		layoutManager.gridx= 0;
		layoutManager.insets = new Insets(0,0,0,10);
		layoutManager.gridwidth = 3;
		pane.add(leftHealth, layoutManager);
		
		layoutManager.gridx = 3;
		layoutManager.insets = new Insets(0,10,0,0);
		pane.add(rightHealth, layoutManager);
		
		wizard1.add(leftWizard(leftWizard.getName()));
		wizard2.add(rightWizard(rightWizard.getName()));
		wizard1.setBackground(Color.white);
		wizard2.setBackground(Color.white);
		BottomPanel.setBounds(new Rectangle (500, 200));
		BottomPanel.add(BottomHalf);
		
		
		layoutManager.insets = new Insets(0,0,0,0);	
		layoutManager.fill = GridBagConstraints.BOTH;
		layoutManager.gridy++;
		layoutManager.gridx = 0 ;	
		layoutManager.anchor = GridBagConstraints.BASELINE_LEADING;
		pane.add(wizard1, layoutManager);
		
		
		layoutManager.gridx = 3;
		layoutManager.weightx = 1.965;
		layoutManager.anchor = GridBagConstraints.BASELINE_TRAILING;
		pane.add(wizard2, layoutManager);
		
		layoutManager.gridy++;
		layoutManager.gridx= 0;
		layoutManager.gridwidth = 6;	
		
		DefaultCaret autoScroller = (DefaultCaret)BottomHalf.getCaret();
		autoScroller.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		 pane.setVisible(true);
		    pane.setSize(500,500);
		    BottomHalf.setBounds(5,5,100,200);
		    scrolltxt=new JScrollPane(BottomHalf);
		    scrolltxt.setAutoscrolls(true);
		    scrolltxt.setBounds(3,3,885,125);
		    pane.add(scrolltxt, layoutManager);
		
		masterFrame = new JFrame();
		masterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		masterFrame.setLayout((new BorderLayout()));
		CreateScrollBox();
		masterFrame.setSize(900,700);	
		AddScroll(BottomHalf, masterFrame);
		masterFrame.add(pane);
		
		
		masterFrame.setVisible(true);
		
		masterFrame.getContentPane().setBackground(Color.yellow);
		
	}
	public void AddScroll(JTextArea x, JFrame o) {
	    
		
	}
	public void CreateScrollBox () {
		   

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
		if (name == "Dragon"){
			wizard1.setFont(masterFont);
			wizard1.append(name +
						   "\n\n                       ");
			wizard1.append("\n                         ______________");
	        wizard1.append("\n                   ,===:'.,            `-._");
	        wizard1.append("\n                        `:.`---.__         `-._");
	        wizard1.append("\n                          `:.     `--.         `.");
	        wizard1.append("\n                            \\.        `.         `.");
	        wizard1.append("\n                     (,,(,    \\.         `.   ____,-`.,");
	    	wizard1.append("\n                   (,'     `/   \\.   ,--.___`.'");
	        wizard1.append("\n             ,  ,'  ,--.  `,   \\.;'         `");
	        wizard1.append("\n              `{D, {    \\  :    \\;");
	        wizard1.append("\n                V,,'    /  /    //");
	        wizard1.append("\n                j;;    /  ,' ,-//.    ,---.      ,");
	        wizard1.append("\n                \\;'   /  ,' /  _  \\  /  _  \\   ,'/");
	        wizard1.append("\n                     \\   `'  / \\  `'  / \\  `.' /");
	        wizard1.append("\n                      `.___,'   `.__,'   `.__,' ");
			}
			 else{
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
			 }
		return wizard1;
	}
}
