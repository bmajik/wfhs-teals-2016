
import java.util.ArrayList;
import java.util.List;


public class BattleSystem {
	//exists because I don't know how to time stuff
	private static long timeTracker;
	public static ArrayList<Spell> spellBook = new ArrayList<Spell>();
	public static void WizardBattleSystem(abstractWizard w1, abstractWizard w2)
	{
		UserInterface testerama = new UserInterface(w1, w2);
		timeTracker = 0;
		//need way of starting fight fairly as neither wizard is on cool down yet
		double start = Math.random(); 
		if (start <.5 ){
			//if random number is in bottom half of what it could be wizard 1 goes first
			String temp = w1.castSpell(w2);
			testerama.ActionBox(temp);
			testerama.update();
			//			testerama.updateRightHealth(w2.getHP());		
			//			testerama.updateRightHealthText(w2.getHP());
		}
		else{
			//if not then wizard 2 goes first
			String temp2 = w2.castSpell(w1);
			testerama.ActionBox(temp2);
			testerama.update();
			
//			testerama.updateLeftHealth(w1.getHP());
//			testerama.updateLeftHealthText(w1.getHP());
		}
		//Start loop here, since both wizards are now on cool down
		//Check health repeatedly 
		while (w1.getHP() > 0 && w2.getHP() > 0)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			 
				System.out.println("Problem, we have a Houston");
			}
			//track time at beginning for cool down purposes
			long timeAtStart = System.currentTimeMillis();
			
			//lower the cool downs by time elapsed from previous loop 
			//yes that makes this loop useless at first loop
			if (w1.getCurrentSpellCooldown() < 0){
				System.out.println("five");
			}
			w1.setCurrentSpellCooldown(w1.getCurrentSpellCooldown() - timeTracker/(long)1000);	
			w2.setCurrentSpellCooldown(w2.getCurrentSpellCooldown() - timeTracker/(long)1000);
			
			//check if wizard 1 can cast a spell
			//if (w1.getCurrentSpellCooldown() <= 0){
				
			//w1.castSpell(w2);
			if (w1.getHP() > 0){
			String temp3 = w1.castSpell(w2);
			testerama.ActionBox(temp3);
			testerama.update();
			}

			//testerama.updateRightHealth(w2.getHP());
			//testerama.updateRightHealthText(w1.getHP());
				
				
			//}
			//check if wizard 2 can cast a spell
			//else if(w2.getCurrentSpellCooldown()<= 0 )
			//{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				 
					System.out.println("Problem, we have a Houston");
				}
				
				//w2.castSpell(w1);
				if (w2.getHP() > 0) {
				String temp4 = w2.castSpell(w1);
				testerama.ActionBox(temp4);
				testerama.update();
				}
				//testerama.updateLeftHealth(w1.getHP());
				//testerama.updateLeftHealthText(w1.getHP());
				//}
				//create a pause in the code to prevent system usage from executing
				//an infinite amount of times while it waits on cool down
				//since it will check repeatedly if a wizard can cast a spell
			
			//track time at end for cool down purposes		
			long timeAtFinish = System.currentTimeMillis();
			
			//figure out elapsed loop time
			timeTracker = timeAtFinish - timeAtStart;
		
			//cool down implementation
		}
		testerama.AnnounceWinner(w1,w2);
		
	/*	if (w1.getHP() < 0){
			w1.setHP(0);
		}
		if (w2.getHP() < 0){
			w2.setHP(0);
		}
		*/
		//this point will only be reached upon a wizard death
//		if (w1.getHP() <= 0)
//		{
//			System.out.println("Congratulations, " +w2.getName()+ " You are Winner");
//			System.out.println("              _,._      ");
//			System.out.println("  .||,       /_ _\\\\     ");
//			System.out.println(" \\.`',/      |'L'| |    ");
//			System.out.println(" = ,. =      | -,| L    ");
//			System.out.println(" / || \\    ,-'\\\"/,'`.   ");
//			System.out.println("   ||     ,'   `,,. `.  ");
//			System.out.println("   ,|____,' , ,;' \\| |  ");
//			System.out.println("  (3|\\    _/|/'   _| |  ");
//			System.out.println("   ||/,-''  | >-'' _,\\\\ ");
//			System.out.println("   ||'      ==\\ ,-'  ,' ");
//			System.out.println("   ||       |  V \\ ,|   ");
//			System.out.println("   ||       |    |` |   ");
//			System.out.println("   ||       |    |   \\  ");
//			System.out.println("   ||       |    \\    \\ ");
//			System.out.println("   ||       |     |    \\");
//			System.out.println("   ||       |      \\_,-'");
//			System.out.println("   ||       |___,,--\")_\\");
//			System.out.println("   ||         |_|   ccc/");
//			System.out.println("   ||        ccc/       ");
//			System.out.println("   ||");
//
//
//
//		}
//		//wizard 2 died if code reaches else
//		else{
//			System.out.println("Conglaturations, " +w1.getName()+ " You are Winner");
//			System.out.println("                    ____");
//			System.out.println("                  .'* *.'");
//			System.out.println("               __/_*_*(_");
//			System.out.println("              / _______ \\");
//			System.out.println("             _\\_)/___\\(_/_");
//			System.out.println("            / _((\\- -/))_ \\");
//			System.out.println("            \\ \\())(-)(()/ /");
//			System.out.println("             ' \\(((()))/ '");
//			System.out.println("            / ' \\)).))/ ' \\");
//			System.out.println("           / _ \\ - | - /_  \\");
//			System.out.println("          (   ( .;''';. .'  )");
//			System.out.println("          _\\\"__ /    )\\ __\"/_");
//			System.out.println("            \\/  \\   ' /  \\/");
//			System.out.println("             .'  '...' ' )");
//			System.out.println("              / /  |  \\ \\");
//			System.out.println("             / .   .   . \\");
//			System.out.println("            /   .     .   \\");
//			System.out.println("           /   /   |   \\   \\");
//			System.out.println("         .'   /    b    '.  '.");
//			System.out.println("     _.-'    /     Bb     '-. '-._");
//			System.out.println(" _.-'       |      BBb       '-.  '-.");
//			System.out.println("(________mrf\\____.dBBBb.________)____)");
//		}
	}

	
	
	
	
}
