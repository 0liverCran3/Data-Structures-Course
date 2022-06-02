package workSheet7;

import java.util.ArrayList;
import java.util.HashSet;


public class TestArrayList {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("peepeepoopoo");
		names.add("glooberdoober");
		
		System.out.println(names);
		
		ArrayList<String> type = new ArrayList<String>();
		
		type.add("freakmanz");
		type.add("glizzy");
		
		System.out.println(merge(names,type));
		
		names.add("hhpus");
		names.add("scoobysnack");
		names.add("ggbro");
		names.add("hungerbar");
		
		System.out.println(enumerate(names));
		
		System.out.println(reverse(names));
	}
	
	public static ArrayList merge(ArrayList a, ArrayList b) {
		ArrayList<String> newList = new ArrayList<String>();
		newList.addAll(a);
		newList.addAll(b);
		return newList;	
	}
	
	public static HashSet enumerate(ArrayList a) {
		HashSet<String> s = new HashSet<String>(a);
		return s;
	}
	
	public static ArrayList reverse(ArrayList a) {
		ArrayList<String> revList = new ArrayList<String>();
		for(int i = a.size()-1; i >= 0; i--)
			revList.add((String) a.get(i));
		return revList;
	}
	
}