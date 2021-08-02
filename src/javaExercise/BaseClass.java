package javaExercise;
import myUtil.utilss; // ��������package�µ�class�ķ���

public class BaseClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item i1 = new Item("���", 5);
		System.out.println(i1.name);
		Item i11 = new Item("woshi");
		System.out.println(i11.name+i11.price);
		
		Armor a1 = new Armor("ogman", 5, 18);
		System.out.println(a1.name+a1.ac);
		
		Item i2 = new Armor("uppp", 0, 10086); //upcasting������ת�ͣ���������Armor����������ת��Ϊ�丸���Item���ͣ����������
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
		this(n, 180); //����Item(String n, int p)������췽�����๹�췽��������
	}

}

class Armor extends Item{
	public int ac;
	public Armor(String n, int p, int ac) {
		super(n, p); //����Ĺ��캯�������д��һ�䣬�Ƚ��и���Ĺ��졣������python���super().__init__(...)
		this.ac = ac;
		
	}
}

enum SportsLeague{ //ö����
	FIFA, FIBA, NBA, CSL, CBA;
}
