import java.util.ArrayList;
public class WizardRunner {
 
  public static void main(String[] args){
   ArrayList<Spell> spellBook = new ArrayList<Spell>();
   
   Spell fireBall = new Spell("Fireball",20, 1);
   Spell heal = new Spell("Heal", 20, true, 1);
   Spell ward = new Spell("Ward", 0, true, 1);
   
   //Attack spells - check parameters
   Spell waterDamage = new Spell("Aquamenti",20,1);//water-health
   Spell fireDamage = new Spell("Confringo",20,1);//fire-health
   Spell explosionDamage = new Spell("Expulso",20,1);//explosion-health
   Spell hangDamageLoseAttunement = new Spell("Levicorpus",20,1);//hang upside down-atunement
   Spell tickleLoseAttunement = new Spell("Rictusempra",20,1);//tickles - atunement
   Spell confusionLoseIntellect = new Spell("Confundus",20,1);//confusion - intellect
   Spell stupidLoseIntellect = new Spell("Stupefy",20,1);//knocks opponent - intellect
   
   //Defense Spells - check parameters
   Spell disarm = new Spell("Expelliermus",true,1);//disarm 
   Spell reflect = new Spell("Protego",20,1);//reflect spell effect to caster
   Spell healLoseAttunement = new Spell("Episkey",20,true,1);//heal and lose attunement
   Spell stopIt = new Spell("Finite Incantantum",5,1);//stop all spells???
   
   
   spellBook.add(disarm);
   spellBook.add(fireBall);
   spellBook.add(heal);
   spellBook.add(ward);
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
   abstractWizard Hairy = new BYOW("Hairy",250,250,250, spellBook);
   abstractWizard Bob = new BYOW("Bob", 250,250,250, spellBook);
   
   BattleSystem b = new BattleSystem();
   b.WizardBattleSystem(Hairy, Bob);
   
   
  
 }
}