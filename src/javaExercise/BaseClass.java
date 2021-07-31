package javaExercise;

public class BaseClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item i1 = new Item("ÄãºÃ", 5);
		System.out.println(i1.name);

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

}
