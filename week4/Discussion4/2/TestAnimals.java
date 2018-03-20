
/* Testing Raining Cats and Dogs */
public class TestAnimals {

	public static void main(String[] args) {
		Animal a = new Animal("Pluto", 9);
		Cat c = new Cat("A Neow", 10);
		Dog d = new Dog("KiKi", 15);

		a.greet(); //(A) Showing: Animal Pluto says: Huh?
		c.greet(); //(B) Showing: Cat A Neow says: Meow!
		d.greet(); //(C) Showing: Dog KiKi says: Woof!

		a = c;
		((Cat) a).greet(); //(D) Showing: Cat A Neow says: Meow!
		a.greet(); //(E) Showing: Cat A Neow says: Meow!

		/* Compiler error: a is a Animal now! We cannot
		 * assign a Dog to it.
		 * We should cast a to a Dog: d = (Dog) a */
		a = new Dog("Spot", 10);
		// d = a;
		d = (Dog) a;
	}
}