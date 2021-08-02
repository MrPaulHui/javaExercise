package myUtil;
//学习java package（包）的用法
public class utilss { //这里不写public，其他的package是访问不了这个类的，只能在相同的package（包）下访问
	public int a; //和上一行同理，不写public，默认为friendly，只能同package下访问，无法在其他package下访问
	public int b;
	public utilss(int a, int b) {
		this.a = a;
		this.b = b;
	}

}
