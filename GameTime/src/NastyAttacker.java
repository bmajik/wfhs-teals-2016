import java.util.ArrayList;

public class NastyAttacker extends abstractWizard {

	public NastyAttacker(String name, ArrayList<Spell> spellBook) {
		super("Nasty Attacker", 250, 500, 250, spellBook);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Spell chooseSpell(abstractWizard enemy) {
		// TODO Auto-generated method stub
		Spell n = new Spell("Avada Kedavra", 40000000, 10000);
		return n;
	}

}
