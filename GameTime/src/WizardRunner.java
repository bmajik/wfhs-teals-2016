import java.util.ArrayList;
public class WizardRunner {
 
  public static void main(String[] args){
   ArrayList<Spell> spellBook = new ArrayList<Spell>();
   Spell disarm= new Spell("Disarm",true, 1);
   Spell fireBall = new Spell("Fireball",50, 1);
   Spell heal = new Spell("Heal", 50, true, 1);
   Spell ward = new Spell("Ward", 0, true, 3);
   
   //Attack spells - check parameters
   Spell aquamenti = new Spell("Aquamenti",50,1);//water-health
   Spell confringo = new Spell("Confringo",50,1);//fire-health
   Spell expulso = new Spell("Expulso",50,1);//explosion-health
   Spell levicorpus = new Spell("Levicorpus",50,1);//hang upside down-atunement
   Spell rictusempra = new Spell("Rictusempra",50,1);//tickles - atunement
   Spell confundus = new Spell("Confundus",50,1);//confusion - intellect
   Spell Stupefy = new Spell("Stupefy",50,1);//knocks opponent - intellect
   
   //Defense Spells - check parameters
   Spell expelliermus = new Spell("Expelliermus",true,1);//disarm 
   Spell protego = new Spell("Protego",50,1);//reflect spell effect to caster
   Spell episkey = new Spell("Episkey",50,true,1);//heal and lose attunement
   Spell finiteIncantantum = new Spell("Finite Incantantum",50,1);//stop all spells???
   
   
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
   
   abstractWizard Hairy = new abstractWizard("Hairy",2500,250,500, spellBook);
   abstractWizard Rob = new abstractWizard("Rob", 2500,700,50, spellBook);
   
   BattleSystem.WizardBattleSystem(Hairy, Rob);
   
   
  
 }
}