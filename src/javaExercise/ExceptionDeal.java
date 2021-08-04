package javaExercise;
import myUtil.OverdraftException;

public class ExceptionDeal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(PracticeException.pratice1());
		Account a1 = new Account(100);
		try {
			a1.withdraw(105);
		}catch (OverdraftException e) {
			System.out.println(e.getMessage());
			e.printStackTrace(); //��λ�쳣λ�ã�debug�����õ�
			System.out.println("͸֧���Ϊ"+e.getDeficit());
		}

	}

}

class PracticeException{
	public static int pratice1() { //������ص���3��finally������Ǳ���ִ�е�
		try {
			return 1;
		} catch (Exception e) {
			return 2;
		}
		finally{
			return 3;
		}
	}
}

class Account{
	private double balance;
	public Account(double bal) {
		this.balance = bal;
	}
	public double getBalance() {
		return this.balance;
	}
	public void deposit(double money) {
		this.balance += money;
	}
	public void withdraw(double money) throws OverdraftException { //�����throwsһ��Ҫ��
		if(this.balance-money<0) {
			double deficit = money-this.balance;
			throw new OverdraftException("��͸֧���޷�ȡ��", deficit);
		}
		else {
			this.balance -= money;
		}
	}
}
/*
class OverdraftException extends Exception{ //�Զ����쳣��ֻ����һ����java�ļ��ﶨ��Ϊpublic class����Ȼ�ᱨ��
	private double deficit;
	
	public OverdraftException(String m, double defi) {
		super(m);
		this.deficit = defi;
	}
	public double getDeficit() {
		return this.deficit;
	}
}
*/