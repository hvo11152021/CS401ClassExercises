package lambdalib;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import quizclasses.Employee;
import quizclasses.Transaction;

public class LambdaLibrary {
	public final static String IMPLEMENT = "implement!";

	// sample query
	public final static TriFunction<List<Employee>, Integer, Integer, List<Employee>> SAMPLE = 
			(list, namelength, year) -> list.stream()
			.filter(e -> e.getName().length() > namelength)
			.filter(e -> e.getYearOfBirth() > year)
			.collect(Collectors.toList());

	public final static TriFunction<List<Employee>, Integer, Integer, List<Employee>> PROB1 = 
			(list, lowrange, highrange) -> list.stream()
			.filter(e -> e.getSalary() > lowrange || e.getSalary() < highrange)
			.sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary).reversed())
			.collect(Collectors.toList());
	
	public final static BiFunction<List<Transaction>, Integer, List<Transaction>> PROB2 = 
			(list, year) -> list.stream()
			.filter(t -> t.getYear() == year)
			.sorted(Comparator.comparing(Transaction::getYear))
			.collect(Collectors.toList());
			
	public final static BiFunction<List<Transaction>, String, List<Transaction>> PROB3 = 
			(list, city) -> list.stream()
			.filter(t -> t.getTrader().getCity() == city)
			.sorted(Comparator.comparing(t -> t.getTrader().getName()))
			.collect(Collectors.toList());
}
