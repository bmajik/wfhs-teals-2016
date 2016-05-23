import java.util.ArrayList;
public class AdvancedCockyWizard extends abstractWizard{
 public AdvancedCockyWizard(String name, ArrayList<Spell> spellBook) {
 super(name, 400, 300, 300, spellBook);
 }
 /*
 ***CHEAT SHEET:
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
 public Spell chooseSpell(abstractWizard enemy) {
 Spell choosenSpell = null;
 while (getHP() > 0){
 if(getHP() < 180 && getAttunement() > 0){
 choosenSpell = this.getSpellBook().get(10); //Heal Spell
 }
 else if (enemy.getHP() < 120){
 choosenSpell = this.getSpellBook().get(3); //Deals 120 Damage
 }
 else if (enemy.getWarded() == true){
 choosenSpell = this.getSpellBook().get(6); //Lowest and quickest attack as it will be blocked
 }
 else if (getWarded() == true){
 choosenSpell = this.getSpellBook().get((int)(Math.random() * 7)); //If I am warded pick a random Damage Spell 
 }
 else if (getAttunement() < 10 && getHP() < 120){
 choosenSpell = this.getSpellBook().get(11); //Ward because I can't heal anymore
 }
 else{
 choosenSpell = this.getSpellBook().get((int)(Math.random() * 7)); //DAMAGE SPELL
 }
 return choosenSpell;
 }
 return choosenSpell;
 }
}