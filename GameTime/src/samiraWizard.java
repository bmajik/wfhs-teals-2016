import java.util.ArrayList;

public class samiraWizard extends abstractWizard {

	public samiraWizard (String name, ArrayList<Spell> spellBook){
		super(name, 600, 200, 200, spellBook);
	}

	@Override
	public Spell chooseSpell() {
		if(this.getHP() <= 75) {
			return this.getSpellBook().get(10);
		}else if (this.getHP() >= 425){
			return this.getSpellBook().get(3);
		}else { 
			int spellBookSize = this.getSpellBook().size();
			return this.getSpellBook().get((int)(Math.random() * spellBookSize));
		}
	}
}



