package lesson11.exercise_2;

import java.util.ArrayList;
import java.util.List;

public class CountStringOccurrences {
	public static <T> int countOccurrences(List<T> arr, T target) {
		int count = 0;
		if (target == null) {
			for (T item : arr) {
				if (item == null) {
					count++;
				}
			}
		} else {
			for (T item : arr) {
				if (target.equals(item)) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		words.add("Hello");
		words.add("Hello");
		words.add("World");
		System.out.println(countOccurrences(words, "Hello"));
	}
}
