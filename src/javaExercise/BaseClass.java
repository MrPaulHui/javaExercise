package javaExercise;
import myUtil.utilss; // 导入其他package下的class的方法

public class BaseClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item i1 = new Item("你好", 5);
		System.out.println(i1.name);
		Item i11 = new Item("woshi");
		System.out.println(i11.name+i11.price);
		
		Armor a1 = new Armor("ogman", 5, 18);
		System.out.println(a1.name+a1.ac);
		
		Item i2 = new Armor("uppp", 0, 10086); //upcasting，向上转型，即将子类Armor的类型向上转换为其父类的Item类型，这是允许的
		//System.out.println(i2.ac); //compile error, i2 is already upcasted to Item type, which has no ac field.
		System.out.println(i2.name);
		Armor a2 = (Armor) i2; //downcasting, ok, because i2 actually points to Armor type
		//Armor a3 = (Armor) i1; //downcasting, error, i1 points to Item type, which cannot convert to Item's son class, which has more fields or methods.
		System.out.println(a2.ac);
		utilss u1 = new utilss(12, 13);
		System.out.println(u1.a);
		
		SportsLeague sl1 = SportsLeague.FIFA; //enum class
		System.out.println(sl1.name()+" "+sl1.ordinal()); //name() return its string, ordinal return its number(order number)
		SportsLeague sl2 = SportsLeague.NBA; 
		System.out.println(sl2.name()+" "+sl2.ordinal());
		
		Armor1 a11 = new Armor1("icon", 12, 13);
		System.out.println(a11.disposable());
		LifePotion1 lp1 = new LifePotion1("mann", 15);
		System.out.println(lp1.disposable());
		

	}

}

class Item {
	public String name;
	public int price;
	
	public Item(String n, int p) {
		// TODO Auto-generated constructor stub
		this.name = n;
		this.price = p;
	}
	public Item(String n) {
		this(n, 180); //调用Item(String n, int p)这个构造方法，多构造方法的体现
	}
	public String getName() {
		return this.name;
	}
}

class Armor extends Item{
	public int ac;
	public Armor(String n, int p, int ac) {// 如果父类显示定义了构造函数，那么子类就必须也显示定义构造函数，且需要下一行的super
		super(n, p); //子类的构造函数里必须写这一句，先进行父类的构造。类似于python里的super().__init__(...)
		this.ac = ac;
	}
}


abstract class Item1 {//抽象类
	public String name;
	public int price;
	
	public Item1(String n, int p) {
		// TODO Auto-generated constructor stub
		this.name = n;
		this.price = p;
	}
	public Item1(String n) {
		this(n, 180); //调用Item(String n, int p)这个构造方法，多构造方法的体现
	}
	public String getName() { //抽象类里可以定义普通的method
		return this.name;
	}
	public abstract boolean disposable(); //只要有一个抽象方法，该类就必须声明为抽象类

}

class Armor1 extends Item1{
	public int ac;
	public Armor1(String n, int p, int ac) {// 如果父类显示定义了构造函数，那么子类就必须也显示定义构造函数，且需要下一行的super
		super(n, p); //子类的构造函数里必须写这一句，先进行父类的构造。类似于python里的super().__init__(...)
		this.ac = ac;
	}
	@Override
	public boolean disposable() {
		return false;
	}
}

class LifePotion1 extends Item1{
	public LifePotion1(String n, int p) {
		super(n, p);
	}
	@Override
	public boolean disposable() {
		return true;
	}
}

enum SportsLeague{ //枚举类
	FIFA, FIBA, NBA, CSL, CBA;
}
