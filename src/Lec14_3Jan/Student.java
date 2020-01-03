package Lec14_3Jan;

public class Student {

	String name;
	int age;

	public Student() {
		age = 0;
		name = null;
	}

	public Student(String name, int age) {

		this.name = name;
		this.age = age;
	}

	public void introduce() {
		
		System.out.println("Hii" + this.name + ":" + this.age);
	}
}










