import java.util.ArrayList;

public class GrandWizardLogan extends abstractWizard {

		// i pick my stats randomly
		public GrandWizardLogan (String name, ArrayList<Spell> spellBook){
			
			// you have to call the base constructor first..
			super("GrandWizardLogan", 700, 50, 200, spellBook);

		}
		
		@Override
		public Spell chooseSpell() {
			int spellerama;
			double num = Math.random();
			if(num < .5){
				spellerama = 3;
			}else{
				spellerama = 10;
			}
			Spell theOne = this.getSpellBook().get(spellerama);
			return theOne;
		}

	}

