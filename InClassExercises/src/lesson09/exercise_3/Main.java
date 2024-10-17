package lesson09.exercise_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Main {
	static enum SortMethod {BYBALANCE, BYNAME};
	Function<Account, Integer> byBalance = b -> b.getBalance(); 
	Function<Account, String> byName = n -> n.getOwnerName();
	
	public void sort(List<Account> accts, final SortMethod method) {
		if (method == SortMethod.BYBALANCE) {
			Collections.sort(accts, Comparator.comparing(byBalance).thenComparing(byName));
		} else {
			Collections.sort(accts, Comparator.comparing(byName).thenComparing(byBalance));
		}
	}

	public static void main(String[] args) {
		List<Account> accounts = new ArrayList<Account>() {
			private static final long serialVersionUID = 1L;
			{
				add(new Account("Bob", 5000, 1001));
				add(new Account("Jim", 10000, 1002));
				add(new Account("Bruce", 5300, 1003));
				add(new Account("Li", 12000, 1004));
				add(new Account("Sam", 9000, 1005));
				add(new Account("Rick", 11000, 1006));
			}
		};
		
		//sorting code here
		Main a = new Main();
		a.sort(accounts, Main.SortMethod.BYBALANCE);
		System.out.println(accounts);
		//same instance
		a.sort(accounts, Main.SortMethod.BYNAME);
		System.out.println(accounts);
	}

}
