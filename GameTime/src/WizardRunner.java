import java.util.ArrayList;
public class WizardRunner {
 
  public static void main(String[] args){
   ArrayList<Spell> spellBook = new ArrayList<Spell>();
   Spell disarm= new Spell("Disarm",true, 1);
   Spell fireBall = new Spell("Fireball",20, 1);
   Spell heal = new Spell("Heal", 20, true, 1);
   Spell ward = new Spell("Ward", 0, true, 1);
   
   //Attack spells - check parameters
   Spell aquamenti = new Spell("Aquamenti",20,1);//water-health
   Spell confringo = new Spell("Confringo",20,1);//fire-health
   Spell expulso = new Spell("Expulso",20,1);//explosion-health
   Spell levicorpus = new Spell("Levicorpus",20,1);//hang upside down-atunement
   Spell rictusempra = new Spell("Rictusempra",20,1);//tickles - atunement
   Spell confundus = new Spell("Confundus",20,1);//confusion - intellect
   Spell Stupefy = new Spell("Stupefy",20,1);//knocks opponent - intellect
   
   //Defense Spells - check parameters
   Spell expelliermus = new Spell("Expelliermus",true,1);//disarm 
   Spell protego = new Spell("Protego",20,1);//reflect spell effect to caster
   Spell episkey = new Spell("Episkey",20,true,1);//heal and lose attunement
   Spell finiteIncantantum = new Spell("Finite Incantantum",5,1);//stop all spells???
   
   
   spellBook.add(disarm);
   spellBook.add(fireBall);
   spellBook.add(heal);
   spellBook.add(ward);
   spellBook.add(aquamenti);
   spellBook.add(confringo);
   spellBook.add(expulso);
   spellBook.add(levicorpus);
   spellBook.add(rictusempra);
   spellBook.add(confundus);
   spellBook.add(Stupefy);
   spellBook.add(expelliermus);
   spellBook.add(protego);
   spellBook.add(episkey);
   spellBook.add(finiteIncantantum);
   
   //real spell list
   //spellBook.add();
   
   // Just using 250 for equal balance testing
   abstractWizard Hairy = new abstractWizard("Hairy",50,250,250, spellBook);
   abstractWizard Rob = new abstractWizard("Rob", 50,250,250, spellBook);
   
   BattleSystem.WizardBattleSystem(Hairy, Rob);
   
   
  
 }
}