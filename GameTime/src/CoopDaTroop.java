
import java.util.ArrayList;

	public class CoopDaTroop extends abstractWizard {

		// i pick my stats randomly
		public CoopDaTroop (ArrayList<Spell> spellBook){
			
			// you have to call the base constructor first..
			super("Cooper", 400, 300, 300, spellBook);

		}
		
		@Override
		public Spell chooseSpell(abstractWizard enemy) {
			// i always choose a random spell
			int spellBookSize = this.getSpellBook().size();
			return this.getSpellBook().get((int)(Math.random() * spellBookSize));
		}

	}


