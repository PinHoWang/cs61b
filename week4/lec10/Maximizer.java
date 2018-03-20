
import java.util.Comparator;

public class Maximizer {
	public static Comparable max(Comparable[] items) {
		int maxDex = 0;
		for (int i = 1; i < items.length; i += 1) {
			if((items[maxDex].compareTo(items[i])) < 0)
				maxDex = i;
		}
		return items[maxDex];

	}

	public static void main(String[] args) {
		Dog[] dogs = {new Dog("Elyse", 3), new Dog("Sture", 9),
		             new Dog("Artemesios", 15)};
		Dog maxDog = (Dog) max(dogs);
		maxDog.bark();

		Comparator<Dog> cd = Dog.getNameComparator();
		if(cd.compare(dogs[0], dogs[2]) > 0) dogs[0].bark();
		else dogs[2].bark();
	}
} 