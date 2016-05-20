import java.util.ArrayList;


public class Jaydawwwg extends abstractWizard {
	// i pick my stats randomly
		public Jaydawwwg (String name, ArrayList<Spell> spellBook){
			
			// you have to call the base constructor first..
			super(name, 100, 100, 100, spellBook);
			
			// distribute 700 points randomly.
			// make sure each score is at least 100 points..
			int RemainingStat = 700;
			
			// but you can change your stats later...
			// I choose my stats randmoly...
			int HP = (int)(Math.random() * RemainingStat);
			RemainingStat -= HP;
			HP += 100;
			
			int Intellect = (int)(Math.random() * RemainingStat);
			RemainingStat -= Intellect;
			Intellect += 100;
			
			int Attunement = RemainingStat;
			Attunement += 100;
			
			this.setHP(HP);
			this.setMaxHP(HP);
						
			this.setIntellect(Intellect);
			
			this.setAttunement(Attunement);
		}
		
		@Override
		public Spell chooseSpell() {
			// i always choose a random spell
			int spellBookSize = this.getSpellBook().size();
			return this.getSpellBook().get((int)(Math.random() * spellBookSize));
		}
}
