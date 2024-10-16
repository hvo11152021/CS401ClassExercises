package lesson09.exercise_1;

import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Stream<Integer> allOdds = Stream.iterate(1, n -> n + 2).limit(8);
		allOdds.forEach(o -> System.out.println(o));
	}
}
