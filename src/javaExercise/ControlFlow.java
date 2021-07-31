package javaExercise;

public class ControlFlow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mo = 3;
		System.out.println(JudgeSeason.judgeString(mo));
		int n = 5;
		System.out.println(Factorial.fact2(n));

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

class Factorial{ //½×³Ë
	public static int fact1(int n) {
		int result = 1;
		while(n>=1) {
			result *= n;
			n -= 1;
		}
		return result;
	}
	
	public static int fact2(int n) { //µÝ¹é°æ±¾
		if(n==1) {
			return 1;
		}
		return n*fact2(n-1);
	}
}
