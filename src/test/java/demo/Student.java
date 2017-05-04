package demo;

public class Student {

	public String id;
	public String name;

	public Student() {
	}

	public Student(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		Student s = (Student) obj;
		return id.equals(s.id);
	}

	@Override
	public int hashCode() {
		String in = id;
		return in.hashCode();
	}
}
