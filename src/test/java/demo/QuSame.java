package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuSame {

	public static void main(String[] args) {
		List<Student> stu = new ArrayList<Student>();
		stu.add(new Student("1", "yi"));
		stu.add(new Student("4", "yi"));
		stu.add(new Student("3", "san"));
		stu.add(new Student("3", "san"));
		stu.add(new Student("2", "er"));
		stu.add(new Student("2", "er1"));
		// set集合保存的是引用不同地址的对象
		Set<Student> ts = new HashSet<Student>();
		ts.addAll(stu);

		for (Student student : ts) {
			System.out.println(student.getId() + "-" + student.getName());
		}
	}
}