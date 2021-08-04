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
			e.printStackTrace(); //定位异常位置，debug很有用的
			System.out.println("透支金额为"+e.getDeficit());
		}
		Account a2 = new CheckAccount(100, 10, 10);
		a2.deposit(5);
		try {
			a2.withdraw(111); //这里用到了多态的特性，即在运行中实际调用的是CheckAccount类的withdraw
		}catch (OverdraftException e) {
			System.out.println(e.getMessage());
			e.printStackTrace(); //定位异常位置，debug很有用的
			System.out.println("透支金额为"+e.getDeficit());
		}
		a2.deposit(4);
		try {
			a2.withdraw(5); //这里用到了多态的特性，即在运行中实际调用的是CheckAccount类的withdraw
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
	protected double balance;
	public Account(double bal) {
		this.balance = bal;
	}
	public double getBalance() {
		return this.balance;
	}
	public void deposit(double money) {
		this.balance += money;
		System.out.println("存款"+money+"，余额为"+this.balance);
	}
	public void withdraw(double money) throws OverdraftException { //后面的throws一定要加
		if(this.balance-money<0) {
			double deficit = money-this.balance;
			throw new OverdraftException("无法取款", deficit);
		}
		else {
			this.balance -= money;
			System.out.println("取款"+money+"，余额为"+this.balance);
		}
	}
}

class CheckAccount extends Account{ //信用卡，哈哈哈
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
		System.out.println("存款"+money+"，余额为"+this.balance+"，信用额度为"+this.overdraftProtect);
	}
	@Override
	public void withdraw(double money) throws OverdraftException{
		if(this.balance+this.overdraftProtect-money<0) {
			double deficit = money-this.balance;
			throw new OverdraftException("超过透支额度，无法取款", deficit);
		}
		else {
			if(this.balance<money) {
				this.overdraftProtect -= money-this.balance;  
			}
			this.balance -= money;
			System.out.println("取款"+money+"，余额为"+this.balance+"，信用额度为"+this.overdraftProtect);
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