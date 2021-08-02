package javaExercise;

import java.util.ArrayList;
import java.util.Arrays;


public class ControlFlow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mo = 3;
		System.out.println(JudgeSeason.judgeString(mo));
		int n = 5;
		System.out.println(Factorial.fact2(n));
		System.out.println(DaffodilNumber.findDaffodilNumber()); // ArrayList can be directly printed
		System.out.println(Arrays.toString(SolvePrim.solve()));

	}

}

class JudgeSeason{
	public static String judgeString(int month) { //static method
		if(month<1 || month>12) {
			return "Invalid Input";
		}
		else {
			if(month>=3 && month<=5) {
				return "Spring";
			}
			else {
				if(month>=6 && month<=8) {
					return "Summer";
				}
				else {
					if(month>=9 && month<=11) {
						return "Autumn";
					}
					else {
						return "Winter";
					}
				}
			}
		}
	}
}

class Factorial{ //阶乘
	public static int fact1(int n) {
		int result = 1;
		while(n>=1) {
			result *= n;
			n -= 1;
		}
		return result;
	}
	
	public static int fact2(int n) { //递归版本
		if(n==1) {
			return 1;
		}
		return n*fact2(n-1);
	}
}

class DaffodilNumber{ //水仙花数
	public static boolean isDaffodilNumber(int n) {
		int n3 = n%10;
		int n2 = (n%100)/10;
		int n1 = n/100;
		if(n==(n3*n3*n3+n2*n2*n2+n1*n1*n1)) {
			return true;
		}
		else {
			return false;
		}
	}
	public static ArrayList<Integer> findDaffodilNumber() {
		int n = 100;
		ArrayList<Integer> result = new ArrayList<>(); //create an ArrayList object, which is like list in python
		while(n<=999) {
			if(isDaffodilNumber(n)) {
				result.add(n);
			}
			n++;
		}
		return result;
	}
}

class SolvePrim{
	//https://how2j.cn/k/control-flow/control-flow-practise/656.html#step3434 solve this question
	public static int[] solve() {
		int[] result = new int[4]; //the way to create a int list, 最普通的
		boolean flag = false;
		for(int n1=0;n1<100;n1++) {
			for(int n2=0;n2<100;n2++) {
				for(int n3=0;n3<100;n3++) {
					for(int n4=0;n4<100;n4++) {
						if(n1+n2==8 && n1+n3==14 && n2+n4==10 && n3-n4==6) {
							result[0] = n1;
							result[1] = n2;
							result[2] = n3;
							result[3] = n4;
							flag = true;
							break;
						}
					}
					if(flag) {
						break;
					}
				}
				if(flag) {
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		return result;
		
	}
}