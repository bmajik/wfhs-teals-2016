
public class Spell {
	//Debated having different classes implementing a Spell superclass
	//decided not to as it isn't enough code to justify its own file
		
	//Basic damaging spell 	
	public Spell(String name,int power, long coolDown)
	{
		this.spellName = name;
		this.power = power;
		this.coolDown = coolDown;
		this.selfTargeting = false;
	}
	//assumes spell is disarm
	public Spell(String name,boolean status, long coolDown)
	{
		this.spellName = name;
		this.disarm = true;
		this.coolDown = coolDown;
		this.selfTargeting = false;
	}
	//assume it is a heal or protection spell
	//if it has any healing power then it won't be a protection spell
	//boolean hitSelf only exists to separate it from a basic damage spell
	public Spell(String name,int healPower, boolean hitSelf, long coolDown)
	{
		this.spellName = name;
		this.selfTargeting = true;		
		this.Healer = healPower;
		this.coolDown = coolDown;
		if (healPower == 0){
			this.protecter = true;
		}
	}
	
	public long getCoolDown() {
		return coolDown;
	}	
	public boolean getDisarm() {
		return disarm;
	}
	public boolean getSelfTargeting() {
		return selfTargeting;
	}
	public boolean getProtecter() {
		return protecter;
	}
	
	public int getHealer() {
		return Healer;
	}
	
	public int getPower() {
		return power;
	}
	public void setHealer(int healer) {
		Healer = healer;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public void setCoolDown(long coolDown) {
		this.coolDown = coolDown;
	}
	public void setDisarm(boolean disarm) {
		this.disarm = disarm;
	}
	
	public void setProtecter(boolean protecter) {
		this.protecter = protecter;
	}
	
	public void setSelfTargeting(boolean selfTargeting) {
		this.selfTargeting = selfTargeting;
	}
	
	public String getName(){
		return this.spellName;
	}
	private String spellName;
	private long coolDown;	
	private int Healer;	
	private int power;
	private boolean disarm;
	private boolean protecter;
	private boolean selfTargeting;
}
