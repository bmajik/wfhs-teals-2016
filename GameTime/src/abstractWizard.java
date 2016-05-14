import java.util.ArrayList;
import java.util.Random;

public class abstractWizard{
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
	private ArrayList<StatusEffect> currentEffects = new ArrayList<StatusEffect>();

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
			return;
		}
		// Checks for cheating on stat points when the wizard is created
		// System.exit(1) -Terminates the rest of the program immediately
		if (maxStatPoints < HP + Intellect + Attunement){
			System.out.println("A Wizards Stats don't equal 1000 or less");
			System.out.println("#CheatersNeverWin #CaughtYou #GetRektKid -SR");
			System.exit(1);
			return;
		}
		//set initial values
			this.HP = HP;
			this.maxHP = HP;
			this.Intellect = Intellect;
			this.Attunement = Attunement;
			this.castAbility = true;
			//make sure that they pass in valid stats
			
	}
	public String castSpell(abstractWizard w2){
		// NEED TO IMPLEMENT check for disarmed or other inhibitors
		
		if (!this.castAbility)
		{
			//they can't cast a spell if they are disarmed
			System.out.println(this.getName() + " is disarmed, they cannot cast a spell");
			//TEMPORARY, ONLY TO TEST WITHOUT FIXING DISARM
			this.castAbility = true;
			return this.getName() + " is disarmed, they cannot cast a spell";
		}
		
		Random rnd = new Random();
		//Gets a random spell, will probably have users implement actual logic
		//So this is temporary
		Spell chosenSpell = spellBook.get(rnd.nextInt(spellBook.size()));
		
		//set value of current spells cool down for use in BattleSystem
		this.setCurrentSpellCooldown(chosenSpell.getCoolDown()); 
		System.out.println(this.getName() +" casts "+ chosenSpell.getName());
		//check if spell is targeting self
		if (chosenSpell.getSelfTargeting()){
			//check for protective spell
			if (chosenSpell.getProtecter()){
				System.out.println(this.getName() + " is now warded");
				this.setWarded(true);
				return this.getName() +" casts "+ chosenSpell.getName() + "\n" + this.getName() + " is now warded";
			}
			//assuming that if it isn't a ward it heals the wizard 
			//Will be changed if more self-targeting spells are implemented
			
			else{
				//May need to be changed, 
				//regenerates HP based on Spell and Intellect
				
				int healingAmount = chosenSpell.getHealer()*this.getIntellect();
								
				if(this.HP + healingAmount > this.maxHP)
				{
					healingAmount = this.maxHP-this.HP;
					this.HP = this.maxHP;
					 
				}
				else{
					this.setHP(this.HP + healingAmount);
				}
					
				System.out.println(this.getName() + " healed for " + healingAmount + " health" );
				return this.getName() +" casts "+ chosenSpell.getName() + "\n" + this.getName() + " healed for " + healingAmount + " health" ;
			}
			
		}
		else if (w2.getWarded()){
			System.out.println(chosenSpell.getName() + " was blocked");			
			this.setWarded(false);
			return this.getName() +" casts "+ chosenSpell.getName() + "\n" + chosenSpell.getName() + " was blocked";
		}
		//This code exists under the assumption that disarm does nothing but disarm
		else if (chosenSpell.getDisarm())
		{
			//disarm will prevent opponent from casting spell
			//unless they are warded
			StatusEffect disarm  = new StatusEffect();
				System.out.println(w2.getName()+ " was disarmed");
				w2.setCastAbility(false);
				this.currentEffects.add(disarm);
			return this.getName() +" casts "+ chosenSpell.getName() + "\n" + w2.getName()+ " was disarmed";
			}
						
		
		//assuming that if it isn't self-targeting or disarming, its a damaging attack
		
		
		else{
			//calculate damage based on wizards intellect and spell power
			int damage = (int)(this.getIntellect()*.01) * chosenSpell.getPower();
			System.out.println(chosenSpell.getName() + " dealt "+ damage + " damage");
			//current way of modifying opponents health
			w2.setHP(w2.HP- damage);
			System.out.println(w2.getName() + " has " +w2.getHP() + " health left");
		 
		return this.getName() +" casts "+ chosenSpell.getName() + "\n" + chosenSpell.getName() + " dealt "+ damage + " damage" + "\n" + w2.getName() + " has " +w2.getHP() + " health left";
	}
	
	}
}