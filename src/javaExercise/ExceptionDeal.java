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
			e.printStackTrace(); //定位异常位置，debug很有用的
			System.out.println("透支金额为"+e.getDeficit());
		}

	}

}

class PracticeException{
	public static int pratice1() { //这个返回的是3，finally代码块是必须执行的
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
	public void withdraw(double money) throws OverdraftException { //后面的throws一定要加
		if(this.balance-money<0) {
			double deficit = money-this.balance;
			throw new OverdraftException("已透支，无法取款", deficit);
		}
		else {
			this.balance -= money;
		}
	}
}
/*
class OverdraftException extends Exception{ //自定义异常，只能在一个新java文件里定义为public class，不然会报错
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