package javaExercise;

import java.util.*;


public class InOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*//�������������
		Item i1 = new Item("���", 5);
		System.out.println(i1.name);
		*/
		
		
		Scanner s = new Scanner(System.in); //��ȡ���ݵķ���
		int a = s.nextInt();
		System.out.println("first number is "+a);
		int b = s.nextInt();
		System.out.println("second number is "+b);
		System.out.println(a+b);
		float c = s.nextFloat();
		System.out.println("float number is "+c);
		String rn = s.nextLine(); //�̶�д������Ϊ��һ���������ַ����ǻ��з�
		String d = s.nextLine();
		System.out.println(d);

	}

}
