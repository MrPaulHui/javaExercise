package javaExercise;
import myUtil.OverdraftException;

public class ExceptionDeal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(PracticeException.pratice1());
		Account a1 = new Account(100);
		a1.deposit(2);
		try {
			a1.withdraw(105);
		}catch (OverdraftException e) {
			System.out.println(e.getMessage());
			e.printStackTrace(); //��λ�쳣λ�ã�debug�����õ�
			System.out.println("͸֧���Ϊ"+e.getDeficit());
		}
		Account a2 = new CheckAccount(100, 10, 10);
		a2.deposit(5);
		try {
			a2.withdraw(111); //�����õ��˶�̬�����ԣ�����������ʵ�ʵ��õ���CheckAccount���withdraw
		}catch (OverdraftException e) {
			System.out.println(e.getMessage());
			e.printStackTrace(); //��λ�쳣λ�ã�debug�����õ�
			System.out.println("͸֧���Ϊ"+e.getDeficit());
		}
		a2.deposit(4);
		try {
			a2.withdraw(5); //�����õ��˶�̬�����ԣ�����������ʵ�ʵ��õ���CheckAccount���withdraw
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
	protected double balance;
	public Account(double bal) {
		this.balance = bal;
	}
	public double getBalance() {
		return this.balance;
	}
	public void deposit(double money) {
		this.balance += money;
		System.out.println("���"+money+"�����Ϊ"+this.balance);
	}
	public void withdraw(double money) throws OverdraftException { //�����throwsһ��Ҫ��
		if(this.balance-money<0) {
			double deficit = money-this.balance;
			throw new OverdraftException("�޷�ȡ��", deficit);
		}
		else {
			this.balance -= money;
			System.out.println("ȡ��"+money+"�����Ϊ"+this.balance);
		}
	}
}

class CheckAccount extends Account{ //���ÿ���������
	private double overdraftProtect;
	private double maxProtect;
	public CheckAccount(double bal) {
		super(bal);
	}
	public CheckAccount(double bal, double protect, double maxp) {
		super(bal);
		this.overdraftProtect = protect;
		this.maxProtect = maxp;
	}
	@Override
	public void deposit(double money) {
		if(this.overdraftProtect<this.maxProtect) {
			this.overdraftProtect += money;
			if(this.overdraftProtect>this.maxProtect) {
				this.overdraftProtect = this.maxProtect;
			}
		}
		this.balance += money;
		System.out.println("���"+money+"�����Ϊ"+this.balance+"�����ö��Ϊ"+this.overdraftProtect);
	}
	@Override
	public void withdraw(double money) throws OverdraftException{
		if(this.balance+this.overdraftProtect-money<0) {
			double deficit = money-this.balance;
			throw new OverdraftException("����͸֧��ȣ��޷�ȡ��", deficit);
		}
		else {
			if(this.balance<money) {
				this.overdraftProtect -= money-this.balance;  
			}
			this.balance -= money;
			System.out.println("ȡ��"+money+"�����Ϊ"+this.balance+"�����ö��Ϊ"+this.overdraftProtect);
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