package javaExercise;

import java.util.Scanner;

public class CalcOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("�������ܼ���");
		int n = s.nextInt();
		String result = n<6?"�����ǹ�����":"��������Ϣ��"; //��Ԫ���������÷� ? :
		System.out.println(result);
		
		//�ж����꣬����Judgeyear.isRunyear��̬����������ʵ�����ֱ࣬�ӵ������з�����
		int y = s.nextInt();
		boolean resulty = Judgeyear.isRunyear(y);
		System.out.println(resulty==true?"����":"ƽ��");

	}

}

class Judgeyear{
	static boolean isRunyear(int year) {// ��дpublic private���Զ�Ĭ��Ϊpublic
		//�ж����꣬��ϰifд�����߼����������Լ���̬����
		if((year%4==0 && year%100!=0) || year%400==0) {
			return true;
		}
		else {
			return false;
		}
	}
}
