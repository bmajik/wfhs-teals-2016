import java.util.ArrayList;
public class BattleSystem {
	//exists because I don't know how to time stuff
	private static long timeTracker;
	public static ArrayList<Spell> spellBook = new ArrayList<Spell>();
	public void WizardBattleSystem(abstractWizard w1, abstractWizard w2)
	{
		UserInterface testerama = new UserInterface(w1, w2);
		timeTracker = 0;
		//need way of starting fight fairly as neither wizard is on cool down yet
		double start = Math.random(); 
		if (start <.5 ){
			//if random number is in bottom half of what it could be wizard 1 goes first
			String temp = castSpell(w1,w2);
			testerama.ActionBox(temp);
			testerama.update();
		}
		else{
			//if not then wizard 2 goes first
			String temp2 = castSpell(w2,w1);
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
				String temp3 = castSpell(w1,w2);
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
				String temp4 = castSpell(w2,w1);
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
	
	public String castSpell(abstractWizard wCaster, abstractWizard wRecieve){
		// NEED TO IMPLEMENT check for disarmed or other inhibitors
		
		if (!wCaster.getCastAbility())
		{
			//they can't cast a spell if they are disarmed
			System.out.println(wCaster.getName() + " is disarmed, they cannot cast a spell");
			//TEMPORARY, ONLY TO TEST WITHOUT FIXING DISARM
			wCaster.setCastAbility(true);
			return wCaster.getName() + " is disarmed, they cannot cast a spell";
		}
		
		Spell chosenSpell = wCaster.chooseSpell();
		
		//set value of current spells cool down for use in BattleSystem
		wCaster.setCurrentSpellCooldown(chosenSpell.getCoolDown()); 
		System.out.println(wCaster.getName() +" casts "+ chosenSpell.getName());
		//check if spell is targeting self
		if (chosenSpell.getSelfTargeting()){
			//check for protective spell
			if (chosenSpell.getProtecter()){
				System.out.println(wCaster.getName() + " is now warded");
				wCaster.setWarded(true);
				return wCaster.getName() +" casts "+ chosenSpell.getName() + "\n" + wCaster.getName() + " is now warded";
			}
			//assuming that if it isn't a ward it heals the wizard 
			//Will be changed if more self-targeting spells are implemented
			
			else{
				//May need to be changed, 
				//regenerates HP based on Spell and Intellect
				
				int healingAmount = chosenSpell.getHealer()*wCaster.getIntellect();
								
				if(wCaster.getHP() + healingAmount > wCaster.getHP())
				{
					healingAmount = wCaster.GetMaxHP() - wCaster.getHP();
					wCaster.RestoreAllHeatlh();
				}
				else{
					wCaster.setHP(wCaster.getHP() + healingAmount);
				}
					
				System.out.println(wCaster.getName() + " healed for " + healingAmount + " health" );
				return wCaster.getName() +" casts "+ chosenSpell.getName() + "\n" + wCaster.getName() + " healed for " + healingAmount + " health" ;
			}
			
		}
		else if (wRecieve.getWarded()){
			System.out.println(chosenSpell.getName() + " was blocked");			
			wRecieve.setWarded(false);
			return wCaster.getName() +" casts "+ chosenSpell.getName() + "\n" + chosenSpell.getName() + " was blocked";
		}
		//This code exists under the assumption that disarm does nothing but disarm
		else if (chosenSpell.getDisarm())
		{
			//disarm will prevent opponent from casting spell
			//unless they are warded
			StatusEffect disarm  = new StatusEffect();
				System.out.println(wRecieve.getName()+ " was disarmed");
				wRecieve.setCastAbility(false);
				wRecieve.currentEffects.add(disarm);
			return wCaster.getName() +" casts "+ chosenSpell.getName() + "\n" + wRecieve.getName()+ " was disarmed";
			}
						
		
		//assuming that if it isn't self-targeting or disarming, its a damaging attack
		
		
		else{
			//calculate damage based on wizards intellect and spell power
			int damage = (int)(wCaster.getIntellect()*.01) * chosenSpell.getPower();
			System.out.println(chosenSpell.getName() + " dealt "+ damage + " damage");
			//current way of modifying opponents health
			wRecieve.setHP(wRecieve.getHP() - damage);
			System.out.println(wRecieve.getName() + " has " +wRecieve.getHP() + " health left");
		 
		return wCaster.getName() +" casts "+ chosenSpell.getName() + "\n" + chosenSpell.getName() + " dealt "+ damage + " damage" + "\n" + wRecieve.getName() + " has " +wRecieve.getHP() + " health left";
		}
	
	}
}
