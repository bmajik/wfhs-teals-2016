import java.util.ArrayList;

public class NastyAttacker extends abstractWizard {

	public NastyAttacker(String name, ArrayList<Spell> spellBook) {
		super(name, 250, 500, 250, spellBook);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Spell chooseSpell() {
		// TODO Auto-generated method stub
		Spell n = new Spell("Avada Kedavra", 1000, 1);
		return n;
	}

}
