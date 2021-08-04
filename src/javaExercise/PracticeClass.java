package javaExercise;

public class PracticeClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spider s1 = new Spider();
		Cat c1 = new Cat("cute");
		Fish f1 = new Fish();
		s1.walk();
		s1.eat();
		c1.walk();
		c1.eat();
		c1.play();
		f1.setName("fat fish");
		f1.walk();
		f1.eat();
		f1.play();
	}

}

abstract class Animal{
	protected int legs;
	protected Animal(int l) {
		this.legs = l;
	}
	public abstract void eat();
	public void walk() {
		System.out.println("use "+this.legs+" legs to walk");
	}
}

interface Pet{
	void setName(String name);
	String getName();
	void play();
}

class Spider extends Animal{
	public Spider() {
		super(8);
	}
	@Override
	public void eat() {
		System.out.println("Spider eat");
	}
}

class Cat extends Animal implements Pet{
	private String name;
	public Cat(String name) {
		super(4);
		this.name = name;
	}
	public Cat() {
		this(null);
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public void play() {
		System.out.println(this.name+" Cat play");
	}
	@Override
	public void eat() {
		System.out.println(this.name+" Cat eat");
	}
}

class Fish extends Animal implements Pet{
	private String name;
	public Fish() {
		super(0);
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public void play() {
		System.out.println(this.name+" Fish play");
	}
	@Override
	public void eat() {
		System.out.println(this.name+" Fish eat");
	}
	@Override
	public void walk() {
		System.out.println("Fish cannot walk and has no legs");
	}
}