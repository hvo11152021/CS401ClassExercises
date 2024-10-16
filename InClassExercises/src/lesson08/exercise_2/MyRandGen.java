package lesson08.exercise_2;

import java.util.Random;

public class MyRandGen implements MyIface {
	@Override
	public int produce() {
		return (new Random().nextInt(1000));
	}
	
	public static void main(String[] args) {
		MyIface mrg = new MyRandGen();
		System.out.println(mrg.produce());
	}
}
