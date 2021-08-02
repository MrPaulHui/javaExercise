package javaExercise;
//实验java方法的传值传引用

public class MethodParam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TryMethodParam tm1 = new TryMethodParam(10);
		tm1.try1(tm1);
		System.out.println(tm1.par); //10
		tm1.try2(tm1);
		System.out.println(tm1.par); //12345
		String s = "tryyy";
		StringParam.giveString(s);
		System.out.println(s);
		StringParam.addString(s);
		System.out.println(s);

	}

}

class TryMethodParam{
	int par;
	public TryMethodParam(int p) {
		this.par = p;
	}
	public void try1(TryMethodParam tm) {
		tm = new TryMethodParam(10086); //指向了新地址，对实参不产生影响
	}
	public void try2(TryMethodParam tm) {
		tm.par = 12345; //通过形参改变了指向对象的属性内容，实参也对应改变
	}
}

class StringParam{
	public static void giveString(String s) {
		s = "helllo";
	}
	public static void addString(String s) {
		s += " tail"; //实参s不会发生改变，实际上这个还是指向了新的地址！！！
	}
}
