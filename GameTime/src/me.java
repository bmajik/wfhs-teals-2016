import java.util.ArrayList;

public class me extends abstractWizard {
	public me(String name, ArrayList<Spell> spellBook){
		super(name, 400,400,200,spellBook);
	}
	@Override
	public Spell chooseSpell(abstractWizard enemy) {
		// Use opponents logic against them or random spell
		Spell chosenSpell;
		double five = Math.random();
		if (five < .5){
			
			chosenSpell = this.getSpellBook().get((int)(Math.random() * this.getSpellBook().size()));	
		}
		else{
			chosenSpell = enemy.chooseSpell(enemy);
		}
		while (chosenSpell.getHealer() != 0){
			if ((this.getHP() > this.GetMaxHP()-100)){
				chosenSpell = this.getSpellBook().get((int)(Math.random() * this.getSpellBook().size()));
			}
			else if  (this.getAttunement() < 0){
				while (chosenSpell.getHealer() != 0){
					chosenSpell = this.getSpellBook().get((int)(Math.random() * this.getSpellBook().size()));
				}
				
			}
			
		}
		return chosenSpell;
		
	}
}