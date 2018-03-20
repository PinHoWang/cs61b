
/* Cat class: subclass of Animal */
public class Cat extends Animal {

	public Cat(String name, int age) {
		super(name, age);
		this.noise = "Meow!";
	}


	/* Overriding the greet() method */
	@Override
	public void greet() {
		System.out.println("Cat " + name + " says: "
			+ makeNoise());
	}
}