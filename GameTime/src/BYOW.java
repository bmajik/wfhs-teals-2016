import java.util.ArrayList;

public class BYOW extends abstractWizard{
	public BYOW (String name,int HP,int Intellect,int Attunement, ArrayList<Spell> spellBook){
		super(name, HP, Intellect, Attunement, spellBook);					
	}
	public Spell chooseSpell(){
		//This is where we implement our own spell logic
		//remove this when you actually implement it
		//Access spellbook using super.getSpellBook();
		//SpellBook is an arraylist of spells
		return null;
	}
	
}
