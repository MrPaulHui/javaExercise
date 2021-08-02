package javaExercise;

public class ModernClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heros h1 = new Heros("timi", 123.5, 0.8, 100, 95);
		Supports s1 = new Supports("daqiao", 200.2, 0.3, 50, 80, 30);
		s1.healself();
		s1.heal(h1);
		System.out.println(h1.life);
		System.out.println(s1.life);
		Heros ssx = new Heros();
		ADheros ad1 = new ADheros();
		APheros ap1 = new APheros();
		ssx.kill(ad1);
		ssx.kill(ap1);
		Items it1 = new Items("Paul");
		Items it2 = new Items("Kobe", 180);
		System.out.println(it1.toString());
		System.out.println(it1.equals(s1));
		System.out.println(it1.equals(it2));

	}

}

interface Healer{
	void healself(); //= public abstract void healself();
	void heal(Heros h);
}

interface Mortal{
	void die();
}

class Heros{
	protected String name; //protectedһ����Ϊ�˼̳�ʹ��
	protected double life;
	protected double money;
	protected int offense;
	protected int defense;
	
	public Heros(String name, double life, double money, int of, int df) {
		this.name = name;
		this.life = life;
		this.money = money;
		this.offense = of;
		this.defense = df;
	}
	public Heros() {
		
	}
	public void kill(Mortal m) { //�����ýӿڶ���û���⣬��Ϊʵ�ʵ��õ�ʱ�򣬶�����ʵ�ֽӿڵľ�����
		m.die(); //��̬
	}
}

class Supports extends Heros implements Healer{// can extend a class and meanwhile implement an interface
	protected double heal_ab;
	public Supports(String name, double life, double money, int of, int df, double hab) {
		super(name, life, money, of, df);
		this.heal_ab = hab;
	}
	@Override
	public void healself() { //override interface's method
		this.life += 1.0;
	}
	@Override
	public void heal(Heros h1) { //���������Ժ�interface��Ĳ�һ��
		h1.life += this.heal_ab;
	}
}

class ADheros implements Mortal{
	@Override
	public void die() {
		System.out.println("ADhero is dead");
	}
}

class APheros implements Mortal{
	@Override
	public void die() {
		System.out.println("APhero is dead");
	}
}

class Items {
	public String name;
	public int price;
	
	public Items(String n, int p) {
		// TODO Auto-generated constructor stub
		this.name = n;
		this.price = p;
	}
	public Items(String n) {
		this(n, 180); //����Item(String n, int p)������췽�����๹�췽��������
	}
	
	@Override
	public String toString() {
		return name+price; //string+int can be directly changed into string
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Items) {//�ж�����
			/*
			if(o.price==this.price) { //����д�����⣬�����Լ���һ��downcasting
				return true;
			}
			*/
			Items i = (Items) o;
			if(i.price==this.price) {
				return true;
			}
		}
		return false;
	}

}

