package javaExercise;

import java.util.*;


public class InOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*//基础的面向对象
		Item i1 = new Item("你好", 5);
		System.out.println(i1.name);
		*/
		
		
		Scanner s = new Scanner(System.in); //读取数据的方法
		int a = s.nextInt();
		System.out.println("first number is "+a);
		int b = s.nextInt();
		System.out.println("second number is "+b);
		System.out.println(a+b);
		float c = s.nextFloat();
		System.out.println("float number is "+c);
		String rn = s.nextLine(); //固定写法，因为第一个读到的字符串是换行符
		String d = s.nextLine();
		System.out.println(d);

	}

}
