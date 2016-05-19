import java.util.ArrayList;
import java.util.Random;

public abstract class abstractWizard{
	//IDEAS:
	/* Wizard Duels - Intellect vs Intellect
	 * Flying
	 * Status effects have a duration
	 * duration tracker within wizard - List of Booleans? (Differentiate between effects)
	 * Expiration code - shut off boolean
	 *Status lowering attacks - lower intelligence? Attunement?
	 *Limit # of effects on wizard? 
	 *Disarm by chance?
	 *if Disarms meet - disarm both or cancel it?
	 */

	//FINALS
	private final int maxStatPoints = 1000;	

	//Funstuff
	private String name;

	//Stats
	private int HP;
	private int maxHP;
	private long currentSpellCooldown;
	private int Intellect;
	private int Attunement;
	private int countAnnoyances;
	private boolean castAbility;
	private boolean warded;

	//Effects
	protected ArrayList<StatusEffect> currentEffects = new ArrayList<StatusEffect>();

	long tempTimer = System.nanoTime();

	//getters and setters
	public int getHP() {
		return HP;
	}
	public int getIntellect() {
		return Intellect;
	}
	public int getAttunement() {
		return Attunement;
	}
	public int getCountAnnoyances() {
		return countAnnoyances;
	}
	public boolean getCastAbility() {
		return castAbility;
	}
	public boolean getWarded() {
		return warded;
	}
	public long getCurrentSpellCooldown() {
		return currentSpellCooldown;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCurrentSpellCooldown(long currentSpellCooldown) {
		this.currentSpellCooldown = currentSpellCooldown;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public void setMaxHP(int MaxHP){
		maxHP = MaxHP;
	}

	public int GetMaxHP() {
		return this.maxHP;
	}

	public void RestoreAllHeatlh() {
		this.setHP(this.maxHP);
	}

	public void setIntellect(int intellect) {
		Intellect = intellect;
	}

	public void setAttunement(int attunement) {
		Attunement = attunement;
	}
	public void setCountAnnoyances(int countAnnoyances) {
		this.countAnnoyances = countAnnoyances;
	}
	public void setCastAbility(boolean castAbility) {
		this.castAbility = castAbility;
	}
	public void setWarded(boolean warded) {
		this.warded = warded;
	}
	public void setSpellBook(ArrayList<Spell> spellBook){
		this.spellBook =spellBook;
	}
	public ArrayList<Spell> getSpellBook(){
		return this.spellBook;
	}
	//utilities
	private ArrayList<Spell> spellBook;

	public abstractWizard(String name,int HP,int Intellect,int Attunement, ArrayList<Spell> spellBook){
		//wizards need spells to fight, so make sure they are passing in a non-null value
		this.name = name;
		if (!spellBook.equals(null)){
			this.spellBook = new ArrayList<Spell>();
			this.spellBook = spellBook;
		}
		else{
			System.out.println("Check Dem Spells");
			System.exit(1);
			return;
		}
		
		// Checks for cheating on stat points when the wizard is created
		// System.exit(1) -Terminates the rest of the program immediately
		if (!AreStatsValid()) {
			System.exit(1);
		}
		
		//set initial values
		this.HP = HP;
		this.maxHP = HP;
		this.Intellect = Intellect;
		this.Attunement = Attunement;
		this.castAbility = true;
		//make sure that they pass in valid stats

	}
	
	public final boolean AreStatsValid() {
		if (maxStatPoints < this.HP + this.Intellect + this.Attunement) {
			System.out.println("A Wizards Stats don't equal 1000 or less");
			System.out.println("#CheatersNeverWin #CaughtYou #GetRektKid -SR");
			return false;
		}
		return true;
	}
	
	public abstract Spell chooseSpell();

}
