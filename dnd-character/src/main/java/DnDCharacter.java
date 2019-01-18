import java.util.Random;
import java.util.List;
import java.util.ArrayList;
class DnDCharacter {
	int strength;
	int dexterity;
	int constitution;
	int intelligence;
	int wisdom;
	int charisma;
	int hitpoints;
	
	public DnDCharacter(){
		strength=ability();
		dexterity=ability();
		constitution=ability();
	    intelligence=ability();
		wisdom=ability();
		charisma=ability();
		hitpoints=10+modifier(constitution);
	}
    int ability() {
		Random rm = new Random();
		List<Integer> matrix = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++)
			matrix.add(rm.nextInt(5) + 1);

		int min = Math.min(Math.min(Math.min(matrix.get(0), matrix.get(1)), matrix.get(2)), matrix.get(3));
		matrix.remove(Integer.valueOf(min));
		int sum = 0;
		for (Integer in : matrix)
			sum += in;

		return sum;
    }

    int modifier(int input) {
       int a = input - 10;
	   double b = a / 2.0;
	   double c = Math.floor(b);
	   return (int) c;
    }
	
	int getStrength(){
		return strength;
	}
	int getDexterity(){
		return dexterity;
	}
	int getConstitution(){
		return constitution;
	}
	int getIntelligence(){
		return intelligence;
	}
	int getWisdom(){
		return wisdom;
	}
	int getCharisma(){
		return charisma;
	}
	
	int getHitpoints(){
		return hitpoints;
	}

}
