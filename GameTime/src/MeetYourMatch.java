import java.util.ArrayList;


public class MeetYourMatch extends abstractWizard {
	 public MeetYourMatch(String name, ArrayList<Spell> spellBook) {
		 super(name, 400, 300, 300, spellBook);
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
		 */
		 @Override
		 public Spell chooseSpell(abstractWizard enemy) {
			 return enemy.chooseSpell(enemy);
		 }
}