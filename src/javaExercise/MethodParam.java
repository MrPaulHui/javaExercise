package javaExercise;
//ʵ��java�����Ĵ�ֵ������

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
		tm = new TryMethodParam(10086); //ָ�����µ�ַ����ʵ�β�����Ӱ��
	}
	public void try2(TryMethodParam tm) {
		tm.par = 12345; //ͨ���βθı���ָ�������������ݣ�ʵ��Ҳ��Ӧ�ı�
	}
}

class StringParam{
	public static void giveString(String s) {
		s = "helllo";
	}
	public static void addString(String s) {
		s += " tail"; //ʵ��s���ᷢ���ı䣬ʵ�����������ָ�����µĵ�ַ������
	}
}
