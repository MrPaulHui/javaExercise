package myUtil;

public class OverdraftException extends Exception{ //自定义异常
	private double deficit;
	
	public OverdraftException(String m, double defi) {
		super(m);
		this.deficit = defi;
	}
	public double getDeficit() {
		return this.deficit;
	}
}