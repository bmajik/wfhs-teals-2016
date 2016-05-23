import java.util.ArrayList;


public class VetterWizard extends abstractWizard{
	
	public VetterWizard(ArrayList<Spell> spellBook) {
		super("The Vetter Wizard", 300, 699, 1, spellBook);
		
	}

	@Override
	public Spell chooseSpell(abstractWizard enemy) {
		
		Spell c = null;	
		if(getHP()/GetMaxHP() <.25) {
			c = getSpellBook().get(10);
		}
		else{
			c = getSpellBook().get(3);
		}
		
		
		return c;
	}

}
