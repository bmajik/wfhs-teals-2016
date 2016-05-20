import java.util.ArrayList;

public class Wizard_Josh extends abstractWizard {

	public Wizard_Josh(ArrayList<Spell> spellBook) {

		super("Josh", 250, 250, 200, spellBook);

		double random = Math.random();
		int Intelect = 250;
		int HP = 250;
		int Attunement = 200;
		if(random <.6){
			Intelect = 500;
			Attunement = 250;
		}
		else{
			HP = 500;
		}
		this.setAttunement(Attunement);
		this.setIntellect(Intelect);
		this.setHP(HP);
		this.setMaxHP(HP);
	}

	@Override
	public Spell chooseSpell(abstractWizard enemy) {
		double healthPercent = (this.getHP()/this.GetMaxHP());
		if(healthPercent < 0.38){
			return this.getSpellBook().get(10);
		}
		else{
			int spellBookSize = this.getSpellBook().size();
			return this.getSpellBook().get((int)(Math.random() * spellBookSize));
		}
	}


}
