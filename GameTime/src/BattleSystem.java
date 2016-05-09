
import java.util.ArrayList;
import java.util.List;


public class BattleSystem {
	//exists because I don't know how to time stuff
	private static long timeTracker;
	public static ArrayList<Spell> spellBook = new ArrayList<Spell>();
	public static void WizardBattleSystem(abstractWizard w1, abstractWizard w2)
	{
		timeTracker = 0;
		//need way of starting fight fairly as neither wizard is on cooldown yet
		double start = Math.random(); 
		if (start <.5 ){
			//if random number is in bottom half of what it could be wizard 1 goes first
			w1.castSpell(w2);
		}
		else{
			//if not then wizard 2 goes first
			w2.castSpell(w1);
		}
		//Start loop here, since both wizards are now on cooldown
		//Check health repeatedly 
		while (w1.getHP() > 0 && w2.getHP() > 0)
		{
			//track time at beginning for cooldown purposes
			long timeAtStart = System.currentTimeMillis();
			//lower the cooldowns by time elapsed from previous loop 
			//yes that makes this loop useless at first loop
			w1.setCurrentSpellCooldown(w1.getCurrentSpellCooldown() - timeTracker/(long)1000);
			//divide by 1000 to convert from milliseconds to actual seconds
			w2.setCurrentSpellCooldown(w2.getCurrentSpellCooldown() - timeTracker/(long)1000);
			//check if wizard 1 can cast a spell
			if (w1.getCurrentSpellCooldown() <= 0){
				w1.castSpell(w2);
			}
			//check if wizard 2 can cast a spell
			else if(w2.getCurrentSpellCooldown()<= 0 )
			{
				w2.castSpell(w1);
			}
			else{
				//create a pause in the code to prevent system usage from executing
				//an infinite amount of times while it waits on cooldown
				//since it will check repeatedly if a wizard can cast a spell
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				 
					System.out.println("Problem, we have a Houston");
				}
			}
			//track time at end for cooldown purposes
			long timeAtFinish = System.currentTimeMillis();
			//figure out elapsed loop time
			timeTracker = timeAtFinish - timeAtStart;
			
			
			
			
			
			
			
			
			
			//cooldown implementation
		}
		//this point will only be reached upon a wizard death
		if (w1.getHP() <= 0)
		{
			System.out.println("Conglaturations, " +w2.getName()+ " You are Winner");
			System.out.println("              _,._      ");
			System.out.println("  .||,       /_ _\\\\     ");
			System.out.println(" \\.`',/      |'L'| |    ");
			System.out.println(" = ,. =      | -,| L    ");
			System.out.println(" / || \\    ,-'\\\"/,'`.   ");
			System.out.println("   ||     ,'   `,,. `.  ");
			System.out.println("   ,|____,' , ,;' \\| |  ");
			System.out.println("  (3|\\    _/|/'   _| |  ");
			System.out.println("   ||/,-''  | >-'' _,\\\\ ");
			System.out.println("   ||'      ==\\ ,-'  ,' ");
			System.out.println("   ||       |  V \\ ,|   ");
			System.out.println("   ||       |    |` |   ");
			System.out.println("   ||       |    |   \\  ");
			System.out.println("   ||       |    \\    \\ ");
			System.out.println("   ||       |     |    \\");
			System.out.println("   ||       |      \\_,-'");
			System.out.println("   ||       |___,,--\")_\\");
			System.out.println("   ||         |_|   ccc/");
			System.out.println("   ||        ccc/       ");
			System.out.println("   ||");



		}
		//wizard 2 died if code reaches else
		else{
			System.out.println("Conglaturations, " +w1.getName()+ " You are Winner");
			System.out.println("                    ____");
			System.out.println("                  .'* *.'");
			System.out.println("               __/_*_*(_");
			System.out.println("              / _______ \\");
			System.out.println("             _\\_)/___\\(_/_");
			System.out.println("            / _((\\- -/))_ \\");
			System.out.println("            \\ \\())(-)(()/ /");
			System.out.println("             ' \\(((()))/ '");
			System.out.println("            / ' \\)).))/ ' \\");
			System.out.println("           / _ \\ - | - /_  \\");
			System.out.println("          (   ( .;''';. .'  )");
			System.out.println("          _\\\"__ /    )\\ __\"/_");
			System.out.println("            \\/  \\   ' /  \\/");
			System.out.println("             .'  '...' ' )");
			System.out.println("              / /  |  \\ \\");
			System.out.println("             / .   .   . \\");
			System.out.println("            /   .     .   \\");
			System.out.println("           /   /   |   \\   \\");
			System.out.println("         .'   /    b    '.  '.");
			System.out.println("     _.-'    /     Bb     '-. '-._");
			System.out.println(" _.-'       |      BBb       '-.  '-.");
			System.out.println("(________mrf\\____.dBBBb.________)____)");
		}
	}

	
	
	
	
}
