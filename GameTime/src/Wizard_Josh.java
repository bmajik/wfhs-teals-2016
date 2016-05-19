import java.util.ArrayList;

public class Wizard_Josh extends abstractWizard {

	public Wizard_Josh(ArrayList<Spell> spellBook) {
		
		super("Josh", 250, 250, 200, spellBook);
		
		double random = Math.random();
		int Intelect = 0;
		int HP = 0;
		int Attunement = 0;
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

}
