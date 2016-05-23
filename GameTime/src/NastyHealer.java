import java.util.ArrayList;

public class NastyHealer extends abstractWizard {

	public NastyHealer(String name, ArrayList<Spell> spellBook) {
		super("Nasty Healer", 250, 500, 250, spellBook);
	}
	@Override
	public Spell chooseSpell(abstractWizard enemy) {
		Spell n = new Spell("Healing Kadabra", 4000 , true, 1000);
		return n;
	}

}