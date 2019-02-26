import java.util.BitSet;
import java.util.List;
import java.util.ArrayList;

public class Allergies{
private int score;
private Allergen al;
private List<Allergen> allergies;

public Allergies(int score){
	this.score = score;	
	allergies = new ArrayList<>();
	for(Allergen a:al.values())
		if(isAllergicTo(a))
			allergies.add(a);
	
}


public boolean isAllergicTo(Allergen al){
if (score == 0)
	return false;
if (al.getScore() == score)
    return true;

if (al.getScore() > score)
	return false;

BitSet bitSet = new BitSet();
for (int i = 0; i < 64; i++)
	if (((score >>> i) & 1) != 0)
		bitSet.set(i);

for (int i = 0; i < 64; i++)
	if (bitSet.get(i) && al.ordinal() == i)
		return true;

return false;	
}

public List<Allergen> getList(){
	return allergies;
}
}
