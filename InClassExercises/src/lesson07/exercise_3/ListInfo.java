package lesson07.exercise_3;

import java.util.ArrayList;
import java.util.List;

public class ListInfo {
	static List<String> list = new ArrayList<>();
	static MyStringList strList = new MyStringList();
	public static void main(String[] args) {
		ListInfo li = new ListInfo();
		li.process();
		System.out.println(strList.toString());
	}
	
	public void process() {
		list.add("A");
		list.add("W");
		list.add("K");
		list.add("C");
		
		//use java8 foreach to copy all list elements into strList
		list.forEach(l -> strList.add(l));
	}
}
