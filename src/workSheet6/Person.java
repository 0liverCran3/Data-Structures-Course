package WorkSheet6;

public class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		}
	
	public int compareTo(Person other) {
		if(this.name.equals(other.name))
			return 0;
		else if(this.name.compareTo(other.name) > 0) 
			return -1;
		else
			return 1;
		

	}
	
}
