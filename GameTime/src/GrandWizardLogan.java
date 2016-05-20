import java.util.ArrayList;

public class GrandWizardLogan extends abstractWizard {

		// i pick my stats randomly
		public GrandWizardLogan (String name, ArrayList<Spell> spellBook){
			
			// you have to call the base constructor first..
			super("GrandWizardLogan", 600, 200, 200, spellBook);

		}
		
		@Override
		public Spell chooseSpell(abstractWizard enemy) {
			int spellerama;
			
			if(this.getHP() < 300){
				spellerama = 10;
			}else{
				spellerama = 3;
			}
			Spell theOne = this.getSpellBook().get(spellerama);
			return theOne;
		}

	}

