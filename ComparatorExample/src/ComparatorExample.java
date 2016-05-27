import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ComparatorExample {

	public static void main(String args[]) {
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("Bob", "3rd", 2));
		students.add(new Student("Amar", "1st", 1));
		students.add(new Student("Charlie", "4th", 1));
		students.add(new Student("Fiaz", "1st", 2));
		students.add(new Student("Gary", "1st", 1));
		students.add(new Student("Dave", "2nd", 2));
		students.add(new Student("Dan", "2nd", 2));
		students.add(new Student("Ted", "1st", 2));
		students.add(new Student("Emanuel", "3rd", 1));

		// Display unsorted list of students
		System.out.println("Unsorted list:");
		displayList(students);

		/*
		 * Using compareTo() method of Comparable interface on object level.
		 * This sorts the items based on a 'particular' logic we implemented in
		 * the compareTo() method definition. Here it's comparison based on
		 * grade. you can't have multiple comparison criteria here. That's the
		 * disadvantage!
		 **/
		Collections.sort(students);
		System.out.println("using comparable sorted by grade:");
		displayList(students);

		/*
		 * You can create your own comparator based on certain criteria like
		 * name, grade, standard.
		 **/
		// Using grade comparator
		StudentGradeComparator stComp = new StudentGradeComparator();
		students.sort(stComp);// or Collections.sort(students, stComp);
		System.out.println("list sorted by grade:");
		displayList(students);

		// Using name comparator
		StudentNameComparator stNameComp = new StudentNameComparator();
		students.sort(stNameComp);// or Collections.sort(students, stNameComp);
		System.out.println("list sorted by name ASC:");
		displayList(students);

		/*
		 * No need to create a new reverse order comparator instead can use
		 * Collections.reverseOrder(Comparator) to get one.
		 */
		Comparator<Student> reverseNameComp = Collections.reverseOrder(stNameComp);
		students.sort(reverseNameComp);
		System.out.println("list sorted by name DESC:");
		displayList(students);

		// Using standard comparator
		StudentStandardComparator stStandardComp = new StudentStandardComparator();
		students.sort(stStandardComp);// or Collections.sort(students,
										// stStandardComp);
		System.out.println("list sorted by standard:");
		displayList(students);

		// filter the list by grade and sort by name in ascending order
		ArrayList<Student> filteredList = filterStudentsByGrade(students, 2);
		System.out.println("students with grade 2 sorted by name in ascending order:");
		filteredList.sort(stNameComp);
		displayList(filteredList);
	}

	/**
	 * @param students
	 *            Display list of objects using Iterator
	 */
	public static void displayList(List<Student> students) {
		System.out.println("Name	Standard	Grade");
		System.out.println("----	--------	-----");

		Iterator<Student> it = students.iterator();

		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}

		System.out.println("");
	}

	public static ArrayList<Student> filterStudentsByGrade(ArrayList<Student> students, int grade) {
		// Create predicate using Lambda expressions
		Predicate<Student> predicate = p -> p.getGrade() == grade;
		ArrayList<Student> filteredList = (ArrayList<Student>) students.stream().filter(predicate)
				.collect(Collectors.toList());
		return filteredList;
	}
}

class StudentNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// The compareTo() method here belongs to String object not Student
		// object.
		return o1.getName().compareTo(o2.getName());
	}
}

class StudentGradeComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getGrade() - o2.getGrade();
	}
}

class StudentStandardComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getStandard().compareTo(o2.getStandard());
	}
}
