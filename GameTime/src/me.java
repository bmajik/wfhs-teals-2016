import java.util.ArrayList;

public class me extends abstractWizard {
	public me(String name, ArrayList<Spell> spellBook){
		super(name, 400,400,200,spellBook);
	}
	@Override
	public Spell chooseSpell(abstractWizard enemy) {
		// Use opponents logic against them or random spell
		double five = Math.random();
		if (five < .5){
			
			return this.getSpellBook().get((int)(Math.random() * this.getSpellBook().size()));	
		}
		else{
			return enemy.chooseSpell(enemy);
		}
		
	}
}
