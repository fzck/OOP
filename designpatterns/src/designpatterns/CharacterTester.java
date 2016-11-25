package designpatterns;

public class CharacterTester {

	//public CharacterTester() {
		// TODO Auto-generated constructor stub
	//}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Character queen = new Queen();
		Character king = new King();
        Character troll = new Troll();
        Character knight = new Knight();
        
		WeaponBehavior w = new AxeBehavior();
		WeaponBehavior ba = new BowAndArrowBehavior();
        WeaponBehavior s = new SwordBehavior();
        WeaponBehavior k = new KnifeBehavior();
        queen.setWeapon(w);
        queen.fight();
     
        troll.setWeapon(s);
        troll.fight();
        
        queen.setWeapon(ba);        
        queen.fight();
              
        king.setWeapon(ba);       
        king.fight();
        
        knight.setWeapon(k);
        knight.fight();
        
        

	}

}
