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
		}
		else{
			//if not then wizard 2 goes first
			String temp2 = w2.castSpell(w1);
			testerama.ActionBox(temp2);
			testerama.update();
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
	}
}
