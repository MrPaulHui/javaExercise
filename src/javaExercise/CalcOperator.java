package javaExercise;

import java.util.Scanner;

public class CalcOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("今天是周几？");
		int n = s.nextInt();
		String result = n<6?"今天是工作日":"今天是休息日"; //三元操作符的用法 ? :
		System.out.println(result);
		
		//判断闰年，调用Judgeyear.isRunyear静态方法（不用实例化类，直接调用其中方法）
		int y = s.nextInt();
		boolean resulty = Judgeyear.isRunyear(y);
		System.out.println(resulty==true?"闰年":"平年");

	}

}

class Judgeyear{
	static boolean isRunyear(int year) {// 不写public private，自动默认为public
		//判断闰年，练习if写法和逻辑操作符，以及静态方法
		if((year%4==0 && year%100!=0) || year%400==0) {
			return true;
		}
		else {
			return false;
		}
	}
}
