import java.util.ArrayList;

public class WizardRunner {
	
		public static void main(String[] args){
			ArrayList<Spell> spellBook = new ArrayList<Spell>();
			Spell disarm= new Spell("Disarm",true,(long)1);
			Spell fireBall = new Spell("Fireball",10, (long)1);
			Spell heal = new Spell("Heal", 50, true, (long)1);
			Spell ward = new Spell("Ward", 0, true, (long)3);
			
			
			//spellBook.add(disarm);
			spellBook.add(fireBall);
			//spellBook.add(heal);
			//spellBook.add(ward);
			abstractWizard Hairy = new abstractWizard("Hairy",250,250,500, spellBook);
			abstractWizard Rob = new abstractWizard("Rob", 250,250,500, spellBook);
			
			
			
			BattleSystem.WizardBattleSystem(Hairy, Rob);
			
			
			
		
	}
}
