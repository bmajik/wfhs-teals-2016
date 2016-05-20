
import java.util.ArrayList;
public class CoopDestroyer extends abstractWizard{
 public CoopDestroyer(String name, ArrayList<Spell> spellBook) {
 super(name, 500, 498, 2, spellBook);
 }
 /*
 ***CHEAT SHEET:/
 *All numbers based on 300 Intellect
 0 = Disarm
 1 = D-60
 2 = D-90
 3 = D-120
 4 = D-75
 5 = D-105
 6 = D-30
 7 = D-45
 8 = Disarm
 9 = D-60
 10 = Heal
 */
 @Override
 public Spell chooseSpell() {
 Spell choosenSpell = null;
 while (getHP() > 0){
 if(getHP() < 180){
 choosenSpell = this.getSpellBook().get(10); //HEAL SPELL
 }
 else{
 choosenSpell = this.getSpellBook().get((int)(Math.random() * 7)); //DAMAGE SPELL
 }
 return choosenSpell;
 }
 return choosenSpell;
 }
}