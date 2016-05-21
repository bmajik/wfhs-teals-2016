import java.util.ArrayList;
public class WizardRunner {
 
  public static void main(String[] args){
   ArrayList<Spell> spellBook = new ArrayList<Spell>();
   
   //Attack spells - check parameters
   Spell waterDamage = new Spell("Aquamenti",20,1000);//water-health
   Spell fireDamage = new Spell("Confringo",30,2000);//fire-health
   Spell explosionDamage = new Spell("Expulso",40,3000);//explosion-health
   Spell hangDamageLoseAttunement = new Spell("Levicorpus",25,1000);//hang upside down-atunement
   Spell tickleLoseAttunement = new Spell("Rictusempra",35,2000);//tickles - atunement
   Spell confusionLoseIntellect = new Spell("Confundus",10,1000);//confusion - intellect
   Spell stupidLoseIntellect = new Spell("Stupefy",15,2000);//knocks opponent - intellect
   
   //Defense Spells - check parameters
   Spell disarm = new Spell("Expelliermus",true,1000);//disarm 
   Spell reflect = new Spell("Protego",20,1000);//reflect spell effect to caster
   Spell healLoseAttunement = new Spell("Episkey",20,true,1000);//heal and lose attunement
   Spell stopIt = new Spell("Finite Incantantum",0,true,1000);//stop all spells???
   
   
   spellBook.add(disarm);
   spellBook.add(waterDamage);
   spellBook.add(fireDamage);
   spellBook.add(explosionDamage);
   spellBook.add(hangDamageLoseAttunement);
   spellBook.add(tickleLoseAttunement);
   spellBook.add(confusionLoseIntellect);
   spellBook.add(stupidLoseIntellect);
   spellBook.add(disarm);
   spellBook.add(reflect);
   spellBook.add(healLoseAttunement);
   spellBook.add(stopIt);
   
   //real spell list
   //spellBook.add();
   
   // Just using 250 for equal balance testing
   abstractWizard Hairy = new NastyHealer("Rex", spellBook);
   abstractWizard Bob = new randomWizard("Bob", spellBook);
   
   BattleSystem b = new BattleSystem();
   b.WizardBattleSystem(Hairy, Bob);
   
   
  
 }
}