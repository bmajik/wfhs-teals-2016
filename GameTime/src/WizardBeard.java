import java.util.ArrayList;

public class WizardBeard extends abstractWizard {
	public WizardBeard(ArrayList<Spell> spellBook) {
		super("WizardBeard", 250, 500, 250, spellBook);
	}
	
	/*
	 ***CHEAT SHEET:
	 *All numbers based on 300 Intellect
 0 = Disarm
 1 = D-60
 2 = D-90
 3 = D-120
 4 = D-75
 5 = D-105
 6 = D-30
 7 = D-45
 8 = Disarm
 9 = D-60
 10 = Heal
 
 
0  spellBook.add(disarm);
1  spellBook.add(waterDamage);
2  spellBook.add(fireDamage);
3  spellBook.add(explosionDamage);
4  spellBook.add(hangDamageLoseAttunement);
5  spellBook.add(tickleLoseAttunement);
6  spellBook.add(confusionLoseIntellect);
7  spellBook.add(stupidLoseIntellect);
8  spellBook.add(disarm);
9  spellBook.add(reflect);
10 spellBook.add(healLoseAttunement);
11 spellBook.add(stopIt);
	 */
	@Override
	public Spell chooseSpell(abstractWizard enemy) {
		
		// attempt to determine enemy's offensive spell power...
		// this will be my trigger point for needing to heal...
		double n1 = enemy.getIntellect();
		double n2 = 500;
		double x = n1/n2;
		int minHP = (int)(x * 200) + 1;
		
		//System.out.println("minHP:" + minHP);
		
		// initialize with a basic damage spell...
		Spell toCast = this.getSpellBook().get(1);
		
		//  if we're disarmed, choose something quick..
		if (!this.getCastAbility()) {
			return toCast;
		}
		
		// if i can destroy the other wizard in one shot, do it
		if (!enemy.getWarded() && enemy.getHP() <= 180) {
			toCast = this.getSpellBook().get(3);
			return toCast;
		}
		
		// if i don't have a ward, set one...
		if (!this.getWarded()) {
			return this.getSpellBook().get(9);
		}
		
		// if i am sick, heal myself
		if (this.getHP() <= minHP && this.getAttunement() >= 40) {
			toCast = this.getSpellBook().get(10);
		}
		
		// if the other wizard is warded... 
		if (enemy.getWarded()) {
			if (!this.getWarded()) {
				toCast = this.getSpellBook().get(8);
			}
			else {
				// if i'm already warded, cast a spell that recharges quickly..
				toCast = this.getSpellBook().get(6);
			}
		}
		
		// if we get here, we'll do the quick basic damage spell...
		
		return toCast;
	}
	
}
