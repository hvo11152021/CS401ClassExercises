package innerclass;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import quizclasses.Employee;
import quizclasses.EmployeeTestData;
import quizclasses.TraderTransactTestData;
import quizclasses.Transaction;

/** SOLVE THE PROBLEMS HERE BY REPLACING LAMBDA EXPRESSIONS IN YOUR PIPELINE SOLUTIONS 
 *  WITH LOCAL INNER CLASSES
 *
 */
public class Main {
	public static void main(String[] args) {
		
		// You need to use local inner classes to replace lambdas in your pipeline solution. 
		// Below is an example of what your code should look like.
		// This example has already been updated the to use local inner classes.

		// The example solves the problem:
		// Print all Employee records for which name has length > 5 and birth year is > 1970
		
		class NameLength implements Predicate<Employee> {
			public boolean test(Employee e) {
				return e.getName().length() > 5;
			}
		}
		class BirthYear implements Predicate<Employee> {
			public boolean test(Employee e) {
				return e.getYearOfBirth() > 1970;
			}
		}
		System.out.println("Sample Query");
		List<Employee> sampleData = EmployeeTestData.getList();
		
		List<Employee> result = sampleData.stream()
							        .filter(new NameLength())
							        .filter(new BirthYear())
							        .collect(Collectors.toList());
		System.out.println(result);
				
		prob1();
		prob2();
		prob3();
	}
	
	//Transform your pipeline solution to prob1 in the pipeline package so that
	//every lambda is replaced by an instance of a
	//local inner class of the correct type
	public static void prob1() {
		//use this list
		class SalaryRange implements Predicate<Employee> {
			public boolean test(Employee e) {
				return e.getSalary() > 55000 || e.getSalary() < 120000;
			}
		}
		class SortName implements Comparator<Employee> {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		}
		class SortSalary implements Comparator<Employee> {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary() < o2.getSalary() ? 1 : o1.getSalary() > o2.getSalary() ? -1 : 0;
			}
		}
		List<Employee> list = EmployeeTestData.getList();
		System.out.println(list.stream()
				.filter(new SalaryRange())
				.sorted(new SortName())
				.sorted(new SortSalary())
				.collect(Collectors.toList()));
	}
	
	///Transform your pipeline solution to prob2 so that
	//every lambda is replaced by an instance of a
	//local inner class of the correct type
	public static void prob2() {
		//use this list	
		class FilterYear implements Predicate<Transaction> {
			public boolean test(Transaction t) {
				return t.getYear() == 2011;
			}
		}
		class SortYear implements Comparator<Transaction> {
			@Override
			public int compare(Transaction o1, Transaction o2) {
				return o1.getYear() < o2.getYear() ? -1 : o1.getYear() > o2.getYear() ? 1 : 0;
			}
		}
		List<Transaction> list = TraderTransactTestData.getTransactions();
		System.out.println(list.stream()
				.filter(new FilterYear())
				.sorted(new SortYear())
				.collect(Collectors.toList()));
		
	}
	
	//Transform your pipeline solution to prob3 so that
	//every lambda is replaced by an instance of a
	//local inner class of the correct type
	public static void prob3() {
		//Use this list
		class FindTrader implements Predicate<Transaction> {
			public boolean test(Transaction t) {
				return t.getTrader().getCity() == "Cambridge";
			}
		}
		class SortTraderName implements Comparator<Transaction> {
			@Override
			public int compare(Transaction o1, Transaction o2) {
				return o1.getTrader().getName().compareTo(o2.getTrader().getName());
			}
		}
		List<Transaction> list = TraderTransactTestData.getTransactions();  
		System.out.println(list.stream()
				.filter(new FindTrader())
				.sorted(new SortTraderName())
				.collect(Collectors.toList()));
		
	                
	}
}
