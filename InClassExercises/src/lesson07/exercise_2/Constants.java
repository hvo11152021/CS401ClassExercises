package lesson07.exercise_2;

public enum Constants {
//	public static final String COMPANY = "Microsoft";
//	public static final int SALES_TARGET = 20000000;
	
	BOTH("Microsoft", 20000000);
	
	private String s;
	private int i;
	
	private Constants(String s, int i) {
		this.s = s;
		this.i = i;
	}
	
	public String getName() {
		return s;
	}
	
	public int getSales() {
		return i;
	}
}
