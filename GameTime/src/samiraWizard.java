import java.util.ArrayList;

public class samiraWizard extends abstractWizard {

	public samiraWizard ( ArrayList<Spell> spellBook){
		super("Super Samira", 600, 300, 100, spellBook);
	}
	/*
	 ***CHEAT SHEET:
	 *All numbers based on 300 Intellect
	 *Thanks Spencer!
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
		
		while(this.getHP()>0){
			
			if(this.getHP() <= 120  && this.getAttunement() > 0 ) 
			{
				return this.getSpellBook().get(10);//heal
			}
			
			else if (Math.abs(enemy.getHP()-this.getHP()) < 1)
			{
				return this.getSpellBook().get(8);//disarm when tied with enemy
			}
			
			else if (this.getHP() >= 425 || enemy.getHP() >= 100)
			{
				return this.getSpellBook().get(3);//highest damage
			}
			
			else if(enemy.getWarded()== true || enemy.getHP() <= 50)
			{
				return this.getSpellBook().get(6);//lowest damage
			}
			
			else if (this.getHP() <= 50 && this.getAttunement() <= 10)
			{
				return this.getSpellBook().get(11);//ward 
			}
			
			else //random spell
			{ 
				int spellBookSize = this.getSpellBook().size();
				return this.getSpellBook().get((int)(Math.random() * spellBookSize));
			}
		}
		return null;
	}
}



