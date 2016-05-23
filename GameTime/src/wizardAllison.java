import java.util.ArrayList;

public class wizardAllison extends abstractWizard {

	public wizardAllison(String name, ArrayList<Spell> spellBook) {
		super("Allison", 600, 200, 200, spellBook);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Spell chooseSpell(abstractWizard enemy) {
		
		if(this.getHP()<200){
			return this.getSpellBook().get(10);
		}
		else if (Math.random()<.7){
			return this.getSpellBook().get(5);
		}
		else {
			return this.getSpellBook().get(0);
		}
		
	}

}
