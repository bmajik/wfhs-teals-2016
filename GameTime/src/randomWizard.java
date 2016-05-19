import java.util.ArrayList;

public class randomWizard extends abstractWizard {

	// i pick my stats randomly
	public randomWizard (String name, ArrayList<Spell> spellBook){
		
		// you have to call the base constructor first..
		super(name, 100, 100, 100, spellBook);
		
		int RemainingStat = 1000;
		
		// but you can change your stats later...
		// I choose my stats randmoly...
		int HP = (int)(Math.random() * RemainingStat);
		RemainingStat -= HP;
		
		int Intellect = (int)(Math.random() * RemainingStat);
		RemainingStat -= Intellect;
		
		int Attunement = RemainingStat;
	
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
