package lesson09.exercise_4;

import java.util.stream.Stream;

public class Main {
	//Use the reduce method to produce a single space-separated String
	public static void main(String[] args) {
		Stream<String> strings = Stream.of("A", "good", "day", "to", "write", "some", "Java");
		System.out.println(strings.reduce("", (x , y) -> (x + y + " ")));
	}

}
